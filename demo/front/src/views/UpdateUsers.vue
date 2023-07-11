<template>
    <main>
      <Navbar />
      <section class="my-5">
        <div class="mx-auto w-25" style="max-width: 100%;">
          <h2 class="text-center mb-3">Update User</h2>
          <form @submit.prevent="updateUser">
            <label for="name" class="form-label">Name</label>
            <input id="name" type="text" name="name" class="form-control" placeholder="Name" required v-model="user.name">
  
            <label for="surname" class="form-label">Surname</label>
            <input id="surname" type="text" name="surname" class="form-control" placeholder="Surname" required v-model="user.surname">
  
            <label for="email" class="form-label">Email</label>
            <input id="email" type="email" name="email" class="form-control" placeholder="Email" required v-model="user.email">
  
            <label for="pNo" class="form-label">Phone Number</label>
            <input id="pNo" type="text" name="pNo" class="form-control" placeholder="Phone Number" required v-model="user.pNo">
  
            <input class="btn btn-primary w-100" type="submit" value="Submit">
          </form>
        </div>
      </section>
    </main>
  </template>


<script>
import Navbar from '../components/Navbar.vue';

export default {
    name: 'UpdateUser',
    components: {
        Navbar
    },

    data(){
        return {
            user: {
                id: '',
                name: '',
                surname: '',
                email: '',
                pNo: ''
            }
        }
    },

    beforeMount(){
        this.getUsers();
    },

    methods: {
        getUsers(){
            fetch(`http://localhost:8080/user/${this.$route.params.id}`)
            .then(res => res.json())
            .then(data => {
                this.user = data;
                console.log(this.user);
            })

        },
        updateUser(){
            fetch(`http://localhost:8080/user`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.user)
            })
            .then(data => {
                console.log(data);
                this.$router.push('/');
            })
        }
    }
}

</script>