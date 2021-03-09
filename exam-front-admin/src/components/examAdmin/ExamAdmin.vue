<template>
    <el-container>
        <el-header>
            <HeaderMenu/>
        </el-header>
        <router-view id="main-router-view"></router-view>
        <el-footer>
        </el-footer>
    </el-container>
</template>

<script>
    import HeaderMenu from "./HeaderMenu";

    export default {
        name: "ExamAdmin",
        components: {HeaderMenu},
        data() {
            return{
            }
        },
        methods: {

        },
        updated() {

        }
    }
</script>

<style>

    #main-router-view{
        margin-top: 10px;
    }

    @media screen and (max-width: 750px) {
        #main-router-view {
            margin-top: 80px;
        }
    }
</style>