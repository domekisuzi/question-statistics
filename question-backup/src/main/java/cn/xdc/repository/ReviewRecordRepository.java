package cn.xdc.repository;

import cn.xdc.entity.ReviewRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRecordRepository  extends JpaRepository<ReviewRecords, Integer> {
}
