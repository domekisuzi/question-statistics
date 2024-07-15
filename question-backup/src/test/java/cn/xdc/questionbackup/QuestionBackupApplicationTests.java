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

//        for (Questions questions : questionRepository.findAll()) {
//
//            for (KnowledgePoints knowledgePoints : questions.getKnowledgePoints()) {
//                System.out.println(questions.toString() + knowledgePoints.toString());
//            }
//        }


        ArrayList<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.ASC,"id"));
        Page<Questions> all = questionsService.findAll(PageRequest.of(0, 15, Sort.by(orders)));
        System.out.println(all.toString());
//        for (Questions questions : all) {
//
//            for (KnowledgePoints knowledgePoints : questions.getKnowledgePoints()) {
//                System.out.println(questions.toString() + knowledgePoints.toString());
//            }
//        }
    }

}
