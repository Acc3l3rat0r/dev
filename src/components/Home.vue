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
        <mdb-nav-item href="#">Pricing</mdb-nav-item>
        <mdb-dropdown tag="li" class="nav-item">
          <mdb-dropdown-toggle tag="a" navLink color="indigo" slot="toggle" waves-fixed>Dropdown</mdb-dropdown-toggle>
          <mdb-dropdown-menu>
            <mdb-dropdown-item>Action</mdb-dropdown-item>
            <mdb-dropdown-item>Another action</mdb-dropdown-item>
            <mdb-dropdown-item>Something else here</mdb-dropdown-item>
          </mdb-dropdown-menu>
        </mdb-dropdown>
      </mdb-navbar-nav>
    </mdb-navbar-toggler>
  </mdb-navbar>
</div>
</template>

<script>
  import { mdbNavbar, mdbNavbarBrand, mdbNavbarToggler, mdbNavbarNav, mdbNavItem, mdbDropdown, mdbDropdownMenu, mdbDropdownToggle, mdbDropdownItem } from 'mdbvue';
  export default {
    data(){
        return{
            email: 'email@mail.ru',
            password: ''
        }
    },
    name: 'NavbarPage',
    components: {
      mdbNavbar,
      mdbNavbarBrand,
      mdbNavbarToggler,
      mdbNavbarNav,
      mdbNavItem,
      mdbDropdown,
      mdbDropdownMenu,
      mdbDropdownToggle,
      mdbDropdownItem,
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
