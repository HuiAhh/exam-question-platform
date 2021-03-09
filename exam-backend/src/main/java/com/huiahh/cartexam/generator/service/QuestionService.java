package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
* <p>
* 题目表 服务类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
public interface QuestionService {

    /**
    * 分页查询Question
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author hhq
    * @since 2020-10-18
    */
    Page<Question> listQuestionsByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询Question
    *
    * @param id 需要查询的Question的id
    * @return 返回对应id的Question对象
    * @author hhq
    * @since 2020-10-18
    */
    Question getQuestionById(int id);

    /**
    * 插入Question
    *
    * @param question 需要插入的Question对象
    * @return 返回插入成功之后Question对象的id
    * @author hhq
    * @since 2020-10-18
    */
    Integer insertQuestion(Question question);

    /**
    * 根据id删除Question
    *
    * @param id 需要删除的Question对象的id
    * @return 返回被删除的Question对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int deleteQuestionById(int id);

    /**
    * 根据id更新Question
    *
    * @param question 需要更新的Question对象
    * @return 返回被更新的Question对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int updateQuestion(Question question);

}
