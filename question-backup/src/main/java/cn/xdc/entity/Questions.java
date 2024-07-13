package cn.xdc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Entity
public class Questions implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Boolean isCorrect;

    private Boolean isWrong;

    private Boolean isGuess;

    private Boolean isUnknown;

    private String remarks;

    private String knowledgeType;

    private String specialPoints;


    @OneToMany(mappedBy = "questions",targetEntity = QuestionKnowledge.class,fetch = FetchType.EAGER)

    private Set<QuestionKnowledge> knowledgePoints =  new HashSet<QuestionKnowledge>();

    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", isCorrect=" + isCorrect +
                ", isWrong=" + isWrong +
                ", isGuess=" + isGuess +
                ", isUnknown=" + isUnknown +
                ", remarks='" + remarks + '\'' +
                ", knowledgeType='" + knowledgeType + '\'' +
                ", specialPoints='" + specialPoints + '\'' +
                ", knowledgePoints=" + knowledgePoints +
                '}';
    }
}
