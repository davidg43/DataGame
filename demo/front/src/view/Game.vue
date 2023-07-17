<script setup>
import { useRouter } from "vue-router"
import { ref, onMounted } from "vue";
import { Icon } from "@iconify/vue"
import axios from 'axios';
import { Input } from "postcss";

const router = useRouter()
// const gameId = router.currentRoute.value.params.id
// const game = ref({})
const props = defineProps(['game'])




// onMounted(async () => {
//   try {
//     const response = await fetch(`http://localhost:8080/games/${gameId}`);
//     game.value = response.data;
//   } catch (error) {
//     console.error(error);
//   }
// })
</script>


<template>
  <div  class="h-screen w-screen grayscale-0">
    <div class="w-full h-full bg-gradient-to-r from-black to-transparent">
      <div class="pt-20 w-full h-full items-center" v-if="game">
        <div>
          <h1 class="text-4xl font-semibold mb-4">{{ game.title }}</h1>
          <p class="text-sm text-neutral-300 w-2/3">{{ game.url }}</p>
          <div class="flex flex-col text-sm gap-2 mt-3">
            <div class="flex items-center gap-2">
              <Icon icon="uiw:date" />
              <span>{{ game.released }}</span>
            </div>
            <div class="flex items-center gap-2">
              <Icon icon="material-symbols:update" />
              <span>{{ game.updated }}</span>
            </div>
            <div class="flex items-center gap-2">
              <Icon icon="ic:round-star" />
              <span>{{ game.rating.lowerBound.value }}/10</span>
            </div>
            <div class="flex items-center gap-2">
              <Icon icon="solar:ranking-bold" />
              <span>{{ game.ratingTop.lowerBound.value }} </span>
            </div>
            <div class="flex items-center gap-2">
              <Icon icon="mdi:clock" />
              <span>{{ game.playTime }} </span>
            </div>
            <div class="flex items-center gap-2">
              <Icon icon="solar:flag-bold" />
              <span>{{ game.achievements }} </span>
            </div>
            <div v-for="platform in game.platforms">
              <Icon icon="icon-park:game-console" />
               <span> {{ platform }}</span>
              </div>
            <div class="flex items-center gap-2">
              <Icon icon="iconoir:developer" />
              <div v-for="develop in game.developers">
               <span> {{ develop }}
              </span>
              </div>
            </div>
            <div class="flex items-center gap-2">
              <Icon icon="bxs:game" />
              <div v-for="genre in game.genres">
               <span> {{ genre }}</span>
              </div>
    
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

