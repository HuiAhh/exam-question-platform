<template>
    <el-container class="mid">
        <el-aside width="auto" class="mid subject-menu" style="float: left; margin-left:2%; padding-right: 2%;">
            <AsideTreeMenu/>
        </el-aside>
        <el-main class="mid main-content" style="float: left; width:80%; margin-left:2%;padding-bottom: 2%">
            <h2 style="text-align: center">题目列表</h2>
            <!--列表头~又select_question_list.html维护，贴至此处-->
            <div style="padding-left: 2%;padding-right: 2%">
              <el-table
                        ref="multipleTable"
                        :data="questionsPaged"
                        tooltip-effect="dark"
                        style="width: 100%"
                        @selection-change="handleSelectionChange">
                    <el-table-column
                            type="selection"
                            width="55">
                    </el-table-column>
                    <el-table-column
                            prop="name"
                            width="auto">
                        <template slot="header">
                            <ListHeader :create-paper="createPaper" :immediate-exercise="immediateExercise" :star-selected="starSelected"/>
                        </template>
                        <template slot-scope="scope">
                            <QuestionSelectItem :page="currentPage" :knowledgesPoint="knowledgePoints" :itemId="scope.$index" :key="scope.row.questionId" :question="scope.row"/>
                        </template>
                    </el-table-column>
                </el-table>
            </div>
            <el-pagination
                    background
                    layout="prev, pager, next"
                    @current-change="changePage"
                    :current-page="currentPage"
                    :total="60">
            </el-pagination>

            <!--列表尾~又select_question_list.html维护，贴至此处-->
        </el-main>
        <el-dialog title="组卷创建" :visible.sync="paperDialogActive" :before-close="clearPaperDialog">
            <el-form>
                <el-form-item label="组卷名称">
                    <el-input v-model="paperName"></el-input>
                </el-form-item>
                <el-form-item label="允许答题用时">
                    <el-input-number v-model="creatingPaper.allowTime">
                    </el-input-number><span>分钟</span>
                </el-form-item>
            </el-form>
            <div>
                <el-button type="primary" @click="clearPaperDialog">提交</el-button>
            </div>
        </el-dialog>
    </el-container>
</template>
<script>
    import ListHeader from "@/ListHeader"
    import QuestionSelectItem from "@/QuestionSelectItem"
    import AsideTreeMenu from "@/AsideTreeMenu";

    export default {
        name: 'MainPage',
        components: {AsideTreeMenu, ListHeader, QuestionSelectItem},
        computed:{
            queryRefresh(){
                return this.$store.state.queryRefresh
            },
            knowledgePoints(){
                return this.$store.state.knowledgePoints
            },

        },
        watch:{
            // '$store.state.queryRefresh': function () {
            //     this.question=this.$store.state.queryResult
            // }
            queryRefresh(){
                this.questions=this.$store.state.queryResult
                this.questionsPaged=this.questions.slice(0,10)
            }

        },
        data() {
            return {
                questions: [
                //     {
                //     itemId: 1,
                //     name: '巴拉巴拉吧巴拉巴拉吧巴拉巴拉吧',
                //     type: "客观题",
                //     knowledgePoint: "导函数",
                //     rightRatio: "59%",
                //     hard: "难"
                // }, {
                //     itemId: 2,
                //     name: '巴拉巴拉吧巴拉巴拉吧巴拉巴拉吧',
                //     type: "客观题",
                //     knowledgePoint: "导函数",
                //     rightRatio: "80%",
                //     hard: "易"
                // },{
                //         itemId: 3,
                //         name: '巴拉巴拉吧巴拉巴拉吧巴拉巴拉吧',
                //         type: "客观题",
                //         knowledgePoint: "导函数",
                //         rightRatio: "80%",
                //         hard: "易"
                //     },

                    /**
                     * {
                          "answer": "string",
                          "answerDetail": "string",
                          "courseId": "string",
                          "difficulty": 0,
                          "knowledgeId": "string",
                          "name": "string",
                          "optiona": "string",
                          "optionb": "string",
                          "optionc": "string",
                          "optiond": "string",
                          "questionId": 0,
                          "type": 0,
                          "userAnswer": "string"
                        }
                     */
                ],
                multipleSelection: [],
                questionsPaged:[],
                currentPage:1,
                emptyPaper:{
                    "addTime": null,
                    "allowTime": null,
                    "beginTime": null,
                    "courseId": null,
                    "deleted": null,
                    "endTime": null,
                    "paperId": null,
                    "score": null,
                    "updateTime": null,
                    "userId": null
                },
                creatingPaper:{
                    "addTime": "2020-10-28T05:42:24.105Z",
                    "allowTime": "2020-10-28T05:42:24.105Z",
                    "beginTime": "2020-10-28T05:42:24.106Z",
                    "courseId": -1,
                    "deleted": false,
                    "endTime": "2020-10-28T05:42:24.106Z",
                    "paperId": -1,
                    "score": -1,
                    "updateTime": "2020-10-28T05:42:24.106Z",
                    "userId": -1
                },
                paperDialogActive:false,
                paperName:''
            }
        },
        methods: {
            getPaperName(){
                console.log(this.$store.state.courses)
                console.log(this.$store.state.courses.filter(item=>item.courseId==this.creatingPaper.courseId)[0])
                return this.$store.state.courses.filter(item=>item.courseId==this.creatingPaper.courseId)[0].name+':==>'
                    +new Date().toJSON()+'组卷'
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            handleNodeClick(data) {
                console.log(data);
            },
            createFilter(queryString) {
                return (category) => {
                    return (category.label.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
                };
            },
            prevPage(){
                // this.questionsPaged=this.questions.slice((page-1)*10,page*10)
            },
            nextPage(){
                // this.questionsPaged=this.questions.slice((page-1)*10,page*10)
            },
            changePage(page){
                this.currentPage=page
                this.questionsPaged=this.questions.slice((page-1)*10,page*10)
            },
            createPaper(){
                this.creatingPaper.courseId=this.questions[0].courseId
                // this.paperName=this.getPaperName()
                this.paperDialogActive=true
            },
            clearPaperDialog(){
                this.paperDialogActive=false
                // this.paperName=''
                this.creatingPaper={...this.emptyPaper}
            },
            immediateExercise(){
                this.$store.commit('putExerciseQuestions', [...this.multipleSelection])
                this.$store.commit('putExercisingPaper',{
                    allowTime:120,
                    exercisingPaperName:new Date().toJSON()+'的临时刷题页'
                })
                this.$router.push('/exercise')
            }
        }
    }
</script>
