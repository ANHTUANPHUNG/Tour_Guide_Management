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
import static service.GuideSV.*;
import static utils.AppUltis.*;
import static utils.AppUltis.CurrencyFormat.covertPriceToString;

public class ClientSV implements CRUD<Client> {
    static int choice;
    public static List<Client> clientList;

    static {
        clientList = (List<Client>) SerializationUtil.deserialize("Client.txt");
    }


    public static void displayClient() {
        System.out.println("                                                  Thông tin khách hàng:");
        System.out.println("=====================================================================================================================");
        System.out.printf("|%-4s| %-15s| %-12s| %-15s| %-15s| %-15s| %-15s| %-10s|\n",
                "ID", "UserName", "Password", "Name", "DOB", "Address", "Phone", "Gender");
        for (Client client : clientList) {
            System.out.printf("|%-4s| %-15s| %-12s| %-15s| %-15s| %-15s| %-15s| %-10s|\n",
                    client.getId(), client.getUserName(), client.getPassword(), client.getName(), client.getDob(),
                    client.getAddress(), client.getPhone(), client.getGender());
        }
        System.out.println("=====================================================================================================================\n\n");
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

    }

    public static void createClient(int id) {
        int IdClient = nextIdGuide();
        for (Client client : clientList) {
            if (client.getId() == id) {
                String userName = client.getUserName();
                String passWord = client.getPassword();
                String Name = client.getName();
                LocalDate Age = client.getDob();
                String Address = client.getAddress();
                EGender Gender = client.getGender();
                String Phone = client.getPhone();
                List<String> Language = Collections.singletonList(getString("Nhập ngoại ngữ"));
                EStatusGuide Status = EStatusGuide.AVAILABLE;
                List<String> FeedBack = Collections.singletonList(getString("Nhập phản hồi"));
                double Rate = 0;
                List<String> Hashtag = Collections.singletonList(getString("Nhập Hashtag"));
                double Price = Double.parseDouble(getString("Nhập tiền"));
                covertPriceToString(Price);
                Guide guide = new Guide(IdClient, userName, passWord, Name, Age, Address, Phone, Language, Gender, Status, FeedBack, Rate, Hashtag, Price);
                guideList.add(guide);
                System.out.println("Thêm nhân viên thành công");
                SerializationUtil.serialize(guideList, "guide.txt");
                clientList.remove(client);
                break;
            }
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
