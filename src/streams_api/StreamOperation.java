package streams_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    }

    private static void groupByStream() {
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
