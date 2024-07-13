package cn.xdc.service.impl;

import cn.xdc.entity.KnowledgePoints;
import cn.xdc.entity.QuestionKnowledge;
import cn.xdc.entity.Questions;
import cn.xdc.mapper.QuestionKnowledgeMapper;
import cn.xdc.service.IQuestionKnowledgeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author domekisuzi
 * @since 2024-07-12
 */
@Service
public class QuestionKnowledgeServiceImpl extends ServiceImpl<QuestionKnowledgeMapper, QuestionKnowledge> implements IQuestionKnowledgeService {


    @Override
    public List<KnowledgePoints> getKnowledgeByQuestion(Integer id) {
        return null;
    }

    @Override
    public List<Questions> getQuestionByKnowledge(Integer id) {
        return null;
    }
}
