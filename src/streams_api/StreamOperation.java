package streams_api;

import util.Product;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperation {
    public static void main(String[] args) {
//        mapStream();
//        filterStream();
//        flatMapStream();
//        limitStream();
//        reduceStream();

        collectStream();
        groupByStream();
        collectingAndThenStream();
        partitionStream();
        parallelStream();

    }

    /***
     *
     */

    private static void parallelStream() {
        List<String> strNumbers = new ArrayList<>();
        strNumbers.add("1");
        strNumbers.add("2");
        strNumbers.add("3");
        strNumbers.add("4");
        strNumbers.add("5");
        strNumbers.add("6");
        strNumbers.add("7");
        strNumbers.add("8");
        strNumbers.add("9");
        strNumbers.add("10");
        Stream<String> strNumStream = strNumbers.parallelStream();
        System.out.println("Parallel Stream");
        strNumStream.forEach(System.out::println);
    }

    /*
    * PartitionBy được sử dụng khi chúng ta muốn chia một tập hợp dựa trên predicate nhất định thành các phân vùng.
    * Nếu như filter chỉ lọc được những giá trị thoả mãn 1 predicate thì partitionBy lọc và chia ra
    * các phân vùng thoả mãn và k thoả mãn
    * */
    private static void partitionStream() {
        List<Product> productList = Arrays.asList(new Product("Apple", 1200), new Product("Samsung", 1000),
                new Product("Nokia", 800), new Product("BlackBerry", 1000), new Product("Apple Pro Max", 1500),
                new Product("Mi", 800), new Product("OnePlus", 1000));
        Map<Boolean, List<Product>> partition = productList.stream()
                                            .collect(Collectors.partitioningBy(e -> e.getPrice() >= 1000));
        System.out.println("Partition: " + partition);
    }

    private static void collectingAndThenStream() {
        List<Product> productList = Arrays.asList(new Product("Apple", 1200), new Product("Samsung", 1000),
                new Product("Nokia", 800), new Product("BlackBerry", 1000), new Product("Apple Pro Max", 1500),
                new Product("Mi", 800), new Product("OnePlus", 1000));

        String maxPriceProduct = productList.stream()
                .collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Product::getPrice)),
                        (product) -> product.isPresent()? product.get().getName(): "None"));
        System.out.println("Max price Product is: " + maxPriceProduct);
    }

    private static void groupByStream() {
        List<Product> productList = Arrays.asList(new Product("Apple", 1200), new Product("Samsung", 1000),
                new Product("Nokia", 800), new Product("BlackBerry", 1000), new Product("Apple Pro Max", 1500),
                new Product("Mi", 800), new Product("OnePlus", 1000));
        Map<Integer, List<Product>> groupByPrice = productList.stream().collect(Collectors.groupingBy(Product::getPrice));
        System.out.println("Product group by price: " + groupByPrice);
    }

    private static void collectStream() {
        List<String> employeeList = new ArrayList<>();
        employeeList.add("Hà Duyên Thắng");
        employeeList.add("Lê Thị Thảo");
        employeeList.add("Nguyễn Mạnh Quân");
        employeeList.add("Trương Thành Nhân");
        employeeList.add("Ngô Nguyễn Thanh Trúc");
        Stream<String> empStream = employeeList.stream();
        List<String> newEmployeeList = empStream.filter(e -> {
            String lName = e.substring(e.lastIndexOf(" ") + 1);
            if (lName.charAt(0) == 'T')
                return true;
            return false;
        }).collect(Collectors.toList());
        newEmployeeList.forEach(e -> System.out.println(e));
    }

    private static void reduceStream() {
        int[] nums = {1, 5, 10, 22, 45, 20, 21,26};
        IntStream s = Arrays.stream(nums);
        int x = s.reduce(0, (a, b) -> {
            System.out.println("a = " + a + ", b = " + b);
            return b % 2 == 0 ? a + b: a;
        });
        System.out.println(x);
    }

    private static void limitStream() {
        int[] nums = {1, 5, 10, 22, 45, 20, 21,26, 102, 221, 455, 904, 124, 987, 565, 1211};
        IntStream s = Arrays.stream(nums);
        s.limit(5).forEach(e-> System.out.println(e));
        System.out.println();
        IntStream s1 = Arrays.stream(nums);
        s1.skip(5).limit(10).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static void flatMapStream() {
        String[] arrWords = {"Hà", "Duyên", "Thắng"};
        Stream<String> wordsStream = Arrays.stream(arrWords);
        wordsStream.map(w -> w.split(" ")).flatMap(e -> Arrays.stream(e)).forEach(e -> System.out.println(e));
    }

    private static void filterStream() {
        int[] nums = {1, 5, 10, 22, 45, 20, 21,26};
        IntStream s = Arrays.stream(nums);
        s.filter(e -> e % 2 == 1).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }


    private static void mapStream() {
        List<String> employeeList = new ArrayList<>();
        employeeList.add("Hà Duyên Thắng");
        employeeList.add("Lê Thị Thảo");
        employeeList.add("Nguyễn Mạnh Quân");
        employeeList.add("Trương Thành Gia Thịnh");
        employeeList.add("Ngô Nguyễn Thanh Trúc");
        Stream<String> empStream = employeeList.stream();
        empStream.map(e -> e.toUpperCase()).forEach(e -> System.out.println(e));
    }
}
