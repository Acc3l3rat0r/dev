import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

const state = {
 token: localStorage.getItem('user-token') || ''
};

const getters = {
 isAuthenticated: state => {
   if (state.token != null && state.token != '') {
     return true;
   } else {
     return false;
   }
 },
 getToken: state => {
   return state.token;
 }
};

const mutations = {
 auth_login: (state, user) => {
   localStorage.setItem('user-token', user.token);
   state.token = user.token;
 },
 auth_logout: () => {
   state.token = '';
   localStorage.removeItem('user-token');
 }
};

const actions = {
 login: (context, user) => {
   context.commit('auth_login', user)
 },
 logout: (context) => {
   context.commit('auth_logout');
 }
};

export const store = new Vuex.Store({
 state,
 getters,
 mutations,
 actions
});
