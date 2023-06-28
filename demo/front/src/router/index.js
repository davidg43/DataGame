import { createRouter, createWebHistory } from 'vue-router'
import ViewUsers from '/src/views/ViewUsers.vue'
//import Home from '../views/Home.vue'
import Login from '/src/views/Login.vue'
import Register from '/src/views/Register.vue'
import UpdateUsers from '/src/views/UpdateUsers.vue'
//import Library from '../views/Library.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    /*{
      path: '/',
      name: 'home',
      component: Home
    },*/
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
    /*{
      path: '/library',
      name: 'library',
      component: Library
    },*/
    {
      path: '/view-users',
      name: 'view-users',
      component: ViewUsers
    },
    {
      path: '/update-users',
      name: 'update-users',
      component: UpdateUsers
    }
  ]
})

export default router