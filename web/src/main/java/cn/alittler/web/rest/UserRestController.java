package cn.alittler.web.rest;

import cn.alittler.dto.UserDto;
import cn.alittler.service.legacy.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping
    public UserDto save(@RequestParam String name, @RequestParam String birthday) {
        return userService.saveUser(name, birthday);
    }

}
