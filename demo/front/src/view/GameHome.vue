<script setup>
import { ref, onBeforeMount } from "vue";
import GameService from "../service/GameService.js";
import Game from "./Game.vue";



const gameService = new GameService();
const games = ref([]);



onBeforeMount(async () => {
  games.value = await gameService.getAll()

});
</script>

<template>
    <div>
      <h1>Game Home</h1>
      <div v-for="game in games" :key="game.id">
                <Game :game="game" />
      </div>
    </div>
  </template>
  
