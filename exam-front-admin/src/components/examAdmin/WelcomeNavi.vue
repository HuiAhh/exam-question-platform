<template>
    <div class="admin-item-navi">
        <h3 style="color: #545c63">管理导航</h3>
        <el-row :gutter="20">
            <el-col :span="defaultSpan">
                <i class="el-icon-coin"></i>
                <span>题目管理</span>
                <ul>
                    <li>题目导入</li>
                    <li>
                        <ul>
                            <li>
                                <router-link to="/exam-admin/question/simple">单题导入</router-link>
                            </li>
                            <li>
                                <router-link to="/exam-admin/question/multi">多题导入</router-link>
                            </li>
                            <li>
                                <router-link to="/exam-admin/question/batch">批量导入</router-link>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <router-link to="/exam-admin/question">题目查询</router-link>
                    </li>
                    <li>
                        <router-link to="/exam-admin/question/report">反馈错题集合</router-link>
                    </li>
                </ul>
            </el-col>
            <el-col :span="defaultSpan">
                <i class="el-icon-document"></i>
                <span>文章管理</span>
                <ul>
                    <li>
                        <router-link to="/exam-admin/topic">文章查询</router-link>
                    </li>
                    <li>
                        <router-link to="/exam-admin/topic/create">创建文章</router-link>
                    </li>
                </ul>
            </el-col>
            <el-col :span="defaultSpan">
                <i class="el-icon-user"></i>
                <span>用户管理</span>
                <ul>
                    <li>
                        <router-link to="/exam-admin/user">用户查询</router-link>
                    </li>
                    <li>
                        <router-link to="/exam-admin/user/permission">用户权限</router-link>
                    </li>
                    <li style="margin-top:5px">用户报表</li>
                    <li>
                        <ul>
                            <li>
                                <router-link to="/exam-admin/user/report">总览</router-link>
                            </li>
                            <li>
                                <router-link to="/exam-admin/user/pv">访问量</router-link>
                            </li>
                            <li>
                                <router-link to="/exam-admin/user/activation">活跃度</router-link>
                            </li>
                        </ul>
                    </li>
                </ul>
            </el-col>
            <el-col :span="defaultSpan">
                <i class="el-icon-s-operation"></i>
                <span>字段管理</span>
                <ul>
                    <li>
                        <router-link to="/exam-admin/field/category">题目分类</router-link>
                    </li>
                    <li>
                        <router-link to="/exam-admin/field/major">学院专业字段</router-link>
                    </li>
                </ul>
            </el-col>
            <el-col :span="defaultSpan">
                <i class="el-icon-s-management"></i>
                <span>权限管理</span>
                <ul>
                    <li>
                        <router-link to="/exam-admin/permission">权限总览</router-link>
                    </li>
                    <li>
                        <router-link to="/exam-admin/permission/role">管理员角色</router-link>
                    </li>
                    <li>
                        <router-link to="/exam-admin/permission/role/set">管理员权限分配</router-link>
                    </li>
                </ul>
            </el-col>
            <el-col :span="defaultSpan">
                <i class="el-icon-receiving"></i>
                <span>用户反馈</span>
                <ul>
                    <li>
                        <router-link to="/exam-admin/feedback">全部条目</router-link>
                    </li>
                    <li>
                        <router-link to="/exam-admin/feedback/question">错题反馈</router-link>
                    </li>
                    <li>
                        <router-link to="/exam-admin/feedback/system">系统反馈</router-link>
                    </li>
                </ul>
            </el-col>
        </el-row>
<!--        <el-row style="margin-top: 20px;" :qutter="20">-->

<!--        </el-row>-->
    </div>
</template>
<script>
    export default {
        name: 'WelcomeNavi',
        data(){
            return{
                defaultSpan:8,
                currentScreenWidth:document.documentElement.clientWidth
            }
        },
        methods:{

        },
        watch:{

        },
        mounted(){
            var _this = this
            window.onresize = ()=> {
                let currentScreenWidth = document.documentElement.clientWidth
                if(currentScreenWidth>750){
                    _this.defaultSpan=4
                }else{
                    _this.defaultSpan=8
                }
            }
        }
    }
</script>
<style scoped>

    ul {
        list-style: none;
    }

    li {
        list-style: none;
    }
</style>