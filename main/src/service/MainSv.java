package service;

import Models.Client;

import java.util.Scanner;

import static service.ClientSV.clientList;

public class MainSv {

    public static String getUniqueUserName() {
        String userName = getString("Nhập tài khoản");
        if (isUserNameTaken(userName)) {
            System.err.println("Tài khoản đã tồn tại");
            System.out.println("Mời nhập lại:");
            return getUniqueUserName();
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
        if (clientSV.getClientList().stream().anyMatch(e -> e.getUserName().equals(userName))) {
            return true;
        }
        return false;
    }
    private static String getString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextLine();
    }
    private int getInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextInt();
    }
}
