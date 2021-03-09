<template>
    <div>
        <span>答案填写：</span>
        <el-radio-group v-if="type==2" v-model="answer">
            <el-radio-button label="A">A</el-radio-button>
            <el-radio-button label="B">B</el-radio-button>
            <el-radio-button label="C">C</el-radio-button>
            <el-radio-button label="D">D</el-radio-button>
        </el-radio-group>
        <el-input v-if="type==1" v-model="answer" placeholder="填空"></el-input>
        <el-input v-if="type==0" v-model="answer" placeholder="大题"></el-input>
    </div>
</template>

<script>
    export default {
        name: "AnswerItem",
        props:['answer','type']
    }
</script>

<style scoped>

</style>