package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.entity.School;
import com.huiahh.cartexam.generator.mapper.SearchHistoryMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.SearchHistoryService;
import com.huiahh.cartexam.generator.entity.SearchHistory;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 搜索历史表 前端控制器
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 * @version v1.0
 */
@RestController
@RequestMapping("/generator/api/v1/search-history")
@Api(tags = "对搜索历史表(关键词)的操作")
public class SearchHistoryController {

    @Autowired
    private SearchHistoryService searchHistoryService;
    @Autowired
    private SearchHistoryMapper searchHistoryMapper;

    /**
    * 查询分页数据
    */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(searchHistoryService.listSearchHistorysByPage(page, pageSize,factor));
    }


    /**
    * 根据id查询
    */
    @ApiOperation(value = "根据id查询关键词列表")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(searchHistoryService.getSearchHistoryById(id));
    }

    /**
    * 新增
    */
    @ApiOperation(value = "新增关键词搜索")
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody SearchHistory searchHistory) {
        return new ResultBean<>(searchHistoryService.insertSearchHistory(searchHistory));
    }

    /**
    * 删除
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(searchHistoryService.deleteSearchHistoryById(id));
    }

    /**
    * 修改
    */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody SearchHistory searchHistory) {
        return new ResultBean<>(searchHistoryService.updateSearchHistory(searchHistory));
    }

    @ApiOperation(value = "部分更新搜索历史表")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective(@RequestBody SearchHistory searchHistory) {
        return new ResultBean<>(searchHistoryMapper.updateByPrimaryKeySelective(searchHistory));
    }

}
