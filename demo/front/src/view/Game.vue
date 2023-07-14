<script setup>
import { useRouter } from "vue-router"
import { ref, onMounted } from "vue";
import { Icon } from "@iconify/vue"
import axios from 'axios';

const router = useRouter()
const gameId = router.currentRoute.value.params.id
const game = ref(null)

onMounted(async () => {
  try {
    const response = await axios.get(`http://localhost:8080/game/${gameId}`);
    game.value = response.data;
  } catch (error) {
    console.error(error);
  }
})
</script>


<template>
  <div class="h-screen w-screen grayscale-0">
    <div class="w-full h-full bg-gradient-to-r from-black to-transparent">
      <div class="pt-20 w-full h-full grid grid-cols-2 items-center" v-if="game.value">
        <div>
          <h1 class="text-4xl font-semibold mb-4">{{ game.value.title }}</h1>
          <p class="text-sm text-neutral-300 w-2/3">{{ game.value.url }}</p>
          <div class="flex flex-col text-sm gap-2 mt-3">
            <div class="flex items-center gap-2">
              <Icon icon="uiw:date" />
              <span>{{ game.value.released }}</span>
            </div>
            <div class="flex items-center gap-2">
              <Icon icon="uiw:date" />
              <span>{{ game.value.updated }}</span>
            </div>
            <div class="flex items-center gap-2">
              <Icon icon="ic:round-star" />
              <span>{{ Math.round(game.value.rating) }}/10</span>
            </div>
            <div class="flex items-center gap-2">
              <Icon icon="ion:people" />
              <span>{{ game.value.ratingTop }} </span>
            </div>
            <div class="flex items-center gap-2">
              <Icon icon="ion:people" />
              <span>{{ game.value.playTime }} </span>
            </div>
            <div class="flex items-center gap-2">
              <Icon icon="ion:people" />
              <span>{{ game.value.achievements }} </span>
            </div>
            <div class="flex items-center gap-2">
              <Icon icon="ion:people" />
              <span>{{ game.value.platform }} </span>
            </div>
            <div class="flex items-center gap-2">
              <Icon icon="ion:people" />
              <span>{{ game.value.developers }} </span>
            </div>
            <div class="flex items-center gap-2">
              <Icon icon="ion:people" />
              <span>{{ game.value.genres }} </span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>


