package joda;

import java.text.DateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020,12, 30);
        System.out.println("Date = " + date);
        DayOfWeek dow = date.getDayOfWeek();
        System.out.println("Day of week: " + dow);

        LocalDate date1 = LocalDate.parse("2022-10-28");
        System.out.println("Date1: " + date1);

        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 19, 12, 20, 50);
        System.out.println(dateTime);
    }
}
