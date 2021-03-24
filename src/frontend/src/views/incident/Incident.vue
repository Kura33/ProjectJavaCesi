<template>
  <h1>CODE COULEUR POUR DANGEROSITE ET RESOLU</h1>
  <div class="p-5 table-responsive">
    <table class="table table-bordered table-hover table-sm" id="incident-table">
      <thead class="thead-dark text-light">
      <tr>
        <th scope="col">Référence</th>
        <th scope="col">Timeframe de l'incident</th>
        <th scope="col">Statut</th>
        <th scope="col" >Dangerosité</th>
        <th scope="col">Type d'incident</th>
        <th scope="col">Résolu</th>
        <th scope="col">Actions</th>
      </tr>
      </thead>

      <tbody class="table-striped" v-if="incidents">
      <tr v-for="incident in incidents" :key="incident.id">
        <th scope="row"> {{ incident.ref }}</th>
        <td> {{ format_date(incident.startDate) }} - {{ format_date(incident.endDate) }}</td>
        <td> {{ incident.status }}</td>
        <td :class="incident.dangerousness > 70.00 ? 'table-danger'
            : incident.dangerousness > 40.00 ? 'table-warning': ''"
        > {{ incident.dangerousness }}%
        </td>
        <td> {{ incident.eventType }}</td>
        <td class="text-center"><span :class="incident.solved ? 'dot-true' : 'dot-false'"></span></td>
        <td>
          <div class="action-div">
            <router-link :to="{ name: 'IncidentDetail', params: {id: incident.id}}" class="action-link"><img class="detail-img" src="@/assets/img/information-button.svg" alt="todo"></router-link>
            <button class="action-button" v-if="incident.status === 'À prendre en charge'">
              <img class="to-do-img" src="@/assets/img/to-do.svg" alt="todo">
            </button>
          </div>
        </td>
      </tr>
      </tbody>
      <tbody class="table-striped" v-else>
      <tr>
        <td colspan="7">Aucun incident pour l'instant</td>
      </tr>
      </tbody>
    </table>
  </div>

</template>

<script>
import $ from 'jquery'
import moment from 'moment'


export default {
  name: "Incident",
  el: "#incident-table",
  data() {
    return {
      incidents: null
    }
  },
  methods: {
    //1
    getIncidentData() {
      fetch("/shield/incident/")
          .then(response => response.json())
          .then((data) => {
            let incidentList = [];
            $.each(data, (incident) => {
              incidentList.push(data[incident])
            })
            this.incidents = incidentList;
          })
          .catch(err => console.log(err.message));
    },
    //2
    created() {
      this.getIncidentData();

    },
    //3
    format_date(value) {
      if (value) {
        return moment(String(value)).format('DD/MM/YYYY')
      }
    }
  },
  mounted() {
    this.created()
  }
}
</script>
<style>
.action-div {
  display: flex;
  align-content: center;
  text-align: center;
  vertical-align: center;
}
.to-do-img {
  width: 30px;
}

.detail-img {
  width: 30px;
}
</style>