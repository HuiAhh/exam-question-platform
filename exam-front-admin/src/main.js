import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'
import 'element-ui/lib/theme-chalk/display.css'
import './css/index.css'
import './css/admin.css'
import router from './router'
import store from './store'
import qs from 'qs'

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
axios.defaults.timeout = 5000
axios.defaults.baseURL = '/generator/api/v1/'
axios.defaults.headers.post['Content-Type'] = 'application/json'
Vue.prototype.$qs = qs;

Vue.use(ElementUI)
Vue.config.productionTip = false
new Vue({
    router,
    store,
    render: h => h(App),
}).$mount('#app')
