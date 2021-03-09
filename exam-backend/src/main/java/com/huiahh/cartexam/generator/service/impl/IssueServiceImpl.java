package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.Issue;
import com.huiahh.cartexam.generator.mapper.IssueMapper;
import com.huiahh.cartexam.generator.service.IssueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.huiahh.cartexam.generator.exception.bizException.BizException;

/**
* <p>
* 常见问题表 服务实现类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Slf4j
@Service
public class IssueServiceImpl extends ServiceImpl<IssueMapper, Issue> implements IssueService {

    @Override
    public Page<Issue> listIssuesByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询issue: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<Issue> queryWrapper =  new QueryWrapper<Issue>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<Issue> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询issue完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public Issue getIssueById(int id) {
        log.info("正在查询issue中id为{}的数据",id);
        Issue issue = super.getById(id);
        log.info("查询id为{}的issue{}",id,(null == issue?"无结果":"成功"));
        return issue;
    }

    @Override
    public Integer insertIssue(Issue issue) {
        log.info("正在插入issue");
        if (super.save(issue)) {
            log.info("插入issue成功,id为{}",issue.getIssueId());
            return issue.getIssueId();
        } else {
            log.error("插入issue失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteIssueById(int id) {
        log.info("正在删除id为{}的issue",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的issue成功",id);
            return id;
        } else {
            log.error("删除id为{}的issue失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateIssue(Issue issue) {
        log.info("正在更新id为{}的issue",issue.getIssueId());
        if (super.updateById(issue)) {
            log.info("更新d为{}的issue成功",issue.getIssueId());
            return issue.getIssueId();
        } else {
            log.error("更新id为{}的issue失败",issue.getIssueId());
            throw new BizException("更新失败[id=" + issue.getIssueId() + "]");
        }
    }

}
