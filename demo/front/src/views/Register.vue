<template>
  <div class="container">
    <!-- Logo Div -->
    <!--    Logo Div-->
    <!--<div class="row">
      <div class="col-12 text-center pt-3">
        <router-link :to="{ name: 'login' }">
          <img id="logo" src="../assets/logo.png" />
        </router-link>
      </div>
    </div>-->

    <div class="row">
      <div class="col-12 justify-content-center d-flex flex-row pt-5">
        <div id="register" class="flex-item border">
          <h2 class="pt-4 pl-4">Create Account</h2>
          <form @submit="register" class="pt-4 pl-4 pr-4">
            <!-- Form fields -->
            <div class="form-group">
              <label for="email">Email</label>
              <input
                type="email"
                id="email"
                class="form-control"
                placeholder="Email"
                required
                v-model="email"
              />
            </div>
            <div class="form-group">
              <label for="username">Username</label>
              <input
                type="text"
                id="username"
                class="form-control"
                placeholder="Username"
                required
                v-model="username"
              />
            </div>
            <div class="form-group">
              <label for="name">Name</label>
              <input
                type="text"
                id="name"
                class="form-control"
                placeholder="Name"
                required
                v-model="name"
              />
            </div>
            <div class="form-group">
              <label for="surname">Surname</label>
              <input
                type="text"
                id="surname"
                class="form-control"
                placeholder="Surname"
                required
                v-model="surname"
              />
            </div>
            <div class="form-group">
              <label for="password">Password</label>
              <input
                type="password"
                id="password"
                class="form-control"
                placeholder="Password"
                required
                v-model="password"
              />
            </div>
            <div class="form-group">
              <label for="passwordConfirm">Confirm Password</label>
              <input
                type="password"
                id="passwordConfirm"
                class="form-control"
                placeholder="Confirm Password"
                required
                v-model="passwordConfirm"
              />
            </div>

            <button type="submit" class="btn btn-primary mt-2 py-0">
              Create Account
            </button>
          </form>
          <hr />
          <small class="form-text text-muted pt-2 pl-4 text-center">
            Already Have an Account?
          </small>
          <p class="text-center">
            <router-link
              class="btn btn-dark text-center mx-auto px-5 py-1 mb-2"
              :to="{ name: 'login' }"
            >
              Login Here
            </router-link>
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Register",
  props: ["baseURL"],
  data() {
    return {
      email: null,
      username: null,
      name: null,
      surname: null,
      password: null,
      passwordConfirm: null,
    };
  },
  methods: {
    register(e) {
      e.preventDefault();
      // if the password matches
      if (this.password === this.passwordConfirm) {
        // make the post body
        const user = {
          email: this.email,
          username: this.username,
          name: this.name,
          surname: this.surname,
          password: this.password,
        };
        // Perform registration logic
      }
    },
  },
};
</script>
  
  <style scoped>
  .btn-dark {
    background-color: #e7e9ec;
    color: #000;
    font-size: smaller;
    border-radius: 0;
    border-color: #adb1b8 #a2a6ac #a2a6ac;
  }
  
  .btn-primary {
    background-color: #f0c14b;
    color: black;
    border-color: #a88734 #9c7e31 #846a29;
    border-radius: 0;
  }
  .container {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
}

#register {
  width: 100%;
  max-width: 400px;
  padding: 20px;
  margin: auto; /* Add this line to center the form horizontally */
}
</style>