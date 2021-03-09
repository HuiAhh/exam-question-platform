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
 * 常见问题表
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("exam_issue")
@ApiModel(value="Issue对象", description="常见问题表")
public class Issue extends Model<Issue> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "issue_id", type = IdType.AUTO)
    private Integer issueId;

    @ApiModelProperty(value = "问题标题")
    private String question;

    @ApiModelProperty(value = "问题答案")
    private String answer;

    /**
     * @date 2020-10-25 22:45:55
     * @Author HuiAhh
     * 加字段关联feedbackId
     */
    @ApiModelProperty(value = "反馈表外键")
    private Integer feedbackId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime addTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;


    @Override
    protected Serializable pkVal() {
        return this.issueId;
    }

}
