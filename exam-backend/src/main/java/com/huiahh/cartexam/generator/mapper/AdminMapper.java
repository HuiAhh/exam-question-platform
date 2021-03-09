package com.huiahh.cartexam.generator.mapper;

import com.huiahh.cartexam.generator.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
* <p>
* 管理员表 Mapper 接口
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Mapper
@Repository
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 部分更新
     * @param admin
     * @return
     */
    int updateByPrimaryKeySelective(Admin admin);

}
