/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.NguoiDung;
import repository.UserRepository;

/**
 *
 * @author Admin
 */
public class UserService {

    private UserRepository repository = new UserRepository();

    public NguoiDung login(String email, String password) {
        NguoiDung user = repository.getUserInfor(email);
        if (user != null) {
            if (user.getEmail().equals(email) && user.getMatKhau().equals(password)) {
                return user;
            }
        }
        return null;
    }

}
