<template>
    <div class="btn-login flex-space-around"
         style="flex-direction: row;width: 200px;">
        <!--                            <a>登录</a>-->
        <!--                            <a>注册</a>-->
        <!--                            <a>个人中心</a>-->
        <el-link :underline="false" style="font-size:20px;" @click="loginDialog">登录</el-link>
        <el-link :underline="false" style="font-size:20px;" @click="registerDialog">注册</el-link>
        <el-link :underline="false" style="font-size:20px;" @click="infoDialog">个人中心</el-link>
    </div>
</template>
<script>
    export default {
        name: 'LoginLink',
        props:['loginDialog','registerDialog','infoDialog']
    }
</script>
