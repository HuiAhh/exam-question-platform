package com.huiahh.cartexam.generator.mapper;

import com.huiahh.cartexam.generator.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huiahh.cartexam.generator.entity.dto.SubjectsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
* <p>
* 类目表 Mapper 接口
* </p>
*
* @author hhq
* @since 2020-10-18
*/
@Mapper
@Repository
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 查询学subjectId对应的章节数量
     * @param subjectId
     * @return
     */
    int findCountChapterById(@Param("subjectId") Integer subjectId);

    /**
     * 根据分类层级查询, level分类层级，默认为0。0未指定、1学科、2章节、3知识点
     * @param level
     * @return
     */
    List<Category> selectByLevel(@Param("level") Integer level);

    /**
     * 查询pid对应的所有章节, 高数->{导数, 极限}
     * @param subjectId
     * @return
     */
    List<Category> selectSectionsByCourse(Integer subjectId);

    /**
     * 根据章节id查询对应的全部知识点
     * @param chapterId
     * @return
     */
    List<Category> selectKnowledgesBySectionId(Integer chapterId);

    /**
     * 根据id实现部分更新
     * @param category
     * @return
     */
    Integer updateByPrimaryKeySelective (Category category);
}
