<template>
    <div>
        <el-breadcrumb class="page-hd-breadcrumb" separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/exam-admin' }">欢迎页</el-breadcrumb-item>
            <el-breadcrumb-item>字段管理</el-breadcrumb-item>
            <el-breadcrumb-item>题目分类</el-breadcrumb-item>
        </el-breadcrumb>
        <h1 class="page-title">题目分类</h1>

        <!--预览：树形菜单-->
        <span>菜单可拖拽，一级学科，二级章节，三级知识点</span>
        <el-tree
                :data="categories"
                node-key="name"
                default-expand-all
                :expand-on-click-node="false"
                :props="{label:'name'}"
                draggable>
          <span slot-scope="{ node, data }">
            <span>{{ data.name }}</span>
            <span style="position: absolute;right:0">
              <el-button
                      type="text"
                      size="mini"
                      @click="() => append(data)">
                <i class="el-icon-plus"></i>添加
              </el-button>
                <el-button
                    type="text"
                    size="mini"
                    @click="() => edit(data)">
                    <i class="el-icon-edit"></i>修改
                </el-button>
              <el-button
                      type="text"
                      size="mini"
                      @click="() => remove(node, data)">
                <i class="el-icon-close"></i>删除
              </el-button>
            </span>
          </span>
        </el-tree>
        <!---->
        <!--扩展平台：编辑-->
        <!--保存按钮-->
        <el-row>
            <el-button>保存</el-button>
            <el-button @click="undoEdit">取消修改</el-button>
        </el-row>
        <!---->
        <!---->
        <el-dialog title="修改字段" :visible.sync="visibleEdit">
            <el-form>
                <el-form-item label="字段名称">
                    <el-input v-model="editingCategory.name"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="visibleEdit=false">取消</el-button>
                <el-button type="primary" @click="commitData">确定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "FieldCategory",
        data() {
            return {
                backupCategories: [
                {
                    "addTime": "2020-10-24T16:31:50.803Z",
                    "categoryId": 0,
                    "deleted": true,
                    "iconUrl": "string",
                    "keywords": "string",
                    "level": "1",
                    "name": "string11",
                    "picUrl": "string",
                    "pid": 0,
                    "sortOrder": 0,
                    "updateTime": "2020-10-24T16:31:50.803Z",
                    children: [
                        {
                            "addTime": "2020-10-24T16:31:50.803Z",
                            "categoryId": 0,
                            "deleted": true,
                            "iconUrl": "string",
                            "keywords": "string",
                            "level": "2",
                            "name": "string21",
                            "picUrl": "string",
                            "pid": 0,
                            "sortOrder": 0,
                            "updateTime": "2020-10-24T16:31:50.803Z",
                            children: [
                                {
                                    "addTime": "2020-10-24T16:31:50.803Z",
                                    "categoryId": 0,
                                    "deleted": true,
                                    "iconUrl": "string",
                                    "keywords": "string",
                                    "level": "string",
                                    "name": "3",
                                    "picUrl": "string",
                                    "pid": 0,
                                    "sortOrder": 0,
                                    "updateTime": "2020-10-24T16:31:50.803Z"
                                }
                            ]
                        },
                        {
                            "addTime": "2020-10-24T16:31:50.803Z",
                            "categoryId": 0,
                            "deleted": true,
                            "iconUrl": "string",
                            "keywords": "string",
                            "level": "string",
                            "name": "2",
                            "picUrl": "string",
                            "pid": 0,
                            "sortOrder": 0,
                            "updateTime": "2020-10-24T16:31:50.803Z",
                            children: [
                                {
                                    "addTime": "2020-10-24T16:31:50.803Z",
                                    "categoryId": 0,
                                    "deleted": true,
                                    "iconUrl": "string",
                                    "keywords": "string",
                                    "level": "3",
                                    "name": "string31",
                                    "picUrl": "string",
                                    "pid": 0,
                                    "sortOrder": 0,
                                    "updateTime": "2020-10-24T16:31:50.803Z"
                                }
                            ]
                        }
                    ]
                }
            ],
                categories: [
                    {
                        "addTime": "2020-10-24T16:31:50.803Z",
                        "categoryId": 0,
                        "deleted": true,
                        "iconUrl": "string",
                        "keywords": "string",
                        "level": "1",
                        "name": "string11",
                        "picUrl": "string",
                        "pid": 0,
                        "sortOrder": 0,
                        "updateTime": "2020-10-24T16:31:50.803Z",
                        children: [
                            {
                                "addTime": "2020-10-24T16:31:50.803Z",
                                "categoryId": 0,
                                "deleted": true,
                                "iconUrl": "string",
                                "keywords": "string",
                                "level": "2",
                                "name": "string21",
                                "picUrl": "string",
                                "pid": 0,
                                "sortOrder": 0,
                                "updateTime": "2020-10-24T16:31:50.803Z",
                                children: [
                                    {
                                        "addTime": "2020-10-24T16:31:50.803Z",
                                        "categoryId": 0,
                                        "deleted": true,
                                        "iconUrl": "string",
                                        "keywords": "string",
                                        "level": "string",
                                        "name": "3",
                                        "picUrl": "string",
                                        "pid": 0,
                                        "sortOrder": 0,
                                        "updateTime": "2020-10-24T16:31:50.803Z"
                                    }
                                ]
                            },
                            {
                                "addTime": "2020-10-24T16:31:50.803Z",
                                "categoryId": 0,
                                "deleted": true,
                                "iconUrl": "string",
                                "keywords": "string",
                                "level": "string",
                                "name": "2",
                                "picUrl": "string",
                                "pid": 0,
                                "sortOrder": 0,
                                "updateTime": "2020-10-24T16:31:50.803Z",
                                children: [
                                    {
                                        "addTime": "2020-10-24T16:31:50.803Z",
                                        "categoryId": 0,
                                        "deleted": true,
                                        "iconUrl": "string",
                                        "keywords": "string",
                                        "level": "3",
                                        "name": "string31",
                                        "picUrl": "string",
                                        "pid": 0,
                                        "sortOrder": 0,
                                        "updateTime": "2020-10-24T16:31:50.803Z"
                                    }
                                ]
                            }
                        ]
                    }
                ],
                editingCategory:{},
                currentEditingData:{},
                visibleEdit:false,
            }
        },
        methods: {
            append(data) {
                this.$message('按“修改”按钮修改空字段');
                const newChild = {name: '?', children: []};
                if (!data.children) {
                    this.$set(data, 'children', []);
                }
                data.children.push(newChild);
            },
            edit(data) {
                this.editingCategory={...data}
                this.currentEditingData=data
                this.visibleEdit=true
            },
            remove(node, data) {
                const parent = node.parent;
                const children = parent.data.children || parent.data;
                const index = children.findIndex(d => d.id === data.id);
                children.splice(index, 1);
            },
            commitData(){
                this.currentEditingData={...this.editingCategory}
                this.visibleEdit=false
            },
            undoEdit(){
                this.categories=[...this.backupCategories]
            }
        }
    }
</script>

<style scoped>

</style>