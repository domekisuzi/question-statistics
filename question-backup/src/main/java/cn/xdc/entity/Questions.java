package cn.xdc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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
    @GeneratedValue
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Boolean isCorrect;

    private Boolean isWrong;

    private Boolean isGuess;

    private Boolean isUnknown;

    private String remarks;

    private String knowledgeType;

    private String specialPoints;

    private Integer questionNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "question_knowledge",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "knowledge_id")
    )


    @JsonIgnoreProperties({"questions"})
    private Set<KnowledgePoints> knowledgePoints =  new HashSet<KnowledgePoints>();

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
                ", questionNumber=" + questionNumber +
                '}';
    }
}
