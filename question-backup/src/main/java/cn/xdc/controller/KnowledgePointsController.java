package cn.xdc.controller;

import cn.xdc.entity.KnowledgePoints;
import cn.xdc.service.IKnowledgePointsService;
import cn.xdc.service.impl.KnowledgePointsServiceImpl;
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
 * @since 2024-07-11
 */
@Controller
@RequestMapping("/knowledgePoints")
@ResponseBody
public class KnowledgePointsController {

    @Autowired
    private  IKnowledgePointsService knowledgePointService;




    // 获取所有知识点
    @GetMapping
    public List<KnowledgePoints> getAllKnowledgePoints() {
        return knowledgePointService.findAll();
    }

    // 根据 ID 获取知识点
    @GetMapping("/{id}")
    public KnowledgePoints getKnowledgePointById(@PathVariable Long id) {
        return knowledgePointService.getById(id);
    }

    // 新增知识点
    @PostMapping
    public void saveKnowledgePoint(@RequestBody KnowledgePoints knowledgePoint) {
        knowledgePointService.save(knowledgePoint);
    }

    // 更新知识点
    @PutMapping("/{id}")
    public void updateKnowledgePoint(@PathVariable Long id, @RequestBody KnowledgePoints knowledgePoint) {
        knowledgePoint.setId(Math.toIntExact(id));
        knowledgePointService.updateById(knowledgePoint);
    }

    // 删除知识点
    @DeleteMapping("/{id}")
    public void deleteKnowledgePoint(@PathVariable Long id) {
        knowledgePointService.removeById(id);
    }

    @GetMapping("/page")
    public Page<KnowledgePoints> getPageOfKnowledgePoints(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size
    ) {
        ArrayList<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.ASC, "id"));
        return knowledgePointService.findAll(PageRequest.of(page, size, Sort.by(orders)));
    }
}
