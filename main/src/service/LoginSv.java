package service;

import Models.Admin;
import Models.Client;
import Models.Guide;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static View.AdminView.menuAdmin;
import static View.ClientView.menuClient;
import static View.GuideView.menuTourGuide;
import static View.TotalView.menu;
import static service.GuideSV.guideList;

public class LoginSv {
//    private static final StringBuilder result;
    public static String result;
    public static String result1;

//    static {
//        result = new StringBuilder();
//    }

    public static void loginSV(String userName, String passWord) {
        AdminSV users = AdminSV.getInstance();
        List<Admin> list1 = users.getUserList();
        for (Admin user : list1) {
            if (user.getUserName().equals(userName)) {
                result = userName;
                menuAdmin();
                break;
            }
        }
        GuideSV guideSV = GuideSV.getInstance();
        List<Guide> guides = guideSV.getGuideList();
        for (Guide user : guides) {
            if (user.getUserName().equals(userName)) {
                if (isGuideActive(user.getIdGuide())) {
                    result = user.getName();
                    result1 = user.getUserName();
                    menuTourGuide();
                }
                return;
            }
        }
        ClientSV clientSV = ClientSV.getInstance();
        List<Client> clientSV1 = clientSV.getClientList();
        for (Client user : clientSV1) {
            if (user.getUserName().equals(userName) ) {
                result = user.getName();
                result1 = userName;
                menuClient();
                break;
            }
        }
        System.err.println("Invalid username or password(Tên đăng nhập hoặc mật khẩu không hợp lệ).");
        menu();
    }
    private static boolean isGuideActive(int guideId) {
        GuideSV guideSV = GuideSV.getInstance();
        List<Guide> guideList = guideSV.getGuideList();
        for (Guide guide : guideList) {
            if (guide.getIdGuide() == guideId) {
                return true;
            }
        }
        return false;
    }

    public static String checkUserName1(){
        return result;
    }
    public static String checkUserName2(){
        return result1;
    }

}
