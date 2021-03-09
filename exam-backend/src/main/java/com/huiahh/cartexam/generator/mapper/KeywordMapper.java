package com.huiahh.cartexam.generator.mapper;

import com.huiahh.cartexam.generator.entity.Keyword;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 关键字表 Mapper 接口
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Mapper
@Repository
public interface KeywordMapper extends BaseMapper<Keyword> {

    /**
     * 根据关键词id，关键词，跳转url增加关键词
     * @param keyword_id
     * @param keyword
     * @param url
     * @return
     */
    int addKeyWordById(int keyword_id, String keyword, String url);

    Integer updateByPrimaryKeySelective (Keyword keyword);

}
