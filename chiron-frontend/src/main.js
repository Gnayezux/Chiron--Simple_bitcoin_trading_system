// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from "vue";
import { BootstrapVue, BootstrapVueIcons, IconsPlugin } from "bootstrap-vue";
import App from "./App";
import router from "./router";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import Vuetify from 'vuetify';
import 'vuetify/dist/vuetify.css'
import '@mdi/font/css/materialdesignicons.css' // Ensure you are using css-loader
import 'material-design-icons-iconfont/dist/material-design-icons.css' // Ensure you are using css-loader

Vue.use(BootstrapVue);
Vue.use(BootstrapVueIcons);
Vue.config.productionTip = false;

/* eslint-disable no-new */
Vue.use(Vuetify);
Vue.use(IconsPlugin)

export default new Vuetify({
  icons: {
    iconfont: 'mdi', // default - only for display purposes
  },
})
new Vue({
 
  el: "#app",
  router,
  template: "<App/>",
  components: { App },
  vuetify : new Vuetify(),
});
