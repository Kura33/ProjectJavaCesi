<template>

  <button @click="backward">Retour</button>
  <div class="content">
    <div class="incident-information" v-if="incident">
      <div><span>RÉFÉRENCE : </span><span>{{ incident.ref }}</span></div>
      <div><span>DATE DE DÉBUT : </span><span>{{ format_date(incident.startDate) }}</span></div>
      <div><span>DATE DE FIN : </span><span>{{ format_date(incident.endDate) }}</span></div>
      <div><span>STATUT : </span><span>{{ incident.status }}</span></div>
      <div><span>DANGEROSITÉ : </span><span>{{ incident.dangerousness }}</span></div>
      <div><span>RÉSOLU : </span><span> {{ incident.solved ? 'OUI' : 'NON' }}</span></div>
      <div><span>DÉCLARÉE PAR : </span><span>{{ incident.declaredBy }}</span></div>
      <div><span>RÉDIGÉE PAR : </span><span>{{ incident.redactedBy }}</span></div>
      <div><span>TYPE D'INCIDENT : </span><span>{{ incident.eventType }}</span></div>
    </div>
    <div v-else>No informations available for this incident</div>
  </div>

  <div class="comments" v-if="comments">
    <ul v-for="comment in comments" :key="comment.id">
      <li>{{ comment.comments }}</li>
    </ul>
  </div>
  <div v-else> pas de commentaire</div>

</template>

<script>

import moment from "moment";

export default {
  name: "IncidentDetail",
  props: ['id'],
  data() {
    return {
      incident: null,
      comments: null,
    }
  },
  methods: {
    // 1
    getIncidentDetails() {
      fetch("/shield/incident/" + this.id)
          .then(response => response.json())
          .then(data => {
            this.incident = data.incident;
            this.comments = data.comments;

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
    this.created()
    console.log(this.incident)
  }
}
</script>
