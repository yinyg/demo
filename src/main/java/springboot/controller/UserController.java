package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.dto.ResultDTO;
import springboot.pojo.User;
import springboot.service.UserService;

/**
 * 用户controller
 * @author yinyg
 * @date 2023/5/4
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户详情
     *
     * @param id
     * @return springboot.dto.ResultDTO<springboot.pojo.User>
     * @throws
     * @author yinyg
     * @date 2023/5/4
     */
    @GetMapping("/detail")
    public ResultDTO<User> detail(Long id) {
        return userService.getUserById(id);
    }

}
