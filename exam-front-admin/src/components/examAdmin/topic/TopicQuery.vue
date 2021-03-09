<template>
    <div>
        <el-breadcrumb class="page-hd-breadcrumb" separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/exam-admin' }">欢迎页</el-breadcrumb-item>
            <el-breadcrumb-item>文章管理</el-breadcrumb-item>
            <el-breadcrumb-item>文章查询</el-breadcrumb-item>
        </el-breadcrumb>
        <h1 class="page-title">文章查询</h1>

        <el-row>
            <el-col :xs="24" :sm="{span:12,offset:6}">
                <!--                <el-switch-->
                <!--                        v-model="enhanceSearch"-->
                <!--                        active-text="高级搜索"-->
                <!--                        inactive-text="初级搜索">-->
                <!--                </el-switch>-->
                <!--                <div v-if="!enhanceSearch">-->
                <!--                    <span>初级搜索</span>-->
                <!--                    <el-input placeholder="初级搜索：文章名">-->
                <!--                        <el-button slot="append" icon="el-icon-search"></el-button>-->
                <!--                    </el-input>-->
                <!--                </div>-->
                <!--                <div v-if="enhanceSearch">-->
                <!--                    <span>高级搜索</span>-->
                <!--                    <el-input placeholder="文章名">-->
                <!--                        <el-button slot="append" icon="el-icon-search"></el-button>-->
                <!--                    </el-input>-->
                <!--                </div>-->
                <el-form>
                    <el-form-item v-model="queryParam.title">
                        <el-input placeholder="标题">
                            <el-button slot="append" icon="el-icon-search"></el-button>
                        </el-input>
                    </el-form-item>
                    <el-collapse>
                        <el-collapse-item title="高级搜索">
                            <el-form-item label="科目">
                                <el-select v-model="queryParam.courseId" clearable placeholder="请选择">
                                    <el-option
                                            v-for="item in subjects"
                                            :key="item.categoryId"
                                            :label="item.name"
                                            :value="item.categoryId">
                                    </el-option>
                                </el-select>
                            </el-form-item>
                            <el-form-item label="创建时间">
                                <el-date-picker
                                        v-model="queryParam.addTime"
                                        align="right"
                                        type="date"
                                        placeholder="选择日期"
                                >
                                </el-date-picker>
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
                queryParam: {
                    "addTime": "2020-10-24T02:11:10.482Z",
                    "content": "string",
                    "deleted": true,
                    "goods": "string",//category
                    "picUrl": "string",
                    "price": 0,
                    "readCount": "string",
                    "sortOrder": 0,
                    "subtitle": "string",
                    "title": "string",
                    "topicId": 0,
                    "updateTime": "2020-10-24T02:11:10.483Z"
                },
                subjects: [
                    {categoryId: 1, name: '计算机导论', level: 1}
                ]
            }
        }
    }
</script>

<style scoped>

</style>