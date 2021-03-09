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
 * 意见反馈表
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("exam_feedback")
@ApiModel(value="Feedback对象", description="意见反馈表")
public class Feedback extends Model<Feedback> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "feedback_id", type = IdType.AUTO)
    private Integer feedbackId;

    @ApiModelProperty(value = "用户表的用户ID")
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    /**
     * @date 2020-10-25 22:58:55
     * @Author HuiAhh
     * 改字段+注释
     */
    @ApiModelProperty(value = "反馈类型:0:'普通反馈',1:'答案问题',2:'系统反馈，后面再扩展")
    private Integer feedType;

    @ApiModelProperty(value = "意见反馈内容")
    private String content;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "是否含有图片")
    private Boolean hasPicture;

    private String picUrls;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime addTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;


    @Override
    protected Serializable pkVal() {
        return this.feedbackId;
    }

}
