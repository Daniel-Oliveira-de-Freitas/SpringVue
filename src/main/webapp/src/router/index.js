import Vue from 'vue'
import Router from 'vue-router'
import CustomerCrud from '@/components/CustomerCrud'
import CustomerList from "@/components/CustomerList";
import Login from "@/components/Login.vue";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'CustomerList',
      component: CustomerList
    },
    {
      path: '/create',
      name: 'CustomerCrud',
      component: CustomerCrud
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})
