import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
import ElementUI from 'element-ui';
import router from './router'
import VueRouter from 'vue-router';

Vue.prototype.$axios = axios
Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.use(VueRouter)

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')