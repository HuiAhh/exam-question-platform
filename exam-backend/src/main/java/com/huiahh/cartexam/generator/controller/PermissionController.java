package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.mapper.PermissionMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.PermissionService;
import com.huiahh.cartexam.generator.entity.Permission;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/permission")
@Api(tags = "对权限表的操作")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private PermissionMapper permissionMapper;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(permissionService.listPermissionsByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据id查询某一用户的权限")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(permissionService.getPermissionById(id));
    }

    /**
    * 新增
    */
    @ApiOperation(value = "对某一用户新增权限")
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody Permission permission) {
        return new ResultBean<>(permissionService.insertPermission(permission));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(permissionService.deletePermissionById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody Permission permission) {
        return new ResultBean<>(permissionService.updatePermission(permission));
    }

    @ApiOperation(value = "部分更新权限表")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective(@RequestBody Permission permission) {
        return new ResultBean<>(permissionMapper.updateByPrimaryKeySelective(permission));
    }
}
