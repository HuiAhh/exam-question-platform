<template>
    <div>
        <el-breadcrumb class="page-hd-breadcrumb" separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/exam-admin' }">欢迎页</el-breadcrumb-item>
            <el-breadcrumb-item>用户管理</el-breadcrumb-item>
            <el-breadcrumb-item>用户查询</el-breadcrumb-item>
        </el-breadcrumb>
        <h1 class="page-title">用户查询</h1>

        <el-row>
            <el-col :xs="24" :sm="{span:12,offset:6}">
                <el-form>
                    <el-form-item>
                        <el-input  v-model="queryParam.nickname" placeholder="昵称">
                            <el-button slot="append" icon="el-icon-search"></el-button>
                        </el-input>
                    </el-form-item>
                    <el-collapse>
                        <el-collapse-item title="高级搜索">
                            <el-form-item label="用户名">
                                <el-input v-model="queryParam.username" placeholder="用户名">
                                </el-input>
                            </el-form-item>
                            <el-form-item label="邮箱">
                                <el-input v-model="queryParam.email" placeholder="邮箱">
                                </el-input>
                            </el-form-item>
                            <el-form-item label="UID">
                                <el-input v-model="queryParam.userId" placeholder="UID">
                                </el-input>
                            </el-form-item>
                            <el-form-item label="性别">
                                <el-radio-group v-model="queryParam.gender">
                                    <el-radio :label="0">未指定</el-radio>
                                    <el-radio :label="1">男</el-radio>
                                    <el-radio :label="2">女</el-radio>
                                </el-radio-group>
                            </el-form-item>
                            <el-form-item label="专业">
                                <el-cascader
                                        v-model="queryParam.major"
                                        :options="options"
                                        :props="{ expandTrigger: 'hover' }"
                                        :show-all-levels="false"
                                        clearable
                                ></el-cascader>
                            </el-form-item>
                            <el-form-item label="创建时间">
                                <el-date-picker
                                        v-model="queryParam.addTime"
                                        align="right"
                                        type="date"
                                        placeholder="选择日期">
                                </el-date-picker>
                            </el-form-item>
                            <el-form-item label="上次登录时间">
                                <el-date-picker
                                        v-model="queryParam.lastLoginTime"
                                        align="right"
                                        type="date"
                                        placeholder="选择日期">
                                </el-date-picker>
                            </el-form-item>
                        </el-collapse-item>
                    </el-collapse>
                </el-form>
            </el-col>
        </el-row>
        <el-table></el-table>
    </div>
</template>

<script>
    export default {
        name: "QuestionQuery",
        data() {
            return {
                queryParam: {
                    "addTime": "2020-10-24T03:46:42.041Z",
                    "avatar": "",
                    "birthday": "",
                    "deleted": true,
                    "email": "",
                    "gender": 0,// 0未指定 1男 2女
                    "grade": "",
                    "lastLoginIp": "",
                    "lastLoginTime": "2020-10-24T03:46:42.042Z",
                    "major": 0,
                    "mobile": "",
                    "nickname": "",
                    "password": "",
                    "status": 0,
                    "updateTime": "2020-10-24T03:46:42.043Z",
                    "userId": 0,
                    "userLevel": 0,
                    "username": "",
                    "weixinOpenid": ""
                },
                options: [
                    {
                        value: 'school_1',
                        label: '互联网金融与信息工程学院',
                        children: [
                            {
                                value: 'major_11',
                                label: '信息管理与信息系统'
                            }, {
                                value: 'major_12',
                                label: '电子商务'
                            },{
                                value: 'major_13',
                                label: '互联网金融'
                            },{
                                value: 'major_14',
                                label: '软件工程'
                            }
                        ]
                    }, {
                        value: 'school_2',
                        label: '会计学院',
                        children: [
                            {
                                value: 'major_21',
                                label: '会计学'
                            }, {
                                value: 'major_12',
                                label: '财务管理'
                            }
                        ]

                    }
                ],
                value:null
            }
        }
    }
</script>

<style scoped>

</style>