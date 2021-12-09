package util;

import java.io.*;

/**
 * @author yinyg
 * @date 2021/11/18
 * @description 代码对比更新工具类
 */
public class CodeCompareUtils {

    /**
     * @param targetDir 目标路径
     * @param sourceDir 源路径
     * @throws
     * @description
     * @author yinyg
     * @date 2021/11/18
     */
    public void compareAndUpdate(String targetDir, String sourceDir) {
        File root = new File(targetDir);
        String[] names = root.list();
        if (names == null || names.length == 0) {
            return;
        }
        File targetFile, sourceFile;
        for (String name : names) {
            targetFile = new File(targetDir + "/" + name);
            sourceFile = new File(sourceDir + "/" + name.replace("Cashier", "App"));
            if (targetFile == null || sourceFile == null) {
                continue;
            }
            if (targetFile.isDirectory()) {
                compareAndUpdate(targetDir + "/" + name, sourceDir + "/" + name.replace("Cashier", "App"));
            }
            if (targetFile.isFile() && sourceFile.isFile()) {
                try {
                    write(targetFile, sourceFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void write(File targetFile, File sourceFile) throws IOException {
        targetFile.delete();
        Writer writer = new FileWriter(targetFile);
        Reader reader = new FileReader(sourceFile);
        // 假设代码文件最大为 10M
        char[] buffer = new char[10000000];
        int count = reader.read(buffer);
        String code = new String(buffer, 0, count);
        code = code.replaceAll("\\.appserver", ".cashier"); // 替换包名
        code = code.replaceAll("\\.utils", ".util"); // 替换包名
        code = code.replaceAll("\\.App", ".Cashier"); // 替换包名
        code = code.replaceAll(" App", " Cashier"); // 替换类名
        code = code.replaceAll(" app", " cashier"); // 替换bean名称
        code = code.replaceAll("toApp", "toCashier"); // 替换方法名
        code = code.replaceAll("\\.app", ".cashier"); // 替换方法名

        // 恢复误改
        code = code.replaceAll("CashierlicationEnum", "ApplicationEnum");
        writer.write(code);
        reader.close();
        writer.close();
    }

    public static void main(String[] args) {
        CodeCompareUtils codeCompareUtils = new CodeCompareUtils();
        // 更新 controller/transmit 包下文件
        codeCompareUtils.compareAndUpdate("/Users/yinyougen/projects/jd/fs/cash-register-service-2/cashier-service/src/main/java/com/jd/fs/bigstore/cashier/controller/transmit",
                "/Users/yinyougen/projects/jd/fs/doga-service-2/app-server-service/src/main/java/com/jd/fs/bigstore/appserver/controller/transmit");
        // 更新 service/transmit 包下文件
        codeCompareUtils.compareAndUpdate("/Users/yinyougen/projects/jd/fs/cash-register-service-2/cashier-service/src/main/java/com/jd/fs/bigstore/cashier/service/transmit",
                "/Users/yinyougen/projects/jd/fs/doga-service-2/app-server-service/src/main/java/com/jd/fs/bigstore/appserver/service/transmit");
        // 更新 dto/transmit 包下文件
        codeCompareUtils.compareAndUpdate("/Users/yinyougen/projects/jd/fs/cash-register-service-2/cashier-service/src/main/java/com/jd/fs/bigstore/cashier/dto/transmit",
                "/Users/yinyougen/projects/jd/fs/doga-service-2/app-server-service/src/main/java/com/jd/fs/bigstore/appserver/dto/transmit");
        // 更新 populator/transmit 包下文件
        codeCompareUtils.compareAndUpdate("/Users/yinyougen/projects/jd/fs/cash-register-service-2/cashier-service/src/main/java/com/jd/fs/bigstore/cashier/populator/transmit",
                "/Users/yinyougen/projects/jd/fs/doga-service-2/app-server-service/src/main/java/com/jd/fs/bigstore/appserver/populator/transmit");
        // 更新 populator/convert/transmit 包下文件
        codeCompareUtils.compareAndUpdate("/Users/yinyougen/projects/jd/fs/cash-register-service-2/cashier-service/src/main/java/com/jd/fs/bigstore/cashier/populator/convert/transmit",
                "/Users/yinyougen/projects/jd/fs/doga-service-2/app-server-service/src/main/java/com/jd/fs/bigstore/appserver/populator/convert/transmit");
    }

}
