package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.Keyword;
import com.huiahh.cartexam.generator.mapper.KeywordMapper;
import com.huiahh.cartexam.generator.service.KeywordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.huiahh.cartexam.generator.exception.bizException.BizException;

/**
* <p>
* 关键字表 服务实现类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Slf4j
@Service
public class KeywordServiceImpl extends ServiceImpl<KeywordMapper, Keyword> implements KeywordService {

    @Autowired
    private KeywordMapper keywordMapper;

    @Override
    public Page<Keyword> listKeywordsByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询keyword: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<Keyword> queryWrapper =  new QueryWrapper<Keyword>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<Keyword> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询keyword完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public Keyword getKeywordById(int id) {
        log.info("正在查询keyword中id为{}的数据",id);
        Keyword keyword = super.getById(id);
        log.info("查询id为{}的keyword{}",id,(null == keyword?"无结果":"成功"));
        return keyword;
    }

    @Override
    public Integer insertKeyword(Keyword keyword) {
        log.info("正在插入keyword");
        if (super.save(keyword)) {
            log.info("插入keyword成功,id为{}",keyword.getKeywordId());
            return keyword.getKeywordId();
        } else {
            log.error("插入keyword失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteKeywordById(int id) {
        log.info("正在删除id为{}的keyword",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的keyword成功",id);
            return id;
        } else {
            log.error("删除id为{}的keyword失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateKeyword(Keyword keyword) {
        log.info("正在更新id为{}的keyword",keyword.getKeywordId());
        if (super.updateById(keyword)) {
            log.info("更新d为{}的keyword成功",keyword.getKeywordId());
            return keyword.getKeywordId();
        } else {
            log.error("更新id为{}的keyword失败",keyword.getKeywordId());
            throw new BizException("更新失败[id=" + keyword.getKeywordId() + "]");
        }
    }

    public int addKeyWordById(int keyword_id, String keyword, String url) {
        return keywordMapper.addKeyWordById(keyword_id, keyword, url);
    }

}
