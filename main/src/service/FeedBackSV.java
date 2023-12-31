package service;

import Models.Bill;
import Models.FeedBack;
import Models.Guide;
import Repository.CRUD;
import utils.AppUltis;
import utils.SerializationUtil;

import java.time.LocalDate;
import java.util.List;

import static service.BillSV.getTheCurrentlyLoginID;
import static service.GuideSV.guideList;
import static service.LoginSv.checkUserName1;
import static service.LoginSv.checkUserName2;
import static utils.AppUltis.CurrencyFormat.covertPriceToString;
import static utils.AppUltis.getString;

public class FeedBackSV implements CRUD<FeedBack> {
    public static List<FeedBack> feedBackList;

    static {
        feedBackList = (List<FeedBack>) SerializationUtil.deserialize("FeedBack.txt");
    }

    public static void main(String[] args) {
        displayFeedBackGuide("Trường An");
    }

    public static void displayFeedBack() {
        System.out.println("                                                 Đánh giá của khách:");
        System.out.println("======================================================================================================================================================");
        System.out.printf("|%-4s| %-25s| %-15s| %-15s| %-20s| %-53s| %-5s|\n",
                "STT", "Tài khoản khách", "Tên khách", "Tên NV", "Ngày", "Đánh giá", "Sao");
        for (FeedBack feedBack : feedBackList) {
            System.out.printf("|%-4s| %-25s| %-15s| %-15s| %-20s| %-53s| %-5s|\n",
                    feedBack.getId(), feedBack.getIdClient(),feedBack.getNameClient(), feedBack.getNameGuide(), feedBack.getInvoiceDate(),
                    feedBack.getFeedback(), feedBack.getRate());
        }
        System.out.println("=======================================================================================================================================================\n\n");}

    public static void displayFeedBackGuide(String name) {
        System.out.println("                                                              Đánh giá khách hàng:");
        System.out.println("=============================================================================================================================");
        System.out.printf("|%-4s| %-15s| %-15s|  %-20s| %-53s| %-5s|\n", "STT", "Tên khách", "Tên NV", "Ngày", "Đánh giá", "Sao");
        for (FeedBack feedBack : feedBackList) {
            if (feedBack.getNameGuide().equals(name)) {
                System.out.printf("|%-4s| %-15s|  %-15s| %-20s| %-53s| %-5s| \n",
                        feedBack.getId(), feedBack.getNameClient(), feedBack.getNameGuide()
                        , feedBack.getInvoiceDate(), feedBack.getFeedback(), feedBack.getRate());
            }
        }
        System.out.println("=============================================================================================================================\n\n");
    }

    @Override
    public FeedBack getById(int id) {
        return feedBackList.stream()
                .filter(feedBack -> feedBack.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static int nextIdFeedBack() {
        int maxId = 0;
        for (FeedBack feedBack : feedBackList) {
            if (feedBack.getId() > maxId) {
                maxId = feedBack.getId();
            }
        }
        return maxId + 1;
    }

    @Override
    public void create() {
    }

    public static void createFeedBackSV(Guide guide) {
        int id = nextIdFeedBack();
        String IdClient = checkUserName1();
        String NameClient= checkUserName2();
        int IdGuild = guide.getIdGuide();
        String nameGuide = guide.getName();
        LocalDate InvoiceDate1 = LocalDate.now();
        String FeedBack = getString("Mời nhập đánh giá của bạn");
        int Rate = AppUltis.getIntWithBound("Enter your choice(Nhập số nguyên để đánh giá):", 1, 5);
        FeedBack feedBack = new FeedBack(id, IdClient, InvoiceDate1, IdGuild, nameGuide, FeedBack, Rate);
        guide.setRate(totalRate(guide.getIdGuide()));
        feedBackList.add(feedBack);
        System.err.println("Đánh giá thành công");
        SerializationUtil.serialize(feedBackList, "FeedBack.txt");
    }

    public static double totalRate(int id) {
        int count = 0;
        int rate = 0;
        double totalRate;
        for (FeedBack feedBack : feedBackList) {
            if (feedBack.getIdGuide() == id) {
                rate += feedBack.getRate();
                count++;
            }
        }
        if (count == 0) {
            totalRate = 0;
        } else {
            totalRate = (double) rate / count;
        }
        return totalRate;
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
