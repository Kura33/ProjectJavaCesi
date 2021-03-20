<template>

  <button @click="backward">Retour</button>
  <div>{{ incident.id }}</div>
  <div>{{ incident.ref }}</div>


</template>

<script>

export default {
  name: "IncidentDetail",
  props: ['id'],
  data() {
    return {
      incident: {},
    }
  },
  methods: {
    // 1
    getIncidentDetails() {
      fetch("/shield/incident/" + this.id)
          .then(response => response.json())
          .then(data => {
            this.incident = data;
            console.log(data)
            console.log(this.$router)
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
    }

  },
  mounted() {
    this.created()
    console.log(this.incident)
  }
}
</script>
