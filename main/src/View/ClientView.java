package View;
import Models.Bill;
import Models.Guide;
import eNum.EStatusBill;
import service.BillSV;
import service.GuideSV;
import utils.AppUltis;
import java.time.LocalDate;
import static View.TotalView.menu;
import static service.BillSV.*;
import static service.FeedBackSV.createFeedBackSV;
import static service.GuideSV.*;
public class ClientView {
    static int choice;
    public static void menuClient() {
        menuClientView();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn):", 0, 2);
        switch (choice) {
            case 1 -> {
                System.out.println("Ngày bắt đầu");
                LocalDate StarDate = AppUltis.getDate();
                System.out.println("Ngày kết thúc");
                LocalDate EndDate = AppUltis.getDate();
                setTourClient(StarDate, EndDate);
            }
            case 2 -> rentedOrder();
            case 0 -> menu();
        }
    }

    public static void menuClientView() {
        System.out.println("Trang cá nhân ");
        System.out.println("1. Chọn ngày đi Tour.");
        System.out.println("2. Đơn hàng của bạn.");
        System.out.println("0. Quay lại.");
    }
    // ngày để chọn guide
    public static void setTourClient(LocalDate startDate, LocalDate endDate) {
        setTour(startDate, endDate);
        listGuide();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn ):", 0, 2);
        switch (choice) {
            case 1 -> pickATourGuide(startDate, endDate);
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
    public static void pickATourGuide(LocalDate startDate, LocalDate endDate) {
        displayGuide();
        System.out.println("0. Quay lại");
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn ):", 0, nextIdGuide() - 1);
        if (choice == 0) {
            setTourClient(startDate, endDate);
        }
        if (choice > 0 && choice < nextIdGuide()) {
            GuideSV guideSV = new GuideSV();
            Guide guide = guideSV.getById(choice);
            BillSV.createBillSV(guide, startDate, endDate);
            menuClient();
        }
    }

    public static void rateGuide() {
        displayGuide();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn ):", 0, nextIdGuide() - 1);
        GuideSV guideSV = new GuideSV();
        Guide guide = guideSV.getById(choice);
        createFeedBackSV(guide);
        menuClient();
    }

    public static void rentedOrder() {
        String idCLIENT = getTheCurrentlyLoginID();
        if (billList.isEmpty()) {
            System.err.println("Bạn chưa đặt hàng");
            return;
        }
        boolean hasPendingApproval = false;
        for (Bill bill : billList) {
            if (bill.getNameClient().equals(idCLIENT)) {
                hasPendingApproval = true;
                break;
            }
        }
        if (hasPendingApproval) {
            displayBill(idCLIENT);
        }
        rentedOrderClients();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn):", 0, 3);
        switch (choice) {
            case 1 -> orderPendingApproval();
            case 2 -> orderApproved();
            case 3 -> orderInProgress();
            case 0 -> menuClient();
        }
    }

    public static void rentedOrderClients() {
        System.out.println("1. Đơn hàng đang chờ duyệt.");
        System.out.println("2. Đơn hàng đã duyệt.");
        System.out.println("3. Đơn hàng đang hoạt động");
        System.out.println("0. Quay lại.");
    }

    public static void orderPendingApproval() {
        final String idCLIENT = getTheCurrentlyLoginID();
        if (billList.isEmpty()) {
            System.err.println("Bạn chưa đặt hàng");
            return;
        }
        boolean hasPendingApproval = false;
        for (Bill bill : billList) {
            if (bill.getNameClient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.WAITING) && bill.getStatus().equals(EStatusBill.Refuse)) {
                hasPendingApproval = true;
                break;
            }
        }
        if (hasPendingApproval) {
            displayBill(idCLIENT);
        }
        orderPendingApprovalClient();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn):", 0, 2);
        switch (choice) {
            case 1:
                billList.stream()
                        .filter(e -> e.getNameClient().equals(idCLIENT))
                        .filter(e -> e.getStatus().equals(EStatusBill.WAITING))
                        .forEach(e -> e.setStatus(EStatusBill.DELETE));
                System.err.println("Hủy thành công");
                menuClient();
            case 2:
                for (Bill bill : billList) {
                    if (bill.getNameClient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.WAITING)) {
                        BillSV.updated(bill.getNameClient());
                    }
                }
            case 0:
                menuClient();
        }
    }

    public static void orderPendingApprovalClient() {
        System.out.println("Đơn hàng đang chờ duyệt");
        System.out.println("1. Huỷ đơn hàng.");
        System.out.println("2. Dời lịch đơn hàng.");
        System.out.println("0. Quay lại.");
    }

    public static void orderApproved() {
        final String idCLIENT = getTheCurrentlyLoginID();
        if (billList.isEmpty()) {
            System.err.println("Đơn hàng của bạn chưa tồn tại");
            return;
        }
        boolean hasPendingApproval = false;
        for (Bill bill : billList) {
            if (bill.getNameClient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.CONFIRMED)) {
                hasPendingApproval = true;
                break;
            }
        }
        if (hasPendingApproval) {
            displayBill(idCLIENT);
        }
        orderApprovedClient();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn ):", 0, 2);
        switch (choice) {
            case 1:
                billList.stream()
                        .filter(e -> e.getNameClient().equals(idCLIENT))
                        .filter(e -> e.getStatus().equals(EStatusBill.CONFIRMED))
                        .forEach(e -> e.setStatus(EStatusBill.DELETE));
                System.err.println("Hủy thành công");
                menuClient();
            case 2:
                for (Bill bill : billList) {
                    if (bill.getNameClient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.CONFIRMED)) {
                        BillSV.updated(bill.getNameClient());
                    }
                }
            case 0:
                menuClient();
        }
    }

    public static void orderApprovedClient() {
        System.out.println("Đơn hàng đang đã duyệt");
        System.out.println("1. Huỷ đơn hàng.");
        System.out.println("0. Quay lại.");
    }

    public static void orderInProgress() {
        final String idCLIENT = getTheCurrentlyLoginID();
        if (billList.isEmpty()) {
            System.err.println("Đơn hàng của bạn chưa tồn tại");
            return;
        }
        boolean hasPendingApproval = false;
        for (Bill bill : billList) {
            if (bill.getNameClient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.INPROGRESS)) {
                hasPendingApproval = true;
                break;
            }
        }
        if (hasPendingApproval) {
            displayBill(idCLIENT);
        }
        orderInProgressClient();
        choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn ):", 0, 1);
        switch (choice) {
            case 1:
                billList.stream()
                        .filter(e -> e.getNameClient().equals(idCLIENT))
                        .filter(e -> e.getStatus().equals(EStatusBill.INPROGRESS))
                        .forEach(e -> e.setStatus(EStatusBill.DELETE));
                System.err.println("Hủy thành công");
                menuClient();
            case 2:
                for (Bill bill : billList) {
                    if (bill.getNameClient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.INPROGRESS)) {
                        BillSV.extended(bill.getNameClient());
                    }
                }
            case 0:
                menuClient();
        }
    }

    public static void orderInProgressClient() {
        System.out.println("Đơn hàng đang hoạt động");
        System.out.println("1. Huỷ đơn hàng.");
        System.out.println("1. Gia hạn đơn hàng.");
        System.out.println("0. Quay lại.");
    }

}
