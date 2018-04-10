package cn.alittler.web.rest;

import cn.alittler.dto.UserDto;
import cn.alittler.entity.User;
import cn.alittler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserRestController
 *
 * @author LiuDeCai
 * @date 2018/03/29
 */
@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    public UserDto save(User user) {
        userService.saveUser(user);
        return
    }

}
