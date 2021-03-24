<template>
  <div class="content w-25 m-auto">
    <form action="" @submit.prevent="handleSubmit" method="post" class="flex flex-column">
      <div class="form-group">
        <label for="email">Email address</label>
        <input v-model="email" name="email" type="email" class="form-control" id="email" aria-describedby="emailHelp"
               placeholder="Enter email">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input v-model="password" name="password" type="password" class="form-control" id="password"
               placeholder="Password">
      </div>
      <button type="submit" class="btn btn-primary m-auto">Se connecter</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios'
import Incident from "@/views/incident/Incident";

export default {
  name: "Login",
  data() {
    return {
      // formErrors: [],
      // errorMessage: null,
      email: '',
      password: '',
    }
  },
  methods: {
    backward() {
      this.$router.go(-1)
    },

    async handleSubmit() {
      const response = await axios.post(`/shield/login`, {
        email: this.email,
        password: this.password,
      })
      localStorage.setItem("token", response.data.token)
      this.$router.push(Incident)

    },
  },
}
</script>