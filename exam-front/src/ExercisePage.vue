<template>
    <el-container>
        <el-header>
            <el-row>
                <el-col :span="6">
                    <span class="el-icon-timer"></span>
                    <span>{{timerMsg}}</span>
                </el-col>
                <el-col :span="12">
                    <h1 style="font-size:16px">{{this.$store.state.exercisingPaper.exercisingPaperName}}</h1>
                </el-col>
                <el-col :span="6">
                    <el-button type="primary" @click="unconfirmDialog=true">交卷</el-button>
                    <el-button type="danger" @click="$router.go(-1)">退出</el-button>
                </el-col>
            </el-row>
        </el-header>
        <!--        <el-aside></el-aside>-->
        <el-main>
            <h1 style="text-align: center">刷题页</h1>
            <el-table
                    width="80%"
                    ref="multipleTable"
                    :data="questionsPaged"
                    tooltip-effect="dark"
                    style="width: 100%"
            >
                <el-table-column
                        prop="name"
                        width="auto">
                    <template slot-scope="scope">
                        <QuestionExerciseItem :disable-star="true" :page="currentPage" :itemId="scope.$index"
                                            :question="scope.row"/>
                        <AnswerItem :answer="answers[(currentPage-1)*10+scope.$index]" :type="scope.row.type"/>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination
                    background
                    layout="prev, pager, next"
                    @current-change="changePage"
                    :current-page="currentPage"
                    :total="20">
            </el-pagination>
        </el-main>
        <scroll-bar style="position: fixed;top:0;right:0"/>
        <el-dialog title="确认提交？" :visible.sync="unconfirmDialog">
            <span>有未完成题目，确认提交？</span>
            <div>
                <el-button type="primary" @click="confirm">提交</el-button>
                <el-button @click="unconfirmDialog=false">返回</el-button>
            </div>
        </el-dialog>
    </el-container>
</template>

<script>
    import QuestionExerciseItem from "@/QuestionExerciseItem";
    import AnswerItem from "@/AnswerItem";
    import ScrollBar from "@/ScrollBar";

    export default {
        name: "ExercisePage",
        components: {QuestionExerciseItem, AnswerItem, ScrollBar},
        data() {
            return {
                currentPage: 1,
                multipleSelection: [],
                questionsPaged: [],
                answers: [],
                timerMsg:'',
                timer:null,
                unconfirmDialog:false
            }
        },
        watch: {},
        methods: {
            changePage(page) {
                this.currentPage = page
                this.questionsPaged = this.$store.state.exerciseQuestions.slice((page - 1) * 10, page * 10)
            },
            countDown() {
                let maxtime=this.$store.state.exercisingPaper.allowTime*60
                if (maxtime >= 0) {
                    let minutes = Math.floor(maxtime / 60);
                    let seconds = Math.floor(maxtime % 60);
                    this.timerMsg = minutes + ":" + seconds;
                } else {
                    clearInterval(this.timer);
                    alert("time over.");
                }
            },
            confirm(){
                this.unconfirmDialog=false
                this.$message('已提交答案')
                this.$router.go(-1)
            }
        },
        mounted() {
            this.changePage(1)
            this.timer=setInterval(this.countDown, 1000);
        }
    }
</script>

<style scoped>

</style>