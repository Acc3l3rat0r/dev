import Vue from 'vue'
import Router from 'vue-router'
import Login from './views/Login.vue'
import Register from './views/Register.vue'
import Home from './views/Home.vue'
import Transaction from '@/views/Transaction.vue'
import {store} from './store'

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

router.beforeEach((to, from, next) => {    
  if (!to.meta.auth) {
    return next()
   }
   // If require auth but user is not authenticated, go to login.
   if (!store.getters.isAuthenticated) {
    return next('/login')
   }
   next()
})


export default router;
