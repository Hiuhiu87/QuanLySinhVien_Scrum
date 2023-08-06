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
public class NguoiDungRepository {

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

    public boolean insert(NguoiDung nguoiDung) {
        try (Connection con = DBContext.getConnection()) {
            String sql = """
                         INSERT INTO [dbo].[NGUOIDUNG]
                                    ([ID]
                                    ,[TEN]
                                    ,[EMAIL]
                                    ,[MATKHAU]
                                    ,[ROLE])
                              VALUES
                                    (?,?,?,?,?)
                         """;
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setObject(1, nguoiDung.getMa());
            preparedStatement.setObject(2, nguoiDung.getTen());
            preparedStatement.setObject(3, nguoiDung.getEmail());
            preparedStatement.setObject(4, nguoiDung.getMatKhau());
            preparedStatement.setObject(5, nguoiDung.getRole());
            int res = preparedStatement.executeUpdate();
            return res > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmail(String email) {
        try (Connection con = DBContext.getConnection()) {
            String sql = """
                         SELECT Email From NGUOIDUNG WHERE Email = ?
                         """;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, email);
            ResultSet rs = ps.executeQuery();
            String emailGet = null;
            while (rs.next()) {
                emailGet = rs.getString(1);
            }
            return emailGet;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean changePass(String email, String pass) {
        try (Connection con = DBContext.getConnection()) {
            String sql = """
                         UPDATE NGUOIDUNG
                         SET MATKHAU = ?
                         WHERE EMAIL = ?
                         """;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, pass);
            ps.setObject(2, email);
            int res = ps.executeUpdate();
            return res > 0;
        } catch (Exception e) {
            return false;
        }
    }

}
