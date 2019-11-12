<template>
  <div class="home">
    <img alt="MDB logo" src="../assets/logo-mdb-vue-small.png">
    <Login msg="Welcome to Your MDB Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Login from '@/components/Login.vue'
//import Register from '@/components/Register.vue'

export default {
  name: 'home',
  components: {
    Login
  }
}
</script>
