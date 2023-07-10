package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class getValue {
    static Scanner input = new Scanner(System.in);

    public static String getString(String str) {
        System.out.println(str);
        return input.nextLine();
    }

    public static String getStringWithPattern(String str, String pattern) {
        String result = getString(str);
        if (!Pattern.compile(pattern).matcher(result).matches()) {
            System.out.println("Invalid String(Số không hợp lệ)");
            getStringWithPattern(str, pattern);
        }
        ;
        return result;
    }

    public static int luachon = -1;


    public static int getInt(String str) {
        try {
            luachon = Integer.parseInt(getValue.getString(str));
            if (luachon < 0 || luachon > 1000) {
                throw new NumberFormatException("Number invalid");
            }
            return luachon;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getInt(str);
        }
    }
}
