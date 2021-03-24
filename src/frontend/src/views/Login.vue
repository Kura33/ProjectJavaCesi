<template>
  <div class="content w-25 m-auto">
    <div class="errors" v-if="errors">
      <span><b>Please correct the following error(s):</b></span>
      <ul>
        <li>{{ errorMessage }}</li>
      </ul>
    </div>


    <form action="" @submit="checkForm" method="post" class="flex flex-column">
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

  <div>{{ connected ? connected :'nope' }}</div>
</template>

<script>
import axios from 'axios'

export default {
  name: "Login",
  data() {
    return {
      formErrors: [],
      errorMessage: null,
      email: null,
      password: null,
      connected: '',
      data: '',
    }
  },
  methods: {
    // 1
    // 2
    backward() {
      this.$router.go(-1)
    },
    // 3
    checkForm(e) {
      e.preventDefault();
      if (this.email && this.password) {
        this.connection();
      }
      this.formErrors = [];

      if (!this.email) {
        this.formErrors.push('Email required.');
      } else if (!this.validEmail(this.email)) {
        this.formErrors.push('Valid email required.');
      }
      if (!this.password) {
        this.formErrors.push('Password required.');
      }

      if (!this.formErrors.length) {
        this.connection();
      }


    },
    validEmail(email) {
      var re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      return re.test(email);
    },
    async connection() {

      const body = {
                email: this.email,
                password: this.password,
              };
      const headers = {"Content-Type": "application/json"};
      try {
        await axios.post(`/shield/login`, body, {headers})
        .then(response => {
          this.connected = response;
          console.log(response)
        })
        // .then(response => {
        //   axios.post(`/shield/user`,
        //       {},
        //       // {body: response},
        //       {headers: {Authorization: response.token}})
        // })
      } catch (e) {
        this.errors.push(e)
      }
    }
  },
  mounted() {
  }
}
</script>