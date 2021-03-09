package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.mapper.PaperMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.PaperService;
import com.huiahh.cartexam.generator.entity.Paper;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 组卷表 前端控制器
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/paper")
@Api(tags = "对组卷表的操作")
public class PaperController {

    @Autowired
    private PaperService paperService;
    @Autowired
    private PaperMapper paperMapper;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(paperService.listPapersByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据id查询某一套组卷信息")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(paperService.getPaperById(id));
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增组卷")
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody Paper paper) {
        return new ResultBean<>(paperService.insertPaper(paper));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(paperService.deletePaperById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody Paper paper) {
        return new ResultBean<>(paperService.updatePaper(paper));
    }

    @ApiOperation(value = "部分更新组卷表")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective(@RequestBody Paper paper) {
        return new ResultBean<>(paperMapper.updateByPrimaryKeySelective(paper));
    }

}
