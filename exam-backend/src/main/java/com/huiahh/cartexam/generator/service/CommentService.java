package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 评论表 服务类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
public interface CommentService {

    /**
    * 分页查询Comment
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author hhq
    * @since 2020-10-18
    */
    Page<Comment> listCommentsByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询Comment
    *
    * @param id 需要查询的Comment的id
    * @return 返回对应id的Comment对象
    * @author hhq
    * @since 2020-10-18
    */
    Comment getCommentById(int id);

    /**
    * 插入Comment
    *
    * @param comment 需要插入的Comment对象
    * @return 返回插入成功之后Comment对象的id
    * @author hhq
    * @since 2020-10-18
    */
    Integer insertComment(Comment comment);

    /**
    * 根据id删除Comment
    *
    * @param id 需要删除的Comment对象的id
    * @return 返回被删除的Comment对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int deleteCommentById(int id);

    /**
    * 根据id更新Comment
    *
    * @param comment 需要更新的Comment对象
    * @return 返回被更新的Comment对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int updateComment(Comment comment);

}
