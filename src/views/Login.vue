<template>
  <div class="register">
    <Login msg="Welcome to Your MDB Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Login from '@/components/Login.vue'
//import Register from '@/components/Register.vue'

export default {
  name: 'login',
  components: {
    Login
  }
}
</script>
