<template>
    <el-container style="height: 500px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu :default-openeds="['1', '3']">
                <el-submenu index="1">
                    <template slot="title"><i class="el-icon-message"></i>导航一</template>
                    <el-menu-item-group>
                        <template slot="title">分组一</template>
                        <el-menu-item index="1-1">选项1</el-menu-item>
                        <el-menu-item index="1-2">选项2</el-menu-item>
                    </el-menu-item-group>
                    <el-menu-item-group title="分组2">
                        <el-menu-item index="1-3">选项3</el-menu-item>
                    </el-menu-item-group>
                    <el-submenu index="1-4">
                        <template slot="title">选项4</template>
                        <el-menu-item index="1-4-1">选项4-1</el-menu-item>
                    </el-submenu>
                </el-submenu>
                <el-submenu index="2">
                    <template slot="title"><i class="el-icon-menu"></i>导航二</template>
                    <el-menu-item-group>
                        <template slot="title">分组一</template>
                        <el-menu-item index="2-1">选项1</el-menu-item>
                        <el-menu-item index="2-2">选项2</el-menu-item>
                    </el-menu-item-group>
                    <el-menu-item-group title="分组2">
                        <el-menu-item index="2-3">选项3</el-menu-item>
                    </el-menu-item-group>
                    <el-submenu index="2-4">
                        <template slot="title">选项4</template>
                        <el-menu-item index="2-4-1">选项4-1</el-menu-item>
                    </el-submenu>
                </el-submenu>
                <el-submenu index="3">
                    <template slot="title"><i class="el-icon-setting"></i>导航三</template>
                    <el-menu-item-group>
                        <template slot="title">分组一</template>
                        <el-menu-item index="3-1">选项1</el-menu-item>
                        <el-menu-item index="3-2">选项2</el-menu-item>
                    </el-menu-item-group>
                    <el-menu-item-group title="分组2">
                        <el-menu-item index="3-3">选项3</el-menu-item>
                    </el-menu-item-group>
                    <el-submenu index="3-4">
                        <template slot="title">选项4</template>
                        <el-menu-item index="3-4-1">选项4-1</el-menu-item>
                    </el-submenu>
                </el-submenu>
            </el-menu>
        </el-aside>

        <el-container>
            <table>
                <tr>
                    <td>
                        <div class="block">
                            <span class="demonstration">单一条件筛选：</span>
                            <el-cascader
                                    :options="options"
                                    :props="{ checkStrictly: true }"
                                    clearable>
                            </el-cascader>
                        </div>
                    </td>
                    <td>
                        <div class="block">
                            <span class="demonstration">复合条件筛选：</span>
                            <el-cascader
                                    :options="options"
                                    :props="{ multiple: true, checkStrictly: true }"
                                    clearable>
                            </el-cascader>
                        </div>
                    </td>
                </tr>
            </table>
            <template>
                <el-header style="text-align: right; font-size: 12px">
                    <el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选/取消
                    </el-checkbox>
                    <table style="float:left">
                        <tr>
                            <td class="container-td" colspan="3">
                                <el-radio-button label="组卷" class="container-td-el-radio-button">组卷</el-radio-button>
                                <el-radio-button label="刷题" class="container-td-el-radio-button">刷题</el-radio-button>
                                <el-radio-button label="收藏" class="container-td-el-radio-button">收藏</el-radio-button>
                            </td>
                        </tr>
                    </table>
                    <el-dropdown style="float:right">
                        <i class="el-icon-setting" style="margin-right: 15px"></i>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>收藏</el-dropdown-item>
                            <el-dropdown-item>刷题</el-dropdown-item>
                            <el-dropdown-item>组卷</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </el-header>
                <el-main>
                    <table style="width:100%">
                        <!--一道题目一行-->
                        <tr v-for="it in items" :key="it.value" class="content_tr">
                            <td style="position:relative;">
                                <el-checkbox-group v-model="checkedCities" @change="handleCheckedCitiesChange">
                                    <el-checkbox class="el-main-elcheckbox"></el-checkbox>
                                </el-checkbox-group>
                                <p class="item-content">{{it.id}}. {{it.title}}</p>
                                <p class="item-bottom">知识点：{{it.type}}
                                正确率：{{it.accuracy}}
                                    难度：{{it.level}}</p>
                            </td>
                        </tr>
                    </table>
                </el-main>
            </template>
        </el-container>
    </el-container>
