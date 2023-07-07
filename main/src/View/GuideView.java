package View;

import utils.getValue;

public class GuideView {
    static int luachon =-1;
    public static void menuGuide(){
        do {
            switch (menuGuideView()) {
                case 0: break;
                case 1:
                    orderRequested();
                    break;
                case 2:

                    break;

            }
        } while (luachon != -1);

    }
    public static int menuGuideView(){
        System.out.println("Trang cá nhân");
        System.out.println("Mời chọn chức năng:");
        System.out.println("1. Đơn hàng đang được yêu cầu.");
        System.out.println("2. Đơn hàng đã hoàn thành.");
        System.out.println("0. Thoát chương trình.");
        return luachon = getValue.getInt("Enter your choice:");
    }
    public static void orderRequested(){
        do {
            switch (orderRequestedGuide()) {
                case 0: break;
                case 1:
                    break;
                case 2:
                    break;

            }
        } while (luachon != -1);

    }
    public static int orderRequestedGuide(){
        System.out.println("Đơn hàng đang được yêu cầu");
        System.out.println("Mời chọn chức năng:");
        System.out.println("1. Chấp thuận đơn hàng.");
        System.out.println("2. Từ chối đơn hàng.");
        System.out.println("0. Quay lại chính.");
        return luachon = getValue.getInt("Enter your choice:");
    }
}
