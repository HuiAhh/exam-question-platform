package com.huiahh.cartexam.generator.mapper;

import com.huiahh.cartexam.generator.entity.Feedback;
import com.huiahh.cartexam.generator.entity.Footprint;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 用户浏览足迹表 Mapper 接口
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Mapper
@Repository
public interface FootprintMapper extends BaseMapper<Footprint> {

    /**
     * 根据id实现部分更新
     * @param footprint
     * @return
     */
    Integer updateByPrimaryKeySelective (Footprint footprint);

}
