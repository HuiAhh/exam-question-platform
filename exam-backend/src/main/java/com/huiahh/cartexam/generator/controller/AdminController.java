package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.mapper.AdminMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.AdminService;
import com.huiahh.cartexam.generator.entity.Admin;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 * @version v1.0
 */
@RestController
@Api(tags = "admin表的操作")
@RequestMapping("/generator/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminMapper adminMapper;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(adminService.listAdminsByPage(page, pageSize,factor));
    }

//    @RequestMapping(method = RequestMethod.GET,value="/list")
//    public ResultBean<?> listByPageMybatis(@RequestParam(name = "page", defaultValue = "1") int page,
//                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
//                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
//        return new ResultBean<>(adminMapper.selectAdmins());
//    }

    /**
    * 根据id查询
    */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ApiOperation(value = "根据id查询admin信息")
    public ResultBean<?> getById(@PathVariable("id")
                                 @ApiParam(name = "id", value = "adminId", required = true)
                                             Integer id) {
        return new ResultBean<>(adminService.getAdminById(id));
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增admin")
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody Admin admin) {
        return new ResultBean<>(adminService.insertAdmin(admin));
    }

    /**
    * 删除
    */
    @ApiOperation(value = "根据id删除admin")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(adminService.deleteAdminById(id));
    }

    /**
    * 修改
    */
    @ApiOperation(value = "更新admin用户信息")
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody Admin admin) {
        return new ResultBean<>(adminService.updateAdmin(admin));
    }

    /**
     * 根据id实现部分更新
     */
    @ApiOperation(value = "部分更新admin用户信息")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective(@RequestBody Admin admin) {
        return new ResultBean<>(adminMapper.updateByPrimaryKeySelective(admin));
    }

}
