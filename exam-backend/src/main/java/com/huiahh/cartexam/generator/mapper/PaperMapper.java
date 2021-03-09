package com.huiahh.cartexam.generator.mapper;

import com.huiahh.cartexam.generator.entity.Paper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 组卷表 Mapper 接口
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Mapper
@Repository
public interface PaperMapper extends BaseMapper<Paper> {

    Integer updateByPrimaryKeySelective (Paper paper);

}
