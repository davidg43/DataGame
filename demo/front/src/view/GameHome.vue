<script setup>
import { ref, onBeforeMount } from "vue";
import GameService from "../service/GameService.js";

const gameService = new GameService();
const games = ref([]);

onBeforeMount(async () => {
  games.value = await gameService.getAll()
  console.log(games.value)
});
</script>

<template>
  <div v-if="games">
    <Game :games="games" />
  </div>
</template>
