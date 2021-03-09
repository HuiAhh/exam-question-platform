<template>
    <div>
        <el-breadcrumb class="page-hd-breadcrumb" separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/exam-admin' }">欢迎页</el-breadcrumb-item>
            <el-breadcrumb-item>权限管理</el-breadcrumb-item>
            <el-breadcrumb-item>管理员角色</el-breadcrumb-item>
        </el-breadcrumb>
        <h1 class="page-title">管理员角色</h1>
        <el-row>
            <el-col :xs="24" :sm="{span:16,offset:4}">
                <el-table :data="queriedRoles">
                    <el-table-column label="角色名" prop="name"></el-table-column>
                    <el-table-column label="权限">
                        <!--   queriedRoles.roleId -> queriedPermissions.filter(roleId).permissionId -->
                        <template slot-scope="scope">
                            <el-tag v-for="(item,index) in getPermissions(scope.row.roleId)"
                                    :key="index"
                                    size="medium"
                                    slot="reference"
                                    closable
                                    @close="removePermission(item)">
                                <!-- remove a permission in a role: -->
                                {{item.permission}}
                            </el-tag>
                            <el-button circle size="mini" type="primary" icon="el-icon-plus"
                                       @click="addPermission(scope.$index)"></el-button>
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="角色启用状态"
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

        <!--弹出框用于添加权限-->
        <el-dialog title="添加权限" :visible.sync="visibleAddPermission">
            <el-form>
                <h1>添加<span style="color: red">{{addingRoleName}}</span>的权限</h1>
                <el-form-item label="权限名称">
                    <el-input v-model="addingPermission.permission"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button style="position: absolute;left:20px;" @click="resetPermission">清空</el-button>
                <el-button @click="visibleAddPermission=false">取消</el-button>
                <el-button type="primary" @click="submitPermission">确定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "AdminPermission",
        data() {
            return {
                visibleAddPermission: false,
                queriedRoles: [
                    {
                        "addTime": "2020-10-24T04:36:22.726Z",
                        "deleted": false,
                        "description": "普通权限的管理员",
                        "enabled": true,
                        "name": "管理员",
                        "roleId": 0,
                        "updateTime": "2020-10-24T04:36:22.726Z"
                    }, {
                        "addTime": "2020-10-24T04:36:22.726Z",
                        "deleted": false,
                        "description": "更高权限的管理员",
                        "enabled": true,
                        "name": "高级管理员",
                        "roleId": 6,
                        "updateTime": "2020-10-24T04:36:22.726Z"
                    }, {
                        "addTime": "2020-10-24T04:36:22.726Z",
                        "deleted": false,
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
                        "deleted": false,
                        "permission": "增加题目",
                        "permissionId": 0,
                        "roleId": 0,
                        "updateTime": "2020-10-24T04:46:14.355Z"
                    },
                    {
                        "addTime": "2020-10-24T04:46:14.354Z",
                        "deleted": false,
                        "permission": "删除题目",
                        "permissionId": 1,
                        "roleId": 0,
                        "updateTime": "2020-10-24T04:46:14.355Z"
                    }
                ],
                addingPermission: {
                    "addTime": "2020-10-24T04:46:14.354Z",
                    "deleted": false,
                    "permission": "",
                    "permissionId": null,
                    "roleId": 0,
                    "updateTime": "2020-10-24T04:46:14.355Z"
                },
                addingRoleName: '',
                emptyPermission: {
                    "addTime": "2020-10-24T04:46:14.354Z",
                    "deleted": false,
                    "permission": "",
                    "permissionId": null,
                    "roleId": null,
                    "updateTime": "2020-10-24T04:46:14.355Z"
                }
            }
        },
        methods: {
            handleDelete(index, item) {
                let roleId = item.roleId
                let permissionId = item.permissionId
                //todo 发起一个能删除掉记录的请求
                console.log(roleId, permissionId)
                this.queriedPermissions.splice(index, 1)
            },
            addPermission(index) {
                this.addingRoleName = this.queriedRoles[index].name
                this.addingPermission.roleId = this.queriedRoles[index].roleId
                this.addingPermission.permission = this.queriedRoles[index].permission
                this.visibleAddPermission = true
            },
            resetPermission() {
                let newPermission = {...this.emptyPermission}
                newPermission.roleId = this.addingPermission.roleId
                this.addingPermission = newPermission
            },
            submitPermission() {
                this.queriedPermissions.push(this.addingPermission)
                this.visibleAddPermission = false
            },
            getPermissions(roleId) {
                return this.queriedPermissions.filter(item => item.roleId === roleId)
            },
            removePermission(item) {
                let index = this.queriedPermissions.indexOf(item)
                this.queriedPermissions.splice(index, 1)
            }
        }
    }
</script>

<style scoped>

</style>