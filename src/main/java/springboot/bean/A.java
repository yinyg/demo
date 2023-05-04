package springboot.bean;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author yinyg
 * @date 2022/9/3
 */
@Component("a")
public class A {

    @Resource
    private B b;

    public String sayHello() {
       return "hello world";
    }

}
