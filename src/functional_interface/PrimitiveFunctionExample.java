package functional_interface;

import java.util.Random;
import java.util.function.*;

public class PrimitiveFunctionExample {
    public static void main(String[] args) {
        problemWithNormalFunctionalInterfaces();
        predicatePrimitiveFunctions();
        functionPrimitiveFunctions();
        biFunctionPrimitiveFunctions();
        consumerPrimitiveFunctions();
        supplierPrimitiveFunctions();
        unaryPrimitiveFunctions();
        binaryPrimitiveFunctions();
    }

    private static void binaryPrimitiveFunctions() {
        IntBinaryOperator intBinaryOperator = (a, b) -> a * b;
        System.out.println("intBinaryOperator: " + intBinaryOperator.applyAsInt(5, 6));
    }

    private static void consumerPrimitiveFunctions() {
        DoubleConsumer doubleConsumer = x -> System.out.printf("%.4f\n", x );
        doubleConsumer.accept(Math.PI);
    }

    private static void unaryPrimitiveFunctions() {
        IntUnaryOperator intUnary = x -> x *2;
        System.out.println("Unary int: " + intUnary.applyAsInt(22));

    }

    private static void supplierPrimitiveFunctions() {
        DoubleSupplier doubleSupplier = () -> {
            Random rnd = new Random();
            return rnd.nextDouble();
        };
        System.out.println("Double supplier: " + doubleSupplier.getAsDouble());
    }

    private static void functionPrimitiveFunctions() {
        /*
        * Nhận vào tham số kiểu int, trả về kiểu tương ứng trong dấu < >
        * */
        IntFunction<String> applyInt = x -> x + " Hehe";
        System.out.println("Apply Int: " + applyInt.apply(10));

        /*
         * Nhận vào tham số kiểu Object, trả về kiểu int
         * */
        ToIntFunction toInt = x -> Integer.parseInt((String)x);
        System.out.println("To Int: " + toInt.applyAsInt("15"));

        /*
         * Nhận vào tham số kiểu double, trả về kiểu int
         * */
        DoubleToIntFunction doubleToInt = x -> (int) x;
        System.out.println("doubleToInt: " + doubleToInt.applyAsInt(10.5));
    }

    private static void biFunctionPrimitiveFunctions() {
        /*
         * Nhận vào 2 tham số kiểu string, trả về kiểu int
         * */
        ToIntBiFunction<String, String> toInt = (str1, str2) -> Integer.parseInt(str1) + Integer.parseInt(str2);
        System.out.println("To Int bi function: " + toInt.applyAsInt("10", "122"));

    }

    private static void predicatePrimitiveFunctions() {
        IntPredicate checkInt = x -> x % 2 == 0;
        System.out.println("CheckInt " + checkInt.test(10));

        DoublePredicate checkDouble = x -> x % 2 == 1;
        System.out.println("Check double: " + checkDouble.test(11.0));
    }

    private static void problemWithNormalFunctionalInterfaces() {
        Function<Integer, Integer> doubleValue = input -> input * 2;
        int[] arr = new int[] {4, 10, 11, 40, 50, -4, 24, 26};
        int[] dArr = new int[arr.length];
        for(int i =0; i < arr.length; i++) {
            dArr[i] = doubleValue.apply(arr[i]);
        }
        System.out.println("Array ban đầu: " + arr.toString());
        System.out.println("Array sau khi double: " + dArr.toString());
    }

}
