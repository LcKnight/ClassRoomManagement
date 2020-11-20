import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Home from '@/components/Home'
import Register from '@/components/Register'
import store from '../store/store'
import * as types from '../store/types'
import ElementUi from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUi)
Vue.use(Router)



const
  routes= [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path:'/register',
      name:"Register",
      component:Register
    },
    {
      path:'/home',
      name:'Home',
      component:Home,
      meta: {
        requireAuth: true,
    },
    }

  ]
  


// 页面刷新时，重新赋值token
if (window.localStorage.getItem('token')) {
  store.commit(types.LOGIN, window.localStorage.getItem('token'))
}

const router = new Router({
  routes
});

router.beforeEach((to, from, next) => {
  if (to.matched.some(r => r.meta.requireAuth)) {
      if (store.state.token) {
          next();
      }
      else {
          next({
              path: '/login',
              query: {redirect: to.fullPath}
          })
      }
  }
  else {
      next();
  }
})

export default router;