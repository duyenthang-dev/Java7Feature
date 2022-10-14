package functional_interface;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        // Creating a function
        UnaryOperator<String> convertStr = str -> str.toLowerCase();
        // calling function method
        System.out.println("Ha DuYEn ThANG -> " + convertStr.apply("Ha DuYEn ThANG"));
        UnaryOperator<String> sameValue = UnaryOperator.identity();
        System.out.println("Gía trị của input: " + sameValue.apply("Thắng"));

        // chaining function method using andThen()
        Function<Integer, Integer> trippleNum = num -> {
            System.out.println("Tripple a number");
            return 3* num;
        };

        UnaryOperator<Integer> plus10 = num -> {
            System.out.println("Plus 10");
            return num + 10;
        };

        Function<Integer, Integer> opreation = trippleNum.andThen(plus10);
        System.out.println(opreation.apply(20));
        opreation = trippleNum.compose(plus10);
        System.out.println(opreation.apply(30));

    }
}
