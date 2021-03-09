package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huiahh.cartexam.generator.entity.dto.CategoryDto;

import java.util.List;

/**
* <p>
* 类目表 服务类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
public interface CategoryService {

    /**
    * 分页查询Category
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author hhq
    * @since 2020-10-18
    */
    Page<Category> listCategorysByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询Category
    *
    * @param id 需要查询的Category的id
    * @return 返回对应id的Category对象
    * @author hhq
    * @since 2020-10-18
    */
    Category getCategoryById(int id);

    /**
    * 插入Category
    *
    * @param category 需要插入的Category对象
    * @return 返回插入成功之后Category对象的id
    * @author hhq
    * @since 2020-10-18
    */
    Integer insertCategory(Category category);

    /**
    * 根据id删除Category
    *
    * @param id 需要删除的Category对象的id
    * @return 返回被删除的Category对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int deleteCategoryById(int id);

    /**
    * 根据id更新Category
    *
    * @param category 需要更新的Category对象
    * @return 返回被更新的Category对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int updateCategory(Category category);

    List<CategoryDto> getCategoryTreeBySections(List<Category> sections);
}
