<template>
    <div>
        <el-breadcrumb class="page-hd-breadcrumb" separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/exam-admin' }">欢迎页</el-breadcrumb-item>
            <el-breadcrumb-item>用户管理</el-breadcrumb-item>
            <el-breadcrumb-item>用户权限</el-breadcrumb-item>
        </el-breadcrumb>
        <h1 class="page-title">用户权限</h1>
        <el-radio-group v-model="userLevel">
            <el-radio label="3">游客</el-radio>
            <el-radio label="1">学生</el-radio>
            <el-radio label="2">教师</el-radio>
            <el-radio label="4">题库管理员</el-radio>
            <el-radio label="5">客服</el-radio>
        </el-radio-group>
        <el-table
                :data="queriedPermissions"
                style="width: 100%">
            <el-table-column
                    label="权限名"
                    prop="permission"
                    width="180">
            </el-table-column>
            <el-table-column
                    label="启用状态"
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
            <el-table-column
                    prop="addTime"
                    label="添加时间">
            </el-table-column>
            <el-table-column>
                <template slot="header">
                    <el-button round size="mini" type="primary" icon="el-icon-plus" @click="addPermission">添加
                    </el-button>
                </template>
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.$index,scope.row)"
                            icon="el-icon-delete"
                            circle></el-button>
                </template>
            </el-table-column>
        </el-table>

        <!--弹出框用于添加权限-->
        <el-dialog title="添加权限" :visible.sync="addingPermissionVisible">
            <el-form>
                <el-form-item label="权限名称">
                    <el-radio-group v-model="addingPermission.roleId">
                        <el-radio label="3">游客</el-radio>
                        <el-radio label="1">学生</el-radio>
                        <el-radio label="2">教师</el-radio>
                        <el-radio label="4">题库管理员</el-radio>
                        <el-radio label="5">客服</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="权限名称">
                    <el-input v-model="addingPermission.permission" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button style="position: absolute;left:20px;" @click="resetPermission">清空</el-button>
                <el-button @click="addingPermissionVisible = false">取消</el-button>
                <el-button type="primary" @click="submitPermission">确定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "UserPermission",
        data() {
            return {
                userLevel: 0,//roleId
                /**
                 * roleId
                 * 0 管理员
                 * 1 学生
                 * 2 教师
                 * 3 游客
                 * 4 题库管理员
                 * 5 客服
                 */
                queriedRole:
                    {
                        "addTime": "2020-10-24T04:36:22.726Z",
                        "deleted": true,
                        "description": "",
                        "enabled": true,
                        "name": "",
                        "roleId": 0,
                        "updateTime": "2020-10-24T04:36:22.726Z"
                    },
                queriedPermissions: [
                    {
                        "addTime": "2020-10-24T04:46:14.354Z",
                        "deleted": true,
                        "permission": "增加题目",
                        "permissionId": 0,
                        "roleId": 0,
                        "updateTime": "2020-10-24T04:46:14.355Z"
                    }
                ],
                emptyPermission: {
                    "addTime": "2020-10-24T04:46:14.354Z",
                    "deleted": false,
                    "permission": "",
                    "permissionId": null,
                    "roleId": null,
                    "updateTime": "2020-10-24T04:46:14.355Z"
                },
                addingPermission: {
                    "addTime": "2020-10-24T04:46:14.354Z",
                    "deleted": false,
                    "permission": "",
                    "permissionId": null,
                    "roleId": null,
                    "updateTime": "2020-10-24T04:46:14.355Z"
                },
                addingPermissionVisible: false
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
            addPermission() {
                this.addingPermission.roleId = this.userLevel
                this.addingPermissionVisible = true
            },
            resetPermission() {
                let newPermission = {...this.emptyPermission}
                newPermission.roleId = this.addingPermission.roleId
                this.addingPermission = newPermission
            },
            submitPermission() {
                this.queriedPermissions.push(this.addingPermission)
                this.addingPermissionVisible = false
            }
        }
    }
</script>

<style scoped>

</style>