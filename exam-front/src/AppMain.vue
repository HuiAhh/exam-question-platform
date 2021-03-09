<template>
    <el-container>
        <el-header class="hd" height="auto" style="margin: 0">
            <div class="hd-search">
                <img style="float: left;" class="lg" src="../asset/logo.jpg" alt="logo"/>
                <div class="hd-r" style="float: right;width: 80%;margin: 2%">
                    <div class="search-bar flex-space-around" style="text-align: right;margin-left: 100px;">
                        <el-input type="text" v-model="searchText" style="width: 60%;height:20px;">
                            <el-select v-model="searchSelect" slot="prepend" placeholder="全部" style="width:80px;">
                                <el-option label="全部" value="0"></el-option>
                                <el-option label="题目" value="1"></el-option>
                                <el-option label="知识点" value="2"></el-option>
                                <el-option label="用户" value="3"></el-option>
                            </el-select>
                            <el-button slot="append" icon="el-icon-search"></el-button>
                        </el-input>
                        <LoginLink ref="loginLink" :login-dialog="login" :register-dialog="register"
                                   :info-dialog="info"/>
                    </div>
                    <div class="hot-topic">
                        <div class="recommand-word"
                             style="margin-top:20px;display: flex;flex-direction: row;flex-wrap: wrap">
                            <strong>推荐</strong>
                            <div class="flex-space-around" style="margin-left:50px;width: 80%">
                                <el-link style="display: inline-block" v-for="(word,index) in recommandWords"
                                         :key="index">{{word}}
                                </el-link>
                            </div>
                        </div>
                        <div class="newest-word" style="margin-top:10px;display: flex;flex-direction: row;">
                            <strong>最新</strong>
                            <div class="flex-space-around" style="margin-left:50px;width: 80%">
                                <el-link style="display: inline-block" v-for="(word,index) in recommandWords"
                                         :key="index">{{word}}
                                </el-link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </el-header>
        <el-tabs v-model="activeName" tab-position="top" stretch>
            <el-tab-pane label="推荐" name="1">
                <MainPage/>
            </el-tab-pane>
            <el-tab-pane label="题库" name="2">
                <MainPage/>
            </el-tab-pane>
            <el-tab-pane label="分类" name="3">
                <AsideTreeMenu/>
            </el-tab-pane>
            <el-tab-pane label="组卷" name="4"></el-tab-pane>
            <el-tab-pane label="刷题" name="5"></el-tab-pane>
            <el-tab-pane label="模拟" name="6"></el-tab-pane>
        </el-tabs>
        <el-footer class="ft" style="clear:both;" height="auto">
            <FooterLink/>
            <div class="copyright" style="text-align: center;clear:both;font-size:12px;">
                <p style="margin:0;padding:-2%">Copyright © 2020, WENG with League of Quick-learner Group.</p>
            </div>
        </el-footer>
        <el-dialog
            title="登录"
            :visible.sync="dialogVisibleLogin"
            width="50%"
            :before-close="cancelLogin"
            >
            <el-form>
                <el-form-item label="用户名">
                    <el-input v-model="loginUser.username" placeholder="用户名"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input v-model="loginUser.password" placeholder="密码" type="password"></el-input>
                </el-form-item>
            </el-form>
            <div>
                <el-button type="primary" @click="submitLogin">登录</el-button>
            </div>
        </el-dialog>
                        <el-dialog
                                title="提示"
                                :visible.sync="dialogVisibleRegister"
                                width="60%"
                                :before-close="cancelRegister"
                                >
                        <el-form>
                            <el-form-item label="用户名">
                                <el-input v-model="registerUser.username" placeholder="用户名"></el-input>
                            </el-form-item>
                            <el-form-item label="新密码">
                                <el-input v-model="registerUser.password" placeholder="新密码" type="password"></el-input>
                            </el-form-item>
                            <el-form-item label="确认密码">
                                <el-input v-model="registerUser.rePassword" placeholder="确认密码" type="password"></el-input>
                            </el-form-item>
                        </el-form>
                    <div>
                        <el-button @click="cancelRegister">取 消</el-button>
                        <el-button type="primary" @click="submitRegister">确 定</el-button>
                    </div>
                </el-dialog>
    </el-container>
</template>

<script>

    import LoginLink from "@/LoginLink";
    import MainPage from "@/MainPage";
    import AsideTreeMenu from "@/AsideTreeMenu";
    import FooterLink from "@/FooterLink";

    export default {
        name: 'AppMain',
        components: {
            AsideTreeMenu,
            MainPage,
            LoginLink,
            FooterLink
        },
        data() {
            return {
                loginUser:{username:'',password:''},
                registerUser:{username:'',password:'',rePassword:''},
                emptyLoginUser:{username:'',password:''},
                emptyRegisterUser:{username:'',password:'',rePassword:''},
                dialogVisibleLogin: false,
                dialogVisibleRegister: false,

                searchSelect: '0',
                searchText: '',
                activeName: '1',
                recommandWords: [
                    '泊松分布',
                    '二阶导数',
                    '激励理论',
                    '不定积分',
                    '二重积分'
                ],
                newestWords: [
                    '泊松分布',
                    '二阶导数',
                    '激励理论',
                    '不定积分',
                    '二重积分'
                ],
            }
        },
        methods: {
            login() {
                this.dialogVisibleLogin=true
            },
            register() {
                this.dialogVisibleRegister=true
            },
            info() {
                this.dialogVisibleLogin=true
            },
            cancelRegister(){
                this.dialogVisibleRegister = false;
                this.registerUser={...this.emptyRegisterUser}
            },
            cancelLogin(){
                this.dialogVisibleLogin = false;
                this.loginUser={...this.emptyLoginUser}
            },
            submitLogin(){
                this.cancelLogin();
            },
            submitRegister(){
                //todo
                this.cancelRegister();
            }
        }
    }
</script>

<!--<style>-->
<!--    @import '../css/index.css';-->
<!--    @import '../css/list.css';-->
<!--    @import '../css/subject_menu.css';-->
<!--</style>-->

<style>
    @import '../css/index.css';
    @import '../css/list.css';
    @import '../css/subject_menu.css';
</style>