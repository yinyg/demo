package springboot.aop;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author yinyg
 * @date 2023/5/4
 */
public class MyPointcut extends StaticMethodMatcherPointcut {

    /**
     * matches
     *
     * @param method
     * @param targetClass
     * @return boolean
     * @throws
     * @author yinyg
     * @date 2023/5/4
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "springboot.bean.A".equals(targetClass.getName());
    }

}
