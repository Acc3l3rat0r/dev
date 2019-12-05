import Vue from 'vue'
import Router from 'vue-router'
import Login from './views/Login.vue'
import Register from './views/Register.vue'
import Home from './views/Home.vue'
import Transaction from '@/views/Transaction.vue'


Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/login',
      name: 'login',
      component: Login,
      meta: {
        auth: false
      }
    },
    {
      path: '/home',
      name: 'home',
      component: Home,
      meta: {
        auth: true // A protected route
      }
    },
    {
      path: '/register',
      name: 'register',
      component: Register,
      meta: {
        auth: false
      }
    },
    {
      path: '/transaction',
      name: 'transaction',
      component: Transaction,
      meta: {
        auth: true
      }
    }
  ]
})



export default router;
