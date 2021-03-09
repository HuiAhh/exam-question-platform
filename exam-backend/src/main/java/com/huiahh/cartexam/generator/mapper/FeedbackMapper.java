package com.huiahh.cartexam.generator.mapper;

import com.huiahh.cartexam.generator.entity.Feedback;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 意见反馈表 Mapper 接口
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Mapper
@Repository
public interface FeedbackMapper extends BaseMapper<Feedback> {

    /**
     * 根据id实现部分更新
     * @param feedback
     * @return
     */
    Integer updateByPrimaryKeySelective (Feedback feedback);

}
