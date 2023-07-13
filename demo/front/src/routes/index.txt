import Login from "../view/Login.vue"
import Register from "../view/Register.vue"
import Home from "../view/Home.vue"
import Movie from "../view/Movie.vue"
import { createRouter, createWebHistory } from "vue-router"

const routes = [
    { path: "/", component: Home },
    { path: "/login", component: Login },
    { path: "/register", component: Register },
    { path: "/movies/:id", component: Movie }
]

export const router = createRouter({
    history: createWebHistory(),
    routes
})