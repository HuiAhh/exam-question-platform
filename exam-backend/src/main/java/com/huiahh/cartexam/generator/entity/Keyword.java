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
 * 关键字表
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("exam_keyword")
@ApiModel(value="Keyword对象", description="关键字表")
public class Keyword extends Model<Keyword> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "keyword_id", type = IdType.AUTO)
    private Integer keywordId;

    @ApiModelProperty(value = "关键字")
    private String keyword;

    @ApiModelProperty(value = "关键字的跳转链接")
    private String url;

    @ApiModelProperty(value = "是否是热门关键字")
    private Boolean isHot;

    @ApiModelProperty(value = "是否是默认关键字")
    private Boolean isDefault;

    @ApiModelProperty(value = "排序")
    private Integer sortOrder;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime addTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;


    @Override
    protected Serializable pkVal() {
        return this.keywordId;
    }

}
