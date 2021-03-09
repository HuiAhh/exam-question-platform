package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.mapper.QuestionMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.QuestionService;
import com.huiahh.cartexam.generator.entity.Question;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 题目表 前端控制器
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/question")
@Api(tags = "对题目表的操作")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionMapper questionMapper;
//
//    @RequestMapping(value="/list", method = RequestMethod.GET)
//    public List<Question> questionList(@RequestParam String name){
//        return questionMapper.selectByName(name);
//    }

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(questionService.listQuestionsByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据id查询题目具体信息")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(questionService.getQuestionById(id));
    }

    /**
     * queryParam: {
 *                     "courseId": "",
 *                     "queryTarget": "",
 *                     "knowledgeId": "",
 *                     "type": 2
 *                 },
     * @return
     */
    @ApiOperation(value = "根据params:{courseId,queryTarget:（查找关键词）,knowledgeId,type}查询题目具体信息")
    @RequestMapping(method = RequestMethod.GET, value = "/query")
    public ResultBean<?> getByParams(@RequestParam(value = "courseId",defaultValue = "") String courseId,
                                     @RequestParam(value = "queryTarget",defaultValue = "") String queryTarget,
                                     @RequestParam(value = "knowledgeId",defaultValue = "") String knowledgeId,
                                     @RequestParam(value = "type" ,required=false) Integer type) {
        return new ResultBean<>(questionMapper.selectByParams(courseId,queryTarget,knowledgeId,type));
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增题目")
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody
                                @ApiParam(name = "type", value = "题目类型,0表示选择题,1表示填空题,2表示论述题") Question question) {
        return new ResultBean<>(questionService.insertQuestion(question));
    }

    @ApiOperation(value = "新增多个题目")
    @RequestMapping(method = RequestMethod.POST,value="/multi")
    public ResultBean<?> insertMulti(@RequestBody List<Question> questions) {
        int counter=0;
        for (Question q :questions
                ) {
            questionService.insertQuestion(q);
            counter++;
        }
        return new ResultBean<>(counter);
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(questionService.deleteQuestionById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody Question question) {
        return new ResultBean<>(questionService.updateQuestion(question));
    }

    @ApiOperation(value = "部分更新题目")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective(@RequestBody Question question) {
        return new ResultBean<>(questionMapper.updateByPrimaryKeySelective(question));
    }

}
