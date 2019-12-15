<template>
<div> 

  <div class="list">
    <b-list-group>
      <b-list-group-item>{{firstName}}</b-list-group-item>
      <b-list-group-item>{{lastName}}</b-list-group-item>
      <b-list-group-item>{{email}}</b-list-group-item>
    </b-list-group>
  </div>

  <div class="list2">
    <b-list-group>
      <b-list-group-item>MY CARDS</b-list-group-item>

      <table class="table">
        <thead>
          <tr>
            <th>Card number</th>
            <th>Balance</th>
          </tr>
        </thead>
        <tbody class="list3">
          <tr v-for="card in cards" :key="card">
            <td>{{card.cardNumber}}</td>
            <td>{{card.balance}}</td>
            <td></td>
          </tr>
        </tbody>
      </table>

      <mdb-btn class="button" color="primary" @click="createCard">Add new card</mdb-btn>
      <mdb-btn class="button" color="primary" @click.native="modal = true">Add money</mdb-btn>
      <mdb-btn class="button" color="primary" @click.native="modal3 = true">View card info</mdb-btn>
    </b-list-group>
  </div>

  <div>
    <mdb-modal :show="modal3" @close="modal3 = false">
      <mdb-modal-header>
        <mdb-modal-title>View card info</mdb-modal-title>
      </mdb-modal-header>
      <mdb-modal-body>
          <select class="form-control" v-model="idInfo">
            <option value="" selected disabled>Choose card</option>
            <option v-for="card in cards" :key="card" :value="card.id">{{ card.cardNumber }} balance {{card.balance}}</option>
          </select>
          <div>
            <span v-if="tab == 'tab'"> Card number: {{cardInfo.cardNumber}}</span>
          </div>
          <mdb-btn color="primary" @click="getCardInfo">Get info</mdb-btn>
          <mdb-btn color="primary" @click="tab = ''" @click.native="modal3 = false">Close</mdb-btn>
          
      </mdb-modal-body>
    </mdb-modal>
  </div>

  <div>
    <mdb-modal :show="modal" @close="modal = false">
      <mdb-modal-header>
        <mdb-modal-title>Add money</mdb-modal-title>
      </mdb-modal-header>
      <mdb-modal-body>
          <select class="form-control" v-model="id">
            <option value="" selected disabled>Choose card</option>
            <option v-for="card in cards" :key="card" :value="card.id">{{ card.cardNumber }} balance {{card.balance}}</option>
          </select>
          <mdb-input type="text" placeholder="Amount" v-model="amount"/>
          <mdb-btn color="primary" @click="pay">To pay</mdb-btn>
      </mdb-modal-body>
    </mdb-modal>
  </div>

  <div>
    <mdb-modal :show="modal2" @close="modal2 = false">
      <mdb-modal-header>
        <mdb-modal-title>Card added successful</mdb-modal-title>
      </mdb-modal-header>
      <mdb-modal-footer>
        <mdb-btn color="secondary" @click.native="modal2 = false">Close</mdb-btn>
      </mdb-modal-footer>
    </mdb-modal>
  </div>


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
</div>
</template>

<script>
  import { mdbNavbar, mdbNavbarBrand, mdbNavbarToggler, mdbNavbarNav, mdbNavItem, mdbBtn,mdbInput,mdbModal, mdbModalHeader, mdbModalTitle, mdbModalBody} from 'mdbvue';
  import axios from 'axios'

  export default {
    data(){
        return{
            firstName: '',
            lastName: '',
            email: '',
            cards: [],
            cardInfo: '',
            id: '',
            idInfo: '',
            amount: '',
            modal: false,
            modal2: false,
            modal3: false,
            tab: ''
        }
    },
    name: 'NavbarPage',
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
      mdbModalTitle,
      mdbModalBody,
    },
    methods: {
     logout() {
          this.$router.push('/login')
     },
     loadData(){
       const header = {'Authorization': 'Bearer ' +this.$cookie.get('token')};
       axios.get('/api/customer/info/'+this.$cookie.get('token'), { headers: header })
      .then(response =>{
        this.$data.firstName = response.data.firstName;
        this.$data.lastName = response.data.lastName;
        this.$data.email = response.data.email;
      })
     },
     createCard(){
       const header = {'Authorization': 'Bearer ' + this.$cookie.get('token')};
       axios.post('/api/card/createCard/'+this.$cookie.get('token'), { headers: header })
       .then(response =>{
         this.loadCard();
         this.modal2 = true;
          console.log(response);
       })
     },
     loadCard(){
       const header = {'Authorization': 'Bearer ' +this.$cookie.get('token')};
       axios.get('/api/card/getCard/'+this.$cookie.get('token'), { headers: header })
       .then(response =>{
         this.$data.cards = response.data
       })
     },
     pay(){
       const header = {'Authorization': 'Bearer ' +this.$cookie.get('token')};
       axios.put('/api/card/pay', {'id': this.$data.id, 'amount': this.$data.amount}, { headers: header })
       .then(response =>{
         this.loadCard();
         this.modal = false;
         console.log(response);
       })
     },
     getCardInfo(){
       const header = {'Authorization': 'Bearer ' +this.$cookie.get('token')};
       axios.get('/api/card/getCardInfo/'+this.idInfo, { headers: header })
       .then(response =>{
         this.tab = 'tab';
         this.$data.cardInfo = response.data
       })
     }
    },
    mounted(){
      this.loadData();
      this.loadCard();
    }
  }
</script>

<style>
  .list {
  margin-left: 10%;
  margin-top: 0%;
  }
  .list-group-item {
    width: 30%;
  }
  .list2 {
  margin-left: 10%;
  margin-top: 5%;
  width: 120%;
  }
  .button{
    width: 30%;
  }
  .table{
    width: 30%;
  }
  .list3 {
    
    font-size: 140%;
  }
  .item{
    width: 70%;
  }
</style>
