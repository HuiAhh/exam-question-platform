<template>
    <el-container>
        <el-aside width="150px">
            <el-menu style="overflow:hidden;" router active-text-color="#303133" :default-active="menuActive">
            <el-menu-item index="/exam-admin/topic">文章查询</el-menu-item>
            <el-menu-item index="/exam-admin/topic/create">创建文章</el-menu-item>
            </el-menu>
        </el-aside>
        <el-main>
            <el-page-header @back="goBack" content="文章管理"></el-page-header>
            <router-view/>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "QuestionAdmin",
        data(){
            return{
                menuActive:'/exam-admin/topic'
            }
        },
        methods:{
            goBack() {
                this.$router.back()
            }
        }
    }
</script>

<style scoped>

</style>