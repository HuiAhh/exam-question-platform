package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.Comment;
import com.huiahh.cartexam.generator.mapper.CommentMapper;
import com.huiahh.cartexam.generator.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.huiahh.cartexam.generator.exception.bizException.BizException;

/**
* <p>
* 评论表 服务实现类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Slf4j
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Override
    public Page<Comment> listCommentsByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询comment: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<Comment> queryWrapper =  new QueryWrapper<Comment>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<Comment> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询comment完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public Comment getCommentById(int id) {
        log.info("正在查询comment中id为{}的数据",id);
        Comment comment = super.getById(id);
        log.info("查询id为{}的comment{}",id,(null == comment?"无结果":"成功"));
        return comment;
    }

    @Override
    public Integer insertComment(Comment comment) {
        log.info("正在插入comment");
        if (super.save(comment)) {
            log.info("插入comment成功,id为{}",comment.getCommentId());
            return comment.getCommentId();
        } else {
            log.error("插入comment失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteCommentById(int id) {
        log.info("正在删除id为{}的comment",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的comment成功",id);
            return id;
        } else {
            log.error("删除id为{}的comment失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateComment(Comment comment) {
        log.info("正在更新id为{}的comment",comment.getCommentId());
        if (super.updateById(comment)) {
            log.info("更新d为{}的comment成功",comment.getCommentId());
            return comment.getCommentId();
        } else {
            log.error("更新id为{}的comment失败",comment.getCommentId());
            throw new BizException("更新失败[id=" + comment.getCommentId() + "]");
        }
    }

}
