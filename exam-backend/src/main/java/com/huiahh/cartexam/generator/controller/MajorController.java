package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.mapper.MajorMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.MajorService;
import com.huiahh.cartexam.generator.entity.Major;
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
@RequestMapping("/generator/api/v1/major")
@Api(tags = "对专业表进行操作")
public class MajorController {

    @Autowired
    private MajorService majorService;
    @Autowired
    private MajorMapper majorMapper;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(majorService.listMajorsByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据id查询专业信息")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(majorService.getMajorById(id));
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增给定学院的专业")
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody Major major) {
        return new ResultBean<>(majorService.insertMajor(major));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(majorService.deleteMajorById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody Major major) {
        return new ResultBean<>(majorService.updateMajor(major));
    }

    @ApiOperation(value = "部分更新专业表")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective(@RequestBody Major major) {
        return new ResultBean<>(majorMapper.updateByPrimaryKeySelective(major));
    }
}
