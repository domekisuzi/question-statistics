package cn.xdc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@TableName("question_knowledge")
@Entity
public class QuestionKnowledge implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    private Integer questionId;
//
//    @Id
//    private Integer knowledgeId;

    @Id
    @ManyToOne(targetEntity = Questions.class)
    @JoinColumn(name = "question_id",referencedColumnName = "id")
    private Questions questions;

    @Id
    @ManyToOne(targetEntity = KnowledgePoints.class)
    @JoinColumn(name = "knowledge_id",referencedColumnName = "id")
    private KnowledgePoints knowledgePoints;


}
