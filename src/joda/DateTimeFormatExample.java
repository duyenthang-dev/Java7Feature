package joda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatExample {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String baseISO = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String ISO = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String local = date.format(DateTimeFormatter.ofPattern(("EEEE, dd/MM/YYYY"), Locale.forLanguageTag("vi")));
        System.out.println(ISO);
        System.out.println("Dạng dd/mm/YYYY: " + local);
    }
}
