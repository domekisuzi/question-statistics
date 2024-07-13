package cn.xdc.service;

import cn.xdc.entity.KnowledgePoints;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author domekisuzi
 * @since 2024-07-11
 */
public interface IKnowledgePointsService extends IService<KnowledgePoints> {
    List<KnowledgePoints> findAll();

    Page<KnowledgePoints> findAll(PageRequest pageRequest);
}
