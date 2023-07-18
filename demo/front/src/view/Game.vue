<script setup>
import { useRouter } from "vue-router"
import { ref, onMounted } from "vue";
import { Icon } from "@iconify/vue"
import axios from 'axios';
import { Input } from "postcss";

const router = useRouter()
const props = defineProps(['game'])

function formatDateTime(dateTimeString) {
  dateTimeString = dateTimeString.replace("T", " ");
  return dateTimeString;
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

/* .game{
  margin-top: 10%;
  display: flex;
  align-items: center;
  flex-direction: column;
  border: 4px solid whitesmoke;
}
.data{
  display: grid;
  grid-template-columns: auto 1fr;
  grid-template-areas:
  "icon info";
  align-items: center;
}

.icon{
  grid-area: icon;
  grid-column: 1;
  width: 30px;

}
.info{
  grid-area: info;
  grid-column: 2;
} */


</style>