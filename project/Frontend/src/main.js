// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from './Utils/https'
import store from "./store/store"


Vue.prototype.axios=axios;
/* eslint-disable no-new */
new Vue({
  el:'#app',
  axios,
  router,
  store,
  render:h=>h(App)
}).$mount('#app');
