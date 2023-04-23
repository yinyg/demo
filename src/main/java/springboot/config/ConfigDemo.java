package springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.bean.BeanLifeCycleDemo;

/**
 * @author yinyg
 * @date 2022/9/1
 */
@Configuration("configDemo")
public class ConfigDemo {

    @Bean("c")
    public String c() {
        return "helloworld";
    }

    @Bean(name = "beanLifeCycleDemo", initMethod = "myInit", destroyMethod = "myDestroy")
    public BeanLifeCycleDemo beanLifeCycleDemo() {
        return new BeanLifeCycleDemo();
    }

}
