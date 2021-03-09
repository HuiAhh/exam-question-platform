<template>
    <el-container>
        <el-aside width="150px">
            <el-menu style="overflow:hidden;" router active-text-color="#303133" :default-active="menuActive">
                <el-menu-item index="/exam-admin/field/category">题目分类</el-menu-item>
                <el-menu-item index="/exam-admin/field/major">学院专业字段</el-menu-item>
            </el-menu>
        </el-aside>
        <el-main>
            <el-page-header @back="goBack" content="权限管理"></el-page-header>
            <router-view/>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "FieldAdmin",
        data(){
            return{
                menuActive:'/exam-admin/field/category'
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