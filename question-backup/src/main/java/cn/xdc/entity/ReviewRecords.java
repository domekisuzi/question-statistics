package cn.xdc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author domekisuzi
 * @since 2024-07-12
 */
@Getter
@Setter
@TableName("review_records")
@Entity
public class ReviewRecords implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 问题id
     */
    private Integer questionId;

    /**
     * 复习时间（可以重复）
     */
    private LocalDateTime reviewTime;

    /**
     * 掌握情况，分熟练，生疏，一般
     */
    private String masteryLevel;

    @Override
    public String toString() {
        return "ReviewRecords{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", reviewTime=" + reviewTime +
                ", masteryLevel='" + masteryLevel + '\'' +
                '}';
    }
}
