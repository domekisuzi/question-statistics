package cn.xdc.service;

import cn.xdc.entity.KnowledgePoints;
import cn.xdc.entity.QuestionKnowledge;
import cn.xdc.entity.Questions;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author domekisuzi
 * @since 2024-07-12
 */
public interface IQuestionKnowledgeService extends IService<QuestionKnowledge> {
    List<KnowledgePoints> getKnowledgeByQuestion(Integer id);


    List<Questions> getQuestionByKnowledge(Integer id);
}
