<template>
  <Nav class="nav"/>
<!--  <Incident/>-->
<!--  <Home/>-->
  <router-view/>
<!--  <About/>-->
<!--  <incident class="incident"/>-->
</template>

<script>
// import Incident from '@/views/incident/Incident.vue'
import Nav from './components/Nav.vue'
// import Home from '@/views/Home'
// import About from '@/views/About'
import('@/assets/style/main.css')

export default {
  name: 'App',
  components: {
    Nav,
    // Home,
    // Incident,
    // About,
  }
}
</script>
<style>

.nav{
  margin: 0 0 5vw 0;
}

</style>
