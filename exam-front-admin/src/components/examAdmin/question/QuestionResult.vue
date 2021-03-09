<template>
    <div>
        <el-breadcrumb class="page-hd-breadcrumb" separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/exam-admin' }">欢迎页</el-breadcrumb-item>
            <el-breadcrumb-item>题目管理</el-breadcrumb-item>
            <el-breadcrumb-item>题目查询</el-breadcrumb-item>
        </el-breadcrumb>
        <h1 class="page-title">查询结果</h1>
    </div>
</template>

<script>
    export default {
        name: "QuestionResult"
    }
</script>

<style scoped>

</style>