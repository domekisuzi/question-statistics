package cn.xdc.service;

import cn.xdc.entity.Questions;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author domekisuzi
 * @since 2024-07-10
 */
public interface IQuestionsService extends IService<Questions> {

      Page<Questions> findAll(Pageable pageable);

    Questions addQuestion(Questions question);
}
