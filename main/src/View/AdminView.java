package View;

import service.GuideSV;
import utils.AppUltis;

import java.time.LocalDate;

import static View.TotalView.menu;
import static service.BillSV.displayBill;
import static service.GuideSV.displayGuide;

import static utils.AppUltis.getYearMonthFromUser;

public class AdminView {
    static int choice;

    public static void menuAdmin() {
        menuAdminView();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 3);
        switch (choice) {
            case 1 -> menuGuideAdmin();
            case 2 -> pendingOrder();
            case 3 -> monthlyRevenue();
            case 0 -> menu();
        }
    }

    public static void menuAdminView() {
        System.out.println("Trang quản lí");
        System.out.println("1. Quản lí hướng dẫn viên.");
        System.out.println("2. Quản lí đơn hàng đang .");
        System.out.println("3. Quản lí doanh thu.");
        System.out.println("0. Quay lại trang chủ.");
    }

    public static void menuGuideAdmin() {
        GuideSV guideSV = GuideSV.getInstance();
        displayGuide();
        menuGuideTour();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 3);
        switch (choice) {
            case 1 -> guideSV.create();
            case 2 -> guideSV.delete();
            case 3 -> guideSV.update();
            case 0 -> menuAdmin();
        }
    }

    public static void menuGuideTour() {
        System.out.println("Trang quản lí hướng dẫn viên");
        System.out.println("1. Thêm hướng dẫn viên.");
        System.out.println("2. Xóa hướng dẫn viên.");
        System.out.println("3. Thay đổi thông tin hướng dẫn viên.");
        System.out.println("0. Quay lại trang quản lí.");
    }

    public static void pendingOrder() {
        displayBill();
//        System.out.println("0. Quay lại trang quản lí.");
//        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 0);
//        if (choice == 0) {
            menuAdmin();
//        }
    }

    public static void monthlyRevenue() {
        monthlyRevenueGuide();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 3);
        switch (choice) {
            case 1:
                AppUltis.getDate();
                break;
            case 2:
                getYearMonthFromUser();
            case 0:
                menuAdmin();
        }
        monthlyRevenue();
    }

    public static void monthlyRevenueGuide() {
        System.out.println("Trang doanh thu tháng");
        System.out.println("1. Xem doanh thu ngày trong tháng.");
        System.out.println("2. Xem doanh thu tháng.");
        System.out.println("0. Quay lại trang quản lí.");

    }

    public static void main(String[] args) {
        menuAdmin();
    }
}


