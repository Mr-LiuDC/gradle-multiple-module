package cn.alittler.service;

import cn.alittler.dto.UserDto;
import cn.alittler.entity.User;

/**
 * UserService
 *
 * @author LiuDeCai
 * @date 2018/03/29
 */
public interface UserService {

    UserDto saveUser(String name,String birthday);

    UserDto updateUser(Long id,String name,String birthday);

    void deleteUserById(Long id);

    UserDto getById(Long id);
}
