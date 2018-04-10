package cn.alittler.dto;

import java.util.Date;

import lombok.Data;

/**
 * UserDto
 *
 * @author LiuDeCai
 * @date 2018/03/29
 */
@Data
public class UserDto {

    private Long id;

    private String name;

    private Date birthday;

    private Date createTime;
}
