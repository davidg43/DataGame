import { createRouter, createWebHistory } from 'vue-router'
import ViewUsers from '../views/ViewUsers.vue'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import Game from '../views/Game.vue'
import GameHome from '../views/GameHome.vue'
//import Library from '../views/Library.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
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
      path: '/game/:id',
      name: 'game',
      component: Game
    },
    /*{
      path: '/library',
      name: 'library',
      component: Library
    },*/
    {
      path: '/view-users',
      name: 'view-users',
      component: ViewUsers
    }
  ]
})

export default router