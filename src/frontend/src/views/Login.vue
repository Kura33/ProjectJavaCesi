<template>
  <div class="content w-25 m-auto">
    <form action="" @submit.prevent="handleSubmit" method="post" class="form-login">
      <div>
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
      </div>
      <button type="submit" class="btn btn-primary m-auto">Se connecter</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios'

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
      await axios.post(`/shield/login`, {
        email: this.email,
        password: this.password,
      })
          .then(response => {
            localStorage.setItem("token", response.data.token)
            window.location.href="/api-shield/incident/";
            response.status === 200
                ? this.$toast.success('Connexion réussie')
                : this.$toast.error("La connexion n'a pu aboutir, veuillez réessayer ultérieurement")
          })

    },
  },
}
</script>

<style>
.content {
  width: 50%;
}
.form-login {
  margin: 100px auto;
  display: flex;
  flex-direction: column;
  max-width: 500px;
}

</style>