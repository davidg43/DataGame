<script setup>
import { ref } from 'vue';

const email = ref('');
const username = ref('');
const name = ref('');
const surname = ref('');
const password = ref('');
const confirmPassword = ref('');

const handleSubmit = () => {
  // Validar y enviar los datos del formulario
  if (password.value !== confirmPassword.value) {
    // Aquí puedes mostrar un mensaje de error si las contraseñas no coinciden
    console.log('Las contraseñas no coinciden');
    return;
  }

  // Aquí puedes realizar la lógica de envío del formulario
  console.log('Formulario enviado');
};
</script>


<template>
  <div>
    <Navbar />
    <div class="content">
      <div class="register-form">
        <h2>Register</h2>
        <form @submit.prevent="handleSubmit">
          <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" v-model="email" required>
          </div>
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" v-model="username" required>
          </div>
          <div class="form-group">
            <label for="name">Name</label>
            <input type="text" id="name" v-model="name" required>
          </div>
          <div class="form-group">
            <label for="surname">Surname</label>
            <input type="text" id="surname" v-model="surname" required>
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" v-model="password" required>
          </div>
          <div class="form-group">
            <label for="confirm-password">Confirm Password</label>
            <input type="password" id="confirm-password" v-model="confirmPassword" required>
          </div>
          <button type="submit">Register</button>
        </form>
      </div>
    </div>
  </div>
</template>

<style scoped>
.content {
  margin-top: 100px; /* Ajusta el valor según el tamaño del Navbar */
}
.register-form {
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

input[type="email"],
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
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button[type="submit"]:hover {
  background-color: #0056b3;
}
</style>
