package cn.xdc.controller;

import cn.xdc.entity.Questions;
import cn.xdc.service.IQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author domekisuzi
 * @since 2024-07-10
 */
@Controller
@RequestMapping("/questions")

//坑点之一，没加ResponseBody 直接404而且不会有报错
@ResponseBody
public class QuestionsController {
    @Autowired
    private  IQuestionsService questionsService;


    // 获取所有问题
    @GetMapping
    public List<Questions> getAllQuestions() {
        return questionsService.list();
    }


    // 根据 ID 获取问题
    @GetMapping("/{id}")
    public Questions getQuestionById(@PathVariable Long id) {
        return questionsService.getById(id);
    }

    // 新增问题
    @PostMapping
    public void saveQuestion(@RequestBody Questions question) {

        questionsService.addQuestion(question);
    }


    // 更新问题
    @PutMapping("/{id}")
    public void updateQuestion(@PathVariable Long id, @RequestBody Questions question) {
        question.setId(Math.toIntExact(id));
        questionsService.updateById(question);
    }

    // 删除问题
//    @DeleteMapping("/{id}")
//    public void deleteQuestion(@PathVariable Long id) {
//        questionsService.removeById(id);
//    }

    @GetMapping("/page")
    public Page<Questions> getPageOfQuestions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size
    ) {
//        排序
        ArrayList<Sort.Order> orders = new ArrayList<>();
        System.out.println("获取到的id为"+page);
        orders.add(new Sort.Order(Sort.Direction.ASC,"id"));
        Page<Questions> all = questionsService.findAll(PageRequest.of(page, size, Sort.by(orders)));

        return all;
    }
}
