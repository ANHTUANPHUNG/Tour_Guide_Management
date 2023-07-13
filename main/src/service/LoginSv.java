package service;

import Models.Admin;
import Models.Client;
import Models.Guide;

import java.util.List;

import static View.AdminView.menuAdmin;
import static View.ClientView.menuClient;
import static View.GuideView.menuTourGuide;
import static service.GuideSV.guideList;

public class LoginSv {
    private static final StringBuilder result;

    static {
        result = new StringBuilder();
    }

    public static void loginSV(String userName, String passWord) {
        AdminSV users = AdminSV.getInstance();
        List<Admin> list1 = users.getUserList();
        for (Admin user : list1) {
            if (user.getUserName().equals(userName) && user.getPassWord().equals(passWord)) {
                result.append(userName);
                menuAdmin();
                break;
            }
        }
        GuideSV guideSV = GuideSV.getInstance();
        List<Guide> guides = guideSV.getGuideList();
        for (Guide user : guides) {
            if (user.getUserName().equals(userName) && user.getPassWord().equals(passWord)) {
                String guides1= user.getName();
                result.append(guides1);
                menuTourGuide();
                break;
            }
        }
        ClientSV clientSV = ClientSV.getInstance();
        List<Client> clientSV1 = clientSV.getClientList();
        for (Client user : clientSV1) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(passWord)) {
                result.append(userName);
                menuClient();
                break;
            }
        }
    }
    public static String checkUserName1(){
        return result.toString();
    }

}
