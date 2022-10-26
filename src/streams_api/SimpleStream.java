package streams_api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SimpleStream {
    public static void main(String[] args) {
        List<String> employeeList = new ArrayList<>();
        employeeList.add("Hà Duyên Thắng");
        employeeList.add("Lê Thị Thảo");
        employeeList.add("Nguyễn Mạnh Quân");
        employeeList.add("Trương Thành Gia Thịnh");
        employeeList.add("Ngô Nguyễn Thanh Trúc");
        Stream<String> empStream = employeeList.stream();

    }
}
