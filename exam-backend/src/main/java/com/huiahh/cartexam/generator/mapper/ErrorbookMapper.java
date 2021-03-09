package com.huiahh.cartexam.generator.mapper;

import com.huiahh.cartexam.generator.entity.Errorbook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 错题集 Mapper 接口
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Mapper
@Repository
public interface ErrorbookMapper extends BaseMapper<Errorbook> {

    /**
     * 根据id实现部分更新
     * @param errorbook
     * @return
     */
    Integer updateByPrimaryKeySelective (Errorbook errorbook);

}
