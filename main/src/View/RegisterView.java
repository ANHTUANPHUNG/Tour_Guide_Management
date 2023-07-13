package View;

import Models.Client;
import eNum.EGender;
import service.ClientSV;
import utils.AppConstant;
import utils.AppUltis;
import utils.SerializationUtil;

import java.time.LocalDate;

import static service.ClientSV.clientList;
import static service.ClientSV.nextIdClient;
import static service.RegisterSV.*;
import static utils.AppUltis.getString;
import static utils.AppUltis.getStringWithPattern;

public class RegisterView {
    public static void Register() {
        int id = nextIdClient();
        String userName = registerCheckUserName("Nhập tên tài khoản: tài khoản gồm 6 kí tử lên và phải là chữ cái:");
        String password = registerCheckPassWord("Nhập mật khẩu: mật khẩu gồm 6 kí tự:");
        String name = registerCheckName("Nhập tên: tên gồm 6 kí tự:");
        LocalDate dob = AppUltis.getUserDateOfBirth();
        String address = getString("Nhập địa chỉ");
        String phone = getStringWithPattern("Nhập số điện thoại", AppConstant.REGEX_PHONE);
        EGender gender = EGender.getGenderFromInt(AppUltis.getIntWithBound("Enter your choice'1:MALE;2:FEMALE;3:OTHER'(Nhập giới tính):", 1, 3));
        Client newClient = new Client(id, userName, password, name, dob, address, phone, gender);
        clientList.add(newClient);
        SerializationUtil.serialize(clientList, "Client.txt");
        System.out.println("Người dùng đã được tạo thành công!");
    }
}
