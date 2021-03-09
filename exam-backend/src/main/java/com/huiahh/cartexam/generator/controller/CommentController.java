package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.entity.Admin;
import com.huiahh.cartexam.generator.mapper.CommentMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.CommentService;
import com.huiahh.cartexam.generator.entity.Comment;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/comment")
@Api(tags = "对评论表的操作")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentMapper commentMapper;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(commentService.listCommentsByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据id查询评论")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(commentService.getCommentById(id));
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增一条评论")
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody Comment comment) {
        return new ResultBean<>(commentService.insertComment(comment));
    }

    /**
    * 删除
    */
    @ApiOperation(value = "删除一条评论")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(commentService.deleteCommentById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody Comment comment) {
        return new ResultBean<>(commentService.updateComment(comment));
    }

    /**
     * 根据id实现部分更新
     */
    @ApiOperation(value = "部分更新comment")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective(@RequestBody Comment comment) {
        return new ResultBean<>(commentMapper.updateByPrimaryKeySelective(comment));
    }
}
