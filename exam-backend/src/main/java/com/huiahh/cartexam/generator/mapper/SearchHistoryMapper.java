package com.huiahh.cartexam.generator.mapper;

import com.huiahh.cartexam.generator.entity.SearchHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 搜索历史表 Mapper 接口
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Mapper
@Repository
public interface SearchHistoryMapper extends BaseMapper<SearchHistory> {

    Integer updateByPrimaryKeySelective (SearchHistory searchHistory);

}
