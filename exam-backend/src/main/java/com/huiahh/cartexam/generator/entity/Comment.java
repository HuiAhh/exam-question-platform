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
 * 评论表
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("exam_comment")
@ApiModel(value="Comment对象", description="评论表")
public class Comment extends Model<Comment> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    @ApiModelProperty(value = "评论对象的ID")
    private Integer valueId;

    @ApiModelProperty(value = "评论类型，如果type=0，则是题目评论；如果是type=1，则是专题评论；如果type=3，则是组卷题目评论。")
    private Integer type;

    private String content;

    @ApiModelProperty(value = "用户表的用户ID")
    private Integer userId;

    @ApiModelProperty(value = "是否含有图片")
    private Boolean hasPicture;

    @ApiModelProperty(value = "图片地址列表，采用JSON数组格式")
    private String picUrls;

    @ApiModelProperty(value = "评分， 1-5")
    private Integer star;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime addTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;


    @Override
    protected Serializable pkVal() {
        return this.commentId;
    }

}
