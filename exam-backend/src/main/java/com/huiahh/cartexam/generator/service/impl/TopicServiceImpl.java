package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.Topic;
import com.huiahh.cartexam.generator.mapper.TopicMapper;
import com.huiahh.cartexam.generator.service.TopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.huiahh.cartexam.generator.exception.bizException.BizException;

/**
* <p>
* 专题表 服务实现类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Slf4j
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {

    @Override
    public Page<Topic> listTopicsByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询topic: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<Topic> queryWrapper =  new QueryWrapper<Topic>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<Topic> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询topic完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public Topic getTopicById(int id) {
        log.info("正在查询topic中id为{}的数据",id);
        Topic topic = super.getById(id);
        log.info("查询id为{}的topic{}",id,(null == topic?"无结果":"成功"));
        return topic;
    }

    @Override
    public Integer insertTopic(Topic topic) {
        log.info("正在插入topic");
        if (super.save(topic)) {
            log.info("插入topic成功,id为{}",topic.getTopicId());
            return topic.getTopicId();
        } else {
            log.error("插入topic失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteTopicById(int id) {
        log.info("正在删除id为{}的topic",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的topic成功",id);
            return id;
        } else {
            log.error("删除id为{}的topic失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateTopic(Topic topic) {
        log.info("正在更新id为{}的topic",topic.getTopicId());
        if (super.updateById(topic)) {
            log.info("更新d为{}的topic成功",topic.getTopicId());
            return topic.getTopicId();
        } else {
            log.error("更新id为{}的topic失败",topic.getTopicId());
            throw new BizException("更新失败[id=" + topic.getTopicId() + "]");
        }
    }

}
