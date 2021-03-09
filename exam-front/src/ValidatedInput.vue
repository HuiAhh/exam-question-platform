<template>
    <div class="search-box" style="display: flex;align-items: center;width: 60%;">
        <!--                            <input id="search" type="text" style="width: 80%;height:30px;"/>-->
<!--        <el-input type="text" style="width: 80%;height:30px;"></el-input>-->
        <!--                            <img src="../asset/search_button.jpg" id="search_button"-->
        <!--                                 style="width: auto;height: 30px;margin-left: 2%"/>-->
        <form>
            <div class="hp-row">
                <input type="text" required="required">
                <span class="bar"></span>
                <label>身份证号</label>
            </div>
            <button type="submit" class="btn btn-submit">submit</button>
        </form>
    </div>
</template>
<script>
    export default {
        name: 'ValidatedInput'
    }
</script>

<style scoped>
    .hp-row {
    margin: 45px;
    position: relative;
    }
    .hp-row input {
    border: none;
    border-bottom: 1px solid #c6c6c6;
    background: none;
    outline: none;
    padding: 10px 10px 10px 5px;
    width: 320px;
    display: block;
    box-sizing: border-box;
    font-size: 16px;
    color: #c6c6c6;
    }

    .hp-row label {
    position: absolute;
    top: 10px;
    left: 5px;
    font-size: 16px;
    transition: all .3s ease;
    -webkit-transition: .3s ease all;
    color: #c6c6c6;
    pointer-events: none;
    }
    .hp-row input:focus ~ label,
    .hp-row input:valid ~ label {
    top: -14px ;
    font-size: 12px;
    color: #2196F3;
    }
    .hp-row .bar{
    display: block;
    position: relative;

    }
    .hp-row .bar:before {
    position: absolute;
    bottom: 0px;
    content: '';
    width: 0px;
    height: 2px;
    transition: all .3s ease;
    -webkit-transition: .3s ease all;
    }

    .hp-row input:focus ~ .bar:before,
    .hp-row input:valid ~ .bar:before {
    width: 320px;
    background:#2196F3;
    }


</style>
