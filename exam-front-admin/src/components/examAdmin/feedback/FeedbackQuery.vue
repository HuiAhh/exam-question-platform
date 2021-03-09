<template>
    <div>
        <el-breadcrumb class="page-hd-breadcrumb" separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/exam-admin' }">欢迎页</el-breadcrumb-item>
            <el-breadcrumb-item>用户反馈</el-breadcrumb-item>
            <el-breadcrumb-item>全部条目</el-breadcrumb-item>
        </el-breadcrumb>
        <h1 class="page-title">用户反馈</h1>
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
                    <el-button v-if="scope.row.feedType==='1'" @click="replyDialog(scope.row)">回复</el-button>
                    <el-button>已阅</el-button>
                </template>
            </el-table-column>
            <el-table-column>
                <template slot-scope="scope">
                    <el-tag>
                        {{feedTypeDisplay[scope.row.feedType]}}
                    </el-tag>
                </template>
            </el-table-column>
            <el-table-column label="时间" prop="addTime"></el-table-column>
            <el-table-column label="用户名" prop="username"></el-table-column>
            <el-table-column label="手机号" prop="mobile"></el-table-column>
            <el-table-column label="受理状态">
                <template slot-scope="scope">
                    <el-tag>
                        {{statusDisplay[scope.row.status]}}
                    </el-tag>
                </template>
            </el-table-column>
        </el-table>
        <el-dialog title="回复问题" :visible.sync="replyVisible">
            <el-form>
                <el-form-item label="问题主体">
                    <span>{{replyingFeedback.content}}</span>
                </el-form-item>
                <el-form-item label="回复内容">
                    <el-input v-model="replyingIssue.answer"></el-input>
                </el-form-item>
                <el-button @click="replyVisible=false">回复</el-button>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "FeedbackQuery",
        data() {
            return {
                // feedType:0 普通反馈;   1 错题反馈
                feedTypeDisplay:{
                    0:'普通反馈',
                    1:'答案问题',
                    2:'系统反馈'
                },
                statusDisplay:{
                    0:'未受理',
                    1:'已受理'
                },
                replyVisible: false,
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
                        "feedType": "string",
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
                        "feedType": "string",
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
                replyingFeedback: {},
                replyingIssue:
                {
                    "addTime": "2020-10-25T10:56:39.550Z",
                    "answer": "string",
                    "deleted": true,
                    "issueId": 0,
                    "question": "string",
                    "updateTime": "2020-10-25T10:56:39.550Z"
                }
            }
        },
        methods: {
            replyDialog(item) {
                this.replyVisible = true
                this.replyingFeedback = item
            }
        }
    }
</script>

<style scoped>

</style>