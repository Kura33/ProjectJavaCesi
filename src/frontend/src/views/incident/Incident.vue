<template>
  <div class="page-content p-5">
  <button class="back-btn btn btn-secondary mb-2">
    <router-link :to="{ name: 'IncidentCreation'}">
      Créer un incident</router-link>
  </button>

  <div class="table-responsive">
    <div class="legende">
      <div>
        <h4>Dangerosité</h4>
        <div>
          <span>Attention : Jaune : Au dessus de 40%</span>
        </div>
        <div>
          <span>Critique : Rouge : Au dessus de 70%</span>
        </div>
      </div>
      <div>
        <h4>Résolu</h4>
        <span>Vert : Oui</span><br>
        <span>Rouge : Non</span>
      </div>
    </div>
    <table class="table table-bordered table-hover table-sm" id="incident-table">
      <thead class="thead-dark text-light">
      <tr>
        <th scope="col">Référence</th>
        <th scope="col">Timeframe de l'incident</th>
        <th scope="col">Statut</th>
        <th scope="col">Dangerosité</th>
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
        > {{ incident.dangerousness }}
        </td>
        <td> {{ incident.eventType }}</td>
        <td class="text-center"><span :class="incident.solved ? 'dot-true' : 'dot-false'"></span></td>
        <td>
          <div class="action-div">
            <router-link :to="{ name: 'IncidentDetail', params: {id: incident.id}}" class="action-link"><img
                class="detail-img" src="@/assets/img/information-button.svg" alt="todo"></router-link>
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
  <div>{{ token }}</div>

  </div>
</template>

<script>
// import $ from 'jquery'
import moment from 'moment'
import axios from "axios";

export default {
  name: "Incident",
  el: "#incident-table",
  data() {
    return {
      incidents: null,
      token: localStorage.getItem('user-token'),
    }
  },
  methods: {
    async loadIncidents() {
      await axios.get("/shield/incident/", {
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Credentials": true,
          Authorization: 'Bearer ' + localStorage.getItem("token"),
        }
      })
      .then(response => {
        this.incidents = response.data
      })

    },
    //2
    created() {
      this.loadIncidents();

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
a {
  text-decoration: none;
  color: white;
}

.to-do-img {
  width: 30px;
}

.detail-img {
  width: 30px;
}

.legende{
  display: flex;
  justify-content: space-evenly;
}
</style>