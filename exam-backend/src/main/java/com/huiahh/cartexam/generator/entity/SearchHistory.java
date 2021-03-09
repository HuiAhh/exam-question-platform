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
 * 搜索历史表
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("exam_search_history")
@ApiModel(value="SearchHistory对象", description="搜索历史表")
public class SearchHistory extends Model<SearchHistory> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "search_history_id", type = IdType.AUTO)
    private Integer searchHistoryId;

    @ApiModelProperty(value = "用户表的用户ID")
    private Integer userId;

    @ApiModelProperty(value = "搜索关键字")
    private String keyword;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime addTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;


    @Override
    protected Serializable pkVal() {
        return this.searchHistoryId;
    }

}
