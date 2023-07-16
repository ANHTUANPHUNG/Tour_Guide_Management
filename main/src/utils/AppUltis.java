package utils;

import Models.Bill;
import service.BillSV;

import java.awt.*;
import java.sql.Time;
import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Objects;

import static service.BillSV.*;
import static service.LoginSv.checkUserName1;
import static utils.AppUltis.CurrencyFormat.covertPriceToString;

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
                throw new NumberFormatException(String.format("Please input number between " + begin + " and " + end + "(Vui lòng nhập số từ " + begin + " đến " + end + ")"));
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

        }
        displayCheckBill(start, end);
        String total = covertPriceToString(totalAmount);
        System.out.println(total);
    }

    public static void salaryGuideOfAdmin(LocalDate start, LocalDate end) {
        Map<String, Double> salaryMap = new HashMap<>();

        for (Bill bill : billList) {
            if (bill.getStarDate().isAfter(start.minusDays(1)) && bill.getEndDate().isBefore(end.plusDays(1))) {
                String guideName = bill.getNameGuide();
                if (salaryMap.containsKey(guideName)) {
                    double total = salaryMap.get(guideName);
                    total += bill.getTotal();

                    salaryMap.put(guideName, total);
                } else {
                    salaryMap.put(guideName, bill.getTotal());
                }
            }
        }
        for (Map.Entry<String, Double> entry : salaryMap.entrySet()) {
            String guideName = entry.getKey();
            double total = entry.getValue();
            double salary = 5000000 + ((total * 10) / 100);
            String sa = covertPriceToString(salary);
            System.out.println("Nhân viên: " + guideName + "    ,      Tổng lương: " + sa);

        }
    }

    public static void salaryGuide(LocalDate start, LocalDate end) {
        Map<String, Double> salaryMap = new HashMap<>();

        for (Bill bill : billList) {
            if (bill.getNameGuide().equals(getTheCurrentlyLoginID())) {
                if (bill.getStarDate().isAfter(start.minusDays(1)) && bill.getEndDate().isBefore(end.plusDays(1))) {
                    if (salaryMap.containsKey(getTheCurrentlyLoginID())) {
                        double total = salaryMap.get(getTheCurrentlyLoginID());
                        total += bill.getTotal();

                        salaryMap.put(getTheCurrentlyLoginID(), total);
                    } else {
                        salaryMap.put(getTheCurrentlyLoginID(), bill.getTotal());
                    }
                }
            }
        }
        if (salaryMap.isEmpty()) {
            System.out.println("Bạn không hoạt động vào thời gian này.");
        } else {
            for (Map.Entry<String, Double> entry : salaryMap.entrySet()) {
                String guideName = entry.getKey();
                double total = entry.getValue();
                double salary = 5000000 + ((total * 10) / 100);
                String sa = covertPriceToString(salary);
                System.out.println("Lương của bạn: " + guideName + ", Tổng lương: " + sa);
            }
        }
    }


    public static LocalDate getDateBook(String str) {
        try {
            LocalDate now = LocalDate.now();
            LocalDate tomorrow = now.plusDays(1);
            LocalDate maxDate = now.plusDays(30);
            LocalDate dateTime = LocalDate.parse(getString(str + " (yyyy-MM-dd):"));
            if (dateTime.isBefore(tomorrow) || dateTime.isAfter(maxDate)) {
                throw new RuntimeException("\n" +
                        "The selected date must be within the next 30 days starting from tomorrow (Ngày đã chọn phải nằm trong khoảng 30 ngày tiếp theo bắt đầu từ ngày mai).");
            }
            return dateTime;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please try again(Định dạng ngày không hợp lệ. Vui lòng thử lại)");
            return getDateBook(str);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getDateBook(str);
        }
    }

    public static LocalDate getUserDateOfBirth() {
        LocalDate userInput = null;
        boolean isValid = false;
        int invalidCount = 0;
        while (!isValid) {
            try {
                 userInput = AppUltis.getDate();
                int minimumAge = 18;
                LocalDate minimumDateOfBirth = LocalDate.now().minusYears(minimumAge);
                if (userInput.isAfter(minimumDateOfBirth)) {
                    System.out.println("You are not yet 18 years old(Bạn chưa đủ 18 tuổi).");
                    continue;

                }
                isValid = true;
            } catch (Exception e) {
                invalidCount++;
                System.out.println("Invalid date format. Please try again(Định dạng ngày không hợp lệ. Vui lòng thử lại).");
                if (invalidCount >= 3) {
                    System.out.println("You have entered an invalid date 3 times. The program will exit(Bạn đã nhập sai quá 3 lần. Chương trình sẽ thoát).");
                    System.exit(0);
                }
            }

        }

        return userInput;
    }


    public static String getStringWithPattern(String str, String pattern) {
        String result = getString(str);
        if (!Pattern.compile(pattern).matcher(result).matches()) {
            System.err.println("Please input phone:03 or 05 or 07 or 08 or 09(Nhập không hợp lệ, bắt đầu bằng:03 hoặc 05 hoặc 07 hoặc 08 hoặc 09)");
            getStringWithPattern(str, pattern);
        }
        return result;
    }

    public static class CurrencyFormat {
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
