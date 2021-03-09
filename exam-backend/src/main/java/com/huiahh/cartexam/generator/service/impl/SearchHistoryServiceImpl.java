package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.SearchHistory;
import com.huiahh.cartexam.generator.mapper.SearchHistoryMapper;
import com.huiahh.cartexam.generator.service.SearchHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.huiahh.cartexam.generator.exception.bizException.BizException;

/**
* <p>
* 搜索历史表 服务实现类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Slf4j
@Service
public class SearchHistoryServiceImpl extends ServiceImpl<SearchHistoryMapper, SearchHistory> implements SearchHistoryService {

    @Override
    public Page<SearchHistory> listSearchHistorysByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询searchHistory: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<SearchHistory> queryWrapper =  new QueryWrapper<SearchHistory>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<SearchHistory> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询searchHistory完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public SearchHistory getSearchHistoryById(int id) {
        log.info("正在查询searchHistory中id为{}的数据",id);
        SearchHistory searchHistory = super.getById(id);
        log.info("查询id为{}的searchHistory{}",id,(null == searchHistory?"无结果":"成功"));
        return searchHistory;
    }

    @Override
    public Integer insertSearchHistory(SearchHistory searchHistory) {
        log.info("正在插入searchHistory");
        if (super.save(searchHistory)) {
            log.info("插入searchHistory成功,id为{}",searchHistory.getSearchHistoryId());
            return searchHistory.getSearchHistoryId();
        } else {
            log.error("插入searchHistory失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteSearchHistoryById(int id) {
        log.info("正在删除id为{}的searchHistory",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的searchHistory成功",id);
            return id;
        } else {
            log.error("删除id为{}的searchHistory失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateSearchHistory(SearchHistory searchHistory) {
        log.info("正在更新id为{}的searchHistory",searchHistory.getSearchHistoryId());
        if (super.updateById(searchHistory)) {
            log.info("更新d为{}的searchHistory成功",searchHistory.getSearchHistoryId());
            return searchHistory.getSearchHistoryId();
        } else {
            log.error("更新id为{}的searchHistory失败",searchHistory.getSearchHistoryId());
            throw new BizException("更新失败[id=" + searchHistory.getSearchHistoryId() + "]");
        }
    }

}