</template>
<script>
    const cityOptions = ['上海', '北京', '广州', '深圳'];
    export default {
        name: 'MiddleSelectResult',
        props: {
            MiddleContent: {}
        },
        data() {
            return {
                checkAll: false,
                checkedCities: ['上海', '北京'],
                cities: cityOptions,
                isIndeterminate: true,
                items: [{
                    id:1,
                    title:"XXXX",
                    type:"反函数",
                    accuracy:"50%",
                    level:"难"
                },
                    {
                        id:2,
                        title:"XXXX",
                        type:"二阶导数",
                        accuracy:"59%",
                        level:"中等"
                    },
                    {
                        id:3,
                        title:"XXXX",
                        type:"微积分",
                        accuracy:"90%",
                        level:"易"
                    }],
                tableData: Array(20).fill(this.item),
                options: [
                    {
                        value: 'zhinan',
                        label: '指南',
                        children: [{
                            value: 'shejiyuanze',
                            label: '设计原则',
                            children: [{
                                value: 'yizhi',
                                label: '一致'
                            }, {
                                value: 'fankui',
                                label: '反馈'
                            }, {
                                value: 'xiaolv',
                                label: '效率'
                            }, {
                                value: 'kekong',
                                label: '可控'
                            }]
                        }, {
                            value: 'daohang',
                            label: '导航',
                            children: [{
                                value: 'cexiangdaohang',
                                label: '侧向导航'
                            }, {
                                value: 'dingbudaohang',
                                label: '顶部导航'
                            }]
                        }]
                    }, {
                        value: 'zujian',
                        label: '组件',
                        children: [{
                            value: 'basic',
                            label: 'Basic',
                            children: [{
                                value: 'layout',
                                label: 'Layout 布局'
                            }, {
                                value: 'color',
                                label: 'Color 色彩'
                            }, {
                                value: 'typography',
                                label: 'Typography 字体'
                            }, {
                                value: 'icon',
                                label: 'Icon 图标'
                            }, {
                                value: 'button',
                                label: 'Button 按钮'
                            }]
                        }, {
                            value: 'form',
                            label: 'Form',
                            children: [{
                                value: 'radio',
                                label: 'Radio 单选框'
                            }, {
                                value: 'checkbox',
                                label: 'Checkbox 多选框'
                            }, {
                                value: 'input',
                                label: 'Input 输入框'
                            }, {
                                value: 'input-number',
                                label: 'InputNumber 计数器'
                            }, {
                                value: 'select',
                                label: 'Select 选择器'
                            }, {
                                value: 'cascader',
                                label: 'Cascader 级联选择器'
                            }, {
                                value: 'switch',
                                label: 'Switch 开关'
                            }, {
                                value: 'slider',
                                label: 'Slider 滑块'
                            }, {
                                value: 'time-picker',
                                label: 'TimePicker 时间选择器'
                            }, {
                                value: 'date-picker',
                                label: 'DatePicker 日期选择器'
                            }, {
                                value: 'datetime-picker',
                                label: 'DateTimePicker 日期时间选择器'
                            }, {
                                value: 'upload',
                                label: 'Upload 上传'
                            }, {
                                value: 'rate',
                                label: 'Rate 评分'
                            }, {
                                value: 'form',
                                label: 'Form 表单'
                            }]
                        }, {
                            value: 'data',
                            label: 'Data',
                            children: [{
                                value: 'table',
                                label: 'Table 表格'
                            }, {
                                value: 'tag',
                                label: 'Tag 标签'
                            }, {
                                value: 'progress',
                                label: 'Progress 进度条'
                            }, {
                                value: 'tree',
                                label: 'Tree 树形控件'
                            }, {
                                value: 'pagination',
                                label: 'Pagination 分页'
                            }, {
                                value: 'badge',
                                label: 'Badge 标记'
                            }]
                        }, {
                            value: 'notice',
                            label: 'Notice',
                            children: [{
                                value: 'alert',
                                label: 'Alert 警告'
                            }, {
                                value: 'loading',
                                label: 'Loading 加载'
                            }, {
                                value: 'message',
                                label: 'Message 消息提示'
                            }, {
                                value: 'message-box',
                                label: 'MessageBox 弹框'
                            }, {
                                value: 'notification',
                                label: 'Notification 通知'
                            }]
                        }, {
                            value: 'navigation',
                            label: 'Navigation',
                            children: [{
                                value: 'menu',
                                label: 'NavMenu 导航菜单'
                            }, {
                                value: 'tabs',
                                label: 'Tabs 标签页'
                            }, {
                                value: 'breadcrumb',
                                label: 'Breadcrumb 面包屑'
                            }, {
                                value: 'dropdown',
                                label: 'Dropdown 下拉菜单'
                            }, {
                                value: 'steps',
                                label: 'Steps 步骤条'
                            }]
                        }, {
                            value: 'others',
                            label: 'Others',
                            children: [{
                                value: 'dialog',
                                label: 'Dialog 对话框'
                            }, {
                                value: 'tooltip',
                                label: 'Tooltip 文字提示'
                            }, {
                                value: 'popover',
                                label: 'Popover 弹出框'
                            }, {
                                value: 'card',
                                label: 'Card 卡片'
                            }, {
                                value: 'carousel',
                                label: 'Carousel 走马灯'
                            }, {
                                value: 'collapse',
                                label: 'Collapse 折叠面板'
                            }]
                        }]
                    }, {
                        value: 'ziyuan',
                        label: '资源',
                        children: [{
                            value: 'axure',
                            label: 'Axure Components'
                        }, {
                            value: 'sketch',
                            label: 'Sketch Templates'
                        }, {
                            value: 'jiaohu',
                            label: '组件交互文档'
                        }]
                    }]
            };
        },
        methods: {
                handleCheckAllChange(val) {
                    this.checkedCities = val ? cityOptions : [];
                    this.isIndeterminate = false;
                },
                handleCheckedCitiesChange(value) {
                    let checkedCount = value.length;
                    this.checkAll = checkedCount === this.cities.length;
                    this.isIndeterminate = checkedCount > 0 && checkedCount < this.cities.length;
                }
            }
    }
</script>
<style>
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }
    .container-td{
        float:right;
        width:300px;
    }
    .container-td-el-radio-button{
        float:right;
        border-radius:5px;
        border: 1px;
        margin-left: 20px;
    }
    .content_tr{
        width:1000px;
        height:150px;
        border: 3px #303133;
        background-color: #f0f0f0;
        margin-bottom: 10px;
    }
    .el-main-elcheckbox{
        float: left;
        position:relative;
        top:-40px;
        left:10px;
    }
    .item-content{
        float:left;
        position:relative;
        top:-55px;
        left:20px;
    }
    .item-bottom{
        float:right;
        position: relative;
        bottom:-50px;
        right:20px;
    }
</style>