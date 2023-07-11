package utils;

import java.sql.Time;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AppUltis {
    private static Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    public static String getString(String str) {
        System.out.println(str);
        return sc.nextLine();
    }

    public static int getInt(String str) {
        try {
            return Integer.parseInt(getString(str));
        } catch (Exception e) {
            System.out.println("Input invalid");
            return getInt(str);
        }
    }

    public static int getIntWithBound(String str, int begin, int end) {
        try {
            int number = getInt(str);
            if (number < begin || number > end) {
                throw new NumberFormatException(String.format("Please input number between "+ begin+" and " +end+"(Vui lòng nhập số từ "+ begin +" đến " + end +")"));
            }
            return number;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getIntWithBound(str, begin, end);
        }
    }

    public static LocalDate getDate() {
        System.out.println("Vui lòng nhập ngày với định dạng YYYY-MM-DD: ");
        String input = sc.nextLine();
        try {
            return LocalDate.parse(input);
        } catch (Exception e) {
            System.out.println("Định dạng ngày không hợp lệ. Vui lòng thử lại.");
            return getDate();
        }
    }
    public static YearMonth getYearMonthFromUser() {
        int month =AppUltis.getIntWithBound("Enter the month(Mời chọn tháng):", 1, 12);
        int year= AppUltis.getIntWithBound("Enter the year(Mời chọn năm):", 2010, 2023);
        return YearMonth.of(year, month);
    }

    public static Time getTime(String str) {
        try {
            System.out.println("Please enter date with format HH:MM:SS");
            String time = getString(str);
            int hour = Integer.parseInt(time.split(":")[0]);
            if (hour > 24 || hour < 0) throw new RuntimeException("Hours Invalid");
            return Time.valueOf(time);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return getTime(str);
        } catch (Exception e) {
            System.out.println("Invalid Time");
            return getTime(str);
        }

    }
    public static String getStringWithPattern(String str, String pattern) {
        String result = getString(str);
        if (!Pattern.compile(pattern).matcher(result).matches()) {
            System.out.println("Invalid String(Nhập không hợp lệ)");
            getStringWithPattern(str, pattern);
        }
        ;
        return result;
    }
    public static long getDaysBetween(LocalDate date1, LocalDate date2) {
        return date2.until(date1, ChronoUnit.DAYS);
    }

    public static void main(String[] args) {
        Time date = getTime("Lua chon Date");
        System.out.println(date.getTime());
    }
}
