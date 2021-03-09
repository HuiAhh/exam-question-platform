package com.huiahh.cartexam.generator.mapper;

import com.huiahh.cartexam.generator.entity.Issue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 常见问题表 Mapper 接口
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Mapper
@Repository
public interface IssueMapper extends BaseMapper<Issue> {

    /**
     * 更新部分常见问题表
     * @param issue
     * @return
     */
    Integer updateByPrimaryKeySelective (Issue issue);


}
