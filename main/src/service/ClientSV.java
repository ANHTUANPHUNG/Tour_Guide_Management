package service;

import Models.Admin;
import Models.Client;
import Models.Guide;
import Repository.CRUD;
import eNum.EGender;
import utils.AppConstant;
import utils.AppUltis;
import utils.SerializationUtil;
import utils.getValue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static service.MainSv.getUniqueUserName;

import static utils.AppUltis.getStringWithPattern;
import static utils.getValue.*;

public class ClientSV implements CRUD<Client> {
    public static List<Client> clientList = (List<Client>) SerializationUtil.deserialize("D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\Client.txt");
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
    public void create()  {
        int id = nextIdClient();
        String userName = getUniqueUserName();
        String password = getString("Nhập mật khẩu");
        String name = getString("Nhập họ tên");
        String dob = getString("Nhập ngày sinh");
        String address = getString("Nhập địa chỉ");
        //phone => 012345
        String phone = getStringWithPattern("Nhập số điện thoại", AppConstant.REGEX_PHONE);
        EGender gender = EGender.getGenderFromInt(getInt("Nhập giới tính"));
        Client newClient = new Client(id, userName, password, name, dob, address, phone, gender);
        ///
        clientList.add(newClient);
        SerializationUtil.serialize(clientList, "D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\Client.txt");
        System.out.println("Người dùng đã được tạo thành công!");
    }



    @Override
    public void update(int id)  {
    }

    @Override
    public void delete(int id){
    }

    @Override
    public void display() {
    }

//    public static void main(String[] args) {
//        getValue.getStringWithPattern("Nhập số ddienj t", AppConstant.REGEX_PHONE);
//    }
}
