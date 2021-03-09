package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.entity.Role;
import com.huiahh.cartexam.generator.mapper.SchoolMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.SchoolService;
import com.huiahh.cartexam.generator.entity.School;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 专业表 前端控制器
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/school")
@Api(tags = "对学院表的操作")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;
    @Autowired
    private SchoolMapper schoolMapper;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(schoolService.listSchoolsByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据id查询某一学院")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(schoolService.getSchoolById(id));
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增学院信息")
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody School school) {
        return new ResultBean<>(schoolService.insertSchool(school));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(schoolService.deleteSchoolById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody School school) {
        return new ResultBean<>(schoolService.updateSchool(school));
    }

    @ApiOperation(value = "部分更新学院表")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective(@RequestBody School school) {
        return new ResultBean<>(schoolMapper.updateByPrimaryKeySelective(school));
    }
}
