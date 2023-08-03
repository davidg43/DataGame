import { createRouter, createWebHistory } from 'vue-router'
import Home from '../view/Home.vue'
import Login from '../view/Login.vue'
import Register from '../view/Register.vue'
import Game from '../view/Game.vue'
import GameHome from '../view/GameHome.vue'
import AddGame from "../view/AddGame.vue"
import EditGame from "../view/EditGame.vue"
import OneGame from "../view/OneGame.vue"
import GameFind from "../view/GameFind.vue"

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/home',
      name: 'home',
      component: Home
    },
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
      path: '/edit/:id',
      name: 'edit',
      component: EditGame
    },
    {
      path: '/find/:query',
      name: 'find',
      component: GameFind
    },
    {
      path: '/add',
      name: 'add',
      component: AddGame
    },
    {
      path: '/game/:id',
      name: 'game',
      component: OneGame
    }
  ]
})

export default router