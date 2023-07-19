<script setup>
import { useRouter } from "vue-router"
import { ref, onMounted } from "vue";
import { Icon } from "@iconify/vue"
import axios from 'axios';
import { Input } from "postcss";
import GameService from "../service/GameService.js";

const router = useRouter()
const props = defineProps(['game'])
const showConfirmationDialog = ref(false);


function formatDateTime(dateTimeString) {
  dateTimeString = dateTimeString.replace("T", " ");
  return dateTimeString;

  function deleteGame() {
  const gameService = new GameService();
  gameService.deleteGame(game.id);
  router.push({ name: "GameHome" });
  showConfirmationDialog.value = true;
}

function editGame() {
  router.push({ name: "EditGame", params: { id: game.id } });
}
}



</script>


<template>
  <div class="game" v-if="game">
    <div style="width: 100%;">
      <h2 style="font-weight: bold; text-align: center;">{{ game.title }} </h2>
      <h6 style="font-weight: inherit; text-align: center;" >{{ game.url }}</h6>
      <br>
      <div class="data">
        <div class="row date1">
          <Icon class="icon" icon="uiw:date" />
          <span class="info">{{ game.released }}</span>
        </div>
        <div class="row date2">
          <Icon class="icon" icon="material-symbols:update" />
          <span class="info">{{ formatDateTime(game.updated) }}</span>
        </div>
        <div class="row rating">
          <Icon class="icon" icon="ic:round-star" />
          <span class="info">{{ game.rating.lowerBound.value }}/10</span>
        </div>
        <div class="row top">
          <Icon class="icon" icon="solar:ranking-bold" />
          <span class="info">{{ game.ratingTop.lowerBound.value }}</span>
        </div>
        <div class="row time">
          <Icon class="icon" icon="mdi:clock" />
          <span class="info">{{ game.playTime }}</span>
        </div>
        <div class="row achiv">
          <Icon class="icon" icon="solar:flag-bold" />
          <span class="info">{{ game.achievements }}</span>
        </div>
        <br>
        <span> Platforms:</span>
        <div v-for="platform in game.platform" :key="platform">
            <div class="row platform"  v-if="platform != ''">
              <Icon class="icon" icon="icon-park-outline:game-console" />
              <span class="info">{{ platform }}</span>
            </div>
        </div>
        <br>
        <span> Developers:</span>
        <div v-for="develop in game.developers" :key="develop">
           <div class="row develop" v-if="develop != ''">
              <Icon class="icon" icon="iconoir:developer" />
              <span class="info">{{ develop }}</span>
           </div>
        </div>
        <br>
        <span> Genres:</span>
        <div  v-for="genre in game.genres" :key="genre">
          <div class="row genre" v-if="genre != ''">
              <Icon class="icon" icon="bxs:game" />
              <span class="info">{{ genre }}</span>
          </div>
        </div>
        <br>
        <div style="display:grid; grid-template-columns:1fr 1fr; gap: 10px;" class="buttons">
          <button class="update" @click="editGame">Edit</button>
          <button class="delete" @click="showConfirmationDialog = true">Delete</button>
        </div>

        <div v-if="showConfirmationDialog" class="confirmation-dialog">
          <p>¿Estás seguro de que deseas eliminar este juego?</p>
          <div class="buttons">
            <button @click="deleteGame">Confirmar</button>
            <button @click="showConfirmationDialog = false">Cancelar</button>
          </div>
        </div>

        
      </div>
    </div>
  </div>
</template>



<style>

.game{
  border: 0.5px solid whitesmoke;
  display: flex;
  padding: 6%;
  margin-top: 10%;
  width: 60%;
  align-items: center;
  justify-content: center;
}

.row{
  display: grid;
  align-items: center;
  gap: 15%;
  grid-template-columns: auto 1fr;
  grid-template-areas: "icon info";
}

.icon{
  justify-content: center;
  grid-area: icon;
}
.info{
  justify-content: center;
  grid-area: info;
}

.data{
  justify-content: center;
}

.update {
  bottom: 10px;
  right: 10px;
  padding: 8px 16px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.delete {
  bottom: 10px;
  right: 70px;
  padding: 8px 16px;
  background-color: #dc3545;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.confirmation-dialog {
  text-align: center;

  color: #000000;
  padding: 16px;
  background-color: #fff;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.confirmation-dialog p {
  margin-bottom: 10px;
}

.confirmation-dialog .buttons {
  display: flex;
  justify-content: flex-end;
}

.confirmation-dialog button {
  margin-left: 10px;
  padding: 8px 16px;
  background-color: #007bff;
  color: #000000;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.confirmation-dialog button:last-child {
  background-color: #dc3545;
}
</style>