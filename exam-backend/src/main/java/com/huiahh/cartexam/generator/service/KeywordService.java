package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.Keyword;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 关键字表 服务类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
public interface KeywordService {

    /**
    * 分页查询Keyword
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author hhq
    * @since 2020-10-18
    */
    Page<Keyword> listKeywordsByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询Keyword
    *
    * @param id 需要查询的Keyword的id
    * @return 返回对应id的Keyword对象
    * @author hhq
    * @since 2020-10-18
    */
    Keyword getKeywordById(int id);

    /**
    * 插入Keyword
    *
    * @param keyword 需要插入的Keyword对象
    * @return 返回插入成功之后Keyword对象的id
    * @author hhq
    * @since 2020-10-18
    */
    Integer insertKeyword(Keyword keyword);

    /**
    * 根据id删除Keyword
    *
    * @param id 需要删除的Keyword对象的id
    * @return 返回被删除的Keyword对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int deleteKeywordById(int id);

    /**
    * 根据id更新Keyword
    *
    * @param keyword 需要更新的Keyword对象
    * @return 返回被更新的Keyword对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int updateKeyword(Keyword keyword);

    /**
     * 根据keywordId插入keyword以及对应的url
     * @param keyword_id
     * @param keyword
     * @param url
     * @return
     */
    int addKeyWordById(int keyword_id, String keyword, String url);

}
