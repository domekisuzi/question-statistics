package cn.xdc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
@TableName("knowledge_points")
@Entity
public class KnowledgePoints implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 章节
     */
    private String chapter;

    /**
     * 知识点
     */
    private String point;

    /**
     * 科目id
     */
    private Integer projectId;


    @ManyToMany(mappedBy = "knowledgePoints",fetch = FetchType.EAGER)

    private Set<Questions> questions =  new HashSet<Questions>();

    @Override
    public String toString() {
        return "KnowledgePoints{" +
                "id=" + id +
                ", chapter='" + chapter + '\'' +
                ", point='" + point + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}
