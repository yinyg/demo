package springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.aop.transaction.MyTransaction;
import springboot.dto.ResultDTO;
import springboot.mapper.UserMapper;
import springboot.pojo.User;
import springboot.service.UserService;

import java.util.Random;

/**
 * 用户接口实现类
 * @author yinyg
 * @date 2023/5/4
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 获取用户详情
     *
     * @param id
     * @return springboot.dto.ResultDTO<springboot.pojo.User>
     * @throws
     * @author yinyg
     * @date 2023/5/4
     */
    @Transactional(readOnly = true)
    @Override
    public ResultDTO<User> getUserById(Long id) {
        User user = this.baseMapper.selectById(id);
        return new ResultDTO<User>().data(user);
    }

    /**
     * 根据用户id随机更新用户级别
     *
     * @param id
     * @return springboot.dto.ResultDTO<java.lang.Void>
     * @throws
     * @author yinyg
     * @date 2023/5/5
     */
    @MyTransaction
    @Override
    public ResultDTO<Void> updateLevelRandomById(Long id) {
        User user = this.baseMapper.selectById(id);
        if (user != null) {
            user.setLevel(new Random().nextInt(10) + 1);
            this.baseMapper.updateById(user);
            if (user.getLevel() > 0) {
                throw new RuntimeException();
            }
        }
        return new ResultDTO<Void>();
    }

}
