package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.mapper.KeywordMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.KeywordService;
import com.huiahh.cartexam.generator.entity.Keyword;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 关键字表 前端控制器
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/keyword")
@Api(tags = "对关键词表的操作")
public class KeywordController {

    @Autowired
    private KeywordService keywordService;
    @Autowired
    private KeywordMapper keywordMapper;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(keywordService.listKeywordsByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据id查询关键词列表")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(keywordService.getKeywordById(id));
    }

    /**
    * 新增
    */
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody Keyword keyword) {
        return new ResultBean<>(keywordService.insertKeyword(keyword));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add-key-word")
    @ApiOperation(value = "根据keyword_id新增关键词")
    public ResultBean<?> addKeyWordById(int keyword_id, String keyword, String url) {
        return new ResultBean<>(keywordService.addKeyWordById(keyword_id, keyword, url));
    }


    /**
    * 删除
    */
    @ApiOperation(value = "根据id逻辑删除关键词词组")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(keywordService.deleteKeywordById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody Keyword keyword) {
        return new ResultBean<>(keywordService.updateKeyword(keyword));
    }

    @ApiOperation(value = "根据关键词id实现部分更新")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective(@RequestBody Keyword keyword) {
        return new ResultBean<>(keywordMapper.updateByPrimaryKeySelective(keyword));
    }


}
