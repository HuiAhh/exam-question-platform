<template>
    <div class="list-item flex-row-center" style="margin-top:10px; padding:2%;" @mouseenter="handleMouseEnter">
        <!--        <input type="checkbox"/>-->
        <div style="margin:0 2%; width:90%">
            <p>
                <strong>{{(page-1)*10+itemId+1}}. </strong>
                <strong style="color: #7376bd">(
                    <!--                    {{this.question.type}}-->
                    <span v-if="this.question.type===2">单选题</span>
                    <span v-if="this.question.type===1">填空题</span>
                    <span v-if="this.question.type===0">主观题</span>
                    )</strong>&nbsp;&nbsp;{{this.question.name}}
            </p>
            <el-form v-if="this.question.type===2">
                <el-form-item label="A">
                    <span>{{this.question.optiona}}</span>
                </el-form-item>
                <el-form-item label="B">
                    <span>{{this.question.optionb}}</span>
                </el-form-item>
                <el-form-item label="C">
                    <span>{{this.question.optionc}}</span>
                </el-form-item>
                <el-form-item label="D">
                    <span>{{this.question.optiond}}</span>
                </el-form-item>
            </el-form>
<!--            <div class="flex-row-center" style="justify-content: flex-start">-->
            <div style="width:70%">
<!--                                <p style="width: 40%"><strong>知识点</strong>&nbsp;&nbsp;-->
<!--                                    <strong style="color: #64bda6">-->
<!--                                        {{getKnowledgeName(this.question.knowledgeId)}}-->
<!--&lt;!&ndash;                                        {{this.question.knowledgeId}}&ndash;&gt;-->
<!--                                    </strong>-->
<!--                                </p>-->
                <p style="width: 20%;float:left;"><strong>正确率</strong>&nbsp;&nbsp;<strong style="color: #bd9154">
                    <!--                    {{this.question.rightRatio}}-->
                    {{rightRatio}}
                </strong></p>
                <p style="width: 20%;float:left;"><strong>难度</strong>&nbsp;&nbsp;<strong style="color: #bd5260">
                    {{this.question.difficulty}}
                </strong>
                </p>
            </div>
        </div>
<!--        <div style="position: relative;">-->
<!--        &lt;!&ndash;        <img style="width: 30px;height: 30px;" src="../asset/star.jpg"/>&ndash;&gt;-->
<!--        <el-button icon="el-icon-star-off" circle style="width:46px;height:46px;position: relative;top:20px;right:20px" @click="starChange"-->
<!--                   :class="{hidden:activeStar}"></el-button>-->
<!--        <el-button icon="el-icon-star-on" circle style="width:46px;height:46px;position: relative;top:20px;right:20px" @click="starChange"-->
<!--                   :class="{hidden:!activeStar}"></el-button>-->
<!--        </div>-->

<!--        <div style="position: relative;">-->
<!--            &lt;!&ndash;        <img style="width: 30px;height: 30px;" src="../asset/star.jpg"/>&ndash;&gt;-->
<!--            <el-button icon="el-icon-star-off" circle style="width:46px;height:46px;position: relative;top:20px;right:20px" @click="starChange"-->
<!--                       :class="{'hidden':activeStar}"></el-button>-->
<!--            <el-button icon="el-icon-star-on" circle style="width:46px;height:46px;position: relative;top:20px;right:20px" @click="starChange"-->
<!--                       :class="{'hidden':!activeStar}"></el-button>-->
<!--        </div>-->
    </div>

</template>
<script>
    export default {
        name: 'QuestionSelectItem',
        data() {
            return {
                activeItem: {},
                activeStar: false
            }
        },
        props: {'question':{}, 'selected':{}, 'itemId':{}, 'knowledgesPoint':{},'page':{},
            'disableStar':{
                required:false,
                default:false
            }
        },
        computed: {
            rightRatio() {
                return Math.floor(Math.random() * 50) + 35 + '%';
            }
        },
        methods: {
            handleMouseEnter() {
                // console.log(event)
                let targetId=(this.page-1)*10+this.itemId+1
                this.$store.commit('putMouseEnterActiveTargetId',targetId)
            },
            starChange() {
                this.activeStar = !this.activeStar
            },
            // getKnowledgeName(knowledgeId){
            //     if(knowledgeId.length===0) return null
            //     let knowledges = JSON.parse(knowledgeId)
            //     let knowledgeNames = knowledges.map(item => {
            //         let found=this.knowledgesPoint.filter(el=>el.categoryId==item[0])
            //         console.log(found.+typeof found)
            //     })
            //     return knowledgeNames
            // }
                // console.log(knowledgeId+typeof knowledgeId)
                //todo
                // let knowledges = eval(knowledgeId)
                // /**
                //  * '[[2,4],[2,5]]'
                //  * [ [], [] ]
                //  */
                // console.log('layer:-1 ====> '+knowledges+ typeof knowledges)
                // let knowledgeNames = knowledges.map(item => {
                //     console.log('layer:0====>'+item+typeof item)
                //     arr=JSON.parse(arr)
                //     console.log('layer:0...1====>'+arr+typeof arr)
                //     // return item.children.filter(elem=>elem.categoryId==item[1])[0]
                //     return this.knowledgesPoint.
                //     filter(elem=>{
                //         elem.categoryId==item[0]
                //         console.log('layer:1====>'+elem)
                //     })[0]
                //     .filter(elem=>{
                //         console.log('layer:2====>'+elem)
                //         elem.categoryId==item[1]
                //     })[1]
                // })
                //
                // return knowledgeNames
            // }
        }
    }
</script>

<style>
    .hidden {
        display: none !important;
    }

    .disable-star{
        display: none !important;
    }
</style>