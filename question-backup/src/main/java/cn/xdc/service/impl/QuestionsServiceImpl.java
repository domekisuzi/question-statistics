package cn.xdc.service.impl;

import cn.xdc.entity.KnowledgePoints;
import cn.xdc.entity.Questions;
import cn.xdc.mapper.QuestionsMapper;
import cn.xdc.repository.QuestionRepository;
import cn.xdc.service.IQuestionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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


    @Override
    public Page<Questions> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    public List<Questions> getQuestionsByKnowledgePoint(Integer id){
        return null;
    }
}
