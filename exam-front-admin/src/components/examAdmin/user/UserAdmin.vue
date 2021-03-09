<template>
    <el-container>
        <el-aside width="150px">
            <el-menu style="overflow:hidden;" router active-text-color="#303133" :default-active="menuActive">
                <el-menu-item index="/exam-admin/user">用户查询</el-menu-item>
                <el-menu-item index="/exam-admin/user/permission">用户权限</el-menu-item>
                <el-submenu index="userReport">
                    <template slot="title">用户报表</template>
                    <el-menu-item index="/exam-admin/user/report">总览</el-menu-item>
                    <el-menu-item index="/exam-admin/user/pv">访问量</el-menu-item>
                    <el-menu-item index="/exam-admin/user/activation">活跃度</el-menu-item>
                </el-submenu>
            </el-menu>
        </el-aside>
        <el-main>
            <el-page-header @back="goBack" content="用户管理"></el-page-header>
            <router-view/>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "UserAdmin",
        data(){
            return{
                menuActive:'/exam-admin/user/report'
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