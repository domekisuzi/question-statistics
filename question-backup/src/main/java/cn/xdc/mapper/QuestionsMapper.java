package cn.xdc.mapper;

import cn.xdc.entity.KnowledgePoints;
import cn.xdc.entity.Questions;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author domekisuzi
 * @since 2024-07-10
 */
public interface QuestionsMapper extends BaseMapper<Questions> {
    @Results({
            @Result(column = "id" ,  property = "id"),
            @Result(column = "id", property = "knowledge_points",many = @Many(select = "cn.xdc.mapper.KnowledgePointsMapper."))
    })
    @Select("SELECT  * FROM question_knowledge WHERE question_id = #{id}")
    List<KnowledgePoints> getKnowledgePointsByQuestion(Integer id);
}
