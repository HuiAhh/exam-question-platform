<template>
    <div>
        <el-breadcrumb class="page-hd-breadcrumb" separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/exam-admin' }">欢迎页</el-breadcrumb-item>
            <el-breadcrumb-item>题目管理</el-breadcrumb-item>
            <el-breadcrumb-item>题目查询</el-breadcrumb-item>
        </el-breadcrumb>
        <h1 class="page-title">题目查询</h1>

        <el-row>
            <el-col :xs="24" :sm="{span:12,offset:6}">
                <el-form>
                    <el-form-item v-model="queryParam.queryTarget">
                        <el-input placeholder="搜索关键词">
                            <el-button slot="append" icon="el-icon-search" @click="query"></el-button>
                        </el-input>
                    </el-form-item>
                    <el-collapse>
                        <el-collapse-item title="高级搜索">
                            <el-form-item label="科目">
                                <el-select v-model="queryParam.courseId"
                                           clearable
                                           placeholder="请选择"
                                           @change="(val)=>selectedCourseId=val">
                                    <el-option
                                            v-for="item in courses"
                                            :key="item.categoryId"
                                            :label="item.name"
                                            :value="item.categoryId">
                                    </el-option>
                                </el-select>
                            </el-form-item>
                            <el-form-item label="知识点">
                                <el-cascader
                                        v-model="selectedknowledgePoints"
                                        :options="knowledgePoints"
                                        :props="{multiple: true, expandTrigger:'hover', value:'categoryId', label:'name'}"
                                        clearable></el-cascader>
                            </el-form-item>
                            <el-form-item label="题目类型">
                                <el-radio-group v-model="queryParam.type">
                                    <el-radio :label="2">单选题</el-radio>
                                    <el-radio :label="1">填空题</el-radio>
                                    <el-radio :label="0">主观题</el-radio>
                                </el-radio-group>
                            </el-form-item>
                        </el-collapse-item>
                    </el-collapse>
                </el-form>
            </el-col>
        </el-row>
        <el-row>
            <!--                todo 补充展示查询结果的item结构-->
            <el-col>

            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "QuestionQuery",
        data() {
            return {
                // enhanceSearch: false,
                knowledgePoints: [],
                queryParam: {
                    "courseId": "",
                    "queryTarget": "",
                    "knowledgeId": "",
                    "type": 2
                },
                selectedknowledgePoints: [],
                selectedCourseId: '',
                courses: [],
            }
        },
        watch: {
            selectedCourseId: function (newVal) {
                this.getKnowledgePoints(newVal)
            }
        },
        methods:{
            query(){
                let selectedPoints = JSON.stringify(this.selectedknowledgePoints)
                this.queryParam.knowledgeId=selectedPoints

                let url='/question/query'
                this.axios.get(url,
                    {
                        params: this.queryParam
                    }
                ).then(function (response) {
                    if (response['status'] === 200) {
                        let data = response['data']['data']
                        self.$store.commit('putQueryResult', data)
                        self.$router.push('/exam-admin/question/result')
                    }
                }).catch((error) => {
                    this.$message.error("出错了: -> " + JSON.stringify(error))
                })
            },
            getKnowledgePoints(courseId) {
                /**
                 * data:
                 * {
                      "children": [
                        {
                          "categoryId": 6,
                          "name": "左极限",
                          "keywords": "",
                          "pid": 3,
                          "iconUrl": "",
                          "picUrl": "",
                          "level": 3,
                          "addTime": null,
                          "updateTime": null,
                          "deleted": false
                        },
                        {
                          "categoryId": 7,
                          "name": "左极限",
                          "keywords": "",
                          "pid": 3,
                          "iconUrl": "",
                          "picUrl": "",
                          "level": 3,
                          "addTime": null,
                          "updateTime": null,
                          "deleted": false
                        }
                      ],
                      "categoryId": 3,
                      "name": "极限",
                      "keywords": "",
                      "pid": 1,
                      "iconUrl": "",
                      "picUrl": "",
                      "level": 2,
                      "addTime": null,
                      "updateTime": null,
                      "deleted": false
                 */
                console.log('into :---->' + 'getKnowledgePoints')
                this.axios.get(
                    '/category/list-knowledge-points',
                    {params: {courseId: courseId}}
                ).then((response) => {
                    if (response['status'] === 200) {
                        let data = response['data']['data']
                        this.knowledgePoints = data
                    }
                })
            },
            getCourses() {
                console.log('getCourse+++before click ')
                this.axios.get(
                    '/category/level',
                    {params: {level: '1'}}
                ).then((response) => {
                    if (response['status'] === 200) {
                        let data = response['data']['data']
                        this.courses = data
                        console.log(data)
                        console.log(this.courses)
                        this.$message(data)
                        /**
                         * data:{
                      "message": null,
                      "code": null,
                      "data": [
                        {
                          "categoryId": 1,
                          "name": "高数",
                          "keywords": "",
                          "pid": 0,
                          "iconUrl": "",
                          "picUrl": "",
                          "level": 1,
                          "addTime": null,
                          "updateTime": null,
                          "deleted": false
                        }
                      ]
                    }
                         */
                    }
                }).catch((error) => {
                    this.$message.error("出错了: -> " + error.message)
                })
                console.log('getCourse+++ ' + 'after ajax')
            }
        },
        created() {
            this.getCourses()
        }
    }
</script>

<style scoped>

</style>