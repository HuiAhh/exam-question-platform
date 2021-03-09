<template>
    <div style="width:40%;display: flex;flex-direction: row;align-content: center;justify-content: space-around">
        <label style="user-select: none;">全选/取消</label>
        <button class="btn" style="background-color: #169bd5;color: #fff;" @click="createPaper">组卷</button>
        <button class="btn" style="background-color: #fff;" @click="immediateExercise">刷题</button>
        <button class="btn" style="background-color: #fff;" @click="starSelected">收藏</button>
    </div>
</template>
<script>
    export default {
        name: 'ListHeader',
        props:['createPaper','immediateExercise','starSelected']
    }
</script>
