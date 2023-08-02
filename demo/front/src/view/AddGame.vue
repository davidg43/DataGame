<script setup>
import Layout from "./Layout.vue"; 

function addGame(game) {
  console.log(JSON.stringify(game));
  fetch("http://localhost:8080/add/" + game, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(game)
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    // Aquí puedes manejar la respuesta en caso de éxito si es necesario
    // Por ejemplo, puedes mostrar un mensaje de éxito o redireccionar a otra página
    console.log('Game edited successfully');
  })
  .catch(error => {
    // Manejo de errores
    console.error('Error editing game:', error);
  });
}

</script>


<template>
  <Layout>
    <div class="container">
      <h2>Add Game</h2>
      <div class="forms">
        <form @submit="addGame">
        <div>
          <label for="title">Title:</label>
          <input type="text" id="title" v-model="newGame.title" />
        </div>
        <div>
          <label for="url">URL:</label>
          <input type="text" id="url" v-model="newGame.url" />
        </div>
        <div>
          <label for="released">Released:</label>
          <input type="text" id="released" v-model="newGame.released" />
        </div>
        <div>
          <label for="updated">Updated:</label>
          <input type="text" id="updated" v-model="newGame.updated" />
        </div>
        <div>
          <label for="rating">Rating:</label>
          <input type="text" id="rating" v-model="newGame.rating" />
        </div>
        <div>
          <label for="playTime">Play Time:</label>
          <input type="text" id="playTime" v-model="newGame.playTime" />
        </div>
        <div>
          <label for="achievements">Achievements:</label>
          <input type="text" id="achievements" v-model="newGame.achievements" />
        </div>
        <div>
          <label for="platforms">Platforms:</label>
          <input type="text" id="platforms" v-model="newGame.platforms" />
        </div>
        <div>
          <label for="developers">Developers:</label>
          <input type="text" id="developers" v-model="newGame.developers" />
        </div>
        <div>
          <label for="genres">Genres:</label>
          <input type="text" id="genres" v-model="newGame.genres" />
        </div>
        <div class="addGame">
          <router-link to="/games">
            <button id="addGame" style= "width: 100%; height: 100%;">Add</button>
          </router-link>
        </div>
      </form>
        
      </div>
    </div>
  </Layout>
</template>
  
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
  
  .addGame {
    margin-top: 10px;
    height: 50px;
    text-align: center;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 4px;
  }

  
 
  #addGame:hover {
    background-color: green;
    }


  </style>
  