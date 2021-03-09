package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.Collect;
import com.huiahh.cartexam.generator.mapper.CollectMapper;
import com.huiahh.cartexam.generator.service.CollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.huiahh.cartexam.generator.exception.bizException.BizException;

/**
* <p>
* 收藏表 服务实现类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Slf4j
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {

    @Override
    public Page<Collect> listCollectsByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询collect: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<Collect> queryWrapper =  new QueryWrapper<Collect>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<Collect> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询collect完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public Collect getCollectById(int id) {
        log.info("正在查询collect中id为{}的数据",id);
        Collect collect = super.getById(id);
        log.info("查询id为{}的collect{}",id,(null == collect?"无结果":"成功"));
        return collect;
    }

    @Override
    public Integer insertCollect(Collect collect) {
        log.info("正在插入collect");
        if (super.save(collect)) {
            log.info("插入collect成功,id为{}",collect.getCollectId());
            return collect.getCollectId();
        } else {
            log.error("插入collect失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteCollectById(int id) {
        log.info("正在删除id为{}的collect",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的collect成功",id);
            return id;
        } else {
            log.error("删除id为{}的collect失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateCollect(Collect collect) {
        log.info("正在更新id为{}的collect",collect.getCollectId());
        if (super.updateById(collect)) {
            log.info("更新d为{}的collect成功",collect.getCollectId());
            return collect.getCollectId();
        } else {
            log.error("更新id为{}的collect失败",collect.getCollectId());
            throw new BizException("更新失败[id=" + collect.getCollectId() + "]");
        }
    }

}
