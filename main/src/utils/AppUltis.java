package utils;

import Models.Bill;
import service.BillSV;

import java.awt.*;
import java.sql.Time;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

import static service.BillSV.billList;

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
            System.out.println("Please input number(Mời nhập số)");
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
        } catch (NumberFormatException e) {
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
            System.err.println("Định dạng ngày không hợp lệ. Vui lòng thử lại.");
            return getDate();
        }
    }
    public static void printBillFromTo(LocalDate start, LocalDate end) {
        List<Bill> billss = billList.stream()
                .filter(bill -> bill.getStarDate().isAfter(start.minusDays(1))
                        && bill.getEndDate().isBefore(end.plusDays(1)))
                .toList();

        double totalAmount = 0.0;
        for (Bill bill : billss) {
            totalAmount += bill.getTotal();
            System.out.println(bill);
        }
        System.out.println("Total Amount: " + totalAmount);
    }
    public static LocalDate getDateBook(String str) {
        try {
            LocalDate dateTime = LocalDate.parse(getString(str + " (yyyy-MM-dd ):"));
            LocalDate now = LocalDate.now();
            long duration = ChronoUnit.HOURS.between(dateTime.atStartOfDay(), now.atStartOfDay());
            if (duration < 0 || duration > 744) {
                throw new RuntimeException("Invalid Date Range. Please enter a date within the last 30 day.");
            }
            return dateTime;
        } catch (DateTimeParseException e) {
            System.out.println("Định dạng ngày không hợp lệ. Vui lòng thử lại");
            return getDateBook(str);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getDateBook(str);
        }
    }
    public static LocalDate getUserDateOfBirth() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = null;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter your date of birth (yyyy-MM-dd): ");
                String userInput = scanner.nextLine();
                dateOfBirth = LocalDate.parse(userInput, formatter);
                int minimumAge = 18;
                LocalDate minimumDateOfBirth = LocalDate.now().minusYears(minimumAge);
                if (dateOfBirth.isAfter(minimumDateOfBirth)) {
                    throw new RuntimeException("Bạn chưa đủ 18 tuổi.");
                }
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter the date in the format 'yyyy-MM-dd'.");
            }
        }

        return dateOfBirth;
    }



    public static String getStringWithPattern(String str, String pattern) {
        String result = getString(str);
        if (!Pattern.compile(pattern).matcher(result).matches()) {
            System.err.println("Please input phone:03 or 05 or 07 or 08 or 09(Nhập không hợp lệ, bắt đầu bằng:03 hoặc 05 hoặc 07 hoặc 08 hoặc 09)");
            getStringWithPattern(str, pattern);
        }
        ;
        return result;
    }
    public class CurrencyFormat {
        public static String covertPriceToString(double price) {
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeVN);
            return currencyFormatter.format(price);
        }
        public static double parseDouble(String price) {
            String priceNew = price.replaceAll("\\D+", "");
            return Double.parseDouble(priceNew);
        }
        public static int parseInteger(double price) {
            String price1 = String.valueOf(price);
            String priceNew = price1.replaceAll("\\D+\\d", "");
            return Integer.parseInt(priceNew);
        }
    }
}
