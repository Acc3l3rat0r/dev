<template>
<div> 
  <div class="image">
    <b-img src="https://picsum.photos/380/230/?image=41" fluid alt="Fluid image" class="rounded"></b-img>
  </div>

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
            <th>Card nubmber</th>
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
    </b-list-group>
  </div>

  <div>
    <mdb-modal :show="modal" @close="modal = false">
      <mdb-modal-header>
        <mdb-modal-title>Add money</mdb-modal-title>
      </mdb-modal-header>
      <mdb-modal-body>
          <mdb-input type="text" placeholder="Card number" v-model="numberOfCard"/>
          <mdb-input type="text" placeholder="Amount" v-model="amount"/>
          <mdb-btn color="primary" @click="pay">To pay</mdb-btn>
      </mdb-modal-body>
      <mdb-modal-footer>
        <mdb-btn color="secondary" @click.native="modal = false">Close</mdb-btn>
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
  import { mdbNavbar, mdbNavbarBrand, mdbNavbarToggler, mdbNavbarNav, mdbNavItem, mdbBtn,mdbInput,mdbModal, mdbModalHeader, mdbModalTitle, mdbModalBody, mdbModalFooter} from 'mdbvue';
  import axios from 'axios'

  export default {
    data(){
        return{
            firstName: '',
            lastName: '',
            email: '',
            cards: [],
            numberOfCard: '',
            amount: '',
            modal: false
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
      mdbModalFooter,
    },
    methods: {
     logout() {
          this.$router.push('/login')
     },
     loadData(){
       axios.get('/api/customer/info/'+this.$cookie.get('token'))
      .then(response =>{
        this.$data.firstName = response.data.firstName;
        this.$data.lastName = response.data.lastName;
        this.$data.email = response.data.email;
      })
     },
     createCard(){
       axios.post('/api/card/createCard/'+this.$cookie.get('token'))
       .then(response =>{
         this.loadCard();
          console.log(response);
       })
     },
     loadCard(){
       axios.get('/api/card/getCard/'+this.$cookie.get('token'))
       .then(response =>{
         this.$data.cards = response.data
       })
     },
     pay(){
       axios.put('/api/card/pay', {'numberOfCard': this.$data.numberOfCard, 'amount': this.$data.amount})
       .then(response =>{
         this.loadCard();
         console.log(response);
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
  .image {
  margin-left: -60%;
  margin-top: 50px;
  }
  .list {
  margin-left: 30%;
  margin-top: -12%;
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
