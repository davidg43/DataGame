<template>
  <Layout>
    <div v-if="randomGame">
      <div class="game">
        <h2 style="font-weight: bold; text-align: center;">{{ randomGame.title }}</h2>
      </div>
    </div>
  </Layout>
</template>

<script setup>
import { ref, onBeforeMount } from "vue";
import GameService from "../service/GameService.js";
import Layout from './Layout.vue';

const gameService = new GameService();
const games = ref([]);

const randomGame = null;

onBeforeMount(async () => {
  games.value = await gameService.getAll();
  const ids = games.value.map((game) => game.id);

  const id =()=> {
    return ids [Math.floor(Math.random() * ids.length)] 
  };

  if (games.value.length > 0) {
    const randomIndex = Math.floor(Math.random() * games.value.length);
    randomGame = games.value[randomIndex];
  }
});
</script>

<style>
.game {
  border: 0.5px solid whitesmoke;
  padding: 6%;
  margin-top: 10%;
  width: 60%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
</style>
