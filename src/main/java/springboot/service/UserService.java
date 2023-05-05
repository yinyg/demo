package springboot.service;

import springboot.dto.ResultDTO;
import springboot.pojo.User;

/**
 * 用户接口
 * @author yinyg
 * @date 2023/5/4
 */
public interface UserService {

    /**
     * 获取用户详情
     *
     * @param id
     * @return springboot.dto.ResultDTO<springboot.pojo.User>
     * @throws
     * @author yinyg
     * @date 2023/5/4
     */
    ResultDTO<User> getUserById(Long id);

}
