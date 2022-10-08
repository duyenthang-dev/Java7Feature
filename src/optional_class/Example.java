package optional_class;

import java.util.Optional;

public class Example {
    public static void main(String[] args) {
        String[] str = new String[10];
        str[5] = "Hà Duyên Thắng";
        // sử dụng of khi biết chắc biến đó k null, ngược lại dùng ofNullable
        Optional<String> nullAble = Optional.ofNullable(str[4]);
        nullAble.ifPresent(System.out::println);
        System.out.println(nullAble.orElse("Null value"));
    }
}
