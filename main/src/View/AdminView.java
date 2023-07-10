package View;

import service.ClientSV;
import service.GuideSV;
import utils.getValue;

import java.io.IOException;

import static View.TotalView.menuTotal;
import static service.GuideSV.displayGuide;

public class AdminView  {
    static int luachon =-1;
    public static void menuAdmin() throws IOException{
        do {
            switch (menuAdminView()) {
                case 1:
                    menuGuide();
                    break;
                case 2:
                    pendingOrder();
                    break;
                case 3:
                    monthlyRevenue();
                    break;
            }
        } while (luachon != 0);

    }
    public static int menuAdminView(){
        System.out.println("Trang quản lí");
        System.out.println("1. Quản lí hướng dẫn viên.");
        System.out.println("2. Quản lí đơn hàng đang chờ duyệt.");
        System.out.println("3. Quản lí doanh thu.");
        System.out.println("0. Quay lại trang chủ.");
        return luachon = getValue.getInt("Enter your choice(Mời chọn chức năng):");
    }
    public static void menuGuide() throws IOException {
        GuideSV guideSV = GuideSV.getInstance();
        do {
            displayGuide();
            switch (menuGuideTour()) {
                case 1:
                    guideSV.create();
                    break;
                case 2:
                    guideSV.update();
                    break;
                case 3:

                    break;

            }
        } while (luachon != 0);

    }
    public static int menuGuideTour() {
        System.out.println("Trang quản lí hướng dẫn viên");
        System.out.println("1. Thêm hướng dẫn viên.");
        System.out.println("2. Xóa hướng dẫn viên.");
        System.out.println("3. Thay đổi thông tin hướng dẫn viên.");
        System.out.println("0. Quay lại trang quản lí.");
        return luachon = getValue.getInt("Enter your choice(Mời chọn chức năng):");
    }
    public static void pendingOrder(){
        do {
            switch (pendingOrderGuide()) {
                case 1:
                    //addTrainer();
                    break;
                case 2:
                    //deleteAdmin();
                    break;
            }
        } while (luachon != 0);

    }
    public static int pendingOrderGuide(){
        System.out.println("Trang quản lí đơn hàng khách yêu cầu");
        System.out.println("1. Chấp thuận đơn hàng.");
        System.out.println("2. Từ chối đơn hàng.");
        System.out.println("0. Quay lại trang quản lí.");
        return luachon = getValue.getInt("Enter your choice(Mời chọn chức năng):");
    }
    public static void monthlyRevenue(){
        do {
            switch (monthlyRevenueGuide()) {
                case 1:
                    //addTrainer();
                    break;
                case 2:
                    //deleteAdmin();
                    break;
            }
        } while (luachon != 0);

    }
    public static int monthlyRevenueGuide(){
        System.out.println("Trang doanh thu tháng");
        System.out.println("1. Xem doanh thu ngày trong tháng.");
        System.out.println("2. Xem doanh thu tháng.");
        System.out.println("0. Quay lại trang quản lí.");
        return luachon = getValue.getInt("Enter your choice(Mời chọn chức năng):");
    }
}
