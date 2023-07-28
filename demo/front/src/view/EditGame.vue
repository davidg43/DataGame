<script>
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
  </script>

<template>
  <Layout>
    <div class="container">
      <h2>Edit Game</h2>
      <form @submit="updateGame">
        <div>
          <label for="title">Title:</label>
          <input type="text" id="title" v-model="editedGame.title" />
        </div>
        <div>
          <label for="url">URL:</label>
          <input type="text" id="url" v-model="editedGame.url" />
        </div>
        <div>
          <label for="released">Released:</label>
          <input type="text" id="released" v-model="editedGame.released" />
        </div>
        <div>
          <label for="updated">Updated:</label>
          <input type="text" id="updated" v-model="editedGame.updated" />
        </div>
        <div>
          <label for="rating">Rating:</label>
          <input type="text" id="rating" v-model="editedGame.rating" />
        </div>
        <div>
          <label for="playTime">Play Time:</label>
          <input type="text" id="playTime" v-model="editedGame.playTime" />
        </div>
        <div>
          <label for="achievements">Achievements:</label>
          <input type="text" id="achievements" v-model="editedGame.achievements" />
        </div>
        <div>
          <label for="platforms">Platforms:</label>
          <input type="text" id="platforms" v-model="editedGame.platforms" />
        </div>
        <div>
          <label for="developers">Developers:</label>
          <input type="text" id="developers" v-model="editedGame.developers" />
        </div>
        <div>
          <label for="genres">Genres:</label>
          <input type="text" id="genres" v-model="editedGame.genres" />
        </div>
        <div class="edit">
          <router-link to="/games">
            <button id="edit" style= "width: 100%; height: 100%;">Edit Game</button>
          </router-link>
        </div>
      </form>
    </div>
  </Layout>
</template>

<script setup>
import Layout from "./Layout.vue"; 
</script>
  
  <style>

  .container{ 
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
  