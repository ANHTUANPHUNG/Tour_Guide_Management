package service;

import Models.Admin;
import Models.Client;
import Models.Guide;

import java.util.List;

import static View.AdminView.menuAdmin;
import static View.ClientView.menuClient;
import static View.GuideView.menuTourGuide;
import static utils.AppUltis.getString;

public class LoginSv {
<<<<<<< HEAD
    public static Object login() {
=======
    public static String login() {
>>>>>>> 3d342bd0a88d133efd8d0e6542c7e6569d377a76
        String userName = getString("Nhập tài khoản");
        String passWord = getString("Nhập mật khẩu");
        AdminSV users = AdminSV.getInstance();
        List<Admin> list1 = users.getUserList();
        for (Admin user : list1) {
            if (user.getUserName().equals(userName) && user.getPassWord().equals(passWord)) {
                menuAdmin();
                break;
            }
        }
        GuideSV guideSV = GuideSV.getInstance();
        List<Guide> guides = guideSV.getGuideList();
        for (Guide user : guides) {
            if (user.getUserName().equals(userName) && user.getPassWord().equals(passWord)) {
                menuTourGuide();
                break;
            }
        }
        ClientSV clientSV = ClientSV.getInstance();
        List<Client> clientSV1 = clientSV.getClientList();
        for (Client user : clientSV1) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(passWord)) {
                menuClient();
                break;
            }
        }
        return userName;
    }

}
