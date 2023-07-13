package service;

import Models.Bill;
import Models.Client;
import Models.Guide;
import Repository.CRUD;
import eNum.EGender;
import eNum.EStatusBill;
import utils.AppConstant;
import utils.AppUltis;
import utils.SerializationUtil;

import java.time.LocalDate;
import java.util.List;

import static View.ClientView.menuClient;
import static View.ClientView.setTourClient;
import static service.BillSV.*;
import static service.BillSV.billList;
import static service.FeedBackSV.createFeedBackSV;
import static service.GuideSV.displayGuide;
import static service.GuideSV.nextIdGuide;
import static utils.AppUltis.*;

public class ClientSV implements CRUD<Client> {
    static int choice;
    public static List<Client> clientList;

    static {
        clientList = (List<Client>) SerializationUtil.deserialize("Client.txt");
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
