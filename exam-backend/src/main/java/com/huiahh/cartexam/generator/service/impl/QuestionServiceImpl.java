package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.Question;
import com.huiahh.cartexam.generator.mapper.QuestionMapper;
import com.huiahh.cartexam.generator.service.QuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.huiahh.cartexam.generator.exception.bizException.BizException;

/**
* <p>
* 题目表 服务实现类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Slf4j
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

    @Override
    public Page<Question> listQuestionsByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询question: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<Question> queryWrapper =  new QueryWrapper<Question>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<Question> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询question完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public Question getQuestionById(int id) {
        log.info("正在查询question中id为{}的数据",id);
        Question question = super.getById(id);
        log.info("查询id为{}的question{}",id,(null == question?"无结果":"成功"));
        return question;
    }

    @Override
    public Integer insertQuestion(Question question) {
        log.info("正在插入question");
        if (super.save(question)) {
            log.info("插入question成功,id为{}",question.getQuestionId());
            return question.getQuestionId();
        } else {
            log.error("插入question失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteQuestionById(int id) {
        log.info("正在删除id为{}的question",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的question成功",id);
            return id;
        } else {
            log.error("删除id为{}的question失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateQuestion(Question question) {
        log.info("正在更新id为{}的question",question.getQuestionId());
        if (super.updateById(question)) {
            log.info("更新d为{}的question成功",question.getQuestionId());
            return question.getQuestionId();
        } else {
            log.error("更新id为{}的question失败",question.getQuestionId());
            throw new BizException("更新失败[id=" + question.getQuestionId() + "]");
        }
    }

}
