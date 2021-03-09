package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.mapper.CollectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.CollectService;
import com.huiahh.cartexam.generator.entity.Collect;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 收藏表 前端控制器
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/collect")
@Api(tags = "对收藏表的操作")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @Autowired
    private CollectMapper collectMapper;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(collectService.listCollectsByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "用户的收藏表id,一个用户可以有多个收藏表")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(collectService.getCollectById(id));
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增一个收藏列表")
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody Collect collect) {
        return new ResultBean<>(collectService.insertCollect(collect));
    }

    /**
    * 删除
    */
    @ApiOperation(value = "删除用户的一个收藏列表")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(collectService.deleteCollectById(id));
    }

    /**
    * 修改
    */
    @ApiOperation(value = "修改用户的一个收藏列表")
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody Collect collect) {
        return new ResultBean<>(collectService.updateCollect(collect));
    }

    /**
     * 根据id实现部分修改
     */
    @ApiOperation(value = "部分修改用户的一个收藏列表")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective (@RequestBody Collect collect) {
        return new ResultBean<>(collectMapper.updateByPrimaryKeySelective(collect));
    }

}
