import Vue from 'vue'
import VueRouter from 'vue-router'

import ExamAdmin from "../components/examAdmin/ExamAdmin";
import QuestionAdmin from "../components/examAdmin/question/QuestionAdmin";
import WelcomeAdmin from "../components/examAdmin/WelcomeAdmin";
import SimpleQuestionAdmin from "../components/examAdmin/question/import/SimpleQuestionAdmin";
import MultiQuestionAdmin from "../components/examAdmin/question/import/MultiQuestionAdmin";
import DefaultComponent from "../components/examAdmin/DefaultComponent";
import QuestionQuery from "../components/examAdmin/question/QuestionQuery";
import QuestionReport from "../components/examAdmin/question/QuestionReport";
import TopicAdmin from "../components/examAdmin/topic/TopicAdmin";
import CreateTopic from "../components/examAdmin/topic/CreateTopic";
import TopicQuery from "../components/examAdmin/topic/TopicQuery";
import UserQuery from "../components/examAdmin/user/UserQuery";
import UserAdmin from "../components/examAdmin/user/UserAdmin";
import UserPermission from "../components/examAdmin/user/UserPermission";
import PermissionAdmin from "../components/examAdmin/permission/PermissionAdmin";
import PermissionQuery from "../components/examAdmin/permission/PermissionQuery";
import AdminPermission from "../components/examAdmin/permission/AdminPermission";
import FieldAdmin from "../components/examAdmin/field/FieldAdmin";
import FieldCategory from "../components/examAdmin/field/FieldCategory";
import FieldMajor from "../components/examAdmin/field/FieldMajor";
import FeedbackAdmin from "../components/examAdmin/feedback/FeedbackAdmin";
import FeedbackQuery from "../components/examAdmin/feedback/FeedbackQuery";
import FeedbackQuestion from "../components/examAdmin/feedback/FeedbackQuestion";
import FeedbackSystem from "../components/examAdmin/feedback/FeedbackSystem";
import AdminLogin from "../components/examAdmin/login/AdminLogin";
import QuestionResult from "../components/examAdmin/question/QuestionResult";

Vue.use(VueRouter)

const routes = [
    {
        path: '/admin-login', component: AdminLogin
    },
    {
        path: '/exam-admin', component: ExamAdmin,
        children: [
            {path: '', component: WelcomeAdmin},
            {
                path: 'question', component: QuestionAdmin,
                children: [
                    {path: 'simple', component: SimpleQuestionAdmin},
                    {path: 'multi', component: MultiQuestionAdmin},
                    {path: 'batch', component: DefaultComponent},
                    {path: 'report', component: QuestionReport},
                    {path: '', component: QuestionQuery},
                    {path:'result',component:QuestionResult}
                ]
            },
            {
                path: 'topic', component: TopicAdmin,
                children: [
                    {path: 'create', component: CreateTopic},
                    {path: '', component: TopicQuery}
                ]
            },
            {
                path: 'user', component: UserAdmin,
                children: [
                    {path: '', component: UserQuery},
                    {path: 'permission', component: UserPermission},
                    {path: 'report', component: DefaultComponent},
                    {path: 'pv', component: DefaultComponent},
                    {path: 'activation', component: DefaultComponent}
                ]
            },
            {
                path: 'permission', component: PermissionAdmin,
                children: [
                    {path: '', component: PermissionQuery},
                    {path: 'role', component: AdminPermission},
                    {path: 'role/set', component: DefaultComponent}

                ]
            },
            {
                path: 'field', component: FieldAdmin,
                children: [
                    {path: 'category', component: FieldCategory},
                    {path: 'major', component: FieldMajor}
                ]
            },
            {
                path: 'feedback', component: FeedbackAdmin,
                children: [
                    {path: '', component: FeedbackQuery},
                    {path: 'question', component: FeedbackQuestion},
                    {path: 'system', component: FeedbackSystem}
                ]
            }
        ]
    }
]

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}

export default new VueRouter({
        routes
    }
)