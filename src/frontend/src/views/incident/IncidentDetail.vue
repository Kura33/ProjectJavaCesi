<template>

  <div class="page-content p-5">
    <button @click="backward" class="back-btn btn btn-secondary mb-2">Retour</button>
    <div class="grid-container">
      <div class="incident-information">
        <div class="info-nav pl-2 text-white">INFORMATIONS</div>
        <div class="info-content px-2 grid-container-incident-info" v-if="incident">
          <div class="grid-item grid-item-1"><span>RÉFÉRENCE : </span><span>{{ incident.ref }}</span></div>
          <div class="grid-item grid-item-2"><span>DATE DE DÉBUT : </span><span>{{
              format_date(incident.startDate)
            }}</span></div>
          <div class="grid-item grid-item-3">
            <span>DATE DE FIN : </span><span>{{ incident.endDate ? format_date(incident.endDate) : ' -' }}</span></div>
          <div class="grid-item grid-item-4"><span>STATUT : </span><span>{{ incident.status }}</span></div>
          <div class="grid-item grid-item-5"><span>DANGEROSITÉ : </span><span>{{ incident.dangerousness }}%</span></div>
          <div class="grid-item grid-item-6"><span>RÉSOLU : </span><span
              :class="incident.solved ? 'text-success' : 'text-danger'"> {{ incident.solved ? 'OUI' : 'NON' }}</span>
          </div>
          <div class="grid-item grid-item-7"><span>DÉCLARÉE PAR : </span><span>{{ incident.declaredBy }}</span></div>
          <div class="grid-item grid-item-8"><span>RÉDIGÉE PAR : </span><span>{{ incident.redactedBy }}</span></div>
          <div class="grid-item grid-item-9"><span>TYPE D'INCIDENT : </span><span>{{ incident.eventType }}</span></div>
        </div>
        <div class="info-content px-2" v-else>No informations available for this incident</div>
      </div>
      <div class="comment-information">
        <table class="table table-bordered table-hover table-sm" id="comment-table">
          <thead class="text-light">
          <tr>
            <th scope="col">COMMENTAIRES</th>
          </tr>
          </thead>

          <tbody class="table-striped" v-if="comments">
          <tr v-for="comment in comments" :key="comment.id">
            <td>{{ comment.comments }}</td>
          </tr>
          </tbody>
          <tbody class="table-striped" v-else>
          <tr>
            <td colspan="7">Aucun incident pour l'instant</td>
          </tr>
          </tbody>
        </table>
      </div>
      <div class="superhero-information" v-if="superbeings">
        <div class="info-nav pl-2 text-white">SUPERBEINGS</div>
        <div v-for="superbeing in superbeings" :key="superbeing.id">
          <div class=""> {{ superbeing.name }}</div>
        </div>
      </div>
      <div class="superhero-information" v-else>
        <div class="info-nav pl-2 text-white">SUPER-HÉROS</div>
      <div class="info-content px-2" >No informations available for this incident</div>
      </div>
      <div class="civil-information" v-if="civils">
        <div class="info-nav pl-2 text-white">CIVILS</div>
        <div v-for="civil in civils" :key="civil.id">
          <div class=""> {{ civil.name }}</div>
        </div>
      </div>
      <div class="civil-information" v-else>
        <div class="info-nav pl-2 text-white">SUPER-HÉROS</div>
      <div class="info-content px-2" >No informations available for this incident</div>
      </div>
      <div class="organisation-information" v-if="organisations">
        <div class="info-nav pl-2 text-white">ORGANISATIONS</div>
        <div v-for="organisation in organisations" :key="organisation.id">
          <div class=""> {{ organisation.name }}</div>
        </div>
      </div>
      <div class="organisation-information" v-else>
        <div class="info-nav pl-2 text-white">SUPER-HÉROS</div>
      <div class="info-content px-2" >No informations available for this incident</div>
      </div>
    </div>
  </div>
</template>

<script>

import moment from "moment";
import axios from "axios";

export default {
  name: "IncidentDetail",
  props: ['id'],
  data() {
    return {
      incident: null,
      comments: null,
      superbeings: null,
      civils: null,
      organisations: null,
    }
  },
  methods: {
    // 1
    async getIncidentDetails() {
      await axios.get("/shield/incident/" + this.id, {
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Credentials": true,
          Authorization: 'Bearer ' + localStorage.getItem("token"),
        }
      })
          .then(response => {
            this.incident = response.data.incident;
            this.comments = response.data.comments;
            this.superbeings = response.data.superbeings;
            this.civils = response.data.civils;
            this.organisations = response.data.organisations;
          })
          .catch(err => console.log(err.message));
    },
    //2
    created() {
      this.getIncidentDetails();

    },
    // 3
    backward() {
      this.$router.go(-1)
    },
    //4
    format_date(value) {
      if (value) {
        return moment(String(value)).format('DD/MM/YYYY')
      }
    }

  },
  mounted() {
    this.created();
  }
}
</script>

<style>
.table > thead {
  background-color: #132141;
}

.grid-container {
  display: grid;
  gap: 20px 20px;
  grid-template-areas:
    "incident organisation organisation"
    "comment civil superbeing";
}

.incident-information {
  grid-area: incident;
}
.comment-information {
  grid-area: comment;
}
.superhero-information {
  grid-area: superbeing;
}
.civil-information {
  grid-area: civil;
}
.organisation-information {
  grid-area: organisation;
}


.grid-container-incident-info {
  display: grid;
  gap: 10px 20px;
  grid-template-areas:
    "first1 second1"
    "first2 second2"
    "first3 second3"
    "first4 second4"
    "first5 second5"
    "first6 second6"
    "first7 second7"
    "first8 second8"
    "first9 second9"
}

.grid-item-1 {
  grid-area: first1;
}

.grid-item-1 > span:nth-child(2) {
  font-weight: bold;
}

.grid-item-2 {
  grid-area: first2;
}

.grid-item-3 {
  grid-area: first3;
}

.grid-item-4 {
  grid-area: first4;
}

.grid-item-5 {
  grid-area: first5;
}

.grid-item-6 {
  grid-area: first6;
}

.grid-item-7 {
  grid-area: second1;
}

.grid-item-8 {
  grid-area: second2;
}

.grid-item-9 {
  grid-area: second3;
}

.info-nav {
  height: 50px;
  background-color: #132141;
  display: flex;
  align-items: center;
}

</style>
