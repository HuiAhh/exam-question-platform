package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 管理员表 服务类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
public interface AdminService {

    /**
    * 分页查询Admin
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author hhq
    * @since 2020-10-18
    */
    Page<Admin> listAdminsByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询Admin
    *
    * @param id 需要查询的Admin的id
    * @return 返回对应id的Admin对象
    * @author hhq
    * @since 2020-10-18
    */
    Admin getAdminById(int id);

    /**
    * 插入Admin
    *
    * @param admin 需要插入的Admin对象
    * @return 返回插入成功之后Admin对象的id
    * @author hhq
    * @since 2020-10-18
    */
    Integer insertAdmin(Admin admin);

    /**
    * 根据id删除Admin
    *
    * @param id 需要删除的Admin对象的id
    * @return 返回被删除的Admin对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int deleteAdminById(int id);

    /**
    * 根据id更新Admin
    *
    * @param admin 需要更新的Admin对象
    * @return 返回被更新的Admin对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int updateAdmin(Admin admin);

}
