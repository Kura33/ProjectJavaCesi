<template>
  <div class="page-content p-5">

    <button @click="backward" class="back-btn btn btn-secondary mb-2">Retour</button>

    <div class="content w-25 m-auto">
      <form action="" @submit.prevent="handleCreation" method="post" class="flex flex-column">

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
        <div class="form-group">
          <label>Résolu ? Oui</label><input v-model="solved" name="solved" type="radio" value="true">
          <label>Non</label><input v-model="solved" name="unsolved" type="radio" value="false">
        </div>
        <div class="form-group">
          <label>Dangerosité</label>
          <input v-model="dangerousness" name="dangerousness" type="number" step="0.01" class="form-control">
        </div>



        <div class="form-group">
          <label>Statut</label>
          <select id="status" v-model="status" name="status" type="text" class="form-control">
            <option value="À prendre en charge">À prendre en charge</option>
            <option value="Traitement en cours">Traitement en cours</option>
            <option value="Intervention demandée">Intervention demandée</option>
            <option value="Refusée">Refusée</option>
          </select>
        </div>
        <div class="form-group">
          <label>Type d'incident</label>
          <input v-model="eventType" name="eventType" type="text" class="form-control">
        </div>
        <div class="form-group">
          <label>Civil 1</label><input type="checkbox" v-model="civil1" value="1">
          <label>Civil 2</label><input type="checkbox" v-model="civil2" value="2">
          <label>Civil 7</label><input type="checkbox" v-model="civil7" value="7">
        </div>
        <div class="form-group">
          <label>Organisation 3</label><input type="checkbox" v-model="orga3" value="3">
          <label>Organisation 8</label><input type="checkbox" v-model="orga8" value="8">
        </div>
        <div class="form-group">
          <label>Superbeing 1</label><input type="checkbox" v-model="superbeing1" value="1">
          <label>Superbeing 2</label><input type="checkbox" v-model="superbeing2" value="2">
          <label>Superbeing 3</label><input type="checkbox" v-model="superbeing3" value="3">
        </div>
        <button type="submit" class="btn btn-primary m-auto">Créer un incident</button>

      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Incident from "@/views/incident/Incident";

export default {
  name: "IncidentCreation",
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
      comments: null,
      civil1: null,
      civil2: null,
      civil7: null,
      orga3: null,
      orga8: null,
      superbeing1: null,
      superbeing2: null,
      superbeing3: null,
      civils: [],
      organisations: [],
      superbeings: [],
      result: '',
    }
  },
  methods: {
    async handleCreation() {

      this.civil1 == true ? this.civils.push(1) : '';
      this.civil2 == true ? this.civils.push(2) : '';
      this.civil7 == true ? this.civils.push(7) : '';

      this.orga3 == true ? this.organisations.push(3) : '';
      this.orga8 == true ? this.organisations.push(8) : '';

      this.superbeing1 == true ? this.superbeings.push(1) : '';
      this.superbeing2 == true ? this.superbeings.push(2) : '';
      this.superbeing3 == true ? this.superbeings.push(3) : '';

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
          "civils": this.civils,
          "organisations": this.organisations,
          "superbeings": this.superbeings,
          "comments": [
            {
              "comments": "premier commentaire"
            },
            {
              "comments": "second commentaire"
            }
          ]
        }
      ];
      let result = '';
      await axios.post("/shield/incident/create", body, {
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Credentials": true,
          Authorization: 'Bearer ' + localStorage.getItem("token"),
        }
      })
          .then(response => {
            result = response.status === 200 ? 'Incident créé avec succès' : 'incident non créé';
            this.$router.push(Incident)


            this.result = result;

            alert(this.result)
          })
          .catch(err => console.log(err.message));
    },
    backward() {
      this.$router.go(-1)
    },
  }
}
</script>

<style scoped>

</style>