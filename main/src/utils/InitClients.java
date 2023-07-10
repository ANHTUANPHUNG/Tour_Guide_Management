package utils;

import Models.Client;
import service.ClientSV;

import java.util.ArrayList;
import java.util.List;

public class InitClients {
    public static void initClients() {
        List<Client> clientList = new ArrayList<>();
        Client client1 = new Client("anhtuan1", "123456");
        Client client2 = new Client("anhthu1", "123456");
        Client client3 = new Client("quangtuan1", "123456");
        Client client4 = new Client("phantrung1", "123456");
        clientList.add(client1);
        clientList.add(client2);
        clientList.add(client3);
        clientList.add(client4);
        ClientSV.clientList = clientList;
        SerializationUtil.serialize(clientList, "D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\Client.txt");
    }
}
