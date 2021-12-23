import Vue from "vue";
import Router from "vue-router";
import Home from "@/views/Home";
import BuyBitCoin from "@/views/BuyBitCoin";
import Login from "@/components/Login";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "home",
      component: Home,
      children: [
        {
          path: "/",
          name: "Login",
          component: Login
        }
      ]
    },
    { path: "/buybitcoin", name: "buybitcoin", component: BuyBitCoin },
    { path: "/Login", name: "Login", component: Login },
  
  ]
});
