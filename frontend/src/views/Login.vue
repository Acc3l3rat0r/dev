<template>
  <div class="register">
    <Login msg="Welcome to Your MDB Vue.js App"/>
  </div>
</template>

<script>

import Login from '@/components/Login.vue'

export default {
  name: 'login',
  components: {
    Login,
  }
}
</script>
