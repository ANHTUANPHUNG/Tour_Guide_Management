package utils;

import Models.Admin;
import Models.Client;
import Models.Guide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class InitAuth {
    public static void initAuth(){
        List<Admin> userAdmin= new ArrayList<>();
        List<Guide> userGuide= new ArrayList<>();
        List<Client> userClient= new ArrayList<>();
        Admin admin = new Admin("tuyettuyet", "12345");
        Guide guide1 = new Guide("tuyettuyet111", "12345");
        Client client1 = new Client("tuyettuyet222111", "12345");
        userAdmin.add(admin);
        userGuide.add(guide1);
        userClient.add(client1);
        List<Object> newList = new ArrayList<>();
        newList.addAll(userAdmin);
        newList.addAll(userGuide);
        newList.addAll(userClient);
        System.out.println(newList);
    }

    public static void main(String[] args) {
        initAuth();
    }
}
