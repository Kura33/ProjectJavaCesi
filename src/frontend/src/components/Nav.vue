<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<!--    <a class="navbar-brand" href="#"><img class="logo" src="@/assets/img/shield.png" alt="shield logo"></a>-->
    <router-link :to="{ name: 'Home'}"><img class="logo" src="@/assets/img/shield.png" alt="shield logo"></router-link>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01"
            aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <router-link :to="{ name: 'Home'}" class="nav-link">Home</router-link>
        </li>
        <li class="nav-item">
<!--          <router-link :to="{ name: 'Incident'}" class="nav-link">Incidents</router-link>-->
<!--          <router-link to="/shield/incident" class="nav-link">Incidents</router-link>-->
          <router-link
              to="/shield/incident/"
              v-slot="{ href, navigate }">
            <a :href="href" @click="navigate" class="nav-link">Incidents</a>
          </router-link>
        </li>
        <li class="nav-item">
<!--          <router-link :to="{ name: 'Litige'}" class="nav-link">Litiges</router-link>-->
          <a class="nav-link" href="#">Litiges</a>
        </li>
        <li class="nav-item">
<!--          <router-link :to="{ name: 'Mission'}" class="nav-link">Missions</router-link>-->
          <a class="nav-link" href="#">Missions</a>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
  name: "Nav"
}
</script>
<style>
.logo {
  width: 50px;
  height: 50px;
}

</style>