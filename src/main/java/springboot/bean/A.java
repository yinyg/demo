package springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yinyg
 * @date 2022/9/3
 */
@Component("a")
public class A {
    @Autowired
    private B b;
}
