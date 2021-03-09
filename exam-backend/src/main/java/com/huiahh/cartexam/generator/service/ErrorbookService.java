package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.Errorbook;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 错题集 服务类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
public interface ErrorbookService {

    /**
    * 分页查询Errorbook
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author hhq
    * @since 2020-10-18
    */
    Page<Errorbook> listErrorbooksByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询Errorbook
    *
    * @param id 需要查询的Errorbook的id
    * @return 返回对应id的Errorbook对象
    * @author hhq
    * @since 2020-10-18
    */
    Errorbook getErrorbookById(int id);

    /**
    * 插入Errorbook
    *
    * @param errorbook 需要插入的Errorbook对象
    * @return 返回插入成功之后Errorbook对象的id
    * @author hhq
    * @since 2020-10-18
    */
    Integer insertErrorbook(Errorbook errorbook);

    /**
    * 根据id删除Errorbook
    *
    * @param id 需要删除的Errorbook对象的id
    * @return 返回被删除的Errorbook对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int deleteErrorbookById(int id);

    /**
    * 根据id更新Errorbook
    *
    * @param errorbook 需要更新的Errorbook对象
    * @return 返回被更新的Errorbook对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int updateErrorbook(Errorbook errorbook);

}
