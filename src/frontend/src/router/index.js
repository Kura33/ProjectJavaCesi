import {createRouter, createWebHistory} from 'vue-router';

const Home = import('@/views/Home');
const Login = import('@/views/Login');
const About = import('@/views/About');
const Incident = import('@/views/incident/Incident');
const IncidentDetail = import('@/views/incident/IncidentDetail');
const IncidentCreation = import('@/views/incident/IncidentCreation');
const NotFound = import('@/views/NotFound');

const routes = [
    {path: '/', name: 'Home', component: Home,},
    {path: '/shield/login', name: 'Login', component: Login,},
    {path: '/shield/incident/', name: 'Incident', component: Incident,},
    {path: '/shield/incident/:id', name: 'IncidentDetail', component: IncidentDetail, props: true,},
    {path: '/shield/incident/create', name: 'IncidentCreation', component: IncidentCreation,},
    {path: '/shield/about/', name: 'About', component: About,},
    // catch all 404
    {path: '/:catchAll(.*)', name: 'NotFound', component: NotFound,},

]

const router = createRouter({
    // mode: "hash",
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router