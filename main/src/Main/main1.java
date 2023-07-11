package Main;

import utils.InitAdmin;
import utils.InitBill;
import utils.InitClients;
import utils.InitGuide;

import java.io.IOException;

import static View.TotalView.menu;

public class main1 {
    public static void main(String[] args){
//        Khi muốn fake dữ liệu CLient
        InitClients.initClients();
        InitAdmin.initAdmin();
        InitGuide.intGuide();
        InitBill.initBill();
        menu();

    }
}
