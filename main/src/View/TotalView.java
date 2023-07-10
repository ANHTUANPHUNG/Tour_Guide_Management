package View;

import Models.Admin;
import Models.Client;
import Models.Guide;
import service.AdminSV;
import service.ClientSV;
import service.GuideSV;
import utils.AppUltis;
import utils.getValue;

import java.io.IOException;
import java.util.List;

import static View.AdminView.*;
import static View.ClientView.menuClient;
import static View.GuideView.menuTourGuide;
import static utils.getValue.getString;

public class TotalView {

    // Trang chur
    static int choice;

    public static void menu() {
        menuTotal();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 2);
        switch (choice) {
            case 1:
                login();
            case 2:
                Register();
            case 0:
                menu();
        }
    }

    public static void menuTotal() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("\t\t CHÀO MỪNG BẠN ĐẾN VỚI PHẦN MỀM QUẢN LÍ");
        System.out.println("--------------------------------------------------\n");
        System.out.println("\t1. Đăng nhập");
        System.out.println("\t2. Đăng kí");
        System.out.println("\t0. Thoát chương trình");
    }

    //    trang đăng kí
    public static void login() {
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
    }

    public static void Register() {
        ClientSV clientSV = ClientSV.getInstance();
        clientSV.create();
    }
}
