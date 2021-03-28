<template>
  <div class="page-content p-5">

    <button @click="backward" class="back-btn btn btn-secondary mb-2">Retour</button>

    <div class="content m-auto">
      <form action="" @submit.prevent="handleCreation" method="post" class="form-flex">

        <div class="first-form-div">

          <div class="column1">
            <div class="form-group">
              <label for="reference">référence</label>
              <input v-model="reference" name="reference" type="text" class="form-control" id="reference"
                     placeholder="Enter référence">
            </div>
            <div class="form-group">
              <label for="startDate">Date de début</label>
              <input v-model="startDate" name="startDate" type="date" class="form-control" id="startDate"
                     placeholder="2021-03-12">
            </div>
            <div class="form-group">
              <label for="endDate">Date de fin</label>
              <input v-model="endDate" name="endDate" type="date" class="form-control" id="endDate"
                     placeholder="2021-03-13">
            </div>
            <div class="form-group solved">
              <label class="solved-label1">Résolu ?</label>
              <div class="solved-div1">
                <div>
                  <label>Oui</label>
                  <input v-model="solved" name="solved" type="radio" value="true">
                </div>
                <div>
                  <label>Non</label>
                  <input v-model="solved" name="unsolved" type="radio" value="false">
                </div>
              </div>
            </div>
            <div class="form-group">
              <label>Dangerosité</label>
              <input v-model="dangerousness" name="dangerousness" type="number" step="0.01" class="form-control">
            </div>
            <div class="form-group">
              <label>Statut</label>
              <select id="status" v-model="status" name="status" class="form-control">
                <option value="À prendre en charge">À prendre en charge</option>
                <option value="Traitement en cours">Traitement en cours</option>
                <option value="Intervention demandée">Intervention demandée</option>
                <option value="Refusée">Refusée</option>
              </select>
            </div>
          </div>
          <div class="column2">
            <div class="form-group">
              <label>Type d'incident</label>
              <input v-model="eventType" name="eventType" type="text" class="form-control">
            </div>
            <div class="form-group">
              <label>Superbeing</label>
              <Multiselect class="multiselect"
                           v-model="superbeings"
                           mode="multiple"
                           :options="superbeingOptions"
                           :searchable="true"
              />
            </div>
            <div class="form-group">
              <label>Civil</label>
              <Multiselect class="multiselect"
                  v-model="civils"
                  mode="multiple"
                  :options="civilOptions"
                  :searchable="true"
              />
            </div>
            <div class="form-group">
              <label>Organisation</label>
              <Multiselect class="multiselect"
                  v-model="organisations"
                  mode="multiple"
                  :options="organisationOptions"
                  :searchable="true"
              />
            </div>
            <div class="form-group comment-btn">
              <button @click="addComment" type="button" class="btn btn-secondary" v-if="comments.length < 1">Ajouter un
                commentaire
              </button>
            </div>
            <div class="form-group comment-block flex" v-for="(comment, index) in comments" :key="index">
              <div class="form-row">
                <div class="form-group">
                  <div class="label-add-comment">
                    <label>Commentaire :</label>
                    <div>
                      <i @click="addComment" class="fas fa-plus-circle fa-2x"></i>
                      <i @click="removeComment(index)" class="fas fa-minus-circle fa-2x"></i>
                    </div>
                  </div>
                  <textarea v-model="comment.comments" type="text" class="form-control"
                            placeholder="Commentaire"></textarea>
                </div>
              </div>
            </div>
          </div>
        </div>
        <button type="submit" class="btn btn-primary m-auto">Créer un incident</button>

      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Incident from "@/views/incident/Incident";
import Multiselect from '@vueform/multiselect'


