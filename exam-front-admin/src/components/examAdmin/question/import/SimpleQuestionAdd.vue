<template>
    <el-form class="page-input-form" label-position="right">
        <el-form-item label="题目类型">
            <el-radio-group v-model="question.type">
                <el-radio :label="2">单选题</el-radio>
                <el-radio :label="1">填空题</el-radio>
                <el-radio :label="0">主观题</el-radio>
            </el-radio-group>
        </el-form-item>
        <el-row>
            <el-col :span="8">
                <!--                <el-button class="el-icon-refresh" @click="getCourses"></el-button>-->
                <el-form-item label="科目" :class="{'invalid-border':invalidInput.courseId}">
                    <el-select v-model="question.courseId"
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
            </el-col>
            <el-col :span="8">
                <el-form-item label="知识点">
                    <el-cascader
                            v-model="selectedknowledgePoints"
                            :options="knowledgePoints"
                            :props="{multiple: true, expandTrigger:'hover', value:'categoryId', label:'name'}"
                            clearable></el-cascader>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row :gutter="30">
            <h2 style="color:grey;font-size:20px;">题目主要内容</h2>
            <el-form-item style="margin-left:10%;" label="题干">
                <el-input style="width:75%;" type="textarea" autosize v-model="question.name"
                          placeholder="题干" :class="{'invalid-border':invalidInput.name}"></el-input>
                <el-button icon="el-icon-close" circle @click="question.name=''"></el-button>
            </el-form-item>
            <el-col :xs="24" :sm="12">
                <div v-if="question.type===2">
                    <h3 style="color:grey;font-size:18px;">选项</h3>
                    <el-form-item label="A">
                        <el-input class="option-input" clearable v-model="question.optiona"
                                  placeholder="A" :class="{'invalid-border':invalidInput.optiona}"></el-input>
                        <el-radio label="A" v-model="question.answer">设为答案</el-radio>
                    </el-form-item>
                    <el-form-item label="B">
                        <el-input class="option-input" clearable v-model="question.optionb"
                                  placeholder="B" :class="{'invalid-border':invalidInput.optionb}"></el-input>
                        <el-radio label="B" v-model="question.answer">设为答案</el-radio>
                    </el-form-item>
                    <el-form-item label="C">
                        <el-input class="option-input" clearable v-model="question.optionc"
                                  placeholder="C" :class="{'invalid-border':invalidInput.optionc}"></el-input>
                        <el-radio label="C" v-model="question.answer">设为答案</el-radio>
                    </el-form-item>
                    <el-form-item label="D">
                        <el-input class="option-input" clearable v-model="question.optiond"
                                  placeholder="D" :class="{'invalid-border':invalidInput.optiond}"></el-input>
                        <el-radio label="D" v-model="question.answer">设为答案</el-radio>
                    </el-form-item>
                </div>
            </el-col>
            <el-col :xs="24" :sm="12">
                <div v-if="question.type===2">
                    <h3 style="color:grey;font-size:18px;">答案</h3>
                    <el-form-item label="答案">
                        <!--                            <el-input class="option-input" v-model="question.answer" placeholder="A"></el-input>-->
                        <el-radio-group v-model="question.answer" :class="{'invalid-border':invalidInput.answer}">
                            <el-radio-button label="A">A</el-radio-button>
                            <el-radio-button label="B">B</el-radio-button>
                            <el-radio-button label="C">C</el-radio-button>
                            <el-radio-button label="D">D</el-radio-button>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item label="详细题解">
                        <el-input style="width:75%;" type="textarea" autosize v-model="question.answerDetail"
                                  placeholder="详细题解"></el-input>
                        <el-button icon="el-icon-close" circle @click="question.answerDetail=''"></el-button>
                    </el-form-item>
                    <span>难度</span>
                    <el-slider style="width:70%" :marks="hardMark" :max="hardRange.max"
                               :min="hardRange.min"
                               v-model="question.difficulty"></el-slider>
                </div>
            </el-col>
            <el-col :xs="24" :sm="12">
                <div v-if="question.type===1||question.type===0">
                    <h3 style="color:grey;font-size:18px;">答案</h3>
                    <el-form-item label="答案" v-if="question.type===1" :class="{'invalid-border':invalidInput.answer}">
                        <!--                            <el-input class="option-input" v-model="question.answer" placeholder="A"></el-input>-->
                        <el-input style="width:75%;" type="textarea" autosize v-model="question.answer"
                                  placeholder="题干"></el-input>
                        <el-button icon="el-icon-close" circle @click="question.answer=''"></el-button>
                    </el-form-item>
                    <el-form-item label="详细题解">
                        <el-input style="width:75%;" type="textarea" autosize v-model="question.answerDetail"
                                  placeholder="详细题解"></el-input>
                        <el-button icon="el-icon-close" circle @click="question.answerDetail=''"></el-button>
                    </el-form-item>
                    <span>难度</span>
                    <el-slider style="width:70%;margin-bottom:20px;" :marks="hardMark" :max="hardRange.max"
                               :min="hardRange.min"
                               v-model="question.difficulty"></el-slider>
                </div>
            </el-col>
        </el-row>
        <el-button :class="{'btn-hidden':hidden}" type="primary" @click="submitForm">添加</el-button>
        <el-button :class="{'btn-hidden':hidden}" @click="resetForm">重填</el-button>
    </el-form>
