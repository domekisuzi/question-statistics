package cn.xdc.controller;

import cn.xdc.entity.ReviewRecords;
import cn.xdc.service.IReviewRecordsService;
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
@RequestMapping("/reviewRecords")
@ResponseBody
public class ReviewRecordsController {
    @Autowired
    private  IReviewRecordsService reviewRecordService;




    // 获取所有复习记录
    @GetMapping
    public List<ReviewRecords> getAllReviewRecords() {
        return reviewRecordService.findAll();
    }

    // 根据 ID 获取复习记录
    @GetMapping("/{id}")
    public ReviewRecords getReviewRecordById(@PathVariable Long id) {
        return reviewRecordService.getById(id);
    }

    // 新增复习记录
    @PostMapping
    public void saveReviewRecord(@RequestBody ReviewRecords ReviewRecords) {
        reviewRecordService.save(ReviewRecords);
    }

    // 更新复习记录
    @PutMapping("/{id}")
    public void updateReviewRecord(@PathVariable Long id, @RequestBody ReviewRecords ReviewRecords) {
        ReviewRecords.setId(Math.toIntExact(id));
        reviewRecordService.updateById(ReviewRecords);
    }

    // 删除复习记录
    @DeleteMapping("/{id}")
    public void deleteReviewRecord(@PathVariable Long id) {
        reviewRecordService.removeById(id);
    }

    @GetMapping("/page")
    public Page<ReviewRecords> getPageOfReviewRecords(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size
    ) {
        ArrayList<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.ASC, "id"));
        return reviewRecordService.findAll(PageRequest.of(page, size, Sort.by(orders)));
    }
}
