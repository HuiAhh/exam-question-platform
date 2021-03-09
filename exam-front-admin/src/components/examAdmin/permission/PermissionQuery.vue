<template>
    <div>
        <el-breadcrumb class="page-hd-breadcrumb" separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/exam-admin' }">欢迎页</el-breadcrumb-item>
            <el-breadcrumb-item>权限管理</el-breadcrumb-item>
            <el-breadcrumb-item>权限总览</el-breadcrumb-item>
        </el-breadcrumb>
        <h1 class="page-title">权限总览</h1>
<el-row>
    <el-col  :xs="24" :sm="{span:16,offset:4}">
    <el-table :data="queriedAdmins">
        <!--
            1.username
            2.roleIds
            3.deleted
        -->
        <el-table-column label="用户名" prop="username"></el-table-column>
        <el-table-column label="角色">
            <template slot-scope="scope">
                <el-popover
                        placement="top-start"
                        :title="getRoleName(item)"
                        width="200"
                        trigger="hover"
                        :content="getDescription(item)"
                        v-for="(item,index) in JSON.parse(scope.row.roleIds)"
                        :key="index">
                    <el-tag size="medium" slot="reference">{{getRoleName(item)}}</el-tag>
                </el-popover>
            </template>
        </el-table-column>
        <el-table-column
                label="管理员账户启用状态"
                prop="deleted"
                width="180">
            <template slot-scope="scope">
                <el-tooltip :content="scope.row.deleted?'禁用':'启用'" placement="top">
                    <el-switch
                            v-model="scope.row.deleted"
                            active-color="#13ce66"
                            inactive-color="#ff4949"
                            :active-value="false"
                            :inactive-value="true">
                    </el-switch>
                </el-tooltip>
            </template>
        </el-table-column>
    </el-table>
</el-col>
</el-row>
    </div>
</template>

<script>
    export default {
        name: "PermissionQuery",
        data() {
            return {
                queriedAdmins: [
                    {
                        "addTime": "2020-10-24T05:27:10.671Z",
                        "adminId": 0,
                        "avatar": "",
                        "deleted": false,
                        "lastLoginIp": "",
                        "lastLoginTime": "2020-10-24T05:27:10.672Z",
                        "password": "",
                        "roleIds": "[0,6,7]",//[]
                        "updateTime": "2020-10-24T05:27:10.673Z",
                        "username": "嘤嘤嘤"
                    }
                ],
                queriedRoles: [
                    {
                        "addTime": "2020-10-24T04:36:22.726Z",
                        "deleted": true,
                        "description": "普通权限的管理员",
                        "enabled": true,
                        "name": "管理员",
                        "roleId": 0,
                        "updateTime": "2020-10-24T04:36:22.726Z"
                    },{
                        "addTime": "2020-10-24T04:36:22.726Z",
                        "deleted": true,
                        "description": "更高权限的管理员",
                        "enabled": true,
                        "name": "高级管理员",
                        "roleId": 6,
                        "updateTime": "2020-10-24T04:36:22.726Z"
                    },{
                        "addTime": "2020-10-24T04:36:22.726Z",
                        "deleted": true,
                        "description": "简单的题库管理员",
                        "enabled": true,
                        "name": "试题管理员",
                        "roleId": 7,
                        "updateTime": "2020-10-24T04:36:22.726Z"
                    },
                ],
                queriedPermissions: [
                    {
                        "addTime": "2020-10-24T04:46:14.354Z",
                        "deleted": true,
                        "permission": "增加题目",
                        "permissionId": 0,
                        "roleId": 0,
                        "updateTime": "2020-10-24T04:46:14.355Z"
                    }
                ]
            }
        },
        methods:{
            getRoleName(item){
                return this.queriedRoles.filter(elem=>elem.roleId==item)[0].name
            },
            getDescription(item){
                return this.queriedRoles.filter(elem=>elem.roleId==item)[0].description
            }
        }
    }
</script>

<style scoped>

</style>