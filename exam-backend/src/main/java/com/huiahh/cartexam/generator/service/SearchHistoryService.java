package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.SearchHistory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 搜索历史表 服务类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
public interface SearchHistoryService {

    /**
    * 分页查询SearchHistory
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author hhq
    * @since 2020-10-18
    */
    Page<SearchHistory> listSearchHistorysByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询SearchHistory
    *
    * @param id 需要查询的SearchHistory的id
    * @return 返回对应id的SearchHistory对象
    * @author hhq
    * @since 2020-10-18
    */
    SearchHistory getSearchHistoryById(int id);

    /**
    * 插入SearchHistory
    *
    * @param searchHistory 需要插入的SearchHistory对象
    * @return 返回插入成功之后SearchHistory对象的id
    * @author hhq
    * @since 2020-10-18
    */
    Integer insertSearchHistory(SearchHistory searchHistory);

    /**
    * 根据id删除SearchHistory
    *
    * @param id 需要删除的SearchHistory对象的id
    * @return 返回被删除的SearchHistory对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int deleteSearchHistoryById(int id);

    /**
    * 根据id更新SearchHistory
    *
    * @param searchHistory 需要更新的SearchHistory对象
    * @return 返回被更新的SearchHistory对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int updateSearchHistory(SearchHistory searchHistory);

}
