package cn.xdc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

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
@Entity
public class Projects implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    @Override
    public String toString() {
        return "Projects{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
