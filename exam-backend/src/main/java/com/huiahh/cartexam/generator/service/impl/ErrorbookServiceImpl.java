package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.Errorbook;
import com.huiahh.cartexam.generator.mapper.ErrorbookMapper;
import com.huiahh.cartexam.generator.service.ErrorbookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.huiahh.cartexam.generator.exception.bizException.BizException;

/**
* <p>
* 错题集 服务实现类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Slf4j
@Service
public class ErrorbookServiceImpl extends ServiceImpl<ErrorbookMapper, Errorbook> implements ErrorbookService {

    @Override
    public Page<Errorbook> listErrorbooksByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询errorbook: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<Errorbook> queryWrapper =  new QueryWrapper<Errorbook>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<Errorbook> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询errorbook完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public Errorbook getErrorbookById(int id) {
        log.info("正在查询errorbook中id为{}的数据",id);
        Errorbook errorbook = super.getById(id);
        log.info("查询id为{}的errorbook{}",id,(null == errorbook?"无结果":"成功"));
        return errorbook;
    }

    @Override
    public Integer insertErrorbook(Errorbook errorbook) {
        log.info("正在插入errorbook");
        if (super.save(errorbook)) {
            log.info("插入errorbook成功,id为{}",errorbook.getErrorbookId());
            return errorbook.getErrorbookId();
        } else {
            log.error("插入errorbook失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteErrorbookById(int id) {
        log.info("正在删除id为{}的errorbook",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的errorbook成功",id);
            return id;
        } else {
            log.error("删除id为{}的errorbook失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateErrorbook(Errorbook errorbook) {
        log.info("正在更新id为{}的errorbook",errorbook.getErrorbookId());
        if (super.updateById(errorbook)) {
            log.info("更新d为{}的errorbook成功",errorbook.getErrorbookId());
            return errorbook.getErrorbookId();
        } else {
            log.error("更新id为{}的errorbook失败",errorbook.getErrorbookId());
            throw new BizException("更新失败[id=" + errorbook.getErrorbookId() + "]");
        }
    }

}
