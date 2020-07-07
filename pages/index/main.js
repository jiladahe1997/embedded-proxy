import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
import 'element-ui/lib/theme-chalk/index.css';
Vue.prototype.$axios = axios
Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
