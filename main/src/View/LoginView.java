package View;

import service.LoginSv;

import static utils.AppUltis.getString;

public class LoginView {
    public static void Login(){
        String userName = getString("Input username(Nhập tài khoản)");
        String passWord = getString("Input password(Nhập mật khẩu)");
        LoginSv.loginSV(userName,passWord);
    }
}
