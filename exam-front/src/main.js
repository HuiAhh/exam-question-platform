import Vue from 'vue';

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import router from './router'
import store from './store'
import App from "@/App";
import qs from 'qs'

import axios from 'axios'
import VueAxios from 'vue-axios'


/**
 * 引入配色方案开始
 */

import './element-#A88158/index.css'
import './element-#A88158/fonts/element-icons.ttf'
import './element-#A88158/fonts/element-icons.woff'

/**
 * 引入配色方案结束
 */


Vue.use(VueAxios, axios)
Vue.prototype.$qs = qs;

axios.defaults.timeout = 5000
axios.defaults.baseURL = '/generator/api/v1/'
axios.defaults.headers.post['Content-Type'] = 'application/json'

Vue.config.productionTip = false

Vue.use(ElementUI);

new Vue({
  router,
  store,
  render:h=>h(App)
}).$mount('#app');