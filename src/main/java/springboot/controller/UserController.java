package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    /**
     * 根据用户id随机更新用户级别
     *
     * @param user
     * @return springboot.dto.ResultDTO<java.lang.Void>
     * @throws
     * @author yinyg
     * @date 2023/5/5
     */
    @PostMapping("/updateLevelRandomById")
    public ResultDTO<Void> updateLevelRandomById(@RequestBody User user) {
        return userService.updateLevelRandomById(user.getId());
    }

}
