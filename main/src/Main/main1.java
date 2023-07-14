package Main;

import service.BillSV;
import utils.*;

import java.io.IOException;

import static View.TotalView.menu;

public class main1 {
    public static void main(String[] args){
//        Khi muốn fake dữ liệu CLient
        InitClients.initClients();
        InitFeedback.initFeedBacks();
        InitAdmin.initAdmin();
        InitGuide.intGuide();
        InitBill.initBill();
        menu();

    }
}
