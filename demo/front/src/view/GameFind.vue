<template>
    <div class="game-find-container">
      <h1>Search Results for "{{ query }}"</h1>
      <ul v-if="filteredGames.length">
        <li v-for="game in filteredGames" :key="game.id">{{ game.title }}</li>
      </ul>
      <p v-else>No games found with this name.</p>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted, computed } from "vue";
  import GameService from "../service/GameService.js";
  import Game from "./Game.vue";
  import Home from "./Home.vue";
  import Layout from './Layout.vue';
  import { useRouter } from 'vue-router';
  
  const gameService = new GameService();
  const router = useRouter();
  const games = ref([]);
  const currentPage = ref(1);
  const gamesPerPage = 5;
  const props = defineProps(['query']);

  onMounted(async () => {
  games.value = await gameService.getByName(props.query);
  });

const filteredGames = computed(() => {
  return games.value.filter((game) =>
    game.name.toLowerCase().includes(query.toLowerCase())
  );
});

//   onBeforeMount(async () => {
//     games = router.currentRoute.value.params.query;
//   });
  
//   const paginatedGames = computed(() => {
//     const startIndex = (currentPage.value - 1) * gamesPerPage;
//     const endIndex = startIndex + gamesPerPage;
//     return games(startIndex, endIndex);
//   });
  
//   function goToPage(page) {
//     currentPage.value = page;
//   }
  
//   function nextPage() {
//     if (currentPage.value < totalPages.value) {
//       currentPage.value++;
//     }
//   }
  
//   function prevPage() {
//     if (currentPage.value > 1) {
//       currentPage.value--;
//     }
//   }
  
//   const totalPages = computed(() => Math.ceil(games.value.length / gamesPerPage));
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