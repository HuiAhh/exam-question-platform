package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.Major;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 专业表 服务类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
public interface MajorService {

    /**
    * 分页查询Major
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author hhq
    * @since 2020-10-18
    */
    Page<Major> listMajorsByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询Major
    *
    * @param id 需要查询的Major的id
    * @return 返回对应id的Major对象
    * @author hhq
    * @since 2020-10-18
    */
    Major getMajorById(int id);

    /**
    * 插入Major
    *
    * @param major 需要插入的Major对象
    * @return 返回插入成功之后Major对象的id
    * @author hhq
    * @since 2020-10-18
    */
    Integer insertMajor(Major major);

    /**
    * 根据id删除Major
    *
    * @param id 需要删除的Major对象的id
    * @return 返回被删除的Major对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int deleteMajorById(int id);

    /**
    * 根据id更新Major
    *
    * @param major 需要更新的Major对象
    * @return 返回被更新的Major对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int updateMajor(Major major);

}
