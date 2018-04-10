package cn.alittler.service.impl;

import cn.alittler.dto.UserDto;
import cn.alittler.entity.User;
import cn.alittler.repository.UserRepository;
import cn.alittler.service.UserService;
import cn.alittler.utils.date.DateUtils;

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
    public UserDto saveUser(String name,String birthday) {
        User user = new User();
        user.setName(name);
        user.setBirthday(DateUtils.parse(birthday, "yyyy-MM-dd"));
        return userRepository.save(user);
    }

    @Override
    public UserDto updateUser(Long id,String name,String birthday) {
        User user = userRepository.findOne(id);
        user.setName(name);
        user.setBirthday(birthday);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }
}
