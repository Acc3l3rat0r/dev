<template>
  <section class="form-simple">
    <mdb-row>
      <mdb-col md="5">
        <mdb-card>
          <div class="header pt-3 grey lighten-2">
            <mdb-row class="d-flex justify-content-start">
              <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5">Log in</h3>
            </mdb-row>
          </div>
          <mdb-card-body class="mx-4 mt-4">
            <mdb-input label="Your email" type="text" v-model="email"/>
            <mdb-input label="Your password" type="password" containerClass="mb-0" v-model="password"/>
            <p class="font-small grey-text d-flex justify-content-end">Forgot <a href="#" class="dark-grey-text font-weight-bold ml-1"> Password?</a></p>
            <div class="text-center mb-4 mt-5">
              <mdb-btn @click="login" color="danger" type="button" class="btn-block z-depth-2">Log in</mdb-btn>
            </div>
            <p class="font-small grey-text d-flex justify-content-center">Don't have an account? <a href="#/register" class="dark-grey-text font-weight-bold ml-1"> Sign up</a></p>
          </mdb-card-body>
        </mdb-card>
      </mdb-col>
    </mdb-row>
  </section>
</template>

<script>
  import { mdbRow, mdbCol, mdbCard, mdbCardBody, mdbInput, mdbBtn } from 'mdbvue';
  import axios from 'axios'

  export default {
    data(){
        return{
            email: '',
            password: ''
        }
    },
    name: 'FormsPage',
    components: {
      mdbRow,
      mdbCol,
      mdbCard,
      mdbCardBody,
      mdbInput,
      mdbBtn
    },
    methods: {
        login(){
          axios.post('/api/auth/login', {'email': this.$data.email, 'password': this.$data.password})
          .then(response =>{
          this.$store.dispatch('login', {'token': response.data.token});
          this.$router.push('/home')
          })
          .catch(error => {
            console.log(error);
          })
        }
    }
  }
</script>

<style>
  .form-simple .font-small {
    font-size: 0.8rem; }

  .form-simple .header {
    border-top-left-radius: .3rem;
    border-top-right-radius: .3rem; }

  .form-simple input[type=text]:focus:not([readonly]) {
    border-bottom: 1px solid #ff3547;
    -webkit-box-shadow: 0 1px 0 0 #ff3547;
    box-shadow: 0 1px 0 0 #ff3547; }

  .form-simple input[type=text]:focus:not([readonly]) + label {
    color: #4f4f4f; }

  .form-simple input[type=password]:focus:not([readonly]) {
    border-bottom: 1px solid #ff3547;
    -webkit-box-shadow: 0 1px 0 0 #ff3547;
    box-shadow: 0 1px 0 0 #ff3547; }

  .form-simple input[type=password]:focus:not([readonly]) + label {
    color: #4f4f4f; }
  .form-simple {
   margin-left: 38%;
   margin-top: 50px;
  }
</style>