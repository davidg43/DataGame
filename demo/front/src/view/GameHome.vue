<template>
  <div class="game-home-container">
    <h1>Game Home</h1>
    <div class="add-game-button">
      <router-link to="/add">
        <button>Add Game</button>
      </router-link>
    </div>
    <div style="min-width: 675px; display: flex; justify-content: center;" class="elemento" v-for="game in paginatedGames" :key="game.id">
      <Game :game="game" />
    </div>

    <div>
      <button @click="prevPage" :disabled="currentPage === 1">Prev</button>
      <span>{{ currentPage }} / {{ totalPages }}</span>
      <button @click="nextPage" :disabled="currentPage === totalPages">Next</button>
    </div>
  </div>
</template>

<script setup>
import { ref, onBeforeMount, computed } from "vue";
import GameService from "../service/GameService.js";
import Game from "./Game.vue";

const gameService = new GameService();
const games = ref([]);
const currentPage = ref(1);
const gamesPerPage = 5;

onBeforeMount(async () => {
  games.value = await gameService.getAll();
});

const paginatedGames = computed(() => {
  const startIndex = (currentPage.value - 1) * gamesPerPage;
  const endIndex = startIndex + gamesPerPage;
  return games.value.slice(startIndex, endIndex);
});

function goToPage(page) {
  currentPage.value = page;
}

function nextPage() {
  if (currentPage.value < totalPages.value) {
    currentPage.value++;
  }
}

function prevPage() {
  if (currentPage.value > 1) {
    currentPage.value--;
  }
}



const totalPages = computed(() => Math.ceil(games.value.length / gamesPerPage));
</script>

<style scoped>
.add-game-button {
  margin-bottom: 20px;
}

.add-game-button button {
  padding: 8px 16px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.add-game-button button:hover {
  background-color: #0056b3;
}




</style>