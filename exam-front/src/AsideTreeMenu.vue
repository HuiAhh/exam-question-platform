<template>
    <div class="tree-menu">
        <el-form>
            <el-form-item label="科目">
                <el-select v-model="courseId"
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
        </el-form>
    </div>
</template>
<script>
    export default {
        name: 'AsideTreeMenu',
        props: {},
        watch: {
            selectedCourseId: function (newVal) {
                this.getKnowledgePoints(newVal)
                this.queryParam.courseId=newVal
                this.query()
            },
            selectedknowledgePoints: function () {
                // this.getKnowledgePoints(newVal)
                this.queryParam.courseId=this.courseId
                this.queryParam.knowledgeId=JSON.stringify(this.selectedknowledgePoints)
                //encoding 操作
                // this.queryParam.knowledgeId=encodeURIComponent(JSON.stringify(this.selectedknowledgePoints))
                console.log(this.queryParam)
                this.$store.commit('putKnowledgePoints',this.knowledgePoints)
                this.query()
            },

        },
        data() {
            return {
                courseProps: {
                    children: 'children',
                    label: 'name'
                },
                courses: [],
                selectedknowledgePoints: [],
                knowledgePoints: [],
                selectedCourseId: [],
                courseId: '',
                coursesTree: [],
                queryParam: {
                    "courseId": "",
                    // "queryTarget": "",//关键词
                    "knowledgeId": "",
                    // "type": 2//题目类型
                },
            }
        }, methods: {
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
                        //todo >>>
                        // this.coursesTree[0]['children'] = this.knowledgePoints
                        // console.log('after ajax:====>getKnowledgePoints')
                        // console.log(this.coursesTree[0])
                    }
                })
            },
            getCourses() {
                let _self=this
                console.log('getCourse+++before click ')
                this.axios.get(
                    '/category/level',
                    {params: {level: '1'}}
                ).then((response) => {
                    if (response['status'] === 200) {
                        let data = response['data']['data']
                        this.courses = data
                        this.coursesTree = data
                        _self.$store.commit('putCourses', data)
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
            },
            query(){
                let _self=this
                console.log('query====>'+'into')
                let url='/question/query'
                this.axios.get(url,
                    {
                        // data: this.$qs.stringify(this.queryParam),
                        // headers: { 'Content-Type': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8' },
                        params:this.queryParam
                    }
                ).then(function (response) {
                    if (response['status'] === 200) {
                        let data = response['data']['data']
                        _self.$store.commit('putQueryResult', data)
                    }
                }).catch((error) => {
                    console.log(error)
                    // this.$message.error("出错了: -> " + JSON.stringify(error))
                })
            }
        },
        mounted() {
            this.getCourses()
        }
    }
</script>
<style>
    .tree-menu {
        float: left;
        margin-left: 2%;
        padding-right: 2%;
        width: 200px;
    }
</style>