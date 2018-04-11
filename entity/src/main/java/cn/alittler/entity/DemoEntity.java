package cn.alittler.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * DemoEntity
 *
 * @author LiuDeCai
 * @date 2018/04/10
 */
@Data
@Entity
@ToString
public class DemoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Date createTime;

    private Date modifiedTime;

}
