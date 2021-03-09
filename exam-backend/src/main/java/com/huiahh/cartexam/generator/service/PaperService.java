package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.Paper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 组卷表 服务类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
public interface PaperService {

    /**
    * 分页查询Paper
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author hhq
    * @since 2020-10-18
    */
    Page<Paper> listPapersByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询Paper
    *
    * @param id 需要查询的Paper的id
    * @return 返回对应id的Paper对象
    * @author hhq
    * @since 2020-10-18
    */
    Paper getPaperById(int id);

    /**
    * 插入Paper
    *
    * @param paper 需要插入的Paper对象
    * @return 返回插入成功之后Paper对象的id
    * @author hhq
    * @since 2020-10-18
    */
    Integer insertPaper(Paper paper);

    /**
    * 根据id删除Paper
    *
    * @param id 需要删除的Paper对象的id
    * @return 返回被删除的Paper对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int deletePaperById(int id);

    /**
    * 根据id更新Paper
    *
    * @param paper 需要更新的Paper对象
    * @return 返回被更新的Paper对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int updatePaper(Paper paper);

}
