package service;

import Models.Admin;
import Models.Guide;
import Repository.CRUD;
import eNum.EDescription;
import eNum.EGender;
import utils.SerializationUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static utils.AppUltis.getInt;
import static utils.getValue.getString;

public class AdminSV implements CRUD<Guide> {
    public static List<Admin> adminList = (List<Admin>) SerializationUtil.deserialize("D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\Admin.txt");
    private static AdminSV instance;

    public static AdminSV getInstance() {
        if (instance == null) {
            instance = new AdminSV();
        }
        return instance;
    }
    public List<Admin> getUserList() {
        return adminList ;
    }


    @Override
    public Guide getById(int id) {
        return null;
    }

    @Override
    public void create()  {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id)  {

    }

    @Override
    public void display() {

    }
}
