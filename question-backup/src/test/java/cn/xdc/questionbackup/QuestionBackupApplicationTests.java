package cn.xdc.questionbackup;

import cn.xdc.entity.KnowledgePoints;

import cn.xdc.entity.Questions;
import cn.xdc.mapper.QuestionsMapper;
import cn.xdc.repository.KnowledgePointRepository;
import cn.xdc.repository.QuestionRepository;
import cn.xdc.service.IQuestionsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
class QuestionBackupApplicationTests {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    KnowledgePointRepository knowledgePointRepository;

    @Autowired
    private IQuestionsService questionsService;
    @Test
    void contextLoads() {
        Questions questions = new Questions();
        questions.setIsCorrect(true);
        KnowledgePoints knowledgePoints = new KnowledgePoints();
        knowledgePoints.setChapter("1");
        knowledgePoints.setPoint("洛必达法则");
        knowledgePoints.setProjectId(1);
        knowledgePoints.setId(1);
        questions.setSpecialPoints("hhh");
        questions.setId(5);
        HashSet<KnowledgePoints> knowledgePoints1 = new HashSet<>();
        knowledgePoints1.add(knowledgePoints);
        questions.setKnowledgePoints(  knowledgePoints1);
        questionsService.addQuestion(questions);





    }

}
