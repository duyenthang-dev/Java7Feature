package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInJava7 {
    private static final String HOME_DIR = "D:\\Java\\javacore-trainning\\Java7Feature";

    public static void main(String[] args) {
        buildPath();
    }

    private static void buildPath() {
        Path path = Paths.get(HOME_DIR, "data", "test.txt");
        Path fileName = path.getFileName();
        System.out.println("Filename: " + fileName);
        System.out.println("File system: " + path.getFileSystem());
        System.out.println("Fiel system separator: " + path.getFileSystem().getSeparator());
        for (int i = 0; i < path.getNameCount(); i++) {
            Path subPath = path.getName(i);
            System.out.println("Path location at index : " + (i + 1) + " is " + subPath);
        }
        System.out.println("Sub path is "+path.subpath(0,4));
        System.out.println("Root path is "+path.getRoot());
        System.out.println("Parent path is "+path.getParent());
    }
}
