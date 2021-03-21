<template>
  <div class="content w-25 m-auto">
    <div class="errors" v-if="errors">
      <span><b>Please correct the following error(s):</b></span>
      <ul>
        <li>{{ errorMessage }}</li>
      </ul>
    </div>


    <form action="@/views/incident/Incident" @submit="checkForm" method="post" class="flex flex-column">
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
export default {
  name: "Login",
  data() {
    return {
      formErrors: [],
      errorMessage: null,
      email: null,
      password: null,
      connectionResult: '',
    }
  },
  methods: {
    // 1
    getLoginPage() {
      fetch("/shield/login")
          .then(response => response.json())
    },

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
      const requestOptions = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
          email: this.email,
          password: this.password,
        })
      };
      fetch('/shield/login', requestOptions)
          .then(async response => {
            const data = await response.json();

            // check for error response
            if (!response.ok) {
              // get error message from body or default to response status
              const error = (data && data.message) || response.status;
              return Promise.reject(error);
            }

            this.connectionResult = data
          })
          .catch(error => {
            this.errorMessage = error;
            console.error('There was an error!', error);
          });
    },
    // 4
    created() {
      this.getLoginPage()

    }
  },
  mounted() {
    this.created()
  }
}
</script>