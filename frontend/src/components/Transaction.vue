<template>
<div>
    <mdb-navbar position="top" color="indigo" dark>
    <mdb-navbar-brand href="https://mdbootstrap.com/">
      NetBank
    </mdb-navbar-brand>
    <mdb-navbar-toggler>
      <mdb-navbar-nav>
        <mdb-nav-item href="#/home" active>Home</mdb-nav-item>
        <mdb-nav-item href="#/transaction">Transactions</mdb-nav-item>
        <mdb-nav-item @click="logout">Logout</mdb-nav-item>
      </mdb-navbar-nav>
    </mdb-navbar-toggler>
  </mdb-navbar>

  <div class="transfer">
    <b-list-group-item class="item">Transfer to another card</b-list-group-item>
    <mdb-input type="text" placeholder="Card from" v-model="cardFrom"/>
    <mdb-input type="text" placeholder="Card to" v-model="cardTo"/>
    <mdb-input type="text" placeholder="Amount" v-model="amount"/>
    <mdb-btn color="primary" @click="transfer">Transfer money</mdb-btn>
  </div>
</div>
</template>

<script>
  import { mdbNavbar, mdbNavbarBrand, mdbNavbarToggler, mdbNavbarNav, mdbNavItem, mdbBtn,mdbInput} from 'mdbvue';
  import axios from 'axios'

  export default {
    data(){
        return{
            cardFrom:'',
            cardTo:'',
            amount:''
        }
    },
    components: {
      mdbNavbar,
      mdbNavbarBrand,
      mdbNavbarToggler,
      mdbNavbarNav,
      mdbNavItem,
      mdbBtn,
      mdbInput
    },
    methods: {
     logout() {
          this.$store.dispatch('logout');
          this.$router.push('/login')
     },
     transfer(){
         axios.put('/api/transaction/transfer', 
         {'cardFrom': this.$data.cardFrom,
         'cardTo': this.$data.cardTo, 
         'amount': this.$data.amount})
       .then(response =>{
         console.log(response);
       })
     }
    }
  }
</script>
