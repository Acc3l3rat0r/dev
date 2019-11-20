<template>
  <section class="form-light">
    <mdb-row>
      <mdb-col md="5">
        <mdb-card>
          <mdb-card-body class="mx-4">
            <div class="text-center">
              <h3 class="pink-text mb-5"><strong>Sign up</strong></h3>
            </div>
            <mdb-input label="First name" type="text" v-model="firstName"/>
            <mdb-input label="Last Name" type="text" v-model="lastName"/>
            <mdb-input label="Email" type="text" v-model="email"/>
            <mdb-input label="Password" type="password" v-model="password"/>
            <mdb-row class="d-flex align-items-center mb-4">
              <mdb-col md="6" class="text-center">
                <button @click="register" type="button" class="btn btn-pink btn-block btn-rounded z-depth-1">Sign up</button>
              </mdb-col>
              <mdb-col md="6">
                <p class="font-small grey-text d-flex justify-content-end">Have an account? <a href="#/login" class="blue-text ml-1"> Log in</a></p>
              </mdb-col>
            </mdb-row>
          </mdb-card-body>
        </mdb-card>
      </mdb-col>
    </mdb-row>
  </section>
</template>

<script>
  import { mdbRow, mdbCol, mdbCard, mdbCardBody, mdbInput } from 'mdbvue';
  import axios from 'axios'
  export default {
    data(){
        return{
            email: '',
            password: '',
            firstName: '',
            lastName: ''
        }
    },
    name: 'FormsPage',
    components: {
      mdbRow,
      mdbCol,
      mdbCard,
      mdbCardBody,
      mdbInput
    },
    methods: {
        register(){
          axios.post('/api/auth/register', {
          'email': this.$data.email, 
          'password': this.$data.password,
          'firstName': this.$data.firstName,
          'lastName': this.$data.lastName
          })
          .then(response =>{
            console.log(response);
            this.$router.push('/login')
          })
          .catch(error => {
            console.log(error);
          })
        }
    }
  }
</script>

<style>
  .form-light .font-small {
    font-size: 0.8rem; }

  .form-light [type="radio"] + label,
  .form-light [type="checkbox"] + label {
    -size: 0.8rem; }

  .form-light [type="checkbox"] + label:before {
    top: 2px;
    width: 15px;
    height: 15px; }

  .form-light input[type="checkbox"] + label:before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    width: 17px;
    height: 17px;
    z-index: 0;
    border-radius: 1px;
    margin-top: 2px;
    -webkit-transition: 0.2s;
    transition: 0.2s; }

  .form-light input[type="checkbox"]:checked + label:before {
    top: -4px;
    left: -3px;
    width: 12px;
    height: 22px;
    border-style: solid;
    border-width: 2px;
    border-color: transparent #EB3573 #EB3573 transparent;
    -webkit-transform: rotate(40deg);
    -ms-transform: rotate(40deg);
    transform: rotate(40deg);
    -webkit-backface-visibility: hidden;
    -webkit-transform-origin: 100% 100%;
    -ms-transform-origin: 100% 100%;
    transform-origin: 100% 100%; }

  .form-light .footer {
    border-bottom-left-radius: .3rem;
    border-bottom-right-radius: .3rem; }
  
  .form-light {
   margin-left: 38%;
   margin-top: 50px;
  }
</style>
