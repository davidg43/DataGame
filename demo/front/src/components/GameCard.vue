<script setup>
//import getImage from '../lib/getImage';
import { Icon } from '@iconify/vue';
import { RouterLink } from 'vue-router';
const { game } = defineProps(["game"])
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
const description = overview.length <= 60 ? overview : overview.slice(0, 60) + "..."
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
                            <Icon icon="ion:people" />
                            <span>{{ rating }} </span>
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