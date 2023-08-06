/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import javax.mail.MessagingException;
import model.NguoiDung;
import repository.NguoiDungRepository;

/**
 *
 * @author Admin
 */
public class NguoiDungService {

    private NguoiDungRepository repository = new NguoiDungRepository();

    public NguoiDung login(String email, String password) {
        NguoiDung user = repository.getUserInfor(email);
        if (user != null) {
            if (user.getEmail().equals(email) && user.getMatKhau().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean dangKyNguoiDung(NguoiDung nguoiDung) {
        return repository.insert(nguoiDung);
    }

    public boolean doiMatKhau(String email) {
        String emailGet = repository.getEmail(email);
        if (emailGet != null) {
            try {
                String newPass = PasswordGenerator.generatePassword();
                boolean changePass = repository.changePass(emailGet, newPass);
                XEmail.sendEmailInfor("Đổi Mật Khẩu", emailGet, newPass);
                return changePass;
            } catch (MessagingException e) {
                return false;
            }
        }
        return false;
    }

}
