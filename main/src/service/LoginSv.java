package service;

import Models.Admin;
import Models.Client;
import Models.Guide;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

import static View.AdminView.menuAdmin;
import static View.ClientView.menuClient;
import static View.GuideView.menuTourGuide;
import static View.TotalView.menu;
import static service.GuideSV.guideList;

public class LoginSv {
//    private static final StringBuilder result;
    public static String result;
    public static String result1;

//    static {
//        result = new StringBuilder();
//    }

    public static void loginSV(String userName, String passWord) {
        AdminSV users = AdminSV.getInstance();
        List<Admin> list1 = users.getUserList();
        for (Admin user : list1) {
            if (user.getUserName().equals(userName)&& user.getPassWord().equals(passWord)) {
                result = userName;
                hashPassword(passWord,generateSalt());

                menuAdmin();
                break;
            }
        }
        GuideSV guideSV = GuideSV.getInstance();
        List<Guide> guides = guideSV.getGuideList();
        for (Guide user : guides) {
            if (user.getUserName().equals(userName)&& user.getPassWord().equals(passWord)) {
                if (isGuideActive(user.getIdGuide())) {
                    result = user.getName();
                    result1 = user.getUserName();
                    hashPassword(passWord,generateSalt());

                    menuTourGuide();
                }
                return;
            }
        }
        ClientSV clientSV = ClientSV.getInstance();
        List<Client> clientSV1 = clientSV.getClientList();
        for (Client user : clientSV1) {
            if (user.getUserName().equals(userName)&& user.getPassword().equals(passWord) ) {
                result = user.getName();
                result1 = userName;
                hashPassword(passWord,generateSalt());
                menuClient();
                break;
            }
        }
        System.err.println("Invalid username or password(Tên đăng nhập hoặc mật khẩu không hợp lệ).");
        menu();
    }

//    public static void main(String[] args) {
//        System.out.println(hashPassword("123456",generateSalt()));
//        System.out.println(hashPassword("123456",generateSalt()));
//    }
    private static String hashPassword(String password, byte[] salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(salt);
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = String.format("%02x", b);
            hexString.append(hex);
        }
        return hexString.toString();
    }
    private static boolean isGuideActive(int guideId) {
        GuideSV guideSV = GuideSV.getInstance();
        List<Guide> guideList = guideSV.getGuideList();
        for (Guide guide : guideList) {
            if (guide.getIdGuide() == guideId) {
                return true;
            }
        }
        return false;
    }

    public static String checkUserName1(){
        return result;
    }
    public static String checkUserName2(){
        return result1;
    }

}
