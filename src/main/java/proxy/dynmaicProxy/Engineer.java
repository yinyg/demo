package proxy.dynmaicProxy;

/**
 * 工程师
 * @author yinyg
 * @date 2023/4/24
 */
public class Engineer implements Person {

    /**
     * 获取工作名称
     *
     * @return java.lang.String
     * @throws
     * @author yinyg
     * @date 2023/4/24
     */
    @Override
    public void getJob() {
        System.out.println("I am an engineer.");
    }

}
