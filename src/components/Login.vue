<template>
   <div div="signin">
       <div class="login-form">
           <b-card
             title="Signin"
             tag="article"
             style="max-width: 20rem;"
             class="mb-2"
           >
           <div>
               <b-alert
                     :show="dismissCountDown"
                     dismissible
                     variant="danger"
                     @dismissed="dismissCountDown=0"
                     @dismiss-count-down="countDownChanged"
                   > {{ alertMessage }}
                   </b-alert>
           </div>
             <div>
                <b-form-input type="text" placeholder="Email" v-model="email" />
                <div class="mt-2"></div>

                <b-form-input type="password" placeholder="Password" v-model="password" />
                <div class="mt-2"></div>
             </div>

             <b-button v-on:click="login" variant="primary">Login</b-button>

             <hr class="my-4" />

             <b-button variant="link">Forget password?</b-button>
           </b-card>
         </div>
   </div>
</template>

<script>
  //import { mdbRow, mdbCol, mdbCard, mdbCardBody, mdbInput, mdbBtn } from 'mdbvue';
  import axios from 'axios'

  export default {
    data(){
        return{
          email: 'mail4@mail.ru',
          password: '12345'
        }
    },
    /*name: 'FormsPage',
    components: {
      mdbRow,
      mdbCol,
      mdbCard,
      mdbCardBody,
      mdbInput,
      mdbBtn
    },*/
    methods: {
        login(){
          axios.post('http://localhost:9000/login', {'email': this.$data.email, 'password': this.$data.password})
          .then(response =>{
            console.log(response);
            this.$router.push('/register')
          })
          .catch(error => {
            console.log(error);
          })
        }
    }
  }
</script>

<style>
.login-form {
   margin-left: 38%;
   margin-top: 50px;
}
</style>