<template>
    <!--    <div class="hd-nav flex-space-around"-->
    <!--         style="margin-top:2%;margin-bottom:2%;clear: both;flex-direction: row;">-->
    <!--        <el-link :underline="false" style="color:black;">主页</el-link>-->
    <!--        <el-link :underline="false">推荐</el-link>-->
    <!--        <el-link :underline="false">题库</el-link>-->
    <!--        <el-link :underline="false">分类</el-link>-->
    <!--        <el-link :underline="false">组卷</el-link>-->
    <!--        <el-link :underline="false">刷题</el-link>-->
    <!--        <el-link :underline="false">模拟</el-link>-->
    <!--    </div>-->

    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
        <el-link :underline="false" style="color:black;">主页</el-link>
        <el-link :underline="false">推荐</el-link>
        <el-link :underline="false">题库</el-link>
        <el-link :underline="false">分类</el-link>
        <el-link :underline="false">组卷</el-link>
        <el-link :underline="false">刷题</el-link>
        <el-link :underline="false">模拟</el-link>
    </el-menu>

</template>
<script>
    export default {
        name: 'NaviBar',
        data() {
            return {
                activeIndex: '1'
            }
        }
    }
</script>
