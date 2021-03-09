package com.huiahh.cartexam.generator.service;

import com.huiahh.cartexam.generator.entity.Topic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 专题表 服务类
* </p>
*
* @author hhq
* @since 2020-10-18
*/
public interface TopicService {

    /**
    * 分页查询Topic
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author hhq
    * @since 2020-10-18
    */
    Page<Topic> listTopicsByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询Topic
    *
    * @param id 需要查询的Topic的id
    * @return 返回对应id的Topic对象
    * @author hhq
    * @since 2020-10-18
    */
    Topic getTopicById(int id);

    /**
    * 插入Topic
    *
    * @param topic 需要插入的Topic对象
    * @return 返回插入成功之后Topic对象的id
    * @author hhq
    * @since 2020-10-18
    */
    Integer insertTopic(Topic topic);

    /**
    * 根据id删除Topic
    *
    * @param id 需要删除的Topic对象的id
    * @return 返回被删除的Topic对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int deleteTopicById(int id);

    /**
    * 根据id更新Topic
    *
    * @param topic 需要更新的Topic对象
    * @return 返回被更新的Topic对象的id
    * @author hhq
    * @since 2020-10-18
    */
    int updateTopic(Topic topic);

}
