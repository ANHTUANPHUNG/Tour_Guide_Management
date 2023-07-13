package View;

import Models.Bill;
import Models.FeedBack;
import eNum.EStatusBill;
import service.FeedBackSV;
import utils.AppUltis;

import static View.TotalView.menu;
import static service.BillSV.*;
import static service.FeedBackSV.displayFeedBackGuide;
import static service.FeedBackSV.feedBackList;
import static service.GuideSV.*;

public class GuideView {
    static int choice;

    // quản lí danh sách
    public static void menuTourGuide() {
        menuGuideView();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn chức năng):", 0, 4);
        switch (choice) {
            case 1 -> orderRequestedGuide();
            case 2 -> orderCompletedGuide();
            case 3 -> orderInProgressGuide();
            case 4 -> FeedBackClient();
            case 0 -> menu();
        }
    }
    public static void menuGuideView() {
        System.out.println("Trang cá nhân.");
        System.out.println("1. Đơn hàng đang được yêu cầu.");
        System.out.println("2. Đơn hàng đã hoàn thành.");
        System.out.println("3. Đơn hàng đang hoạt động");
        System.out.println("4. Đánh giá của khách hàng");
        System.out.println("0. Quay lại trang chính.");
    }
}
