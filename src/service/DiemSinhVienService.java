/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dbconfig.DBContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Diem;

/**
 *
 * @author Admin
 */
public class DiemSinhVienService {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;
    DBContext db = new DBContext();

    public List<Diem> getAllDiem() throws SQLException {
        sql = "SELECT * FROM DIEM";
        List<Diem> listDiem = new ArrayList<>();
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Diem diem = new Diem(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
                listDiem.add(diem);
            }
            return listDiem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public int addDiem(Diem diem) throws SQLException {
        sql = "INSERT INTO DIEM (ID, IDSINHVIEN, IDMON, DIEM) VALUES (?, ?, ?, ?)";
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, diem.getId());
            ps.setObject(2, diem.getIdSinhVien());
            ps.setObject(3, diem.getIdMon());
            ps.setObject(4, diem.getDiem());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

}
