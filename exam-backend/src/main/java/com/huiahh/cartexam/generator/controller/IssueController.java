package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.mapper.IssueMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.IssueService;
import com.huiahh.cartexam.generator.entity.Issue;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 常见问题表 前端控制器
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/issue")
@Api(tags = "对常见问题表的操作 和Feedback表配合操作(很骚")
public class IssueController {

    @Autowired
    private IssueService issueService;
    @Autowired
    private IssueMapper issueMapper;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(issueService.listIssuesByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(issueService.getIssueById(id));
    }

    /**
    * 新增
    */
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody Issue issue) {
        return new ResultBean<>(issueService.insertIssue(issue));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(issueService.deleteIssueById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody Issue issue) {
        return new ResultBean<>(issueService.updateIssue(issue));
    }


    @ApiOperation(value = "部分更新常见问题表")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective(@RequestBody Issue issue) {
        return new ResultBean<>(issueMapper.updateByPrimaryKeySelective(issue));
    }

}
