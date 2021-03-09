package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.Feedback;
import com.huiahh.cartexam.generator.mapper.FeedbackMapper;
import com.huiahh.cartexam.generator.service.FeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.huiahh.cartexam.generator.exception.bizException.BizException;

/**
* <p>
* 意见反馈表 服务实现类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Slf4j
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {

    @Override
    public Page<Feedback> listFeedbacksByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询feedback: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<Feedback> queryWrapper =  new QueryWrapper<Feedback>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<Feedback> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询feedback完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public Feedback getFeedbackById(int id) {
        log.info("正在查询feedback中id为{}的数据",id);
        Feedback feedback = super.getById(id);
        log.info("查询id为{}的feedback{}",id,(null == feedback?"无结果":"成功"));
        return feedback;
    }

    @Override
    public Integer insertFeedback(Feedback feedback) {
        log.info("正在插入feedback");
        if (super.save(feedback)) {
            log.info("插入feedback成功,id为{}",feedback.getFeedbackId());
            return feedback.getFeedbackId();
        } else {
            log.error("插入feedback失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteFeedbackById(int id) {
        log.info("正在删除id为{}的feedback",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的feedback成功",id);
            return id;
        } else {
            log.error("删除id为{}的feedback失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateFeedback(Feedback feedback) {
        log.info("正在更新id为{}的feedback",feedback.getFeedbackId());
        if (super.updateById(feedback)) {
            log.info("更新d为{}的feedback成功",feedback.getFeedbackId());
            return feedback.getFeedbackId();
        } else {
            log.error("更新id为{}的feedback失败",feedback.getFeedbackId());
            throw new BizException("更新失败[id=" + feedback.getFeedbackId() + "]");
        }
    }

}
