package com.huiahh.cartexam.generator.entity;

import java.math.BigDecimal;
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
 * 专题表
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("exam_topic")
@ApiModel(value="Topic对象", description="专题表")
public class Topic extends Model<Topic> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "topic_id", type = IdType.AUTO)
    private Integer topicId;

    @ApiModelProperty(value = "专题标题")
    private String title;

    @ApiModelProperty(value = "专题子标题")
    private String subtitle;

    @ApiModelProperty(value = "专题内容，富文本格式")
    private String content;

    /**
     * @date 2020-10-25 22:39:13
     * @author HuiAhh
     * @modified 删除字段
     */

    @ApiModelProperty(value = "专题阅读量")
    private String readCount;

    @ApiModelProperty(value = "专题图片")
    private String picUrl;

    /**
     * @date 2020-10-25 22:37:40
     * @author HuiAhh
     * @modified 删除字段
     */

    /**
     * @date 2020-10-25 22:34:18
     * @author HuiAhh
     * @modified 改字段注释、字段名
     */
    @ApiModelProperty(value = "专题相关题目，采用JSON数组格式[]")
    private String knowledgeId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime addTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;


    @Override
    protected Serializable pkVal() {
        return this.topicId;
    }

}
