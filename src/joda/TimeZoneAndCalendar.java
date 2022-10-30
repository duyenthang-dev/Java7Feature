package joda;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.AbstractMap.*;
import java.util.Map;
import java.util.stream.Collectors;

public class TimeZoneAndCalendar {
    public static void main(String[] args) {
        printAllZone();
        timeZone();
        calendarSystem();
    }

    private static void printAllZone() {
        LocalDateTime local = LocalDateTime.now();
        Map<String, String> result= ZoneId.getAvailableZoneIds()
                .stream()
                .map(e -> ZoneId.of(e))
                .map(zoneId -> new SimpleEntry<>(zoneId.toString(),local.atZone(zoneId).getOffset().getId().replaceAll("Z", "+00:00")))
                .filter(entry -> entry.getKey().startsWith("Asia"))
                .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
        result.forEach((key, val) -> System.out.println("Zone id: " + key + " -> Offset: " + val));
        System.out.println("Toal asia zone: " + result.size());
    }

    private static void calendarSystem() {
    }

    private static void timeZone() {

    }
}
