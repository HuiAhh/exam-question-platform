package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.Major;
import com.huiahh.cartexam.generator.mapper.MajorMapper;
import com.huiahh.cartexam.generator.service.MajorService;
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
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements MajorService {

    @Override
    public Page<Major> listMajorsByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询major: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<Major> queryWrapper =  new QueryWrapper<Major>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<Major> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询major完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public Major getMajorById(int id) {
        log.info("正在查询major中id为{}的数据",id);
        Major major = super.getById(id);
        log.info("查询id为{}的major{}",id,(null == major?"无结果":"成功"));
        return major;
    }

    @Override
    public Integer insertMajor(Major major) {
        log.info("正在插入major");
        if (super.save(major)) {
            log.info("插入major成功,id为{}",major.getMajorId());
            return major.getMajorId();
        } else {
            log.error("插入major失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteMajorById(int id) {
        log.info("正在删除id为{}的major",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的major成功",id);
            return id;
        } else {
            log.error("删除id为{}的major失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateMajor(Major major) {
        log.info("正在更新id为{}的major",major.getMajorId());
        if (super.updateById(major)) {
            log.info("更新d为{}的major成功",major.getMajorId());
            return major.getMajorId();
        } else {
            log.error("更新id为{}的major失败",major.getMajorId());
            throw new BizException("更新失败[id=" + major.getMajorId() + "]");
        }
    }

}
