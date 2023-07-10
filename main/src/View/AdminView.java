package View;

import service.GuideSV;
import utils.AppUltis;

import java.time.LocalDate;

import static service.GuideSV.displayGuide;
import static utils.AppUltis.calculateMonthlySum;

public class AdminView {
    static int luachon;

    public static void menuAdmin() {
        menuAdminView();
        luachon = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 3);
        switch (luachon) {
            case 1 -> menuGuide();
            case 2 -> pendingOrder();
            case 3 -> monthlyRevenue();
            case 0 -> menuAdmin();
        }
    }

    public static void menuAdminView() {
        System.out.println("Trang quản lí");
        System.out.println("1. Quản lí hướng dẫn viên.");
        System.out.println("2. Quản lí đơn hàng đang chờ duyệt.");
        System.out.println("3. Quản lí doanh thu.");
        System.out.println("0. Quay lại trang chủ.");
    }

    public static void menuGuide() {
        GuideSV guideSV = GuideSV.getInstance();
        displayGuide();
        menuGuideTour();
        luachon = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 3);
        switch (luachon) {
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
//         đang thiếu list đơn đang chờ
        System.out.println("Trang quản lí đơn hàng đang chờ duyệt");
        System.out.println("0. Quay lại trang quản lí.");
        luachon = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 0);
        if (luachon == 0) {
            menuAdmin();
        }
    }

    public static void monthlyRevenue() {
        monthlyRevenueGuide();
        luachon = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 3);
        switch (luachon) {
            case 1:
                AppUltis.getDate();
                break;
            case 2:
                LocalDate currentDate = LocalDate.now();
                int month = currentDate.getMonthValue();
                int year = currentDate.getYear();

                // Gọi hàm tính tổng hàng 1 trong tháng và in ra kết quả
                int sum = calculateMonthlySum(month, year, 1);
                System.out.println("Tổng hàng 1 trong tháng " + month + " năm " + year + ": " + sum);

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
        monthlyRevenue();
    }
}


