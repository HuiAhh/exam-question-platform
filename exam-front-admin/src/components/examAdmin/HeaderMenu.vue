<template>
    <el-menu router mode="horizontal">
        <el-submenu index="question">
            <template slot="title">题目管理</template>
            <el-submenu index="questionImport">
                <template slot="title">题目导入</template>
                <el-menu-item index="/exam-admin/question/simple">单题导入</el-menu-item>
                <el-menu-item index="/exam-admin/question/multi">多题导入</el-menu-item>
                <el-menu-item index="/exam-admin/question/batch">批量导入</el-menu-item>
            </el-submenu>
            <el-menu-item index="/exam-admin/question">题目查询</el-menu-item>
            <el-menu-item index="/exam-admin/question/report">反馈错题集合</el-menu-item>
        </el-submenu>
        <el-submenu index="topic">
            <template slot="title">文章管理</template>
            <el-menu-item index="/exam-admin/topic">文章查询</el-menu-item>
            <el-menu-item index="/exam-admin/topic/create">创建文章</el-menu-item>
        </el-submenu>
        <el-submenu index="user">
            <template slot="title">用户管理</template>
            <el-menu-item index="/exam-admin/user">用户查询</el-menu-item>
            <el-menu-item index="/exam-admin/user/permission">用户权限</el-menu-item>
            <el-submenu index="1-2">
                <template slot="title">用户报表</template>
                <el-menu-item index="/exam-admin/user/report">总览</el-menu-item>
                <el-menu-item index="/exam-admin/user/pv">访问量</el-menu-item>
                <el-menu-item index="/exam-admin/user/activation">活跃度</el-menu-item>
            </el-submenu>
        </el-submenu>
        <el-submenu index="field">
            <template slot="title">字段管理</template>
            <el-menu-item index="1-1">题目分类</el-menu-item>
            <el-menu-item index="1-2">学院专业字段</el-menu-item>
        </el-submenu>
        <el-submenu index="permission">
            <template slot="title">权限管理</template>
            <el-menu-item index="/exam-admin/permission">权限总览</el-menu-item>
            <el-menu-item index="/exam-admin/permission/role">管理员角色</el-menu-item>
        </el-submenu>
        <el-submenu index="feedback">
            <template slot="title">用户反馈</template>
            <el-menu-item index="/exam-admin/feedback">全部条目</el-menu-item>
            <el-menu-item index="/exam-admin/feedback/question">错题反馈</el-menu-item>
            <el-menu-item index="/exam-admin/feedback/system">系统反馈</el-menu-item>
        </el-submenu>
        <el-menu-item style="position: absolute ;right:0" index="4">
            <a href="" target="_blank">退出登录</a>
        </el-menu-item>
    </el-menu>
</template>
<script>
    export default {
        name: 'HeaderMenu',
        props: {
        },
        data(){
            return{
                headerMenuActive:''
            }
        },
        mounted() {
            this.headerMenuActive=this.$route.path

        }
    }
</script>
