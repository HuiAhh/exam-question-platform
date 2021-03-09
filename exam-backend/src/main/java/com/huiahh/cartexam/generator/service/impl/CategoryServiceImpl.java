package com.huiahh.cartexam.generator.service.impl;

import com.huiahh.cartexam.generator.entity.Category;
import com.huiahh.cartexam.generator.entity.dto.CategoryDto;
import com.huiahh.cartexam.generator.mapper.CategoryMapper;
import com.huiahh.cartexam.generator.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.huiahh.cartexam.generator.exception.bizException.BizException;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 类目表 服务实现类
 * </p>
 *
 * @author hhq
 * @since 2020-10-18
 */
@Slf4j
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    // 2级查3级 将所有的知识点都封装在children内
    @Override
    public List<CategoryDto> getCategoryTreeBySections(List<Category> sections) {
        List<CategoryDto> sectionsDto = new ArrayList<>();
        for (Category c : sections) {
            //根据章节id 查询所有的知识点
            List<Category> knowledges = categoryMapper.selectKnowledgesBySectionId(c.getCategoryId());
            CategoryDto sectionWithChildren = new CategoryDto(c);
            sectionWithChildren.setChildren(knowledges);    //设置children
            sectionsDto.add(sectionWithChildren);
        }
        return sectionsDto;
    }

    @Override
    public Page<Category> listCategorysByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询category: page = {} pageSize = {} factor = {}", page, pageSize, factor);
        QueryWrapper<Category> queryWrapper = new QueryWrapper<Category>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<Category> result = super.page(new Page<>(page, pageSize));
        log.info("分页查询category完毕: 结果数 = {} ", result.getRecords().size());
        return result;
    }

    @Override
    public Category getCategoryById(int id) {
        log.info("正在查询category中id为{}的数据", id);
        Category category = super.getById(id);
        log.info("查询id为{}的category{}", id, (null == category ? "无结果" : "成功"));
        return category;
    }

    @Override
    public Integer insertCategory(Category category) {
        log.info("正在插入category");
        if (super.save(category)) {
            log.info("插入category成功,id为{}", category.getCategoryId());
            return category.getCategoryId();
        } else {
            log.error("插入category失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteCategoryById(int id) {
        log.info("正在删除id为{}的category", id);
        if (super.removeById(id)) {
            log.info("删除id为{}的category成功", id);
            return id;
        } else {
            log.error("删除id为{}的category失败", id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateCategory(Category category) {
        log.info("正在更新id为{}的category", category.getCategoryId());
        if (super.updateById(category)) {
            log.info("更新d为{}的category成功", category.getCategoryId());
            return category.getCategoryId();
        } else {
            log.error("更新id为{}的category失败", category.getCategoryId());
            throw new BizException("更新失败[id=" + category.getCategoryId() + "]");
        }
    }

}
