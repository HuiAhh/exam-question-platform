package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 角色表 服务类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
public interface RoleService {

    /**
    * 分页查询Role
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author hhq
    * @since 2020-10-18
    */
    Page<Role> listRolesByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询Role
    *
    * @param id 需要查询的Role的id
    * @return 返回对应id的Role对象
    * @author hhq
    * @since 2020-10-18
    */
    Role getRoleById(int id);

    /**
    * 插入Role
    *
    * @param role 需要插入的Role对象
    * @return 返回插入成功之后Role对象的id
    * @author hhq
    * @since 2020-10-18
    */
    Integer insertRole(Role role);

    /**
    * 根据id删除Role
    *
    * @param id 需要删除的Role对象的id
    * @return 返回被删除的Role对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int deleteRoleById(int id);

    /**
    * 根据id更新Role
    *
    * @param role 需要更新的Role对象
    * @return 返回被更新的Role对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int updateRole(Role role);

}
