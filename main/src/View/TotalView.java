package View;

import utils.AppUltis;

import static View.LoginView.Login;
import static View.RegisterView.Register;

public class TotalView {

    // Trang chur
    static int choice;

    public static void menu() {
        menuTotal();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 2);
        switch (choice) {
            case 1 -> Login();
            case 2 -> {
                Register();
                menu();
            }
            case 0 -> {
                System.exit(1);
            }
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
}
