package service;

public class RegisterSV {
    public static void Register() {
        ClientSV clientSV = ClientSV.getInstance();
        clientSV.create();
    }
}
