package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.Issue;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 常见问题表 服务类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
public interface IssueService {

    /**
    * 分页查询Issue
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author hhq
    * @since 2020-10-18
    */
    Page<Issue> listIssuesByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询Issue
    *
    * @param id 需要查询的Issue的id
    * @return 返回对应id的Issue对象
    * @author hhq
    * @since 2020-10-18
    */
    Issue getIssueById(int id);

    /**
    * 插入Issue
    *
    * @param issue 需要插入的Issue对象
    * @return 返回插入成功之后Issue对象的id
    * @author hhq
    * @since 2020-10-18
    */
    Integer insertIssue(Issue issue);

    /**
    * 根据id删除Issue
    *
    * @param id 需要删除的Issue对象的id
    * @return 返回被删除的Issue对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int deleteIssueById(int id);

    /**
    * 根据id更新Issue
    *
    * @param issue 需要更新的Issue对象
    * @return 返回被更新的Issue对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int updateIssue(Issue issue);

}
