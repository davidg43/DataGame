import { createRouter, createWebHistory } from 'vue-router'
// import Home from '../view/Home.vue'
import Login from '../view/Login.vue'
import Register from '../view/Register.vue'
import Game from '../view/Game.vue'
import GameHome from '../view/GameHome.vue'
// import Movie from "../view/Movie.vue"

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // {
    //   path: '/',
    //   name: 'home',
    //   component: Home
    // },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/register',
      name: 'register',
      component: Register
    },
    {
      path: '/games',
      name: 'games',
      component: GameHome
    },
    {
      path: '/game/:id',
      name: 'game',
      component: Game
    }
    // {
    //   path: '/movies',
    //   name: 'movies',
    //   component: Movie
    // },
    // {
    //   path: '/movies/:id',
    //   name: 'movies',
    //   component: Movie
    // }
  ]
})

export default router