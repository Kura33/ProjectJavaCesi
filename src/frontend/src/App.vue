<template>
  <Nav class="nav"/>
  <router-view/>
</template>

<script>
import Nav from './components/Nav.vue'
import('@/assets/style/main.css')

export default {
  name: 'App',
  components: {
    Nav,
  }
}
</script>
<style>

.nav{
  margin: 0 0 5vw 0;
}

</style>
