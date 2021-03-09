package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.entity.Major;
import com.huiahh.cartexam.generator.mapper.RoleMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.RoleService;
import com.huiahh.cartexam.generator.entity.Role;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/role")
@Api(tags = "对角色表的操作")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMapper roleMapper;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(roleService.listRolesByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "查询某一角色的功能")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(roleService.getRoleById(id));
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增角色的权限")
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody Role role) {
        return new ResultBean<>(roleService.insertRole(role));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(roleService.deleteRoleById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody Role role) {
        return new ResultBean<>(roleService.updateRole(role));
    }

    @ApiOperation(value = "部分更新角色表")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective(@RequestBody Role role) {
        return new ResultBean<>(roleMapper.updateByPrimaryKeySelective(role));
    }

}
