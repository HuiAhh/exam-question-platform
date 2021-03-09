package com.huiahh.cartexam.generator.mapper;

import com.huiahh.cartexam.generator.entity.Collect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 收藏表 Mapper 接口
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Mapper
@Repository
public interface CollectMapper extends BaseMapper<Collect> {

    Integer updateByPrimaryKeySelective (Collect collect);

}
