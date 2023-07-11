package utils;

import Models.Client;
import eNum.EGender;
import service.ClientSV;

import java.util.ArrayList;
import java.util.List;

public class InitClients {
    public static void initClients() {
        List<Client> clientLists = new ArrayList<>();
        Client client1 = new Client(1,"minhan","123456","Minh An","05-05-2000","huế","0388888888", EGender.male);
        Client client2 = new Client(2,"trungdung","123456","Trung Dũng","05-05-2000","huế","0388888888",EGender.male);
        Client client3 = new Client(3,"taiduc","123456","Tài Đức","05-05-2000","huế","0388888888",EGender.male);
        Client client4 = new Client(4,"manhhung","123456","Mạnh Hùng","05-05-2000","huế","0388888888",EGender.male);
        clientLists.add(client1);
        clientLists.add(client2);
        clientLists.add(client3);
        clientLists.add(client4);
        ClientSV.clientList = clientLists;
        SerializationUtil.serialize(clientLists, "D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\Client.txt");
    }
}
