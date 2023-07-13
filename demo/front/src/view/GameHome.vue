<script setup>
import { ref, onBeforeMount, defineAsyncComponent } from "vue"
import GameService from "../services/GameService.js"

const games = GameService.getGames()
const bannerGame = ref(null)

const AsyncGameBanner = defineAsyncComponent(() => {
  return import("../components/GameBanner.vue")
})    

onBeforeMount(async() => {
  await getGames() 
  gameBanner.value = gaes.value[getRandomInt(0, games.value.length - 1)]
})

</script>

<template>
    <AsyncBanner 
    :gameBanner="gameBanner"
    />
    <games 
    :game="games"
    />
</template>