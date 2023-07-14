package View;

import Models.FeedBack;
import utils.AppUltis;

import static View.LoginView.Login;
import static View.RegisterView.Register;
import static service.FeedBackSV.displayFeedBack;
import static service.FeedBackSV.feedBackList;

public class TotalView {

    // Trang chur
    static int choice;

    public static void menu() {
        menuTotal();
        choice = AppUltis.getIntWithBound("              Enter your choice(Mời chọn chức năng):", 0, 2);
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
        System.out.println(" ╔════════════════════════════════════════════════════════════════╗");
        System.out.println(" ║             CHÀO MỪNG BẠN ĐẾN VỚI PHẦN MỀM QUẢN LÍ             ║");
        System.out.println(" ╠════════════════════════════════════════════════════════════════╣");
        System.out.println(" ║                                                                ║");
        System.out.println(" ║                       1. Đăng nhập                             ║");
        System.out.println(" ║                       2. Đăng kí                               ║");
        System.out.println(" ║                       0. Thoát chương trình                    ║");
        System.out.println(" ║                                                                ║");
        System.out.println(" ╚════════════════════════════════════════════════════════════════╝");
    }

    public static void main(String[] args) {

    }

}
