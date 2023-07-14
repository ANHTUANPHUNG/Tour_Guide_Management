package View;
import Models.Bill;
import Models.Guide;
import eNum.EStatusBill;
import service.BillSV;
import service.GuideSV;
import utils.AppUltis;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static View.TotalView.menu;
import static eNum.EStatusBill.isBillComplete;
import static service.BillSV.*;
import static service.FeedBackSV.createFeedBackSV;
import static service.GuideSV.*;
import static utils.AppUltis.CurrencyFormat.covertPriceToString;

public class ClientView {
    static int choice;
    public static void menuClient() {
        final String idCLIENT = getTheCurrentlyLoginID();
        menuClientView();
        choice = AppUltis.getIntWithBound("     Enter your choice(Mời chọn):", 0, 3);
        switch (choice) {
            case 1 -> {
                boolean check = true;
                for (Bill bill : billList) {
                    if (bill.getNameClient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.WAITING)
                            ||bill.getNameClient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.CONFIRMED)
                            ||bill.getNameClient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.INPROGRESS)) {
                            check = false;
                            break;

                    }
                }

                if (!check) {
                    System.out.println("Cannot select date. You have either Waiting for confirmation, Confirmed, or In progress status " +
                            "(Không thể chọn ngày. Bạn đang có Đang chờ xác nhận, Đã xác nhận hoặc Đang chạy).");
                    menuClient();
                } else {
                    LocalDate startDate = AppUltis.getDateBook("Start Date (Ngày khởi hành)");
                    LocalDate endDate;
                    long daysBetween;
                    do {
                        System.out.println("End Date (Ngày kết thúc)");
                        endDate = AppUltis.getDate();
                        daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
                        if (daysBetween < 2 || daysBetween > 31) {
                            System.err.println("Invalid duration. End date must be at least 2 days after the start date and within 30 days " +
                                    "(Thời lượng không hợp lệ. Ngày kết thúc phải sau ngày bắt đầu ít nhất 2 ngày và không quá 30 ngày).");
                        }
                    } while (daysBetween < 2 || daysBetween > 31);

                    setTourClient(startDate, endDate);
                }
            }
            case 2 -> rentedOrder();
            case 3->rateGuide();
            case 0 -> menu();
        }
    }

    public static void menuClientView() {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║             Trang cá nhân          ║");
        System.out.println("║          1. Chọn ngày đi Tour.     ║");
        System.out.println("║          2. Đơn hàng của bạn.      ║");
        System.out.println("║          3. Đánh giá nhân viên.    ║");
        System.out.println("║          0. Quay lại.              ║");
        System.out.println("╚════════════════════════════════════╝");
    }
    // ngày để chọn guide
    public static void setTourClient(LocalDate startDate, LocalDate endDate) {
        setTour(startDate, endDate);
        listGuide();
        choice = AppUltis.getIntWithBound("    Enter your choice(Mời chọn ):", 0, 1);
        switch (choice) {
            case 1 -> pickATourGuide(startDate, endDate);
            case 0 -> menuClient();
        }
    }

    public static void listGuide() {
        System.out.println("╔═══════════════════════════════════════════╗");
        System.out.println("║          Danh sách hướng dẫn viên         ║");
        System.out.println("║       1. Chọn hướng dẫn viên              ║");
        System.out.println("║       0. Quay lại                         ║");
        System.out.println("╚═══════════════════════════════════════════╝");

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
        choice = AppUltis.getIntWithBound("    Enter your choice(Mời chọn ):", 0, nextIdGuide() - 1);
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
        if (!hasPendingApproval) {
            displayBill(idCLIENT);
        }else {
            System.out.println("Không có đơn hàng");
            menuClient();
        }
        rentedOrderClients();
        choice = AppUltis.getIntWithBound("     Enter your choice(Mời chọn):", 0, 3);
        switch (choice) {
            case 1 -> orderPendingApproval();
            case 2 -> orderApproved();
            case 3 -> orderInProgress();
            case 0 -> menuClient();
        }
    }

    public static void rentedOrderClients() {
        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("║           Đơn hàng                ║");
        System.out.println("║     1. Đơn hàng đang chờ duyệt    ║");
        System.out.println("║     2. Đơn hàng đã duyệt          ║");
        System.out.println("║     3. Đơn hàng đang hoạt động    ║");
        System.out.println("║     0. Quay lại                   ║");
        System.out.println("╚═══════════════════════════════════╝");
    }

    public static void orderPendingApproval() {
        final String idCLIENT = getTheCurrentlyLoginID();
        if (billList.isEmpty()) {
            System.err.println("Bạn chưa đặt hàng");
            return;
        }
        boolean hasPendingApproval = false;
        for (Bill bill : billList) {
            if (bill.getNameClient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.WAITING) ||bill.getNameClient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.Refuse)) {
                hasPendingApproval = true;
                break;
            }
        }
        if (hasPendingApproval) {
            displayBill(idCLIENT);

        }else {
            System.err.println("Không có yêu cầu đang chờ duyệt.");
            rentedOrder();
        }
        orderWaiting();
        choice = AppUltis.getIntWithBound("    Enter your choice(Mời chọn):", 0, 2);
        switch (choice) {
            case 1:
                boolean hasCancelledBill = false;
                for (Bill bill : billList) {
                    if (bill.getNameClient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.WAITING)) {
                        bill.setStatus(EStatusBill.DELETE);
                        hasCancelledBill = true;
                        break;
                    }
                }

                if (hasCancelledBill) {
                    System.err.println("Hủy thành công");
                } else {
                    System.err.println("Đơn đã bị huỷ trước đó");
                }
                menuClient();
            case 0:
                menuClient();
        }
    }
    public static void orderWaiting() {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║          Đơn hàng đang chờ duyệ       ║");
        System.out.println("║        1. Huỷ đơn hàng                ║");
        System.out.println("║        0. Quay lại                    ║");
        System.out.println("╚═══════════════════════════════════════╝");
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
        }else {
            System.err.println("Không có đơn đã duyệt.");
            rentedOrder();
        }
        orderApprovedClient();
        choice = AppUltis.getIntWithBound("    Enter your choice(Mời chọn ):", 0, 1);
        switch (choice) {
            case 1:
                boolean hasCancelledBill = false;
                for (Bill bill : billList) {
                    if (bill.getNameClient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.CONFIRMED)) {
                        bill.setStatus(EStatusBill.DELETE);
                        hasCancelledBill = true;
                        break;
                    }
                }

                if (hasCancelledBill) {
                    System.err.println("Hủy thành công");
                } else {
                    System.err.println("Đơn đã bị huỷ trước đó");
                }
                menuClient();
            case 0:
                menuClient();
        }
    }

    public static void orderApprovedClient() {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║            Đơn hàng đã duyệt          ║");
        System.out.println("║        1. Huỷ đơn hàng                ║");
        System.out.println("║        0. Quay lại                    ║");
        System.out.println("╚═══════════════════════════════════════╝");
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
        }else {
            System.err.println("Không có đơn đang chạy.");
            rentedOrder();
        }
        orderInProgressClient();
        choice = AppUltis.getIntWithBound("    Enter your choice(Mời chọn ):", 0, 2);
        switch (choice) {
            case 1:
                boolean hasCancelledBill = false;
                for (Bill bill : billList) {
                    if (bill.getNameClient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.INPROGRESS)) {
                        bill.setStatus(EStatusBill.DELETE);
                        hasCancelledBill = true;
                        break;
                    }
                }

                if (hasCancelledBill) {
                    System.err.println("Hủy thành công");
                } else {
                    System.err.println("Đơn đã bị huỷ trước đó");
                }
            case 2:
                for (Bill bill : billList) {
                    if (bill.getNameClient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.INPROGRESS)) {
                        System.out.println("Thay đổi ngày kết thúc");
                        LocalDate EndDate = AppUltis.getDate();
                        long daysBetween = ChronoUnit.DAYS.between(bill.getStarDate(), EndDate);
                        double Total = (daysBetween+1) * bill.getPrice();
                        covertPriceToString(Total);
                        bill.setEndDate(EndDate);
                        bill.setTotal(Total);
                        System.out.println("Sửa đơn thành công");
                    }
                }
            case 0:
                menuClient();
        }
    }

    public static void orderInProgressClient() {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║       Đơn hàng đang hoạt động         ║");
        System.out.println("║     1. Huỷ đơn hàng                   ║");
        System.out.println("║     2. Gia hạn đơn hàng               ║");
        System.out.println("║     0. Quay lại                       ║");
        System.out.println("╚═══════════════════════════════════════╝");
    }

}
