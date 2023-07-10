package View;

import utils.getValue;

import static View.TotalView.menuTotal;

public class ClientView {

    static int luachon =-1;
    public static void menuClient(){
        do {
            switch (menuClientView()) {
                case 1:
                    listGuide();
                    break;
                case 2:

                    break;
                case 3:
                    break;
            }
        } while (luachon != 0);

    }
    public static int menuClientView(){
        System.out.println("Trang cá nhân ");
        System.out.println("1. Danh sách hướng dẫn viên.");
        System.out.println("2. Đơn hàng đã mua.");
        System.out.println("3. Đơn hàng đang chờ duyệt.");
        System.out.println("0. Thoát chương trình.");
        return luachon = getValue.getInt("Enter your choice(Mời chọn chức năng):");
    }
    public static void listGuide(){
        do {
            switch (listGuideMenu()) {
                case 1:
                    break;
                case 2:
                    break;

            }
        } while (luachon != 0);

    }
    public static int listGuideMenu(){
        System.out.println("Danh sách hướng dẫn viên.");
        System.out.println("1. Chọn hướng dẫn viên");
        System.out.println("2. Đánh giá hướng dẫn viên");
        System.out.println("0. Quay lại chính.");
        return luachon = getValue.getInt("Enter your choice(Mời chọn chức năng):");
    }
}
