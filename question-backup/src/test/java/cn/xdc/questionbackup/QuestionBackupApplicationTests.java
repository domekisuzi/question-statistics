package cn.xdc.questionbackup;

import cn.xdc.entity.KnowledgePoints;

import cn.xdc.entity.Questions;
import cn.xdc.mapper.QuestionsMapper;
import cn.xdc.repository.KnowledgePointRepository;
import cn.xdc.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuestionBackupApplicationTests {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    KnowledgePointRepository knowledgePointRepository;
    @Test
    void contextLoads() {
        for (Questions questions : questionRepository.findAll()) {

            for (KnowledgePoints knowledgePoints : questions.getKnowledgePoints()) {
                System.out.println(questions.toString() + knowledgePoints.toString());
            }
        }
    }

}
