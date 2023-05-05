package springboot.aop.transaction;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.AnnotationUtils;
import springboot.service.impl.UserServiceImpl;

import java.lang.reflect.Method;

/**
 * 自定义注解切点
 * @author yinyg
 * @date 2023/5/5
 */
public class MyTransactionPointcut extends StaticMethodMatcherPointcut {

    /**
     * matches
     *
     * @param method
     * @param targetClass
     * @return boolean
     * @throws
     * @author yinyg
     * @date 2023/5/5
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        Object annotation = AnnotationUtils.findAnnotation(method, MyTransaction.class);
        if (annotation == null) {
            annotation = AnnotationUtils.findAnnotation(targetClass, MyTransaction.class);
        }
        return annotation != null;
    }

    public static void main(String[] args) {
        MyTransactionPointcut myTransactionPointcut = new MyTransactionPointcut();
        Class<?> clazz = UserServiceImpl.class;
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println("Is method " + m.getName() + " has annotation MyTransaction.class: " + myTransactionPointcut.matches(m, clazz));
        }
    }

}
