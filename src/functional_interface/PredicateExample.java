package functional_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {
    public static void main(String[] args) {
        // Creating a predicate
        Predicate<Integer> isEven = i -> i % 2 == 0;

        // calling method
        System.out.println("61 la so chan? " + isEven.test(61));

        // creating a predicate
        Predicate<Integer> isGTE50 = i -> i >= 50;
        System.out.println("61 >= 50? " + isGTE50.test(61));

        // Predicate AND chaining
        System.out.println("61 >= 50 và 61 là số chẵn? " + isGTE50.and(isEven).test(61));

        // Predicat OR chaining
        System.out.println("61 >= 50 hoặc 61 là số chẵn? " + isGTE50.or(isEven).test(61));

        // Predicate negate chaining
        System.out.println("Is the number 61 is odd? : " + isEven.negate().test(61));

        // Usage predicate inside Collection and Streams
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect = list.stream().filter(isEven).collect(Collectors.toList());
        System.out.println("Danh sách số chẵn: " + collect);

        Predicate<String> checkEquality = Predicate.isEqual("Thang");
        System.out.println("Chuỗi đã cho có bằng nhau: " + checkEquality.test("thang"));
    }
}
