<template>
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
        <div class="add">
          <router-link to="/games">
            <button id="add" style= "width: 100%; height: 100%;">Add</button>
          </router-link>
        </div>
      </form>
        
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        newGame: {
          title: "",
          url: "",
          released: "",
          updated: "",
          rating: "",
          playTime: "",
          achievements: "",
          platforms: "",
          developers: "",
          genres: "",
        },
      };
    },
    methods: {
      addGame() {
        console.log('New Game:', this.newGame);
        this.newGame = {
          title: "",
          url: "",
          released: "",
          updated: "",
          rating: "",
          playTime: "",
          achievements: "",
          platforms: "",
          developers: "",
          genres: "",
        };
      },
    },
  };
  </script>
  
  <style>


  .container{
    margin:auto;
    padding: auto;
    width: 70%;
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
  }
  
  .add {
    margin-top: 10px;
    height: 50px;
    text-align: center;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 4px;
  }

  
 
  #add:hover {
    background-color: green;
    }


  </style>
  