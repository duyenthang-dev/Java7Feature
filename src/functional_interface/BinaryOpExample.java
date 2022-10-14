package functional_interface;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOpExample {
    public static void main(String[] args) {
        // creating binary op
        BinaryOperator<String> appendAndConvert = (str1, str2) -> (str1 + str2).toUpperCase();
        // calling method
        System.out.println("Full name: " + appendAndConvert.apply("ha duyen", " thang"));

        BinaryOperator<Integer> maxOperation = BinaryOperator.maxBy(Comparator.naturalOrder());
        System.out.println("The largest number is: " + maxOperation.apply(16, 30));

        BinaryOperator<Integer> minOperation = BinaryOperator.minBy(Comparator.naturalOrder());
        System.out.println("The smallest number is: " + minOperation.apply(16, 30));
    }
}
