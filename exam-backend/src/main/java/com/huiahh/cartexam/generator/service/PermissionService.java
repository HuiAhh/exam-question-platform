package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 权限表 服务类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
public interface PermissionService {

    /**
    * 分页查询Permission
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author hhq
    * @since 2020-10-18
    */
    Page<Permission> listPermissionsByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询Permission
    *
    * @param id 需要查询的Permission的id
    * @return 返回对应id的Permission对象
    * @author hhq
    * @since 2020-10-18
    */
    Permission getPermissionById(int id);

    /**
    * 插入Permission
    *
    * @param permission 需要插入的Permission对象
    * @return 返回插入成功之后Permission对象的id
    * @author hhq
    * @since 2020-10-18
    */
    Integer insertPermission(Permission permission);

    /**
    * 根据id删除Permission
    *
    * @param id 需要删除的Permission对象的id
    * @return 返回被删除的Permission对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int deletePermissionById(int id);

    /**
    * 根据id更新Permission
    *
    * @param permission 需要更新的Permission对象
    * @return 返回被更新的Permission对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int updatePermission(Permission permission);

}
