package com.huiahh.cartexam.generator.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.huiahh.cartexam.generator.entity.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SubjectsDto对象", description = "封装所有学科,对应的章节和章节对应的知识点也封装进去")
public class SubjectsDto {

    //传入对象category的level约定为2
    public SubjectsDto(Category category) {
        chapters = new ArrayList<>();
        categoryId = category.getCategoryId();
        name = category.getName();
        keywords = category.getKeywords();
        pid = category.getPid();
        iconUrl = category.getIconUrl();
        picUrl = category.getPicUrl();
        level = category.getLevel();
        addTime = category.getAddTime();
        updateTime = category.getUpdateTime();
        deleted = category.getDeleted();
    }

    @ApiModelProperty(value = "章节对应的知识点用List封装")
    private List<CategoryDto> chapters;

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

    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;

}
