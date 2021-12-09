import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yinyg
 * @date 2020/12/7
 * @description
 */
public class HelloWorld {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2 ,3, 4);
        list = list.stream()
                .sorted(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (o1 < 02) {
                            return 1;
                        } else if (o1 > o2) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                })
                .collect(Collectors.toList());
        System.out.println(1);
    }

}
