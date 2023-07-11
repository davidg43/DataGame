<template>
    <main>
      <header>
        <Navbar />
      </header>
  
      <section>
        <h1 class="text-center">View User</h1>
        <a href="/add" class="btn btn-primary">Add User</a>
        <table class="table table-striped">
          <thead>
            <tr>
              <th scope="col">Id</th>
              <th scope="col">Name</th>
              <th scope="col">Surname</th>
              <th scope="col">Email</th>
              <th scope="col">Phone Number</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="user in users" :key="user.id">
              <td>{{user.id}}</td>
              <td>{{user.name}}</td>
              <td>{{user.surname}}</td>
              <td>{{user.email}}</td>
              <td>{{user.pNo}}</td>
              <td>
                <a class="btn btn-primary" :href="`/edit/${user.id}`">Edit</a>
                <button class="btn btn-danger mx-2" @click="deleteUser(user.id)">Delete</button>
              </td>
            </tr>
          </tbody>
        </table>
      </section>
    </main>
  </template>


<script>
import Navbar from '../components/Navbar.vue'

    export default {
        name: 'ViewUsers',
        components: {
            Navbar
        },
        data() {
            return {
                users: []
            }
        },

        beforeMount(){
            this.getUsers()
        },

        methods: {
            getUsers(){
                fetch('http://localhost:8080/users')
                .then(res => res.json())
                .then(data => {
                    this.users = data
                    console.log(data)
                })
            },
            deleteUsers(id){
                fetch(`http://localhost:8080/user/${id}`, {
                    method: 'DELETE'
                })
                .then(data => {
                    console.log(data)
                    this.getUsers()
                })
            }
        }

    }

</script>