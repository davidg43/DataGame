<script setup>
import { ref } from 'vue';
import Layout from './Layout.vue';

const username = ref('');
const password = ref('');

const handleSubmit = () => {
  // Aquí puedes realizar la lógica de envío del formulario
  console.log('Formulario enviado');
};
</script>

<template>
  <Layout>
    <div>
      <div class="content">
        <div class="login-form">
          <h2>Login</h2>
          <form @submit.prevent="handleSubmit">
            <div class="form-group">
              <label>Username</label>
              <input type="text" v-model="username" required>
            </div>
            <div class="form-group">
              <label>Password</label>
              <input type="password" v-model="password" required>
            </div>
            <button type="submit">Login</button>
          </form>
        </div>
      </div>
    </div>
  </Layout>
</template>

<style scoped>
.content {
  margin-top: 220px; 
}
.login-form {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  background-color: #434343;
  border-radius: 8px;
}

.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  font-weight: bold;
}

input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #000000;
  border-radius: 4px;
  color: #000000;
}

button[type="submit"] {
  padding: 10px 20px;
  background-color: #007bff;
  color: #ffffff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button[type="submit"]:hover {
  background-color: #0056b3;
}
</style>
