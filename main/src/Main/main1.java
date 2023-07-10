package Main;

import utils.InitAdmin;
import utils.InitClients;
import utils.InitGuide;

import java.io.IOException;

import static View.TotalView.menu;

public class main1 {
    public static void main(String[] args){
//        Khi muốn fake dữ liệu CLient
        InitClients.initClients();
        InitAdmin.initAdmin();
        InitGuide.intGuide();;
        try{
            menu();}
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
