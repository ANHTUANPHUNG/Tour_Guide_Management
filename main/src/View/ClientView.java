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
import static service.LoginSv.checkUserName1;
import static utils.AppUltis.CurrencyFormat.covertPriceToString;

public class ClientView {
    static int choice;

    public static void menuClient() {
        final String idCLIENT = getTheCurrentlyLoginID();
        menuClientView();
        choice = AppUltis.getIntWithBound("     Enter your choice(Mời chọn):", 0, 3);
        switch (choice) {
            case 1 -> {
                boolean check = false;
                for (Bill bill : billList) {
                    if (bill.getZclient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.WAITING)
                            || bill.getZclient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.CONFIRMED)
                            || bill.getZclient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.INPROGRESS)) {
                        check = true;
                        break;

                    }
                }

                if (check) {
                    System.err.println("Cannot select date. You have either Waiting for confirmation, Confirmed, or In progress status " +
                            "(Không thể chọn ngày. Bạn đang có đơn Đang chờ xác nhận, Đã xác nhận hoặc Đang chạy).");
                    menuClient();
                } else {
                    LocalDate startDate = AppUltis.getDateBook("Start Date (Ngày bắt đầu)");
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
            case 3 -> rateGuide();
            case 0 -> menu();
        }
    }

    public static void menuClientView() {
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║             Personal page(Trang cá nhân)          ║");
        System.out.println("║          1. Choose the date(Chọn ngày đi Tour).   ║");
        System.out.println("║          2. Your order(Đơn hàng của bạn).         ║");
        System.out.println("║          3. Employee rate(Đánh giá nhân viên).    ║");
        System.out.println("║          0. Go back(Quay lại).                    ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
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
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║          List of Tour Guides (Danh sách hướng dẫn viên)        ║");
        System.out.println("║       1. Choose a Tour Guide(Chọn hướng dẫn viên)              ║");
        System.out.println("║       0. Go back (Quay lại)                                    ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");

    }

    public static void pickATourGuide(LocalDate startDate, LocalDate endDate) {
        displayGuide();
        System.out.println("0. Go back (Quay lại)");
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
        if (choice == 0) {
            menuClient();
        } else {
            GuideSV guideSV = new GuideSV();
            Guide guide = guideSV.getById(choice);
            createFeedBackSV(guide);
            menuClient();
        }
    }

    public static void rentedOrder() {
        String idCLIENT = checkUserName1();
        if (billList.isEmpty()) {
            System.err.println("Your not order(Bạn chưa đặt hàng)");
            return;
        }
        boolean hasPendingApproval = false;
        for (Bill bill : billList) {
            if (bill.getZclient().equals(idCLIENT)) {
                hasPendingApproval = true;
                break;
            }
        }
        if (hasPendingApproval) {
            displayBill(idCLIENT);
        } else {
            System.out.println("Your not order(Bạn chưa đặt hàng)");
            menuClient();
        }
        rentedOrderClients();
        choice = AppUltis.getIntWithBound("     Enter your choice(Mời chọn):", 0, 4);
        switch (choice) {
                case 1 -> orderPendingApproval();
            case 2 -> orderApproved();
            case 3 -> orderInProgress();
            case 4 -> orderRefuse();
            case 0 -> menuClient();
        }
    }

    public static void rentedOrderClients() {
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║           Oder(Đơn hàng)                           ║");
        System.out.println("║     1. Order waiting(Đơn hàng đang chờ duyệt)      ║");
        System.out.println("║     2. Order confirmed (Đơn hàng đã duyệt)         ║");
        System.out.println("║     3. Oder in progress(Đơn hàng đang hoạt động)   ║");
        System.out.println("║     4. Oder refuse (Đơn hàng bị từ chối)           ║");
        System.out.println("║     0. Go back (Quay lại)                          ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
    }

    public static void orderRefuse() {
        final String idCLIENT = checkUserName1();
        if (billList.isEmpty()) {
            System.err.println("Your not order(Bạn chưa đặt hàng)");
            return;
        }
        boolean hasPendingApproval = false;
        for (Bill bill : billList) {
            if (bill.getZclient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.Refuse)) {
                hasPendingApproval = true;
                break;
            }
        }
        if (hasPendingApproval) {
            displayBillg(idCLIENT);
            System.err.println("Sorry, the order is not approved(Xin lỗi, đơn không được chấp thuận).");
            System.out.println("0. Go back (Quay lại).");
            choice = AppUltis.getIntWithBound("    Enter your choice(Mời chọn):", 0, 0);
            if (choice == 0) {
                rentedOrder();
            }
        }else {
            System.err.println("Your not order(Bạn chưa đặt hàng).");
            rentedOrder();
        }
    }

    public static void orderPendingApproval() {
        final String idCLIENT = checkUserName1();
        if (billList.isEmpty()) {
            System.err.println("Your not order(Bạn chưa đặt hàng)");
            return;
        }
        boolean hasPendingApproval = false;
        for (Bill bill : billList) {
            if (bill.getZclient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.WAITING)
            ) {
                hasPendingApproval = true;
                break;
            }

        }
        if (hasPendingApproval) {
            displayBillz(idCLIENT);

        } else {
            System.err.println("Your not order(Bạn chưa đặt hàng).");
            rentedOrder();
        }

        orderWaiting();
        choice = AppUltis.getIntWithBound("    Enter your choice(Mời chọn):", 0, 2);
        switch (choice) {
            case 1:
                boolean hasCancelledBill = false;
                for (Bill bill : billList) {
                    if (bill.getZclient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.WAITING)) {
                        bill.setStatus(EStatusBill.DELETE);
                        hasCancelledBill = true;
                        break;
                    }
                }
                if (hasCancelledBill) {
                    System.err.println("Cancelled successfully ( Hủy thành công).");
                } else {
                    System.err.println("The order has already been cancelled before (Đơn đã bị huỷ trước đó)");
                }
                menuClient();
            case 2:
                for (Bill bill : billList) {
                    if (bill.getZclient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.WAITING)) {
                        LocalDate StarDate = AppUltis.getDateBook("Start Date (Ngày bắt đầu)");
                        LocalDate endDate;
                        long daysBetween;
                        do {
                            System.out.println("End Date (Ngày kết thúc)");
                            endDate = AppUltis.getDate();
                            daysBetween = ChronoUnit.DAYS.between(StarDate, endDate);
                            if (daysBetween < 2 || daysBetween > 31) {
                                System.err.println("Invalid duration. End date must be at least 2 days after the start date and within 30 days " +
                                        "(Thời lượng không hợp lệ. Ngày kết thúc phải sau ngày bắt đầu ít nhất 2 ngày và không quá 30 ngày).");
                            }
                        } while (daysBetween < 2 || daysBetween > 31);
                        daysBetween = ChronoUnit.DAYS.between(StarDate, endDate);
                        double Total = (daysBetween + 1) * bill.getPrice();
                        covertPriceToString(Total);
                        bill.setStarDate(StarDate);
                        bill.setEndDate(endDate);
                        bill.setTotal(Total);
                        System.out.println("Order modified successfully (Sửa đơn thành công)");
                    }
                }
            case 0:
                menuClient();
        }
    }

    public static void orderWaiting() {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║          Order waiting(Đơn hàng đang chờ duyệt)      ║");
        System.out.println("║        1. Cancel order(Huỷ đơn hàng)                 ║");
        System.out.println("║        2. Change date(Đổi ngày)                      ║");
        System.out.println("║        0. Go back (Quay lại)                         ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }


    public static void orderApproved() {
        final String idCLIENT = getTheCurrentlyLoginID();
        if (billList.isEmpty()) {
            System.err.println("Your not order(Bạn chưa đặt hàng)");
            return;
        }
        boolean hasPendingApproval = false;
        for (Bill bill : billList) {
            if (bill.getZclient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.CONFIRMED)) {
                hasPendingApproval = true;
                break;
            }

        }
        if (hasPendingApproval) {
            displayBillx(idCLIENT);
        } else {
            System.err.println("Your not order(Bạn chưa đặt hàng).");
            rentedOrder();
        }

        orderApprovedClient();
        choice = AppUltis.getIntWithBound("    Enter your choice(Mời chọn ):", 0, 1);
        switch (choice) {
            case 1:
                boolean hasCancelledBill = false;
                for (Bill bill : billList) {
                    if (bill.getZclient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.CONFIRMED)) {
                        bill.setStatus(EStatusBill.DELETE);
                        hasCancelledBill = true;
                        break;
                    }
                }

                if (hasCancelledBill) {
                    System.err.println("Cancelled successfully ( Hủy thành công).");
                } else {
                    System.err.println("The order has already been cancelled before (Đơn đã bị huỷ trước đó)");
                }
                menuClient();

            case 0:
                menuClient();
        }
    }

    public static void orderApprovedClient() {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║            Order confirmed (Đơn hàng đã duyệt)       ║");
        System.out.println("║        1. Cancel order(Huỷ đơn hàng)                 ║");
        System.out.println("║        0. Go back (Quay lại)                         ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }

    public static void orderInProgress() {
        final String idCLIENT = checkUserName1();
        if (billList.isEmpty()) {
            System.err.println("Your not order(Bạn chưa đặt hàng)");
            return;
        }
        boolean hasPendingApproval = false;

        for (Bill bill : billList) {
            if (bill.getZclient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.INPROGRESS)) {
                hasPendingApproval = true;
                break;
            }

        }
        if (hasPendingApproval) {
            displayBilly(idCLIENT);

        } else {
            System.err.println("Your not order(Bạn chưa đặt hàng).");
            rentedOrder();
        }

        orderInProgressClient();
        choice = AppUltis.getIntWithBound("    Enter your choice(Mời chọn ):", 0, 2);
        switch (choice) {
            case 1:
                boolean hasCancelledBill = false;
                for (Bill bill : billList) {
                    if (bill.getZclient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.INPROGRESS)) {
                        bill.setStatus(EStatusBill.DELETE);
                        hasCancelledBill = true;
                        break;
                    }
                }

                if (hasCancelledBill) {
                    System.err.println("Cancelled successfully ( Hủy thành công).");
                } else {
                    System.err.println("The order has already been cancelled before (Đơn đã bị huỷ trước đó)");
                }
                menuClient();
            case 2:
                for (Bill bill : billList) {
                    if (bill.getZclient().equals(idCLIENT) && bill.getStatus().equals(EStatusBill.INPROGRESS)) {
                        System.out.println("Change end date(Thay đổi ngày kết thúc)");
                        LocalDate endDate;
                        long daysBetween;
                        do {
                            System.out.println("End Date (Ngày kết thúc)");
                            endDate = AppUltis.getDate();
                            daysBetween = ChronoUnit.DAYS.between(bill.getStarDate(), endDate);
                            if (daysBetween < 2 || daysBetween > 31) {
                                System.err.println("Invalid duration. End date must be at least 2 days after the start date and within 30 days " +
                                        "(Thời lượng không hợp lệ. Ngày kết thúc phải sau ngày bắt đầu ít nhất 2 ngày và không quá 30 ngày).");
                            }
                        } while (daysBetween < 2 || daysBetween > 31);
                        daysBetween = ChronoUnit.DAYS.between(bill.getStarDate(), endDate);
                        double Total = (daysBetween + 1) * bill.getPrice();
                        covertPriceToString(Total);
                        bill.setEndDate(endDate);
                        bill.setTotal(Total);
                        System.out.println("Order modified successfully (Sửa đơn thành công)");
                    }
                }
            case 0:
                menuClient();
        }
    }

    public static void orderInProgressClient() {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║        Oder in progress(Đơn hàng đang hoạt động)     ║");
        System.out.println("║     1. Cancel order(Huỷ đơn hàng)                    ║");
        System.out.println("║     2. Extend tour(Gia hạn đơn hàng)                 ║");
        System.out.println("║     0. Go back (Quay lại)                            ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }

}
