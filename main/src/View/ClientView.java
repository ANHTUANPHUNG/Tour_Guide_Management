package View;

import service.BillSV;
import utils.AppUltis;

import static View.TotalView.menu;
import static service.GuideSV.*;

public class ClientView {
    public static void main(String[] args) {
        menuClient();
    }

    static int choice;
    public static void menuClient() {
        menuClientView();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn):", 0, 4);
        switch (choice) {
            case 1 -> listGuideMenu();
            case 2 -> rentedOrder();
            case 3 -> orderPendingApproval();
            case 4 -> orderInProgressClient();
            case 0 -> menu();
        }
    }
    public static void menuClientView(){
        System.out.println("Trang cá nhân ");
        System.out.println("1. Danh sách hướng dẫn viên.");
        System.out.println("2. Đơn hàng đã thuê.");
        System.out.println("3. Đơn hàng đang chờ duyệt.");
        System.out.println("4. Đơn hàng đang hoạt động");
        System.out.println("0. Quay lại.");
    }
    public static void listGuideMenu(){
        displayGuide();
        listGuide();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn ):", 0, 3);
        switch (choice) {
            case 1 -> pickATourGuide();
            case 2 -> rateGuide();
            case 0 -> menuClient();
        }
    }
    public static void listGuide(){
        System.out.println("Danh sách hướng dẫn viên.");
        System.out.println("1. Chọn hướng dẫn viên");
        System.out.println("2. Đánh giá hướng dẫn viên");
        System.out.println("0. Quay lại .");
    }
    public static void pickATourGuide(){
        displayGuide();
        System.out.println("0. Quay lại");
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn ):", 0, nextIdGuide()-1);
        if(choice ==0 ){
            listGuideMenu();
        }
        if(choice>0 && choice<nextIdGuide()-1){
            BillSV.createa(choice);
<<<<<<< HEAD

=======
>>>>>>> 3d342bd0a88d133efd8d0e6542c7e6569d377a76
        }

    }
    public static void rateGuide(){

    }
    public static void rentedOrder(){

    }
    public static void orderPendingApproval(){

    }
    public static void orderInProgressClient(){
        orderInProgress();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn ):", 0, 1);
        switch (choice) {
//            case 1: in bill
            case 2:
                cancelTheOrderClient();
            case 0:
                menuClient();
        }
    }

    public static void orderInProgress() {
        System.out.println("Đơn hàng đang hoạt động");
        System.out.println("1. Xem đơn hàng.");
        System.out.println("2. Huỷ đơn hàng.");
        System.out.println("0. Quay lại.");
    }

    //    huỷ đơn
    public static void cancelTheOrderClient() {
        cancelTheOrder();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn):", 0, 1);
        switch (choice) {
//            case 1 -> bhuyr đơn hàng();
            case 0 -> orderInProgressClient();
        }
    }
    public static void cancelTheOrder() {
        System.out.println("1. Huỷ đơn hàng.");
        System.out.println("0. Quay lại.");
    }
}
