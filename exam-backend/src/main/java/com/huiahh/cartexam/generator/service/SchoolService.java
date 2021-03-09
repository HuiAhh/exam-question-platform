package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.School;
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
public interface SchoolService {

    /**
    * 分页查询School
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author hhq
    * @since 2020-10-18
    */
    Page<School> listSchoolsByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询School
    *
    * @param id 需要查询的School的id
    * @return 返回对应id的School对象
    * @author hhq
    * @since 2020-10-18
    */
    School getSchoolById(int id);

    /**
    * 插入School
    *
    * @param school 需要插入的School对象
    * @return 返回插入成功之后School对象的id
    * @author hhq
    * @since 2020-10-18
    */
    Integer insertSchool(School school);

    /**
    * 根据id删除School
    *
    * @param id 需要删除的School对象的id
    * @return 返回被删除的School对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int deleteSchoolById(int id);

    /**
    * 根据id更新School
    *
    * @param school 需要更新的School对象
    * @return 返回被更新的School对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int updateSchool(School school);

}
