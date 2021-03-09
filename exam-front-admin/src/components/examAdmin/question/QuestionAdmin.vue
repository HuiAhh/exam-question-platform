<template>
    <el-container>
        <el-aside width="150px">
            <el-menu style="overflow:hidden;" router active-text-color="#303133" :default-active="menuActive">
            <el-submenu index="questionImport">
                <template slot="title">题目导入</template>
                <el-menu-item index="/exam-admin/question/simple">单题导入</el-menu-item>
                <el-menu-item index="/exam-admin/question/multi">多题导入</el-menu-item>
                <el-menu-item index="/exam-admin/question/batch">批量导入</el-menu-item>
            </el-submenu>
            <el-menu-item index="/exam-admin/question">题目查询</el-menu-item>
            <el-menu-item index="/exam-admin/question/report">反馈错题集合</el-menu-item>
            </el-menu>
        </el-aside>
        <el-main>
            <el-page-header @back="goBack" content="题目管理"></el-page-header>
            <router-view/>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "QuestionAdmin",
        data(){
            return{
                menuActive:'/exam-admin/question/simple'
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