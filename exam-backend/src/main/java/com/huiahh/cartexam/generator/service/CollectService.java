package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.Collect;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 收藏表 服务类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
public interface CollectService {

    /**
    * 分页查询Collect
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author hhq
    * @since 2020-10-18
    */
    Page<Collect> listCollectsByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询Collect
    *
    * @param id 需要查询的Collect的id
    * @return 返回对应id的Collect对象
    * @author hhq
    * @since 2020-10-18
    */
    Collect getCollectById(int id);

    /**
    * 插入Collect
    *
    * @param collect 需要插入的Collect对象
    * @return 返回插入成功之后Collect对象的id
    * @author hhq
    * @since 2020-10-18
    */
    Integer insertCollect(Collect collect);

    /**
    * 根据id删除Collect
    *
    * @param id 需要删除的Collect对象的id
    * @return 返回被删除的Collect对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int deleteCollectById(int id);

    /**
    * 根据id更新Collect
    *
    * @param collect 需要更新的Collect对象
    * @return 返回被更新的Collect对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int updateCollect(Collect collect);

}
