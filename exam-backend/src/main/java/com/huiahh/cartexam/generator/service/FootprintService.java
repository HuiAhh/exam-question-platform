package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.Footprint;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 用户浏览足迹表 服务类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
public interface FootprintService {

    /**
    * 分页查询Footprint
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author hhq
    * @since 2020-10-18
    */
    Page<Footprint> listFootprintsByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询Footprint
    *
    * @param id 需要查询的Footprint的id
    * @return 返回对应id的Footprint对象
    * @author hhq
    * @since 2020-10-18
    */
    Footprint getFootprintById(int id);

    /**
    * 插入Footprint
    *
    * @param footprint 需要插入的Footprint对象
    * @return 返回插入成功之后Footprint对象的id
    * @author hhq
    * @since 2020-10-18
    */
    Integer insertFootprint(Footprint footprint);

    /**
    * 根据id删除Footprint
    *
    * @param id 需要删除的Footprint对象的id
    * @return 返回被删除的Footprint对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int deleteFootprintById(int id);

    /**
    * 根据id更新Footprint
    *
    * @param footprint 需要更新的Footprint对象
    * @return 返回被更新的Footprint对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int updateFootprint(Footprint footprint);

}
