package cn.xdc.service.impl;

import cn.xdc.entity.KnowledgePoints;
import cn.xdc.mapper.KnowledgePointsMapper;
import cn.xdc.repository.KnowledgePointRepository;
import cn.xdc.service.IKnowledgePointsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author domekisuzi
 * @since 2024-07-11
 */
@Service
public class KnowledgePointsServiceImpl extends ServiceImpl<KnowledgePointsMapper, KnowledgePoints> implements IKnowledgePointsService {
    @Autowired
    private  KnowledgePointRepository knowledgePointRepository;




    @Override
    public List<KnowledgePoints> findAll() {
        return knowledgePointRepository.findAll();
    }


    @Override
    public Page<KnowledgePoints> findAll(PageRequest pageRequest) {
        return knowledgePointRepository.findAll(pageRequest);
    }
}
