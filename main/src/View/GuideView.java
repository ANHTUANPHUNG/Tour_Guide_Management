package View;

import utils.AppUltis;
import utils.getValue;

import static View.TotalView.menu;
import static View.TotalView.menuTotal;

public class GuideView {
    static int choice;

    // quản lí danh sách
    public static void menuTourGuide() {
        menuGuideView();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 3);
        switch (choice) {
            case 1 -> orderRequestedGuide();
            case 2 -> orderCompletedGuide();
            case 3 -> orderInProgressGuide();
            case 0 -> menu();
        }
    }

    public static void menuGuideView() {
        System.out.println("Trang cá nhân");
        System.out.println("1. Đơn hàng đang được yêu cầu.");
        System.out.println("2. Đơn hàng đã hoàn thành.");
        System.out.println("3. Đơn hàng đang hoạt động");
        System.out.println("0. Quay lại trang chính.");
    }

    // quản lí đơn hàng
    public static void orderRequestedGuide() {
        orderRequested();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 2);
        switch (choice) {
            case 1 -> acceptTheOrderGuide();
            case 2 -> declineTheOrderGuide();
            case 0 -> menuTourGuide();
        }
    }

    public static void orderRequested() {
        System.out.println("Đơn hàng đang được yêu cầu");
        System.out.println("1. Chấp thuận đơn hàng.");
        System.out.println("2. Từ chối đơn hàng.");
        System.out.println("0. Quay lại trang cá nhân.");
    }

    // đồng ý đơn hàng
    public static void acceptTheOrderGuide() {
        acceptTheOrder();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 1);
        switch (choice) {
//            case 1 ->in list bill();
            case 0 -> orderRequestedGuide();
        }
    }

    public static void acceptTheOrder() {
        System.out.println("1. Chấp thuận đơn hàng.");
        System.out.println("0. Quay lại trang quản lí đơn hàng chờ.");
    }

    //    từ chối đơn
    public static void declineTheOrderGuide() {
        declineTheOrder();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 1);
        switch (choice) {
//            case 1 -> bill();
            case 0 -> orderRequestedGuide();
        }
    }

    public static void declineTheOrder() {
        System.out.println("1. Từ chối đơn hàng.");
        System.out.println("0. Quay lại trang quản lí đơn hàng chờ.");
    }


    public static void orderCompletedGuide() {
//in bill xong cho quay lại màn hình chính
    }

    //    phần này để in đơn hàng và huỷ đơn
    public static void orderInProgressGuide() {
        orderInProgress();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 1);
        switch (choice) {
//            case 1: in bill
            case 2:
                cancelTheOrderGuide();
            case 0:
                menuGuideView();
        }
    }

    public static void orderInProgress() {
        System.out.println("Đơn hàng đang hoạt động");
        System.out.println("1. Xem đơn hàng.");
        System.out.println("2. Huỷ đơn hàng.");
        System.out.println("0. Quay lại trang cá nhân.");
    }

    //    huỷ đơn
    public static void cancelTheOrderGuide() {
        cancelTheOrder();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 1);
        switch (choice) {
//            case 1 -> huỷ đơn hàng;
            case 0 -> orderRequestedGuide();
        }
    }

    public static void cancelTheOrder() {
        System.out.println("1. Huỷ đơn hàng.");
        System.out.println("0. Quay lại trang quản lí đơn hàng đang hoạt động.");
    }
}
