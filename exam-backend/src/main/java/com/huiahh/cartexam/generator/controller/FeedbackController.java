package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.entity.Admin;
import com.huiahh.cartexam.generator.mapper.FeedbackMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.FeedbackService;
import com.huiahh.cartexam.generator.entity.Feedback;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 意见反馈表 前端控制器
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/feedback")
@Api(tags = "对意见反馈表的操作")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private FeedbackMapper feedbackMapper;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(feedbackService.listFeedbacksByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(feedbackService.getFeedbackById(id));
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增反馈意见")
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody Feedback feedback) {
        return new ResultBean<>(feedbackService.insertFeedback(feedback));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(feedbackService.deleteFeedbackById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody Feedback feedback) {
        return new ResultBean<>(feedbackService.updateFeedback(feedback));
    }

    /**
     * 根据id实现部分更新
     */
    @ApiOperation(value = "部分更新意见反馈表")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective(@RequestBody Feedback feedback) {
        return new ResultBean<>(feedbackMapper.updateByPrimaryKeySelective(feedback));
    }
}
