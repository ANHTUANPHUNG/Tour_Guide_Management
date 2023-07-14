package service;

import Models.Admin;
import Models.Client;
import Models.Guide;

import java.util.List;

import static View.AdminView.menuAdmin;
import static View.ClientView.menuClient;
import static View.GuideView.menuTourGuide;
import static View.TotalView.menu;
import static service.GuideSV.guideList;

public class LoginSv {
//    private static final StringBuilder result;
    public static String result;

//    static {
//        result = new StringBuilder();
//    }

    public static void loginSV(String userName, String passWord) {
        AdminSV users = AdminSV.getInstance();
        List<Admin> list1 = users.getUserList();
        for (Admin user : list1) {
            if (user.getUserName().equals(userName) && user.getPassWord().equals(passWord)) {
                result = userName;
                menuAdmin();
                break;
            }
        }
        GuideSV guideSV = GuideSV.getInstance();
        List<Guide> guides = guideSV.getGuideList();
        for (Guide user : guides) {
            if (user.getUserName().equals(userName) && user.getPassWord().equals(passWord)) {
                if (isGuideActive(user.getIdGuide())) {
                    result = user.getName();
                    menuTourGuide();
                }
                return;
            }
        }
        ClientSV clientSV = ClientSV.getInstance();
        List<Client> clientSV1 = clientSV.getClientList();
        for (Client user : clientSV1) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(passWord)) {
                result = user.getName();

                menuClient();
                break;
            }
        }
        System.err.println("Sai tên đăng nhập hoặc mật khẩu.");
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

}
