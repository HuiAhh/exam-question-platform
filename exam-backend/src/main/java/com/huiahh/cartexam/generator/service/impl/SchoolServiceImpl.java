package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.School;
import com.huiahh.cartexam.generator.mapper.SchoolMapper;
import com.huiahh.cartexam.generator.service.SchoolService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.huiahh.cartexam.generator.exception.bizException.BizException;

/**
* <p>
* 专业表 服务实现类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Slf4j
@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements SchoolService {

    @Override
    public Page<School> listSchoolsByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询school: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<School> queryWrapper =  new QueryWrapper<School>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<School> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询school完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public School getSchoolById(int id) {
        log.info("正在查询school中id为{}的数据",id);
        School school = super.getById(id);
        log.info("查询id为{}的school{}",id,(null == school?"无结果":"成功"));
        return school;
    }

    @Override
    public Integer insertSchool(School school) {
        log.info("正在插入school");
        if (super.save(school)) {
            log.info("插入school成功,id为{}",school.getSchoolId());
            return school.getSchoolId();
        } else {
            log.error("插入school失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteSchoolById(int id) {
        log.info("正在删除id为{}的school",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的school成功",id);
            return id;
        } else {
            log.error("删除id为{}的school失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateSchool(School school) {
        log.info("正在更新id为{}的school",school.getSchoolId());
        if (super.updateById(school)) {
            log.info("更新d为{}的school成功",school.getSchoolId());
            return school.getSchoolId();
        } else {
            log.error("更新id为{}的school失败",school.getSchoolId());
            throw new BizException("更新失败[id=" + school.getSchoolId() + "]");
        }
    }

}
