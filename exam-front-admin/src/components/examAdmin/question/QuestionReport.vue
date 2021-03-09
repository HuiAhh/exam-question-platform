<template>
    <div>
    <el-breadcrumb class="page-hd-breadcrumb" separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/exam-admin' }">欢迎页</el-breadcrumb-item>
        <el-breadcrumb-item>题目管理</el-breadcrumb-item>
        <el-breadcrumb-item>反馈错题集合</el-breadcrumb-item>
    </el-breadcrumb>
    <h1 class="page-title">反馈错题集合</h1>
    <!--todo 添加一个表格-->
    <el-table></el-table>
    </div>
</template>

<script>
    export default {
        name: "QuestionReport"
    }
</script>

<style scoped>

</style>