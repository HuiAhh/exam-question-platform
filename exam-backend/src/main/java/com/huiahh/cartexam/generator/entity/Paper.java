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
 * 组卷表
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("exam_paper")
@ApiModel(value="Paper对象", description="组卷表")
public class Paper extends Model<Paper> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "paper_id", type = IdType.AUTO)
    private Integer paperId;

    @ApiModelProperty(value = "用户表的用户ID")
    private Integer userId;

    @ApiModelProperty(value = "试卷得分, 借来判断是否做过此卷子")
    private Integer score;

    private LocalDateTime beginTime;

    private LocalDateTime endTime;

    private LocalDateTime allowTime;
    /**
     * @date 2020-10-25 23:04:55
     * @Author HuiAhh
     * 加字段+注释
     */
    @ApiModelProperty(value = "课程Id，对应category表中一级类目")
    private Integer courseId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime addTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;


    @Override
    protected Serializable pkVal() {
        return this.paperId;
    }

}
