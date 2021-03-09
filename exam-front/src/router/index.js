import Vue from 'vue'
import VueRouter from "vue-router"
import AppMain from "@/AppMain";
import MiddleSelectResult from "@/MiddleSelectResult";
import Test from "@/Test";
import ScrollBar from "@/ScrollBar";
import ExercisePage from "@/ExercisePage";

Vue.use(VueRouter)

const routes = [
    {path: '/', component: AppMain},
    {path: '/middle', component: MiddleSelectResult},
    {path: '/test', component: Test},
    {path:'/scroll',component:ScrollBar},
    {path:'/exercise',component:ExercisePage},
]

const router = new VueRouter({
        routes
    }
)

export default router