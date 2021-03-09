package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.Paper;
import com.huiahh.cartexam.generator.mapper.PaperMapper;
import com.huiahh.cartexam.generator.service.PaperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.huiahh.cartexam.generator.exception.bizException.BizException;

/**
* <p>
* 组卷表 服务实现类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Slf4j
@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService {

    @Override
    public Page<Paper> listPapersByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询paper: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<Paper> queryWrapper =  new QueryWrapper<Paper>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<Paper> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询paper完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public Paper getPaperById(int id) {
        log.info("正在查询paper中id为{}的数据",id);
        Paper paper = super.getById(id);
        log.info("查询id为{}的paper{}",id,(null == paper?"无结果":"成功"));
        return paper;
    }

    @Override
    public Integer insertPaper(Paper paper) {
        log.info("正在插入paper");
        if (super.save(paper)) {
            log.info("插入paper成功,id为{}",paper.getPaperId());
            return paper.getPaperId();
        } else {
            log.error("插入paper失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deletePaperById(int id) {
        log.info("正在删除id为{}的paper",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的paper成功",id);
            return id;
        } else {
            log.error("删除id为{}的paper失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updatePaper(Paper paper) {
        log.info("正在更新id为{}的paper",paper.getPaperId());
        if (super.updateById(paper)) {
            log.info("更新d为{}的paper成功",paper.getPaperId());
            return paper.getPaperId();
        } else {
            log.error("更新id为{}的paper失败",paper.getPaperId());
            throw new BizException("更新失败[id=" + paper.getPaperId() + "]");
        }
    }

}