export default {
  name: "IncidentCreation",
  components: {Multiselect},
  data() {
    return {
      reference: null,
      startDate: null,
      endDate: null,
      solved: null,
      dangerousness: null,
      status: null,
      archive: 0,
      eventType: null,
      comments: [],
      comment1: null,
      comment2: null,
      civils: null,
      organisations: null,
      superbeings: null,
      superbeingOptions: [],
      civilOptions: [],
      organisationOptions: [],
    }
  },
  methods: {
    async handleCreation() {
      this.comment1 != null ? this.comments.push({"comments": this.comment1}) : '';
      this.comment2 != null ? this.comments.push({"comments": this.comment2}) : '';

      const body = [
        {
          "ref": this.reference,
          "startDate": this.startDate,
          "endDate": this.endDate,
          "solved": this.solved,
          "archive": this.archive,
          "dangerousness": this.dangerousness,
          "status": this.status,
          "eventType": {
            "name": this.eventType,
          },
          "civils": this.civils == null ? [] : this.civils,
          "organisations": this.organisations == null ? [] : this.organisations,
          "superbeings": this.superbeings == null ? [] : this.superbeings,
          "comments": this.comments,
        }
      ];
      await axios.post("/shield/incident/create", body, {
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Credentials": true,
          Authorization: 'Bearer ' + localStorage.getItem("token"),
        }
      })
          .then(response => {
            response.status === 200
                ? this.$toast.success('Incident créé avec succès')
                : this.$toast.error("L'incident n'a pas pu être créé")
            this.$router.push(Incident)
          })
          .catch(err => console.log(err.message));
    },
    backward() {
      this.$router.go(-1)
    },
    async getSuperbeingList() {
      await axios.get("/shield/superbeing/", {
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Credentials": true,
          Authorization: 'Bearer ' + localStorage.getItem("token"),
        }
      })
          .then(response => {

            response.data.forEach((superbeing) => {
              console.log(superbeing)
              this.superbeingOptions.push({
                value: superbeing.id,
                label: superbeing.name,
              });
            })
          })
          .catch(err => console.log(err.message));

    },
    async getCivilList() {
      await axios.get("/shield/civil/", {
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Credentials": true,
          Authorization: 'Bearer ' + localStorage.getItem("token"),
        }
      })
          .then(response => {

            response.data.forEach((civil) => {
              console.log(civil)
              this.civilOptions.push({
                value: civil.id,
                label: civil.firstname + ' ' + civil.lastname,
              });
            })
          })
          .catch(err => console.log(err.message));

    },
    async getOrganisationList() {
      await axios.get("/shield/organisation/", {
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Credentials": true,
          Authorization: 'Bearer ' + localStorage.getItem("token"),
        }
      })
          .then(response => {

            response.data.forEach((organisation) => {
              console.log(organisation)
              this.organisationOptions.push({
                value: organisation.id,
                label: organisation.name,
              });
            })
          })
          .catch(err => console.log(err.message));
    },
    addComment() {
      this.comments.push({
        comments: '',
      })
    },
    removeComment(index) {
      this.comments.splice(index, 1);
    },
  },
  mounted() {
    this.getSuperbeingList()
    this.getCivilList()
    this.getOrganisationList()
  }
}
</script>
<style src="@vueform/multiselect/themes/default.css"></style>
<style>
.content {
}

.comment-div {
  display: flex;
  flex-direction: column;
}

.form-flex {
  display: flex;
  flex-direction: column;
}

.first-form-div {
  display: flex;
  margin: auto;
  width: 100%;
  justify-content: space-around;
}

.multiselect {
  background: white;
}

.solved {
  display: flex;
  flex-direction: column;
}

.solved-div1 {
  display: flex;
  justify-content: space-around;
}

.first-form-div > .column2 > div.comment-btn {
  text-align: center;
}

.label-add-comment {
  display: flex;
  justify-content: space-between;
}

.fa-plus-circle {
  color: #73B519;
  cursor: pointer;
}

.fa-minus-circle {
  color: crimson;
  cursor: pointer;
}

@media screen and (max-width: 600px) {
  .first-form-div {
    width: 100%;
    justify-content: space-between;
  }
}

@media screen and (max-width: 800px) {
  .first-form-div {
    flex-direction: column;
    width: 100%;
    justify-content: space-between;
  }
}

</style>