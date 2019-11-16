<template>
<div> 
  <div class="image">
    <b-img src="https://picsum.photos/380/230/?image=41" fluid alt="Fluid image" class="rounded"></b-img>
  </div>

  <div class="list">
    <b-list-group>
      <b-list-group-item>Firstname</b-list-group-item>
      <b-list-group-item>Secondname</b-list-group-item>
      <b-list-group-item>Lastname</b-list-group-item>
    </b-list-group>
  </div>

  <mdb-navbar position="top" color="indigo" dark>
    <mdb-navbar-brand href="https://mdbootstrap.com/">
      NetBank
    </mdb-navbar-brand>
    <mdb-navbar-toggler>
      <mdb-navbar-nav>
        <mdb-nav-item href="#/home" active>Home</mdb-nav-item>
        <mdb-nav-item href="#">Transactions</mdb-nav-item>
        <mdb-nav-item @click="logout">Logout</mdb-nav-item>
      </mdb-navbar-nav>
    </mdb-navbar-toggler>
  </mdb-navbar>
</div>
</template>

<script>
  import { mdbNavbar, mdbNavbarBrand, mdbNavbarToggler, mdbNavbarNav, mdbNavItem} from 'mdbvue';
  export default {
    data(){
        return{
            email: '',
            password: '',
        }
    },
    name: 'NavbarPage',
    components: {
      mdbNavbar,
      mdbNavbarBrand,
      mdbNavbarToggler,
      mdbNavbarNav,
      mdbNavItem,
    },
    methods: {
     logout() {
          this.$store.dispatch('logout');
          this.$router.push('/login')
     }
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
  
</style>
