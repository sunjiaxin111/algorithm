package chapterOne.three;

import java.io.File;

/**
 * Created by sunjiaxin on 2017/5/12.
 */
public class FileList {

    public static final String tab = "  ";

    public static void main(String[] args) {
        listFiles(new File(args[0]), "");
    }

    public static void listFiles(File file, String tabs) {
        if (!file.exists()) {
            throw new RuntimeException("文件路径有误！");
        }

        System.out.println(tabs + file.getName());

        if (file.isDirectory()) {
            String subTabs = tabs + tab;
            for (File subFile : file.listFiles()) {
                listFiles(subFile, subTabs);
            }
        }
    }
}
