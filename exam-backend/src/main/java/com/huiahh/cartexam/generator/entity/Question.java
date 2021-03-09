package com.huiahh.cartexam.generator.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 题目表
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("exam_question")
@ApiModel(value="Question对象", description="题目表")
public class Question extends Model<Question> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "question_id", type = IdType.AUTO)
    private Integer questionId;

    @ApiModelProperty(value = "题干")
    private String name;

    @ApiModelProperty(value = "题枝选项")
    private String optiona;

    @ApiModelProperty(value = "题枝选项")
    private String optionb;

    @ApiModelProperty(value = "题枝选项")
    private String optionc;

    @ApiModelProperty(value = "题枝选项")
    private String optiond;

    @ApiModelProperty(value = "题目类型")
    private Integer type;

    /**
     * @date 2020-10-25 22:45:55
     * @Author HuiAhh
     * 改字段名、类型为string
     */
    @ApiModelProperty(value = "知识点Id，相当于category表中三级类目，默认值[]")
    private String knowledgeId;

    @ApiModelProperty(value = "答案")
    private String answer;

    @ApiModelProperty(value = "题解")
    private String answerDetail;

    @ApiModelProperty(value = "用户答案")
    private String userAnswer;

    @ApiModelProperty(value = "课程ID")
    private String courseId;

    @ApiModelProperty(value = "难度系数")
    private Integer difficulty;

    @Override
    protected Serializable pkVal() {
        return this.questionId;
    }

}
