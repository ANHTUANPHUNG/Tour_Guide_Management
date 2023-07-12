package View;

import service.LoginSv;

import static utils.AppUltis.getString;

public class LoginView {
    public static void Login(){
        String userName = getString("Nhập tài khoản");
        String passWord = getString("Nhập mật khẩu");
        LoginSv.loginSV(userName,passWord);
    }
}
