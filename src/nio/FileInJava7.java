package nio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class FileInJava7 {
    private static final String HOME_DIR = "D:\\Java\\javacore-trainning\\Java7Feature";

    public static void main(String[] args) {
        try {
            workingWithFiles();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void workingWithFiles() throws IOException {
        // 1. Lấy đường dẫn tới file
        Path path = Paths.get(HOME_DIR, "data", "user-info.txt");
        // đọc nội dung file -> bytes
        byte[] datas = Files.readAllBytes(path);
        // chuyển từ byte sang string, định dạng UTF - 8
        String contents = new String(datas, StandardCharsets.UTF_8);
        System.out.println(contents);
        // đọc nội dung file dùng read All line
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        for(String line: lines) {
            System.out.println(line);
        }

        /*
        * Ghi file
        * */
        String newLine = "\n0986525691";
        Files.write(path, newLine.getBytes(), StandardOpenOption.APPEND);

        /*
         * Tạo file, thư mục
         * */
        Path newPath = Paths.get(HOME_DIR, "data", "test");
        Files.createDirectories(newPath);
        Path filePath = Paths.get(HOME_DIR, "data", "test", "hihi.txt");
        if (!Files.exists(filePath))
            Files.createFile(filePath);

        /*
        * Copy file
        * */
        InputStream in = Files.newInputStream(path);
        Files.copy(in, filePath, StandardCopyOption.REPLACE_EXISTING);

        /*
         * Xoá file
         * */
        boolean isDone = Files.deleteIfExists(filePath);
        if (isDone) {
            System.out.println("Deleted file: " + filePath.getFileName());
        }

    }
}
