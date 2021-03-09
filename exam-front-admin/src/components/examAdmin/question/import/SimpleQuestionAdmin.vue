<template>
    <div>
        <el-breadcrumb class="page-hd-breadcrumb" separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/exam-admin' }">欢迎页</el-breadcrumb-item>
            <el-breadcrumb-item>题目管理</el-breadcrumb-item>
            <el-breadcrumb-item>题目导入</el-breadcrumb-item>
            <el-breadcrumb-item>单题导入</el-breadcrumb-item>
        </el-breadcrumb>
        <h1 class="page-title">单题导入</h1>
        <!--            <el-radio v-model="selectType" label="3">多选题</el-radio>-->
        <SimpleQuestionAdd ref="questionAdd" :submit-form="submitForm"/>
    </div>
</template>

<script>
    import SimpleQuestionAdd from "./SimpleQuestionAdd";

    export default {
        name: "SimpleQuestionAdmin",
        components: {SimpleQuestionAdd},
        data() {
            return {}
        },
        methods: {
            submitForm() {
                if (this.$refs.questionAdd.beforeSubmit()) {
                    let question = this.$refs.questionAdd.question
                    this.axios.post('/question', JSON.stringify(question))
                        .then((response) => {
                            if (response['status'] === 200) {
                                this.$message('提交成功')
                                console.log(response)
                            } else {
                                this.$message.error('提交失败')
                            }
                        }).catch((error) => {
                        this.$message.error("出错了: -> " + error.message)
                    })
                }
            }
        }
    }
</script>

