package View;

import Models.Bill;
import Models.FeedBack;
import eNum.EStatusBill;
import service.FeedBackSV;
import utils.AppUltis;

import java.time.LocalDate;

import static View.TotalView.menu;
import static service.BillSV.*;
import static service.FeedBackSV.displayFeedBackGuide;
import static service.FeedBackSV.feedBackList;
import static service.GuideSV.*;
import static utils.AppUltis.salaryGuide;
import static utils.AppUltis.salaryGuideOfAdmin;

public class GuideView {
    static int choice;

    // quản lí danh sách
    public static void menuTourGuide() {
        menuGuideView();
        choice = AppUltis.getIntWithBound("        Mời chọn chức năng:", 0, 6);
        switch (choice) {
            case 1 -> orderRequestedGuide();
            case 2 -> orderConfirmedGuide();
            case 3 -> orderInProgressGuide();
            case 4 -> orderCompletedGuide();
            case 5 -> FeedBackClient();
            case 6 -> {
                System.out.println("Ngày bắt đầu");
                LocalDate start = AppUltis.getDate();
                System.out.println("Ngày kết thúc");
                LocalDate end = AppUltis.getDate();
                salaryGuide(start,end);
                System.out.println("0. Quay lại.");
                choice = AppUltis.getIntWithBound("Mời chọn chức năng:", 0, 0);
                if (choice == 0) {
                    menuTourGuide();
                }
            }
            case 0 -> menu();
        }
    }
    public static void menuGuideView() {
        System.out.println("╔═════════════════════════════════════════════╗");
        System.out.println("║                Trang cá nhân.               ║");
        System.out.println("║           1. Đơn hàng đang được yêu cầu.    ║");
        System.out.println("║           2. Đơn hàng đã xác nhận.          ║");
        System.out.println("║           3. Đơn hàng đang hoạt động        ║");
        System.out.println("║           4. Đơn hàng đã hoàn thành.        ║");
        System.out.println("║           5. Đánh giá của khách hàng        ║");
        System.out.println("║           6. Lương                          ║");
        System.out.println("║           0. Quay lại trang chính.          ║");
        System.out.println("╚═════════════════════════════════════════════╝");
    }

}
