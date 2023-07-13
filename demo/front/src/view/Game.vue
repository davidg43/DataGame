<script setup>
import { useRouter } from "vue-router"
import { ref } from "vue";
import { Icon } from "@iconify/vue"
//import getImage from "../lib/getImage"
const router = useRouter()
// const gameId = router.currentRoute.value.params.id
const game = ref(null)

game.value = await fetch(`localhost:8080/game/${game.id}`).then(res => res.json())

const {
    id,
    title,
    released,
    updated,
    url,
    rating,
    ratingTop,
    playTime,
    achivement,
    platform,
    developers, 
    genres
} = game.value

</script>

<template>
    <div
    class="h-screen w-screen grayscale-0"
    >
        <div class="w-full h-full bg-gradient-to-r from-black to-transparent">
            <div class="pt-20 w-full h-full grid grid-cols-2 items-center">
                <div>
                    <h1 class="text-4xl font-semibold mb-4">{{ title }}</h1>
                    <p class="text-sm text-neutral-300 w-2/3">{{ url }}</p>
                    <div class="flex flex-col text-sm gap-2 mt-3">
                        <div class="flex items-center gap-2">
                            <Icon icon="uiw:date" />
                            <span>{{ released }}</span>
                        </div>
                        <div class="flex items-center gap-2">
                            <Icon icon="uiw:date" />
                            <span>{{ updated }}</span>
                        </div>
                        <div class="flex items-center gap-2">
                            <Icon icon="ic:round-star" />
                            <span>{{ Math.round(rating) }}/10</span>
                        </div>
                        <div class="flex items-center gap-2">
                            <Icon icon="ion:people" />
                            <span>{{ ratingTop }} </span>
                        </div>
                        <div class="flex items-center gap-2">
                            <Icon icon="ion:people" />
                            <span>{{ rating }} </span>
                        </div>
                        <div class="flex items-center gap-2">
                            <Icon icon="ion:people" />
                            <span>{{ playTime }} </span>
                        </div>
                        <div class="flex items-center gap-2">
                            <Icon icon="ion:people" />
                            <span>{{ achivement }} </span>
                        </div>
                        <div class="flex items-center gap-2">
                            <Icon icon="ion:people" />
                            <span>{{ platform }} </span>
                        </div>
                        <div class="flex items-center gap-2">
                            <Icon icon="ion:people" />
                            <span>{{ developers }} </span>
                        </div>
                        <div class="flex items-center gap-2">
                            <Icon icon="ion:people" />
                            <span>{{ genres }} </span>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>

    </div>
</template>