package functional_interface;

import java.time.LocalDate;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        // creating a supplier
        Supplier<Integer> getCurrentDayOfMonth = () -> LocalDate.now().getDayOfMonth();
        // invoking get method
        System.out.println("Hôm nay là ngày thứ " + getCurrentDayOfMonth.get() + " trong tháng");

        // creating a supplier
        Supplier<String> getCurrentDay = () -> LocalDate.now().getDayOfWeek().name();
        System.out.println("Hôm nay là thứ " + getCurrentDay.get());
    }
}
