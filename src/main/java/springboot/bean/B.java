package springboot.bean;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author yinyg
 * @date 2022/9/3
 */
@Component("b")
public class B {
    @Resource
    private A a;
}
