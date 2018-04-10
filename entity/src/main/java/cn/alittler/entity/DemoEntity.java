package cn.alittler.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * DemoEntity
 *
 * @author LiuDeCai
 * @date 2018/04/10
 */
@Data
public class DemoEntity implements Serializable {

    private Long id;

    private String name;

    private Date createTime;

    private Date modifiedTime;

}
