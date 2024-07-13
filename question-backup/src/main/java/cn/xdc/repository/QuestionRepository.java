package cn.xdc.repository;

import cn.xdc.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * made by @domekisuzi at
 * 2024/7/10:20:08
 */
@Repository
public interface QuestionRepository   extends JpaRepository<Questions, Long> {

}
