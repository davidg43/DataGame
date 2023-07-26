<template>
  <nav class="navbar">
    <div class="navbar-logo">
      <router-link to="/">
        <Icon class="icon" icon="fxemoji:videogame" />
        <span class="logo-text">DataGame</span>
      </router-link>
    </div>
    <div class="navbar-links">
      <router-link to="/" class="nav-link" :class="{ active: currentRoute === '/' }">Home</router-link>
      <router-link to="/games" class="nav-link" :class="{ active: currentRoute === '/games' }">Games</router-link>
      <router-link to="/login" class="nav-link" :class="{ active: currentRoute === '/login' }">Login</router-link>
      <router-link to="/register" class="nav-link" :class="{ active: currentRoute === '/register' }">Register</router-link>
    </div>
  </nav>
</template>

<script setup>
import { computed } from 'vue';
import { useRoute } from 'vue-router';

const currentRoute = computed(() => useRoute().path);
</script>

<style scoped>
.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #007bff;
  color: #fff;
  padding: 10px;
}

.navbar-logo {
  display: flex;
  align-items: center;
}

.icon {
  font-size: 24px;
  margin-right: 5px;
}

.logo-text {
  font-weight: bold;
  font-size: 18px;
}

.navbar-links {
  display: flex;
}

.nav-link {
  color: #fff;
  text-decoration: none;
  margin-left: 20px;
}

.nav-link.active {
  font-weight: bold;
}
</style>