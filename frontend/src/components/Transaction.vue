<template>
<div>
  <b-tabs content-class="mt-3">
    <b-tab title="Between your cards" @click="currentTab = 'between'"><p></p></b-tab>
    <b-tab title="To the client of our bank" @click="currentTab = 'toClient'"><p></p></b-tab>
  </b-tabs>

    <mdb-navbar position="top" color="indigo" dark>
    <mdb-navbar-brand href="https://mdbootstrap.com/">
      Boom Bank
    </mdb-navbar-brand>
    <mdb-navbar-toggler>
      <mdb-navbar-nav>
        <mdb-nav-item href="#/home" active>Home</mdb-nav-item>
        <mdb-nav-item href="#/transaction">Transactions</mdb-nav-item>
        <mdb-nav-item @click="logout">Logout</mdb-nav-item>
      </mdb-navbar-nav>
    </mdb-navbar-toggler>
  </mdb-navbar>

  <div class="transfer" v-if="currentTab == 'between'">
    <select class="form-control" v-model="idFrom">
      <option value="" selected disabled>Choose card from</option>
      <option v-for="card in cards" :key="card" :value="card.id">{{ card.cardNumber }} balance {{card.balance}}</option>
    </select>
    <select class="form-control" v-model="idTo">
      <option value="" selected disabled>Choose card to</option>
      <option v-for="card in cards" :key="card" :value="card.id">{{ card.cardNumber }} balance {{card.balance}}</option>
    </select>
    <mdb-input type="text" placeholder="Amount" v-model="amount"/>
    <mdb-btn color="primary" @click="transferBetween">Transfer money</mdb-btn>
  </div>

  <div class="transfer" v-if="currentTab == 'toClient'">
    <select class="form-control" v-model="idFrom">
      <option value="" selected disabled>Choose card from</option>
      <option v-for="card in cards" :key="card" :value="card.id">{{ card.cardNumber }} balance {{card.balance}}</option>
    </select>
    <mdb-input type="text" placeholder="Card number" v-mask="'####-####-####-####'" v-model="cardTo"/>
    <mdb-input type="text" placeholder="Amount" v-model="amount"/>
    <mdb-btn color="primary" @click="transferToClient">Transfer money</mdb-btn>
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
            idFrom:'',
            idTo:'',
            cardTo: '',
            amount:'',
            cards: [],
            modal: false,
            currentTab: 'between'
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
     transferBetween(){
       const header = {'Authorization': 'Bearer ' +this.$cookie.get('token')};
         axios.put('/api/transaction/transfer', 
         {'idFrom': this.$data.idFrom,
         'idTo': this.$data.idTo, 
         'amount': this.$data.amount}, { headers: header })
       .then(response =>{
         this.modal = true;
         console.log(response);
       })
     },
     transferToClient(){
        const header = {'Authorization': 'Bearer ' +this.$cookie.get('token')};
        axios.put('/api/transaction/transferToClient', 
         {'idFrom': this.$data.idFrom,
         'cardTo': this.$data.cardTo, 
         'amount': this.$data.amount}, { headers: header })
       .then(response =>{
         this.modal = true;
         console.log(response);
       })
     },
     loadCard(){
       const header = {'Authorization': 'Bearer ' +this.$cookie.get('token')};
       axios.get('/api/card/getCard',{ headers: header })
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
