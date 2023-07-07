package utils;

import java.util.Scanner;

public class getValue {
    static Scanner input = new Scanner(System.in);
    public static String getString(String str){
        System.out.println(str);
        return input.nextLine();
    }
    
    public static int luachon = -1;

    
    public static int getInt (String str) {
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
