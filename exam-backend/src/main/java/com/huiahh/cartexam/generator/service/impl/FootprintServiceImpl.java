package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.Footprint;
import com.huiahh.cartexam.generator.mapper.FootprintMapper;
import com.huiahh.cartexam.generator.service.FootprintService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.huiahh.cartexam.generator.exception.bizException.BizException;

/**
* <p>
* 用户浏览足迹表 服务实现类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Slf4j
@Service
public class FootprintServiceImpl extends ServiceImpl<FootprintMapper, Footprint> implements FootprintService {

    @Override
    public Page<Footprint> listFootprintsByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询footprint: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<Footprint> queryWrapper =  new QueryWrapper<Footprint>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<Footprint> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询footprint完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public Footprint getFootprintById(int id) {
        log.info("正在查询footprint中id为{}的数据",id);
        Footprint footprint = super.getById(id);
        log.info("查询id为{}的footprint{}",id,(null == footprint?"无结果":"成功"));
        return footprint;
    }

    @Override
    public Integer insertFootprint(Footprint footprint) {
        log.info("正在插入footprint");
        if (super.save(footprint)) {
            log.info("插入footprint成功,id为{}",footprint.getFootprintId());
            return footprint.getFootprintId();
        } else {
            log.error("插入footprint失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteFootprintById(int id) {
        log.info("正在删除id为{}的footprint",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的footprint成功",id);
            return id;
        } else {
            log.error("删除id为{}的footprint失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateFootprint(Footprint footprint) {
        log.info("正在更新id为{}的footprint",footprint.getFootprintId());
        if (super.updateById(footprint)) {
            log.info("更新d为{}的footprint成功",footprint.getFootprintId());
            return footprint.getFootprintId();
        } else {
            log.error("更新id为{}的footprint失败",footprint.getFootprintId());
            throw new BizException("更新失败[id=" + footprint.getFootprintId() + "]");
        }
    }

}
