package service;

import utils.AppUltis;

import java.util.Scanner;

import static View.TotalView.menu;
import static utils.AppUltis.getString;

public class RegisterSV {
    static int choice;

    public static String registerCheckUserName(String str) {
        String userName = getString(str);
        if (isUserNameTaken(userName)) {
            System.err.println("The account already exists(Tài khoản đã tồn tại)");
            System.out.println("Please enter again(Mời nhập lại):");
            return registerCheckUserName(str);
        }
        if(!checkUser(userName)){
            System.err.println("Input error(Nhập sai)");
            System.out.println("Please enter again(Mời nhập lại):");
            return registerCheckUserName(str);
        }
        return userName;
    }
    public static boolean isUserNameTaken(String userName) {
        AdminSV adminSV = AdminSV.getInstance();
        if (adminSV.getUserList().stream().anyMatch(e -> e.getUserName().equals(userName))) {
            return true;
        }
        GuideSV guideSV = GuideSV.getInstance();
        if (guideSV.getGuideList().stream().anyMatch(e -> e.getUserName().equals(userName))) {
            return true;
        }
        ClientSV clientSV = ClientSV.getInstance();
        return clientSV.getClientList().stream().anyMatch(e -> e.getUserName().equals(userName));
    }
    public static boolean checkUser(String userName) {
        boolean isLetter = false;
        for (char i : userName.toCharArray()) {
            if (Character.isLetter(i)) {
                isLetter = true;
            }
        }
        boolean isNumber = false;
        for (char i: userName.toCharArray()) {
            if(Character.isDigit(i)){
                isNumber = true;
            }
        }

        return !isNumber && isLetter && userName.length() >= 6;
    }
    public static String registerCheckPassWord(String str) {
        String passWord = getString(str);
        if(!(passWord.length() >= 6)){
            System.err.println("Input error(Nhập sai).");
            System.out.println("1. Continue(tiếp tục).");
            System.out.println("0. Go back (Quay lại).");
            choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn):", 0, 1);
            switch (choice){
                case 1-> registerCheckPassWord(str);
                case 0-> menu();
            }
        }
        return passWord;
    }
    public static String registerCheckName(String str) {
        String name = getString(str);
        if(!(name.length() >= 6)){
            System.err.println("Input error(Nhập sai).");
            System.out.println("1.Continue( Tiếp tục).");
            System.out.println("0.Go back (Quay lại).");
            choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn):", 0, 1);
            switch (choice){
                case 1-> registerCheckName(str);
                case 0-> menu();
            }
        }
        return name;
    }
}
