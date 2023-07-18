<template>
    <div>
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
        <!-- Agrega otros campos que desees editar -->
        <button type="submit">Save</button>
      </form>
    </div>
  </template>
  
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
    methods: {
      updateGame() {
        // Aquí puedes implementar la lógica para actualizar el juego en la base de datos o realizar otras acciones necesarias
        console.log('Edited Game:', this.editedGame);
      },
    },
  };
  </script>
  
  <style>
  /* Estilos adicionales para el formulario de edición */
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
  }
  
  button {
    margin-top: 10px;
    padding: 5px 10px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  
  button:hover {
    background-color: #0056b3;
  }
  </style>
  