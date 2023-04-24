package proxy.staticProxy;

/**
 * person代理
 * @author yinyg
 * @date 2023/4/24
 */
public class PersonProxy implements Person{

    /** 被代理的person */
    private Person person;

    public PersonProxy(Person person) {
        this.person = person;
    }

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
        System.out.println("I am a static proxy for Person.");
        person.getJob();
    }

    public static void main(String[] args) {
        Person person = new Engineer();
        PersonProxy personP = new PersonProxy(person);
        personP.getJob();
    }

}
