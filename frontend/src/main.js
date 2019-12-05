import '@fortawesome/fontawesome-free/css/all.min.css'
import 'bootstrap-css-only/css/bootstrap.min.css'
import 'mdbvue/lib/css/mdb.min.css'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import Vue from 'vue'
import App from './App.vue'
import router from './router'
import {store} from './store'

Vue.config.productionTip = false
Vue.use(BootstrapVue) 

var VueCookie = require('vue-cookie');
Vue.use(VueCookie);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
