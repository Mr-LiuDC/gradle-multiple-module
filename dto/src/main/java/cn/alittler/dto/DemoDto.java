package cn.alittler.dto;

import cn.alittler.entity.DemoEntity;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * DemoDto
 *
 * @author LiuDeCai
 * @date 2018/04/10
 */
@Data
@ToString
public class DemoDto implements Serializable {

    private Long id;

    private String name;

    private Date createTime;

    private Date modifiedTime;

}
