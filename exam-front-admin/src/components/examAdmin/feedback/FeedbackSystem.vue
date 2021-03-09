<template>
    <div>
        <el-breadcrumb class="page-hd-breadcrumb" separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/exam-admin' }">欢迎页</el-breadcrumb-item>
            <el-breadcrumb-item>用户反馈</el-breadcrumb-item>
            <el-breadcrumb-item>系统反馈</el-breadcrumb-item>
        </el-breadcrumb>
        <h1 class="page-title">系统反馈</h1>
        <el-table :data="queriedFeedbacks">
            <el-table-column type="expand">
                <template slot-scope="scope">
                    <span>详细信息</span>
                    <el-form>
                        <el-form-item label="反馈类型">
                            <span>{{scope.row.feedType}}</span>
                        </el-form-item>
                        <el-form-item label="详细内容">
                            <span>{{scope.row.content}}</span>
                        </el-form-item>
                    </el-form>
                    <el-button>已阅</el-button>
                </template>
            </el-table-column>
            <el-table-column label="时间" prop="addTime"></el-table-column>
            <el-table-column label="用户名" prop="username"></el-table-column>
            <el-table-column label="受理状态">
                <template slot-scope="scope">
                    <el-tag>
                        {{statusDisplay[scope.row.status]}}
                    </el-tag>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    export default {
        name: "FeedbackSystem",
        data() {
            return {
                queriedFeedbacks: [
                    {
                        "addTime": "2020-10-25T10:57:24.048Z",
                        "content": "string",
                        "deleted": false,
                        "feedType": "1",
                        "feedbackId": 0,
                        "hasPicture": true,
                        "mobile": "string",
                        "picUrls": "string",
                        "status": 0,
                        "updateTime": "2020-10-25T10:57:24.049Z",
                        "userId": 0,
                        "username": "string"
                    },
                    {
                        "addTime": "2020-10-25T10:57:24.048Z",
                        "content": "string",
                        "deleted": false,
                        "feedType": "1",
                        "feedbackId": 1,
                        "hasPicture": false,
                        "mobile": "string",
                        "picUrls": "string",
                        "status": 0,
                        "updateTime": "2020-10-25T10:57:24.049Z",
                        "userId": 0,
                        "username": "string"
                    },
                    {
                        "addTime": "2020-10-25T10:57:24.048Z",
                        "content": "string",
                        "deleted": false,
                        "feedType": "1",
                        "feedbackId": 2,
                        "hasPicture": false,
                        "mobile": "string",
                        "picUrls": "string",
                        "status": 0,
                        "updateTime": "2020-10-25T10:57:24.049Z",
                        "userId": 0,
                        "username": "string"
                    }
                ],
                statusDisplay: {
                    0: '未受理',
                    1: '已受理'
                },

            }
        },
        methods: {}
    }
</script>

<style scoped>

</style>