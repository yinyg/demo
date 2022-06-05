package jvm;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yinyg
 * @date 2022/5/15
 */
@Getter
@Setter
public class User {

    private int id;
    private String name;

    public void print() {
        System.out.println("User.class for version 2");
    }

}
