package br.com.jurisconexao.notify.enums;


public interface EmailSender {
    void sendVeriftion(String to, String email);
    void sendResetPass(String to, String email);
}
