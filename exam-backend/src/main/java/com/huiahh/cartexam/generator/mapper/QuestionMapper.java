package com.huiahh.cartexam.generator.mapper;

import com.huiahh.cartexam.generator.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
* <p>
* 题目表 Mapper 接口
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Mapper
@Repository
public interface QuestionMapper extends BaseMapper<Question> {

    //根据id查询题目
    Question selectByPrimaryKey(int id);

    //根据名称模糊查询题目
    List<Question> selectByName(String name);

    //多重关键字查询
    List<Question> selectByParams(String courseId, String queryTarget,
                                  String knowledgeId, Integer type);

    //部分更新题目表
    Integer updateByPrimaryKeySelective (Question question);
}
