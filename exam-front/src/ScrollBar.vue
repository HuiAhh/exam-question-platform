<template>
    <div id="scroll-container">
        <div style="background: #b99d75;width:60px;height:555px;padding-top:40px;" v-for="(group,index) in ids" :key="index">
            <div :class="{'hidden':!flag[index]}">
                <span v-for="(id,index) in group" :key="index" class="scrollSpan">
                    <span class="scrollSpanText" @click="active=index+1">{{id}}</span>
                </span>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Scroll",
        data() {
            return {
                flag: [true, false],
                active:1,
                ids: [
                    [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
                    [11, 12, 13, 14, 15]
                ]
            }
        },
        computed:{
            getTargetId(){
                return this.$store.state.mouseEnterActiveTargetId
            }
        },
        methods:{
            light(active){
                let xpath='//*[@id="scroll-container"]/div['+1+']/div/span['+active+']'
                let target=document.evaluate(xpath, document).iterateNext();
                target.setAttribute("class", "scrollSpanActive")
            },
            unlight(unactive){
                let xpath='//*[@id="scroll-container"]/div['+1+']/div/span['+unactive+']'
                let target=document.evaluate(xpath, document).iterateNext();
                target.setAttribute("class", "scrollSpan")
            }
        },
        watch:{
            active(newVal,oldVal){
                this.light(newVal)
                this.unlight(oldVal)
            },
            getTargetId(newVal,oldVal){
                this.light(newVal)
                this.unlight(oldVal)
            }
        },
        mounted(){
            this.light(this.active)
        }
    }
</script>

<style>
    .scrollSpan {
         border-radius: 50%;
         height: 50px;
         width: 50px;
         display: block;
         background: #ffffff;
         vertical-align: top;
         margin: 5px;
    }

    .scrollSpanActive {
        border-radius: 50%;
        height: 50px;
        width: 50px;
        display: block;
        background: #fffc8d;
        vertical-align: top;
        margin: 5px;
    }

    .scrollSpanText {
        display: block;
        color: #303133;
        height: 50px;
        line-height: 50px;
        text-align: center;
        font-size: 20px;
    }

    .hidden{
        display: none;
    }

</style>
