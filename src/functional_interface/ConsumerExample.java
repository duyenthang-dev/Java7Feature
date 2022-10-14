package functional_interface;

import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        // creating â consumer
        Consumer<String> convertAndPrintStr = str -> System.out.println("Chuỗi " + str +
                " được chuyển về dạng viết hoa là: " + str.toUpperCase());
        // calling method
        convertAndPrintStr.accept("hà duyên thắng");

        Consumer<String> hello = str -> System.out.println("Hello " + str);
        Consumer<String> getLastName = str -> System.out.println("Tên: " + str.substring(str.lastIndexOf(" ") + 1));
        hello.andThen(getLastName).accept("hà duyên thắng");
    }
}
