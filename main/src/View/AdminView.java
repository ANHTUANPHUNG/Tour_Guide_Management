package View;

import Models.FeedBack;
import Models.Guide;
import service.FeedBackSV;
import service.GuideSV;
import utils.AppUltis;

import java.time.LocalDate;

import static View.TotalView.menu;
import static service.BillSV.displayBill;
import static service.ClientSV.createClient;
import static service.ClientSV.displayClient;
import static service.FeedBackSV.createFeedBackSV;
import static service.FeedBackSV.displayFeedBack;
import static service.GuideSV.displayGuide;

import static service.GuideSV.nextIdGuide;
import static utils.AppUltis.*;

public class AdminView {
    static int choice;

    public static void menuAdmin() {
        System.out.println();
        System.out.println();
        System.out.println("              Chào mừng sếp yêu quý.");
        menuAdminView();
        choice = AppUltis.getIntWithBound("    Mời chọn chức năng:", 0, 3);
        switch (choice) {
            case 1 -> menuGuideAdmin();
            case 2 -> pendingOrder();
            case 3 -> monthlyRevenue();
            case 0 -> menu();
        }
    }

    public static void menuAdminView() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║           Trang quản lí                 ║");
        System.out.println("║       1. Quản lí hướng dẫn viên.        ║");
        System.out.println("║       2. Quản lí đơn hàng.              ║");
        System.out.println("║       3. Quản lí doanh thu.             ║");
        System.out.println("║       0. Quay lại.                      ║");
        System.out.println("╚═════════════════════════════════════════╝");
    }

    public static void menuGuideAdmin() {
        GuideSV guideSV = GuideSV.getInstance();
        displayGuide();
        menuGuideTour();
        choice = AppUltis.getIntWithBound("    Mời chọn ", 0, 5);
        switch (choice) {
            case 1 -> {
                displayClient();
                choice = AppUltis.getIntWithBound("Mời chọn ví trí:", 0, nextIdGuide() );
                if (choice == 0) {
                    menuGuideAdmin();
                } else {
                    createClient(choice);
                }
            }
            case 2 -> {
                displayGuide();
                choice = AppUltis.getIntWithBound("Mời chọn ví trí nhân viên:", 1, nextIdGuide() - 1);
                guideSV.delete(choice);
            }
            case 3 -> {
                displayGuide();
                choice = AppUltis.getIntWithBound("Mời chọn ví trí nhân viên:", 1, nextIdGuide() - 1);
                guideSV.update(choice);

            }
            case 4 -> {
                displayFeedBack();
                System.out.println("0. Quay lại.");
                choice = AppUltis.getIntWithBound("Mời chọn :", 0, 0);
                if (choice == 0) {
                    menuGuideAdmin();
                }
            }
            case 5-> {
                System.out.println("Ngày bắt đầu");
                LocalDate start = AppUltis.getDate();
                System.out.println("Ngày kết thúc");
                LocalDate end = AppUltis.getDate();
                salaryGuideOfAdmin(start,end);
                System.out.println("0. Quay lại.");
                choice = AppUltis.getIntWithBound("Mời chọn :", 0, 0);
                if (choice == 0) {
                    menuGuideAdmin();
                }
            }
            case 0 -> menuAdmin();
        }
        menuGuideAdmin();
    }

    public static void menuGuideTour() {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║       Trang quản lí hướng dẫn viên         ║");
        System.out.println("║      1. Thêm hướng dẫn viên                ║");
        System.out.println("║      2. Xóa hướng dẫn viên                 ║");
        System.out.println("║      3. Thay đổi thông tin hướng dẫn viên  ║");
        System.out.println("║      4. Xem đánh giá khách hàng            ║");
        System.out.println("║      5. Lương nhân viên                    ║");
        System.out.println("║      0. Quay lại                           ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }

    public static void pendingOrder() {
        displayBill();
        System.out.println("0. Quay lại.");
        choice = AppUltis.getIntWithBound("    Mời chọn chức năng:", 0, 0);
        if(choice ==0){
            menuAdmin();
        }
    }

    public static void monthlyRevenue() {
        monthlyRevenueGuide();
        choice = AppUltis.getIntWithBound("    Mời chọn chức năng:", 0, 1);
        switch (choice) {
            case 1 -> {
                System.out.println("Ngày bắt đầu");
                LocalDate star = AppUltis.getDate();
                System.out.println("Ngày kết thúc");
                LocalDate end = AppUltis.getDate();
                printBillFromTo(star, end);
            }
            case 0 -> menuAdmin();
        }
        monthlyRevenue();
    }

    public static void monthlyRevenueGuide() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         Trang doanh thu              ║");
        System.out.println("║    1. Xem doanh thu ngày trong tháng ║");
        System.out.println("║    0. Quay lại                       ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    public static void main(String[] args) {
        menuAdmin();
    }
}


