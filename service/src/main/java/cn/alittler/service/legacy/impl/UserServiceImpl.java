package cn.alittler.service.legacy.impl;

import cn.alittler.dto.UserDto;
import cn.alittler.entity.User;
import cn.alittler.repository.UserRepository;
import cn.alittler.service.legacy.UserService;
import cn.alittler.utils.date.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @author LiuDeCai
 * @date 2018/03/29
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDto saveUser(String name, String birthday) {
        UserDto userDto = new UserDto();
        User user = new User();
        user.setName(name);
        user.setBirthday(DateUtils.parse(birthday, "yyyy-MM-dd"));
        userRepository.save(user);
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    @Override
    public UserDto updateUser(Long id, String name, String birthday) {
        UserDto userDto = new UserDto();
        User user = userRepository.findOne(id);
        user.setName(name);
        user.setBirthday(DateUtils.parse(birthday, "yyyy-MM-dd HH:mm:ss"));
        userRepository.saveAndFlush(user);
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.delete(id);
    }

    @Override
    public UserDto getById(Long id) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRepository.getOne(id), userDto);
        return userDto;
    }
}
