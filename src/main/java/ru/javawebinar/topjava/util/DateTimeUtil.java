package ru.javawebinar.topjava.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static boolean isBetween(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        if (startTime == null) startTime = LocalTime.MIN;
        if (endTime == null) endTime = LocalTime.MAX;
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) <= 0;
    }

    public static boolean isBetween(LocalDate ld, LocalDate startDate, LocalDate endDate) {
        if (startDate == null) startDate = LocalDate.MIN;
        if (endDate == null) endDate = LocalDate.MAX;

        return ld.compareTo(startDate) >= 0 && ld.compareTo(endDate) <= 0;
    }

    public static LocalDate localDateParse(String str) {

        return !str.isEmpty() ? LocalDate.parse(str) : null;
    }

    public static LocalTime localTimeParse(String str) {

        return !str.isEmpty() ? LocalTime.parse(str) : null;
    }

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER);
    }
}
