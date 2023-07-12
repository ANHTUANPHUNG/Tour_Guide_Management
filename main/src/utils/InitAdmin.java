package utils;

import Models.Admin;
import service.AdminSV;
import service.ClientSV;

import java.util.ArrayList;
import java.util.List;

public class InitAdmin {
    public static void initAdmin() {
        List<Admin> admins = new ArrayList<>();
        Admin admin = new Admin("tuyettuyet", "123456");
        admins.add(admin);
        SerializationUtil.serialize(admins, "D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\Admin.txt");
    }
}
