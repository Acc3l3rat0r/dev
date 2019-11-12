<template>
  <div class="home">
    <img alt="MDB logo" src="../assets/logo-mdb-vue-small.png">
    <Register msg="Welcome to Your MDB Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Register from '@/components/Register.vue'
//import Register from '@/components/Register.vue'

export default {
  name: 'home',
  components: {
    Register
  }

}
</script>