</template>
<script>
    export default {
        name: 'SimpleQuestionAdd',
        props: {
            submitForm: Function,
            hidden: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
                question: {
                    "answer": "",
                    "answerDetail": "",
                    "courseId": "",
                    "difficulty": 5,
                    "knowledgeId": "",
                    "name": "",
                    "optiona": "",
                    "optionb": "",
                    "optionc": "",
                    "optiond": "",
                    "type": 2,
                    "userAnswer": ""
                },
                emptyQuestion: {
                    "answer": "",
                    "answerDetail": "",
                    "courseId": "",
                    "difficulty": 5,
                    "knowledgeId": "",
                    "name": "",
                    "optiona": "",
                    "optionb": "",
                    "optionc": "",
                    "optiond": "",
                    "type": 0,
                    "userAnswer": ""
                },
                hardMark: {
                    0: '易',
                    5: '中',
                    10: '难'
                },
                hardRange: {
                    max: 10,
                    min: 0
                },
                courses: [],
                knowledgePoints: [],
                selectedknowledgePoints: [],
                selectedCourseId: '',
                invalidInput: {
                    "answer": false,
                    "courseId": false,
                    "name": false,
                    "optiona": false,
                    "optionb": false,
                    "optionc": false,
                    "optiond": false
                },
                emptyInvalidInput: {
                    "answer": false,
                    "courseId": false,
                    "name": false,
                    "optiona": false,
                    "optionb": false,
                    "optionc": false,
                    "optiond": false
                }
            }
        },
        watch: {
            selectedCourseId: function (newVal) {
                this.getKnowledgePoints(newVal)
            }
        },
        methods: {
            /**
             * selectedknowledgePoints:
             * [[2,4],[2,5],[3,6],[3,7]]
             */
            validateQuestion() {
                let question = this.question
                if (!question.answer) this.invalidInput.answer = true
                if (!question.courseId) this.invalidInput.courseId = true
                if (!question.name) this.invalidInput.name = true
                if (question.type == 2) {
                    if (!question.optiona) this.invalidInput.optiona = true
                    if (!question.optionb) this.invalidInput.optionb = true
                    if (!question.optionc) this.invalidInput.optionc = true
                    if (!question.optiond) this.invalidInput.optiond = true
                    return JSON.stringify(this.invalidInput) == JSON.stringify(this.emptyInvalidInput)
                } else if(question.type==1){
                    return !this.invalidInput.answer && !this.invalidInput.courseId && !this.invalidInput.name
                } else {
                    return !this.invalidInput.courseId && !this.invalidInput.name
                }
            },
            resetValidation(){
                this.invalidInput = {...this.emptyInvalidInput}
            },
            beforeSubmit() {
                this.resetValidation()
                console.log('validateQuestion--->++++===' + this.validateQuestion())
                if (this.validateQuestion()) {
                    let selectedPoints = JSON.stringify(this.selectedknowledgePoints)
                    this.question.knowledgeId = selectedPoints
                    return true
                }
                return false
            },
            resetForm() {
                let type = this.question.type;
                this.resetValidation()
                let newQuestion = {...this.emptyQuestion}
                newQuestion.type = type
                this.question = newQuestion
            },
            editFormFromMulti(oldQuestion) {
                this.question = oldQuestion
                this.selectedknowledgePoints=JSON.parse(oldQuestion.knowledgeId)
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
<style>
    .option-input {
        width: 70%;
    }

    .invalid-border {
        border: 5px dashed red;
    }
</style>