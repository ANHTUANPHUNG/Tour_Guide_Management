package service;

import Models.Client;
import Repository.CRUD;
import eNum.EGender;
import utils.AppConstant;
import utils.AppUltis;
import utils.SerializationUtil;

import java.util.List;

import static service.MainSv.getUniqueUserName;
import static utils.AppUltis.*;

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
        EGender gender = EGender.getGenderFromInt(AppUltis.getIntWithBound("Enter your choice(Nhập giới tính):", 1, 3));
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
