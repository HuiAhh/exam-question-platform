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
 * 用户浏览足迹表
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("exam_footprint")
@ApiModel(value="Footprint对象", description="用户浏览足迹表")
public class Footprint extends Model<Footprint> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "footprint_id", type = IdType.AUTO)
    private Integer footprintId;

    @ApiModelProperty(value = "用户表的用户ID")
    private Integer userId;

    @ApiModelProperty(value = "题目ID")
    private Integer questionId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime addTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;


    @Override
    protected Serializable pkVal() {
        return this.footprintId;
    }

}
