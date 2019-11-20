<template>
  <div class="home">
    <Transaction msg="Welcome to Your MDB Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Transaction from '@/components/Transaction.vue'


export default {
  name: 'transaction',
  components: {
    Transaction
  }
}
</script>