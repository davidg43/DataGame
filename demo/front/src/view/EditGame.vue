<!-- <script>
  export default {
    props: {
      game: {
        type: Object,
        required: true,
      },
    },
    data() {
      return {
        editedGame: { ...this.game },
      };
    },
    mounted() {
    this.editedGame = { ...this.game };
    },
    methods: {
      updateGame() {
        // Aquí puedes implementar la lógica para actualizar el juego en la base de datos o realizar otras acciones necesarias
        console.log('Edited Game:', this.editedGame);
      },
    },
  };
  </script> -->
  
  <script setup>
  import { ref, watch, onBeforeMount, computed } from "vue";
  import { useRouter } from "vue-router"
  import { Icon } from "@iconify/vue"
  import GameService from "../service/GameService.js";
  import Layout from './Layout.vue';
  
  const game = ref(null);
  const gameService = new GameService();
  const router = useRouter();
  
  onBeforeMount(async () => {
    const gameId = router.currentRoute.value.params.id;
    game.value = await gameService.getById(gameId);
    console.log(game.value);
  });

  function formatDateTime(dateTimeString) {
    return dateTimeString ? dateTimeString.replace("T", " ") : "N/A";
  }

  //const formattedUpdated = computed(() => formatDateTime(game.value.updated));

  // function updateGame(id) {
  //   gameService.updateGame(id);
  //   console.log('Edited Game:', id);
  // }

  function updateGame(id) {
  return new Promise((resolve, reject) => {
    gameService.updateGame(id)
      .then(response => {
        console.log('Edited Game:', id);
        resolve(response); // Resolves the promise with the response from gameService.updateGame
      })
      .catch(error => {
        console.error('Error updating game:', error);
        reject(error); // Rejects the promise with the error received from gameService.updateGame
      });
  });
}

  </script>


<template>
  <Layout>
    <div class="updateform" v-if="game">
      <h2>Edit Game</h2>
      <form @submit="updateGame">
        <div>
          <label for="title">Title:</label>
          <input type="text" id="title" v-model="game.title" />
        </div>
        <div>
          <label for="url">URL:</label>
          <input type="text" id="url" v-model="game.url" />
        </div>
        <div>
          <label for="released">Released:</label>
          <input type="text" id="released" v-model="game.released" />
        </div>
        <div>
          <label for="updated">Updated:</label>
          <input type="text" id="updated" v-model="game.updated" />
        </div>
        <div>
          <label for="rating">Rating:</label>
          <input type="text" id="rating" v-model="game.rating.lowerBound.value" />
        </div>
        <div>
          <label for="rating">Rating Top:</label>
          <input type="text" id="ratingTop" v-model="game.ratingTop.lowerBound.value" />
        </div>
        <div>
          <label for="playTime">Play Time:</label>
          <input type="text" id="playTime" v-model="game.playTime" />
        </div>
        <div>
          <label for="achievements">Achievements:</label>
          <input type="text" id="achievements" v-model="game.achievements" />
        </div>
        <div>
          <label for="platforms">Platforms:</label>
          <input type="text" id="platforms" v-model="game.platform" />
        </div>
        <div>
          <label for="developers">Developers:</label>
          <input type="text" id="developers" v-model="game.developers" />
        </div>
        <div>
          <label for="genres">Genres:</label>
          <input type="text" id="genres" v-model="game.genres" />
        </div>
        <div class="edit">
          <router-link to="/games">
            <button @click="updateGame(game.id)" id="updateGame" style= "width: 100%; height: 100%;">Edit Game</button>
          </router-link>
        </div>
      </form>
    </div>
  </Layout>
</template>
  
<style>

.updateform {
    margin:auto;
    width: 70%;
    padding: 20px;
    background-color: #434343;
    border-radius: 8px;
  }
  
  
  label {
    display: block;
    font-weight: bold;
    margin-top: 10px;
  }
  
  input[type="text"] {
    width: 100%;
    padding: 5px;
    border: 1px solid #ccc;
    border-radius: 4px;
    margin-top: 5px;
    color: #000000;
  }
  
  .edit {
    margin-top: 10px;
    height: 50px;
    text-align: center;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 4px;
  }

  
 
  #edit:hover {
    background-color: green;
    }


  </style>
  