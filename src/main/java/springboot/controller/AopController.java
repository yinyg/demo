package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.bean.A;

/**
 * @author yinyg
 * @date 2023/5/4
 */
@RestController
@RequestMapping("/aop")
public class AopController {

    @Autowired
    public A a;

    /**
     * sayHello
     *
     * @return java.lang.String
     * @throws
     * @author yinyg
     * @date 2023/5/4
     */
    @GetMapping("/sayHello")
    public String sayHello() {
        return a.sayHello();
    }

}
