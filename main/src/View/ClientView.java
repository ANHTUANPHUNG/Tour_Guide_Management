package View;

import Models.Bill;
import Models.Client;
import Models.Guide;
import eNum.EStatusBill;
import service.BillSV;
import service.ClientSV;
import service.FeedBackSV;
import service.GuideSV;
import utils.AppUltis;

import java.util.List;
import java.util.Objects;

import static View.TotalView.menu;
import static service.BillSV.billList;
import static service.BillSV.getTheCurrentlyLoginID;
import static service.FeedBackSV.createFeedBackSV;
import static service.GuideSV.*;
import static service.LoginSv.checkUserName1;

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
            case 4 -> orderInProgress();
            case 0 -> menu();
        }
    }

    public static void menuClientView() {
        System.out.println("Trang cá nhân ");
        System.out.println("1. Danh sách hướng dẫn viên.");
        System.out.println("2. Đơn hàng đã thuê.");
        System.out.println("3. Đơn hàng đang chờ duyệt.");
        System.out.println("4. Đơn hàng đang hoạt động");
        System.out.println("0. Quay lại.");
    }

    public static void listGuideMenu() {
        displayGuide();
        listGuide();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn ):", 0, 3);
        switch (choice) {
            case 1 -> pickATourGuide();
            case 2 -> rateGuide();
            case 0 -> menuClient();
        }
    }

    public static void listGuide() {
        System.out.println("Danh sách hướng dẫn viên.");
        System.out.println("1. Chọn hướng dẫn viên");
        System.out.println("2. Đánh giá hướng dẫn viên");
        System.out.println("0. Quay lại .");
    }

    public static void pickATourGuide() {
        displayGuide();
        System.out.println("0. Quay lại");
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn ):", 0, nextIdGuide() - 1);
        if (choice == 0) {
            listGuideMenu();
        }
        if (choice > 0 && choice < nextIdGuide()) {
            GuideSV guideSV = new GuideSV();
            Guide guide = guideSV.getById(choice);
            BillSV.createBillSV(guide);
            menuClient();
        }
    }

    public static void rateGuide() {
        GuideSV guideSV = new GuideSV();
        Guide guide = guideSV.getById(choice);
        createFeedBackSV(guide);
        menuClient();
    }

    public static void rentedOrder() {
        String idCLIENT = getTheCurrentlyLoginID();
        billList.stream()
                .filter(e -> Objects.equals(e.getNameClient(), idCLIENT))
                .forEach(System.out::println);
        menuClient();
    }

    public static void orderPendingApproval() {

        String idCLIENT = getTheCurrentlyLoginID();
        if(billList==null){
            System.out.println("Bạn chưa đặt hàng");
            return;
        }
        billList.stream()
                .filter(e -> e.getNameClient().equals(idCLIENT))
                .filter(e -> e.getStatus().equals(EStatusBill.WAITING))
                .forEach(System.out::println);
        orderPendingApprovalClient();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn):", 0, 1);
        switch (choice) {
            case 1:
                billList.stream()
                        .filter(e -> e.getNameClient().equals(idCLIENT))
                        .filter(e -> e.getStatus().equals(EStatusBill.WAITING))
                        .forEach(e -> e.setStatus(EStatusBill.DELETE));
                System.out.println("Hủy thành công");
                menuClient();
            case 0:
                menuClient();
        }
    }

    public static void orderPendingApprovalClient() {
        System.out.println("Đơn hàng đang chờ duyệt");
        System.out.println("1. Huỷ đơn hàng.");
        System.out.println("0. Quay lại.");
    }

    public static void orderInProgress() {
        orderInProgressClient();
        String idClient = getTheCurrentlyLoginID();
        billList.stream()
                .filter(e -> e.getNameClient().equals(idClient))
                .filter(e -> e.getStatus().equals(EStatusBill.CONFIRMED))
                .forEach(System.out::println);
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn ):", 0, 1);
        switch (choice) {
            case 1:
                billList.stream()
                        .filter(e -> e.getNameClient().equals(idClient))
                        .filter(e -> e.getStatus().equals(EStatusBill.CONFIRMED))
                        .forEach(e -> e.setStatus(EStatusBill.DELETE));
                System.out.println("Hủy thành công");
                menuClient();
            case 0:
                menuClient();
        }
    }

    public static void orderInProgressClient() {
        System.out.println("Đơn hàng đang hoạt động");
        System.out.println("1. Huỷ đơn hàng.");
        System.out.println("0. Quay lại.");
    }
}
