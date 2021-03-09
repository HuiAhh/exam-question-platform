package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.entity.Topic;
import com.huiahh.cartexam.generator.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.UserService;
import com.huiahh.cartexam.generator.entity.User;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/user")
@Api(tags = "对用户表的操作")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(userService.listUsersByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据id查询用户信息")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(userService.getUserById(id));
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增用户信息")
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody User user) {
        return new ResultBean<>(userService.insertUser(user));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(userService.deleteUserById(id));
    }

    /**
    * 修改
    */
    @ApiOperation(value = "修改用户信息")
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody User user) {
        return new ResultBean<>(userService.updateUser(user));
    }

    @ApiOperation(value = "部分修改用户信息")
    @RequestMapping(method = RequestMethod.PUT,value="/updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective(@RequestBody User user) {
        return new ResultBean<>(userMapper.updateByPrimaryKeySelective(user));
    }
}
