import Vue from 'vue'
import Vuex from 'vuex'
// import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
    state:{
        adminStatus:{

        },
        queryResult:{

        },
        queryRefresh:0,
        knowledgePoints:[],
        courses:[],
        exerciseQuestions:[],
        exercisingPaper:{},
        exercisingPaperName:'',
        mouseEnterActiveTargetId:1

    },
    mutations:{
        putQueryResult(state,data){
            state.queryResult=data
            state.queryRefresh=state.queryRefresh+1
        },
        putKnowledgePoints(state,data){
            state.knowledgePoints=data
        },
        putCourses(state,data){
            state.courses=data
        },
        putExerciseQuestions(state,data){
            state.exerciseQuestions=data
        },
        putExercisingPaper(state,data){
            state.exercisingPaper=data
        },
        putExercisingPaperName(state,data){
            state.exercisingPaperName=data
        },
        putMouseEnterActiveTargetId(state,data){
            state.mouseEnterActiveTargetId=data
        }
    }
})