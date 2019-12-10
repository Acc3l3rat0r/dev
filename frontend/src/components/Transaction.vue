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
    <select class="form-control" v-model="cardFrom">
      <option value="" selected disabled>Choose card from</option>
      <option v-for="card in cards" :key="card" :value="card.cardNumber">{{ card.cardNumber }}</option>
    </select>
    <select class="form-control" v-model="cardTo">
      <option value="" selected disabled>Choose card to</option>
      <option v-for="card in cards" :key="card" :value="card.cardNumber">{{ card.cardNumber }}</option>
    </select>
    <mdb-input type="text" placeholder="Amount" v-model="amount"/>
    <mdb-btn color="primary" @click="transfer">Transfer money</mdb-btn>
  </div>

  <div>
    <mdb-modal :show="modal" @close="modal = false">
      <mdb-modal-header>
        <mdb-modal-title>Transfered successful</mdb-modal-title>
      </mdb-modal-header>
      <mdb-modal-footer>
        <mdb-btn color="secondary" @click.native="modal = false">Close</mdb-btn>
      </mdb-modal-footer>
    </mdb-modal>
  </div>

</div>
</template>

<script>
  import { mdbNavbar, mdbNavbarBrand, mdbNavbarToggler, mdbNavbarNav, mdbNavItem, mdbBtn,mdbInput, mdbModal, mdbModalHeader,mdbModalFooter} from 'mdbvue';
  import axios from 'axios'

  export default {
    data(){
        return{
            cardFrom:'',
            cardTo:'',
            amount:'',
            cards: [],
            modal: false
        }
    },
    components: {
      mdbNavbar,
      mdbNavbarBrand,
      mdbNavbarToggler,
      mdbNavbarNav,
      mdbNavItem,
      mdbBtn,
      mdbInput,
      mdbModal,
      mdbModalHeader,
      mdbModalFooter
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
         this.modal = true;
         console.log(response);
       })
     },
     loadCard(){
       axios.get('/api/card/getCard/'+this.$cookie.get('token'))
       .then(response =>{
         this.$data.cards = response.data
       })
     }
    },
    mounted(){
      this.loadCard();
    }
  }
</script>

<style>
.transfer {
  margin-left: 20%;
  width: 40%;
  }
</style>
