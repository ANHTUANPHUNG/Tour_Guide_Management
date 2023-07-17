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
        String userName = registerCheckUserName("Enter the account name: The account consists of 6 uppercase letters and must be alphabetic(Nhập tên tài khoản: tài khoản gồm 6 kí tử lên và phải là chữ cái):");
        String password = registerCheckPassWord("Enter the password: The password consists of 6 characters(Nhập mật khẩu: mật khẩu gồm 6 kí tự):");
        String name = registerCheckName("Enter name: The name consists of 6 characters(Nhập tên: tên gồm 6 kí tự):");
        LocalDate dob = AppUltis.getUserDateOfBirth();
        String address = getString("Enter address(Nhập địa chỉ)");
        String phone = getStringWithPattern("Enter phone(Nhập số điện thoại)", AppConstant.REGEX_PHONE);
        EGender gender = EGender.getGenderFromInt(AppUltis.getIntWithBound("Enter your choice'1:MALE;2:FEMALE;3:OTHER'(Nhập giới tính'1:nam,2:nữ,3:khác'):", 1, 3));
        Client newClient = new Client(id, userName, password, name, dob, address, phone, gender);
        clientList.add(newClient);
        SerializationUtil.serialize(clientList, "Client.txt");
        System.out.println("User has been created successfully(Người dùng đã được tạo thành công)!");
    }
}
