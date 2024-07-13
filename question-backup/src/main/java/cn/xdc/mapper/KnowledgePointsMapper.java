package cn.xdc.mapper;

import cn.xdc.entity.KnowledgePoints;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author domekisuzi
 * @since 2024-07-11
 */
public interface KnowledgePointsMapper extends BaseMapper<KnowledgePoints> {
    @Select("SELECT  * FROM question_knowledge WHERE knowledge_id = #{id}")
    List<KnowledgePoints> getQuestionsByKnowledgePoint(Integer id);



}
