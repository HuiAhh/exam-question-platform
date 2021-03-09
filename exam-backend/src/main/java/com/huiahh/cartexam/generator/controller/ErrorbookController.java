package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.entity.Admin;
import com.huiahh.cartexam.generator.mapper.ErrorbookMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.ErrorbookService;
import com.huiahh.cartexam.generator.entity.Errorbook;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 错题集 前端控制器
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/errorbook")
@Api(tags = "对错题接口的操作")
public class ErrorbookController {

    @Autowired
    private ErrorbookService errorbookService;
    @Autowired
    private ErrorbookMapper errorbookMapper;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(errorbookService.listErrorbooksByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据错题Id查询")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(errorbookService.getErrorbookById(id));
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增错题")
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody Errorbook errorbook) {
        return new ResultBean<>(errorbookService.insertErrorbook(errorbook));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(errorbookService.deleteErrorbookById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody Errorbook errorbook) {
        return new ResultBean<>(errorbookService.updateErrorbook(errorbook));
    }

    /**
     * 根据id实现部分更新
     */
    @ApiOperation(value = "部分更新errorbook")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective(@RequestBody Errorbook errorbook) {
        return new ResultBean<>(errorbookMapper.updateByPrimaryKeySelective(errorbook));
    }
}
