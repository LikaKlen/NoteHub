import { createRouter, createWebHistory } from 'vue-router'
import Home from './components/Home.vue'
import Reg from './components/Reg.vue'
import Log from './components/Log.vue'
import StudProf from './components/StudProf.vue'
import StudCart from './components/StudCart.vue'

export default  createRouter({
    history:createWebHistory(),
    routes:[
        {path:"/auth/home",component:Home },
        {path:"/reg",component:Reg},
        {path:"/log",component:Log,alias:'/'},
        {path:"/auth/StudProf",component:StudProf},
        {path:"/auth/:id",component:StudCart},

    ]
})