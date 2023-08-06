/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;


import dbconfig.DBContext;
import java.sql.*;
import model.NguoiDung;

/**
 *
 * @author Admin
 */
public class UserRepository {

    public NguoiDung getUserInfor(String email) {
        try (Connection con = DBContext.getConnection();) {
            String sql = """
                         SELECT [ID]
                               ,[TEN]
                               ,[EMAIL]
                               ,[MATKHAU]
                               ,[ROLE]
                           FROM [dbo].[NGUOIDUNG]
                         WHERE [EMAIL] = ?
                         """;
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setObject(1, email);
            NguoiDung nguoiDung = new NguoiDung();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                nguoiDung.setMa(rs.getString(1));
                nguoiDung.setTen(rs.getString(2));
                nguoiDung.setEmail(rs.getString(3));
                nguoiDung.setMatKhau(rs.getString(4));
                nguoiDung.setRole(rs.getBoolean(5));
            }
            return nguoiDung;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        NguoiDung nd = new UserRepository().getUserInfor("hailong@gmail.com");
        System.out.println(nd.getMa());
    }

}
