package multithreaded;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 进程demo
 * @author yinyg
 * @date 2022/5/8
 */
public class ProcessDemo {

    @Test
    public void processDemo() throws IOException {
        Process process = new ProcessBuilder("ls", "-l")
                .directory(new File(ProcessDemo.class.getResource("").getPath()).getAbsoluteFile())
                .start();
        try (Scanner in = new Scanner(process.getInputStream())) {
            while (in.hasNext()) {
                System.out.println(in.nextLine());
            }
        }
    }

}
