<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <router-link :to="{ name: 'Home'}"><img class="logo" src="@/assets/img/shield.png" alt="shield logo"></router-link>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01"
            aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
      <ul class="navbar-nav mr-auto">
          <router-link :to="{ name: 'Home'}" class="nav-link">
            <li class="nav-item active">Home</li>
          </router-link>
          <router-link
              :to="{ name: 'Incident'}" class="nav-link"><li class="nav-item">Incidents</li>
          </router-link>
        <li class="nav-item">
          <a class="nav-link" href="#">Litiges</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Missions</a>
        </li>
        <router-link
            :to="{ name: 'Login'}" class="nav-link"><li class="nav-item">Login</li>
        </router-link>
        <li class="nav-item" v-if="existingToken != null" :key="existingToken">
          <button class="btn btn-primary" @click="logout">Logout</button>
        </li>

      </ul>
    </div>
  </nav>
</template>

<script>
import Home from "@/views/Home";

export default {
  name: "Nav",
  data() {
    return {
      existingToken : localStorage.getItem("token") ? localStorage.getItem("token") : null,
    }
  },
  methods: {
    logout() {
      localStorage.removeItem("token")
      this.$toast.success('Déconnexion réussie')
      this.$router.push(Home)
    }
  },
  mounted() {
    console.log(this.existingToken)
    this.$forceUpdate();
  }
}
</script>
<style>
.logo {
  width: 50px;
  height: 50px;
}

.navbar {
  margin: 0 !important;
}


</style>