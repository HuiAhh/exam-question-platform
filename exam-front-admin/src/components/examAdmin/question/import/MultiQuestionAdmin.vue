<template>
    <div>
        <el-breadcrumb class="page-hd-breadcrumb" separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/exam-admin' }">欢迎页</el-breadcrumb-item>
            <el-breadcrumb-item>题目管理</el-breadcrumb-item>
            <el-breadcrumb-item>题目导入</el-breadcrumb-item>
            <el-breadcrumb-item>多题导入</el-breadcrumb-item>
        </el-breadcrumb>
        <h1 class="page-title">多题导入</h1>
        <span>待提交题目</span>
        <el-table :data="questions">
            <el-table-column label="题干" prop="name"></el-table-column>
            <el-table-column label="类型">
                <template slot-scope="scope">
                    <span v-if="scope.row.type==0">主观题</span>
                    <span v-if="scope.row.type==1">填空题</span>
                    <span v-if="scope.row.type==2">单选题</span>
                </template>
            </el-table-column>
            <el-table-column label="科目">
                <template slot-scope="scope">
                    <span>{{findCourse(scope.row.courseId)['name']}}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作">
                <template slot="header">
                    <el-button round size="mini" type="primary" icon="el-icon-upload2" @click="submitAll">提交</el-button>
                    <el-popconfirm
                            title="确定清空？"
                            @onConfirm="clearAll"
                    >
                        <el-button slot="reference" round size="mini" type="danger" icon="el-icon-delete">清空</el-button>
                    </el-popconfirm>
                </template>
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            @click="handleQuestionEdit(scope.$index, scope.row)"
                            :class="{'btn-hidden':editingFlag}"
                    >重新退回修改</el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            @click="handleQuestionDelete(scope.$index)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-button :class="{'btn-hidden':!editingFlag}" @click="submitEdit" type="primary">提交改动</el-button>
        <el-button :class="{'btn-hidden':!editingFlag}" @click="cancelEdit">取消修改</el-button>
        <SimpleQuestionAdd :submit-form="submitForm" :hidden="editingFlag" ref="questionForm"/>
    </div>
</template>

<script>
    import SimpleQuestionAdd from "./SimpleQuestionAdd";
    export default {
        name: "SimpleQuestionAdmin",
        components: {SimpleQuestionAdd},
        data() {
            return {
                questions:[

                ],
                editingFlag:false,
                beforeEditionQuestion:{}
            }
        },
        methods: {
            submitAll(){
                if(this.questions) {
                    this.axios.post('/question/multi', JSON.stringify(this.questions))
                        .then((response) => {
                            if (response['status'] === 200) {
                                this.$message('提交成功' + response.data.data)
                                console.log(response)
                                this.clearAll()
                            } else {
                                this.$message.error('提交失败')
                            }
                        }).catch((error) => {
                        this.$message.error("出错了: -> " + error.message)
                    })
                }
            },
            clearAll(){
                this.questions=[]
                this.$refs.questionForm.selectedknowledgePoints=[]
            },
            submitForm(){
                // console.log('add a question temporarily')
                if (this.$refs.questionForm.beforeSubmit()) {
                    this.questions.push(this.$refs.questionForm.question)
                    console.log(this.questions)
                    this.editingFlag = false
                    this.$refs.questionForm.resetForm()
                    this.$refs.questionForm.selectedknowledgePoints=[]
                }
            },
            handleQuestionEdit(index,item){
                // console.log(item)
                this.$refs.questionForm.editFormFromMulti(item)
                this.handleQuestionDelete(index)
                this.editingFlag=true
                this.beforeEditionQuestion={...item}
            },
            handleQuestionDelete(index){
                this.questions.splice(index,1)
            },
            submitEdit(){
                this.submitForm()
            },
            cancelEdit(){
                this.$refs.questionForm.editFormFromMulti(this.beforeEditionQuestion)
                this.submitForm()
            },
            findCourse(courseId){
                let arr= this.$refs.questionForm.courses.filter(item=>item.categoryId==courseId)
                return arr[0]
            }
        }
    }
</script>

<style>

</style>