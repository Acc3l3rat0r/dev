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
      <li v-for="card in cards" :key="card" class="list3">
        {{ card.cardNumber }} balance {{card.balance}}$
      </li>
      <mdb-btn class="button" color="primary" @click="createCard">Add new card</mdb-btn>
    </b-list-group>
  </div>

  <div class="pay">
    <b-list-group-item class="item">Add money to card</b-list-group-item>
    <mdb-input type="text" placeholder="Card number" v-model="numberOfCard"/>
    <mdb-input type="text" placeholder="Amount" v-model="amount"/>
    <mdb-btn color="primary" @click="pay">To pay</mdb-btn>
  </div>


  <mdb-navbar position="top" color="indigo" dark>
    <mdb-navbar-brand href="https://mdbootstrap.com/">
      NetBank
    </mdb-navbar-brand>
    <mdb-navbar-toggler>
      <mdb-navbar-nav>
        <mdb-nav-item href="#/home" active>Home</mdb-nav-item>
        <mdb-nav-item>Transactions</mdb-nav-item>
        <mdb-nav-item @click="logout">Logout</mdb-nav-item>
      </mdb-navbar-nav>
    </mdb-navbar-toggler>
  </mdb-navbar>
</div>
</template>

<script>
  import { mdbNavbar, mdbNavbarBrand, mdbNavbarToggler, mdbNavbarNav, mdbNavItem, mdbBtn,mdbInput} from 'mdbvue';
  import axios from 'axios'

  export default {
    data(){
        return{
            firstName: '',
            lastName: '',
            email: '',
            cards: [],
            numberOfCard: '',
            amount: ''
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
      mdbInput
    },
    methods: {
     logout() {
          this.$store.dispatch('logout');
          this.$router.push('/login')
     },
     loadData(){
       axios.get('/customer/info/'+this.$store.getters.getToken)
      .then(response =>{
        this.$data.firstName = response.data.firstName;
        this.$data.lastName = response.data.lastName;
        this.$data.email = response.data.email;
      })
     },
     createCard(){
       axios.post('/card/createCard/'+this.$store.getters.getToken)
       .then(response =>{
          console.log(response);
       })
     },
     loadCard(){
       axios.get('/card/getCard/'+this.$store.getters.getToken)
       .then(response =>{
         this.$data.cards = response.data
       })
     },
     pay(){
       axios.put('/card/pay', {'numberOfCard': this.$data.numberOfCard, 'amount': this.$data.amount})
       .then(response =>{
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
  .list3 {
    margin-left: -70%;
    font-size: 160%;
  }
  .pay{
    margin-left: 55%;
    margin-top: -15.4%;
    width: 30%;
  }
  .item{
    width: 70%;
  }
  
</style>
