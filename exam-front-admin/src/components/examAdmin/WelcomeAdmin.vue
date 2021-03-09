<template>
    <el-container>
        <el-aside width="150px">
            <el-menu id="aside-menu" unique-opened active-text-color="#303133" style="overflow:hidden;" router :default-active="menuActive">
                <el-submenu index="question">
                    <template slot="title">
                        <i class="el-icon-coin"></i>
                        <span slot="title">题目管理</span>
                    </template>
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
                    <template slot="title">
                        <i class="el-icon-document"></i>
                        <span slot="title">文章管理</span>
                    </template>
                    <el-menu-item index="/exam-admin/topic">文章查询</el-menu-item>
                    <el-menu-item index="/exam-admin/topic/create">创建文章</el-menu-item>
                </el-submenu>
                <el-submenu index="user">
                    <template slot="title">
                        <i class="el-icon-user"></i>
                        <span slot="title">用户管理</span>
                    </template>
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
                    <template slot="title">
                        <i class="el-icon-s-operation"></i>
                        <span slot="title">字段管理</span>
                    </template>
                    <el-menu-item index="/exam-admin/field/category">题目分类</el-menu-item>
                    <el-menu-item index="/exam-admin/field/major">学院专业字段</el-menu-item>
                </el-submenu>
                <el-submenu index="permission">
                    <template slot="title">
                        <i class="el-icon-s-management"></i>
                        <span slot="title">权限管理</span>
                    </template>
                    <el-menu-item index="/exam-admin/permission">权限总览</el-menu-item>
                    <el-menu-item index="/exam-admin/permission/role">管理员角色</el-menu-item>
                </el-submenu>
                <el-submenu index="feedback">
                    <template slot="title">
                        <i class="el-icon-receiving"></i>
                        <span slot="title">用户反馈</span>
                    </template>
                    <el-menu-item index="/exam-admin/feedback">全部条目</el-menu-item>
                    <el-menu-item index="/exam-admin/feedback/question">错题反馈</el-menu-item>
                    <el-menu-item index="/exam-admin/feedback/system">系统反馈</el-menu-item>
                </el-submenu>
            </el-menu>
        </el-aside>
        <el-main>
            <p>欢迎<span class="stress-green">{{adminName}}</span>，上次登录于<span class="stress-green">{{lastLoginDataTime}}</span>，上次IP地址为<span class="stress-green">{{lastLoginIP}}</span></p>
            <WelcomeNavi/>
        </el-main>
    </el-container>
</template>
<script>
    import WelcomeNavi from "./WelcomeNavi";

    export default {
        name: 'WelcomeAdmin',
        components: {WelcomeNavi},
        data(){
            return {
                menuActive: '/exam-admin/question/simple',
                adminName:'HuiAhh',
                lastLoginDataTime:'2020-10-21 17:45:20',
                lastLoginIP:'127.0.0.1'
            }
        }
    }
</script>
<style scoped>
    .stress-green {
        color: darkgreen;
    }

    ul{
        list-style: none;
    }
    li{
        list-style: none;
    }
</style>