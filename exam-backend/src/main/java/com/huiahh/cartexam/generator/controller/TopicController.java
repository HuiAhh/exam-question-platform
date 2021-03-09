package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.entity.School;
import com.huiahh.cartexam.generator.mapper.TopicMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.TopicService;
import com.huiahh.cartexam.generator.entity.Topic;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 专题表 前端控制器
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/topic")
@Api(tags = "对题解表进行操作")
public class TopicController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private TopicMapper topicMapper;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(topicService.listTopicsByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据id查询题解")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(topicService.getTopicById(id));
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增题解")
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody Topic topic) {
        return new ResultBean<>(topicService.insertTopic(topic));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(topicService.deleteTopicById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody Topic topic) {
        return new ResultBean<>(topicService.updateTopic(topic));
    }

    @ApiOperation(value = "部分更新专题表")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective(@RequestBody Topic topic) {
        return new ResultBean<>(topicMapper.updateByPrimaryKeySelective(topic));
    }
}
