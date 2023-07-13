package utils;

import Models.Client;
import eNum.EGender;
import service.ClientSV;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InitClients {
    public static void initClients() {
        List<Client> clientLists = new ArrayList<>();
        Client client1 = new Client(1,"minhan","123456","Minh An", LocalDate.of(2000,7,15),"Hà Nội","0388888854", EGender.female);
        Client client2 = new Client(2,"trungdung","123456","Trung Dũng",LocalDate.of(1994,2,16),"Mỹ","082741777",EGender.male);
        Client client3 = new Client(3,"taiduc","123456","Tài Đức",LocalDate.of(1997,6,15),"Úc","032999911",EGender.male);
        Client client4 = new Client(4,"ngocbang","123456","Ngọc Băng",LocalDate.of(1995,1,13),"Canada","0972294555",EGender.female);
        Client client5 = new Client(5,"trungkien","123456","Trung Kiên",LocalDate.of(1998,12,16),"Sài Gòn","086999992",EGender.male);
        Client client6 = new Client(6,"thaochi","123456","Thảo Chi",LocalDate.of(1967,4,2),"Trung Quốc","0945000021",EGender.female);
        Client client7 = new Client(7,"duyluan","123456","Duy Luận",LocalDate.of(1987,6,8),"Lào","0942102277",EGender.male);
        Client client8 = new Client(8,"trucduong","123456","Trúc Dương",LocalDate.of(1983,7,3),"Thái Lan","0966202020",EGender.female);
        Client client9 = new Client(9,"hongnhung","123456","Hồng Nhung",LocalDate.of(1974,2,18),"Campuchia","0838114477",EGender.female);
        Client client10 = new Client(10,"gialong","123456","Gia Long",LocalDate.of(1954,4,21),"Ân Độ","0911700055",EGender.male);
        clientLists.add(client1);
        clientLists.add(client2);
        clientLists.add(client3);
        clientLists.add(client4);
        clientLists.add(client6);
        clientLists.add(client7);
        clientLists.add(client8);
        clientLists.add(client9);
        clientLists.add(client10);
        clientLists.add(client5);
        SerializationUtil.serialize(clientLists, "Client.txt");
    }
}
