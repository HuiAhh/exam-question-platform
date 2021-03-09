<template>
    <el-container>
        <el-aside width="150px">
            <el-menu style="overflow:hidden;" router active-text-color="#303133" :default-active="menuActive">
                <el-menu-item index="/exam-admin/feedback">全部条目</el-menu-item>
                <el-menu-item index="/exam-admin/feedback/question">错题反馈</el-menu-item>
                <el-menu-item index="/exam-admin/feedback/system">系统反馈</el-menu-item>
            </el-menu>
        </el-aside>
        <el-main>
            <el-page-header @back="goBack" content="用户反馈"></el-page-header>
            <router-view/>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "FeedbackAdmin",
        data(){
            return{
                menuActive:'/exam-admin/feedback'
            }
        },
        methods:{
            goBack(){
                this.$router.back()
            }
        }
    }
</script>

<style scoped>

</style>