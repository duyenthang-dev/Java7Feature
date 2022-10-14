package functional_interface;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        // Creating a function
        Function<String, String> convertStr = input -> input.toUpperCase();

        // calling fuction method
        System.out.println("\"ha duyen thang\" -> " + convertStr.apply("ha duyen thang"));
        Function<String, String> sameValue = Function.identity();
        System.out.println("Hà Duyên Thắng -> " + sameValue.apply("Hà Duyên Thắng"));

        //Chaining the function methods using andThen()
        Function<Integer, Integer> doubleNum = num -> {
            System.out.println("-> Double");
            return 2 * num;
        };

        Function<Integer, Integer> addMore10 = doubleNum.andThen(num -> {
            System.out.println("-> Add more 10");
            return num + 10;
        });
        System.out.println("50: " + addMore10.apply(50));

        //Chaining the function methods using compose()
        Function<Integer, Integer> divBy2 = num -> {
            System.out.println("Div by 2");
            return num / 2;
        };
        Function<Integer, Integer> sub10 = divBy2.compose(num -> {
            System.out.println("Sub 10");
            return num - 10;
        });
        System.out.println("100: " + sub10.apply(100));
    }
}
