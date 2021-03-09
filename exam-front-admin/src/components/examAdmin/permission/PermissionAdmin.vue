<template>
    <el-container>
        <el-aside width="150px">
            <el-menu style="overflow:hidden;" router active-text-color="#303133" :default-active="menuActive">
                <el-menu-item index="/exam-admin/permission">权限总览</el-menu-item>
                <el-menu-item index="/exam-admin/permission/role">管理员角色</el-menu-item>
                <el-menu-item index="/exam-admin/permission/role/set">管理员权限分配</el-menu-item>
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
        name: "PermissionAdmin",
        data(){
            return{
                menuActive:'/exam-admin/permission'
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