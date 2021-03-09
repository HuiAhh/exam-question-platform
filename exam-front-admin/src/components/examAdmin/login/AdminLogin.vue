<template>
    <div>
        <h1 style="font-size: 26px;text-align: center;">登录</h1>
        <el-form>
            <ValidatedInput title="用户名"
                            :input-data="form.username"
                            type="text"/>
            <ValidatedInput title="密码"
                            :input-data="form.password"
                            type="password"/>
        </el-form>
        <el-button>登录</el-button>
    </div>
</template>

<script>
    import ValidatedInput from "./ValidatedInput";
    export default {
        name: "AdminLogin",
        components: {ValidatedInput},
        data(){
            return{
                form:{
                    username:'',
                    password:''
                }
            }
        }
    }
</script>

<style scoped>

</style>