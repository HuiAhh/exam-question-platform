<template>
    <div>
        <el-breadcrumb class="page-hd-breadcrumb" separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/exam-admin' }">欢迎页</el-breadcrumb-item>
            <el-breadcrumb-item>字段管理</el-breadcrumb-item>
            <el-breadcrumb-item>学院专业字段</el-breadcrumb-item>
        </el-breadcrumb>
        <h1 class="page-title">学院专业字段</h1>
        <el-table
                :data="schools"
                style="width: 100%">
            <el-table-column type="expand">
                <template slot-scope="scope">
                    <el-table :data="getMajorsBySchool(scope.row.schoolId)">
                        <el-table-column prop="majorName" label="专业"></el-table-column>
                        <el-table-column>
                            <template slot="header">
                                <el-button
                                        size="mini"
                                        class="el-icon-plus"
                                        circle></el-button>
                            </template>
                            <template slot-scope="scope">
                                <el-button
                                        size="mini"
                                        class="el-icon-edit"
                                        circle></el-button>
                                <el-button
                                        size="mini"
                                        type="danger"
                                        class="el-icon-close"
                                        circle
                                        @click="handleMajorDelete(scope.row.majorId)"></el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </template>
            </el-table-column>
            <el-table-column prop="schoolName" label="学院">
            </el-table-column>
            <el-table-column>
                <template slot="header">
                    <el-button
                            size="mini"
                            class="el-icon-plus"
                            circle></el-button>
                    <el-button round size="mini"
                               type="primary"
                               icon="el-icon-upload2"
                               @click="submitAll">提交</el-button>
                    <el-button round size="mini"
                               type="danger"
                               icon="el-icon-delete"
                               @click="cancelEdit">取消更改</el-button>
                </template>
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            class="el-icon-edit"
                            circle></el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            class="el-icon-close"
                            circle
                            @click="handleSchoolDelete(scope.$index)"></el-button>
                </template>
            </el-table-column>

        </el-table>
    </div>
</template>

<script>
    export default {
        name: "FieldMajor",
        data() {
            return {
                schools:[
                    {
                        "addTime": "2020-10-25T06:57:58.921Z",
                        "deleted": false,
                        "schoolId": 0,
                        "schoolName": "互联网",
                        "updateTime": "2020-10-25T06:57:58.921Z",
                    },{
                        "addTime": "2020-10-25T06:57:58.921Z",
                        "deleted": false,
                        "schoolId": 1,
                        "schoolName": "数统",
                        "updateTime": "2020-10-25T06:57:58.921Z",
                    },{
                        "addTime": "2020-10-25T06:57:58.921Z",
                        "deleted": false,
                        "schoolId": 2,
                        "schoolName": "会计",
                        "updateTime": "2020-10-25T06:57:58.921Z",
                    }
                ],
                backupSchools:[
                    {
                        "addTime": "2020-10-25T06:57:58.921Z",
                        "deleted": false,
                        "schoolId": 0,
                        "schoolName": "互联网",
                        "updateTime": "2020-10-25T06:57:58.921Z",
                    },{
                        "addTime": "2020-10-25T06:57:58.921Z",
                        "deleted": false,
                        "schoolId": 1,
                        "schoolName": "数统",
                        "updateTime": "2020-10-25T06:57:58.921Z",
                    },{
                        "addTime": "2020-10-25T06:57:58.921Z",
                        "deleted": false,
                        "schoolId": 2,
                        "schoolName": "会计",
                        "updateTime": "2020-10-25T06:57:58.921Z",
                    }
                ],
                majors:[
                    {
                        "addTime": "2020-10-25T07:00:20.545Z",
                        "deleted": false,
                        "majorId": 0,
                        "majorName": "软件工程",
                        "schoolId": 0,
                        "updateTime": "2020-10-25T07:00:20.545Z"
                    },
                    {
                        "addTime": "2020-10-25T07:00:20.545Z",
                        "deleted": false,
                        "majorId": 1,
                        "majorName": "应用统计学",
                        "schoolId": 1,
                        "updateTime": "2020-10-25T07:00:20.545Z"
                    }
                ]
            }
        },
        methods:{
            submitAll(){

            },
            cancelEdit(){
                this.schools=[...this.backupSchools]
            },
            handleSchoolDelete(index){
                this.schools.splice(index,1)
            },
            getMajorsBySchool(schoolId){
                return this.majors.filter(item=>item.schoolId==schoolId)
            },
            handleMajorDelete(majorId){
                this.majors.filter(item=>item.majorId==majorId)
            },
        }
    }
</script>

<style scoped>

</style>