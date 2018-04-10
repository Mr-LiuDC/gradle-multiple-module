package cn.alittler.dto;

import cn.alittler.entity.DemoEntity;
import lombok.Data;

import java.util.Date;

/**
 * DemoDto
 *
 * @author LiuDeCai
 * @date 2018/04/10
 */
@Data
public class DemoDto extends DemoEntity {

    private Long id;

    private String name;

    private Date createTime;

    private Date modifiedTime;

}
