package cn.xdc.service.impl;

import cn.xdc.entity.ReviewRecords;
import cn.xdc.mapper.ReviewRecordsMapper;
import cn.xdc.repository.ReviewRecordRepository;
import cn.xdc.service.IReviewRecordsService;
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
public class ReviewRecordsServiceImpl extends ServiceImpl<ReviewRecordsMapper, ReviewRecords> implements IReviewRecordsService {
    @Autowired
    private  ReviewRecordRepository reviewRecordRepository;



    @Override
    public List<ReviewRecords> findAll() {
        return reviewRecordRepository.findAll();
    }

    @Override
    public Page<ReviewRecords> findAll(PageRequest pageRequest) {
        return reviewRecordRepository.findAll(pageRequest);
    }
}
