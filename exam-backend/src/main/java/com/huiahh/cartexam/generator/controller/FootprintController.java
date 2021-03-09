package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.entity.Admin;
import com.huiahh.cartexam.generator.mapper.FootprintMapper;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.FootprintService;
import com.huiahh.cartexam.generator.entity.Footprint;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户浏览足迹表 前端控制器
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/footprint")
@Api(tags = "对用户浏览足迹表的操作")
public class FootprintController {

    @Autowired
    private FootprintService footprintService;
    @Autowired
    private FootprintMapper footprintMapper;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(footprintService.listFootprintsByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(footprintService.getFootprintById(id));
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增浏览题目")
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody
                                @ApiParam(name = "questionId", value = "用户浏览题目的Id,必填") Footprint footprint) {
        return new ResultBean<>(footprintService.insertFootprint(footprint));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(footprintService.deleteFootprintById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody Footprint footprint) {
        return new ResultBean<>(footprintService.updateFootprint(footprint));
    }

    /**
     * 根据id实现部分更新
     */
    @ApiOperation(value = "部分更新footprint信息")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective(@RequestBody Footprint footprint) {
        return new ResultBean<>(footprintMapper.updateByPrimaryKeySelective(footprint));
    }
}
