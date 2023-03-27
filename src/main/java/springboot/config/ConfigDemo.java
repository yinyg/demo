package springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.bean.LifeCycleDemo;

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

    @Bean(name = "lifeCycleDemo", initMethod = "init", destroyMethod = "destroy")
    public LifeCycleDemo lifeCycleDemo() {
        return new LifeCycleDemo();
    }

}
