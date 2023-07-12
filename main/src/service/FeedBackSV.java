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
import static utils.AppUltis.CurrencyFormat.covertPriceToString;
import static utils.AppUltis.getString;

public class FeedBackSV implements CRUD<FeedBack> {
    public static List<FeedBack> feedBackList = (List<FeedBack>) SerializationUtil.deserialize("D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\FeedBack.txt");

    public static void displayFeedBack() {
        System.out.println("                                                              Thông tin hóa đơn:");
        System.out.println("===========================================================================================================================================================");
        System.out.printf("|%-4s| %-20s| %-12s| %-20s| %-12s| %-12s|\n", "ID", "Name Client", "Name Guide", "InvoiceDate", "Feedback", "Rate");
        for (FeedBack feedBack : feedBackList) {
            System.out.printf("|%-4s| %-20s| %-12s| %-20s| %-12s| %-12s| \n",
                   feedBack.getId(),feedBack.getIdClient(),feedBack.getNameGuide(),feedBack.getInvoiceDate(),feedBack.getFeedback(),feedBack.getRate());
        }
        System.out.println("===========================================================================================================================================================\n\n");
    }
    @Override
    public FeedBack getById(int id) {
        return feedBackList.stream()
                .filter(feedBack -> feedBack.getId() == id)
                .findFirst()
                .orElse(null);    }
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
        String IdClient = getTheCurrentlyLoginID();
        int IdGuild = guide.getIdGuide();
        String nameGuide =guide.getName();
        LocalDate InvoiceDate1 = LocalDate.now();
        String FeedBack = getString("Mời nhập đánh giá của bạn");
        double Rate = AppUltis.getIntWithBound("Enter your choice(Nhập số để đánh giá):", 1, 5);
        FeedBack feedBack = new FeedBack(id, IdClient,InvoiceDate1,IdGuild, nameGuide,  FeedBack, Rate);
        feedBackList.add(feedBack);
        System.out.println("Đánh giá thành công");
        SerializationUtil.serialize(feedBackList, "D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\FeedBack.txt");
    }
    public static double totalRate(int id){
        int count =0;
        int rate =0;
        double totalRate;
        for(FeedBack feedBack: feedBackList ){
            if(feedBack.getIdGuide() == id){
                rate += feedBack.getRate();
                count++;
            }
        }
        if (count == 0 ) {
            totalRate = 0;
        } else {
            totalRate= (double) rate /count;
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
