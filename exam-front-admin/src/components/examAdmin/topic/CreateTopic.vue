<template>
    <div>
        <el-breadcrumb class="page-hd-breadcrumb" separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/exam-admin' }">欢迎页</el-breadcrumb-item>
            <el-breadcrumb-item>文章管理</el-breadcrumb-item>
            <el-breadcrumb-item>创建文章</el-breadcrumb-item>
        </el-breadcrumb>
        <h1 class="page-title">创建文章</h1>
            <!--            <el-radio v-model="selectType" label="3">多选题</el-radio>-->
        <default-component/>
    </div>
</template>

<script>

    import DefaultComponent from "../DefaultComponent";
    export default {
        name: "SimpletopicAdmin",
        components: {DefaultComponent},
        data() {
            return {
                topic:{
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
                emptyTopic:{
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
                ],
                knowledgePoints: [
                    {
                        name: '文化基础', categoryId: 1, level: 2,
                        children: [
                            {name: '理论计算机形成', categoryId: 2, level: 3},
                            {name: '图灵模型', categoryId: 3, level: 3}
                        ]
                    }
                ]

            }
        },
        methods: {
            submitForm(){
                console.log('submited')
            },
            resetForm() {
                let type = this.topic.type;
                let newTopic = {...this.emptyTopic}
                newTopic.type = type
                this.topic = newTopic
            }
        }
    }
</script>

