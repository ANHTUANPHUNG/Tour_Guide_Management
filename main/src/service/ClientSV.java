package service;

import Models.Bill;
import Models.Client;
import Models.Guide;
import Repository.CRUD;
import eNum.EGender;
import eNum.EStatusBill;
import eNum.EStatusGuide;
import utils.AppConstant;
import utils.AppUltis;
import utils.SerializationUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static View.ClientView.menuClient;
import static View.ClientView.setTourClient;
import static service.BillSV.*;
import static service.BillSV.billList;
import static service.FeedBackSV.createFeedBackSV;
import static service.GuideSV.displayGuide;
import static service.GuideSV.nextIdGuide;
import static utils.AppUltis.*;
import static utils.AppUltis.CurrencyFormat.covertPriceToString;

public class ClientSV implements CRUD<Client> {
    static int choice;
    public static List<Client> clientList;

    static {
        clientList = (List<Client>) SerializationUtil.deserialize("Client.txt");
    }
    public static void displayClient() {
        System.out.println("                                                              Thông tin hướng dẫn viên:");
        System.out.println("============================================================================================================================================================================");
        System.out.printf("|%-4s| %-15s| %-12s| %-10s| %-8s| %-10s| %-20s| %-10s| %-25s| %-5s| %-25s| %-12s|\n", "ID", "Name", "Age", "Address", "Gender", "Phone", "Language", "Status", "FeedBack", "Rate", "Hashtag", "Price");
        for (Client client : clientList) {
            System.out.printf("|%-4s| %-15s| %-12s| %-10s| %-8s| %-10s| %-20s| %-10s| %-25s| %-5s| %-25s| %-12s|\n",
                    client.getIdGuide(), client.getName(), client.getAge(), client.getAddress(), client.geteGender(),
                    client.getPhone(), client.getSkill(), client.geteStatusGuide(), client.getFeedBack(), client.getRate(), client.getHastag(), covertPriceToString(client.getPrice()));
        }
        System.out.println("============================================================================================================================================================================\n\n");
    }


    private static ClientSV instance;

    public static ClientSV getInstance() {
        if (instance == null) {
            instance = new ClientSV();
        }
        return instance;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    @Override
    public Client getById(int id) {
        return null;
    }
//lấy vị trí tiếp theo
    public static int nextIdClient() {
        int maxId = 0;
        for (Client client : clientList) {
            if (client.getId() > maxId) {
                maxId = client.getId();
            }
        }
        return maxId + 1;
    }




    @Override
    public void create() {
        for( Client client :clientList){
            int IdClient = nextIdClient();
            String Name = client.getName();
            LocalDate Age = client.getDob();
            String Address = client.getAddress();
            EGender Gender = client.getGender();
            String Phone = client.getPhone();
            List<String> Language = Collections.singletonList(getString("Nhập ngoại ngữa"));
            EStatusGuide Status = EStatusGuide.getStatusGuideFromInt(AppUltis.getIntWithBound("Enter your choice(Mời chọn trạng thái):", 1, 2));
            List<String> FeedBack = Collections.singletonList(getString("Nhập phản hồi"));
            double Rate = 0;
            List<String> Hashtag = Collections.singletonList(getString("Nhập Hashtag"));
            double Price = Double.parseDouble(getString("Nhập tiền"));
            covertPriceToString(Price);
            Guide newGuide = new Guide(IdGuide, Name, Age, Address, Phone, Language, Gender, Status, FeedBack, Rate, Hashtag, Price);
            guideList.add(newGuide);
            System.out.println("Thêm nhân viên thành công");
            SerializationUtil.serialize(guideList, "guide.txt");
        }
    }

    @Override
    public void update(int id) {
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void display() {
    }

}
