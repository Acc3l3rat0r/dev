<template>
  <div class="home">
    <Home msg="Welcome to Your MDB Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Home from '@/components/Home.vue'


export default {
  name: 'home',
  components: {
    Home
  }
}
</script>