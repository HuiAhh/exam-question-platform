package com.huiahh.cartexam.generator.controller;


import com.huiahh.cartexam.generator.entity.dto.CategoryDto;
import com.huiahh.cartexam.generator.entity.dto.SubjectsDto;
import com.huiahh.cartexam.generator.mapper.CategoryMapper;
import com.huiahh.cartexam.generator.util.CategoryUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.huiahh.cartexam.generator.entity.dto.ResultBean;
import com.huiahh.cartexam.generator.service.CategoryService;
import com.huiahh.cartexam.generator.entity.Category;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 类目表 前端控制器
 * </p>
 *
 * @author hhq
 * @version v1.0
 * @since 2020-10-18
 */
@RestController
@RequestMapping("/generator/api/v1/category")
@Api(tags = "对类目表的操作 多级目录")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询分页数据
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<?> listByPage(@RequestParam(name = "page", defaultValue = "1") int page,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    @RequestParam(name = "factor", defaultValue = "") String factor) {
        return new ResultBean<>(categoryService.listCategorysByPage(page, pageSize, factor));
    }

    @ApiOperation("根据分级查列表：0未指定，1学科，2章节，3知识点")
    @RequestMapping(method = RequestMethod.GET, value = "/level")
    public ResultBean<?> listByLevel(@RequestParam(name = "level", defaultValue = "1") Integer level) {
        return new ResultBean<>(categoryMapper.selectByLevel(level));
    }

    //
    @RequestMapping(method = RequestMethod.GET, value = "/list-knowledge-points")
    @ApiOperation("根据pId返回一个能让element-ui级联选择器解析到的数据, 查询pid对应的所有章节, 高数->{导数, 极限}")
    public ResultBean<?> listByCourse(@RequestParam(name = "courseId") Integer courseId) {
        //1级查2级 根据学科id查询所有的章节
        List<Category> sections = categoryMapper.selectSectionsByCourse(courseId);
//        CategoryUtils.getSectionIds(sections);
//        List<Category> knowledges=categoryMapper.selectBySections()
//        List<CategoryDto> categoryDtos = CategoryUtils.convertToTreeList(categories);
        // 2级查3级 根据章节id查询所有的知识点
        List<CategoryDto> categoryDtos = categoryService.getCategoryTreeBySections(sections);
        return new ResultBean<>(categoryDtos);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listgetAll")
    @ApiOperation("查询所有学科,学科对应的章节和知识点都查询出来")
    public ResultBean<?> findAll () {
        //1. 查询数据库中所有level为1的category
        List<Category> categories = categoryMapper.selectByLevel(1);
        List<SubjectsDto> subjectsDtos = new ArrayList<>();
        for (Category category : categories) {
            subjectsDtos.add(new SubjectsDto(category));
        }
        //对每个学科内的章节进行封装
        for (SubjectsDto subjectDto : subjectsDtos) {
            //获取学科id
            int subjectId = subjectDto.getCategoryId();
            //1级查2级 根据学科id查询所有的章节
            List<Category> sections = categoryMapper.selectSectionsByCourse(subjectId);
            // 2级查3级 根据章节id查询所有的知识点
            List<CategoryDto> categoryDtos = categoryService.getCategoryTreeBySections(sections);
            subjectDto.setChapters(categoryDtos);
//            System.out.println(subjectDto.getName());
//            for (CategoryDto categoryDto : subjectDto.getChapters()) {
//                System.out.println(categoryDto.getName());
//                for (Category category : categoryDto.getChildren()) {
//                    System.out.print(category.getName() + ",");
//                }
//                System.out.println();
//            }
        }
        return new ResultBean<>(subjectsDtos);
    }


    /**
     * 根据id查询
     */
    @ApiOperation(value = "根据id查询目录信息")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResultBean<?> getById(@PathVariable("id") Integer id) {
        return new ResultBean<>(categoryService.getCategoryById(id));
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增目录信息")
    @RequestMapping(method = RequestMethod.POST)
    public ResultBean<?> insert(@RequestBody Category category) {
        return new ResultBean<>(categoryService.insertCategory(category));
    }

    /**
     * 删除
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResultBean<?> deleteById(@PathVariable("id") Integer id) {
        return new ResultBean<>(categoryService.deleteCategoryById(id));
    }

    /**
     * 修改
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultBean<?> updateById(@RequestBody Category category) {
        return new ResultBean<>(categoryService.updateCategory(category));
    }

    @ApiOperation(value = "部分更新category信息")
    @RequestMapping(method = RequestMethod.PUT, value = "updateSelective")
    public ResultBean<?> updateByPrimaryKeySelective (@RequestBody Category category) {
        return new ResultBean<>(categoryMapper.updateByPrimaryKeySelective(category));
    }

}
