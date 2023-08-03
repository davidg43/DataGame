<template>
  <nav class="navbar">
    <div class="navbar-logo">
      <div id="app">
        <input v-model="gameName" type="text" placeholder="Search...">
        <button @click="searchName(gameName)" id="search">Search</button>
        
      </div>
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
import { useRoute, useRouter } from 'vue-router';
import GameService from '../service/GameService';
import GameFind from './GameFind.vue';

const currentRoute = computed(() => useRoute().path);
const gameService = new GameService();
const router = useRouter();

function searchName(query, title) {
  const games = gameService.getByName(query);
  console.log(games);
  if (games.length == 0) {
    alert('Games with this name are not found');
  } else {
    router.push({
    path: '/find/:query',
    params: { query: query },
    name: 'find',
    component: GameFind,
});
  }
}

</script>

<style scoped>
.navbar {
  min-width: 100%;
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

#app {
  display: grid;
  grid-template-columns: 1fr 1fr;
}
</style>