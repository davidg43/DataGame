import '/src/assets/main.css'
import { createApp } from 'vue'
import App from '/src/App.vue'
import router from '/src/router'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'

const app = createApp(App)

app.use(router)

app.mount('#app')
