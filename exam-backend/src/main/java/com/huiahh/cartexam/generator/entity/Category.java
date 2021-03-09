package com.huiahh.cartexam.generator.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 类目表
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("exam_category")
@ApiModel(value="Category对象", description="多级标签表")
public class Category extends Model<Category> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "标签关键字，以JSON数组格式")
    private String keywords;

    @ApiModelProperty(value = "父类目ID, level=1时指向专业majorid")
    private Integer pid;

    @ApiModelProperty(value = "类目图标")
    private String iconUrl;

    @ApiModelProperty(value = "类目图片")
    private String picUrl;

    /**
     * @date 2020-10-25 22:42:11
     * @Author HuiAhh
     * 改字段默认值、类型
     */
    @ApiModelProperty(value = "分类层级，默认为0。0未指定、1学科、2章节、3知识点")
    private Integer level;

    /**
     * @date 2020-10-25 22:42:11
     * @Author HuiAhh
     * 删字段
     */

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date addTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;


    @Override
    protected Serializable pkVal() {
        return this.categoryId;
    }

}
