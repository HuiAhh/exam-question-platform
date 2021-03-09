package com.huiahh.cartexam.generator.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 专业表
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("exam_school")
@ApiModel(value="School对象", description="专业表")
public class School extends Model<School> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "school_id", type = IdType.AUTO)
    private Integer schoolId;

    @ApiModelProperty(value = "学院名")
    private String schoolName;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime addTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;


    @Override
    protected Serializable pkVal() {
        return this.schoolId;
    }

}
