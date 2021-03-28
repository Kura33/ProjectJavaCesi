import {createApp} from 'vue';
import App from './App.vue';
import router from "@/router";
import axios from 'axios';
import VueAxios from 'vue-axios';
import Toaster from '@meforma/vue-toaster';

createApp(App)
    .use(router)
    .use(VueAxios, axios)
    .use(Toaster, {
        position: 'top-right',
        duration: 5000,
        dismissible: true,
        pauseOnHover: true,
        useDefaultCss: true,
    })
    .mount('#app')
