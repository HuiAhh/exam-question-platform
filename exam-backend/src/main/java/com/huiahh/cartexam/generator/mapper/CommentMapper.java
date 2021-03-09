package com.huiahh.cartexam.generator.mapper;

import com.huiahh.cartexam.generator.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 评论表 Mapper 接口
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Mapper
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * 根据id实现部分更新
     * @param comment
     * @return
     */
    Integer updateByPrimaryKeySelective (Comment comment);

}
