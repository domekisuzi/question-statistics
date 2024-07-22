package cn.xdc.service.impl;

import cn.xdc.entity.KnowledgePoints;
import cn.xdc.entity.Questions;
import cn.xdc.mapper.QuestionsMapper;
import cn.xdc.repository.KnowledgePointRepository;
import cn.xdc.repository.QuestionRepository;
import cn.xdc.service.IQuestionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author domekisuzi
 * @since 2024-07-10
 */

@Service
public class QuestionsServiceImpl extends ServiceImpl<QuestionsMapper, Questions> implements IQuestionsService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private KnowledgePointRepository knowledgePointRepository;
    @Override
    public Page<Questions> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }





//    Optional 可以用于处理空值
    @Override
    public Questions addQuestion(Questions question) {
        List<KnowledgePoints> attachedKnowledgePoints = new ArrayList<>();
        for (KnowledgePoints kp : question.getKnowledgePoints()) {
           knowledgePointRepository.findById(kp.getId())
                    .ifPresent(attachedKnowledgePoints::add);
        }

        question.setKnowledgePoints(new HashSet<>(attachedKnowledgePoints)  );
        return questionRepository.save(question);
    }


}
