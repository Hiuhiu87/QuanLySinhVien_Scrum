/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dbconfig.DBContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.SinhVien;

/**
 *
 * @author long0
 */
public class SinhVienService {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    DBContext db = new DBContext();

    public List<SinhVien> getAllSinhVien() throws SQLException {
        sql = "SELECT * FROM SINHVIEN";
        List<SinhVien> listSV = new ArrayList<>();
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                listSV.add(sv);
            }
            return listSV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public int addSinhVien(SinhVien sv) throws SQLException {
        sql = "INSERT INTO SINHVIEN (ID, HOTEN, NGAYSINH, GIOITINH, DIACHI, SDT, EMAIL, IDLOP) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sv.getId());
            ps.setObject(2, sv.getHoTen());
            ps.setObject(3, sv.getNgaySinh());
            ps.setObject(4, sv.getGioiTinh());
            ps.setObject(5, sv.getDiaChi());
            ps.setObject(6, sv.getSoDienThoai());
            ps.setObject(7, sv.getEmail());
            ps.setObject(8, sv.getIdLop());
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

    public int updateSinhVien(SinhVien sv, String id) throws SQLException {
        sql = "UPDATE SINHVIEN SET HOTEN = ?, NGAYSINH = ?, GIOITINH = ?, DIACHI = ?, SDT = ?, EMAIL = ?, IDLOP = ? WHERE ID = ?";
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sv.getId());
            ps.setObject(2, sv.getHoTen());
            ps.setObject(3, sv.getNgaySinh());
            ps.setObject(4, sv.getGioiTinh());
            ps.setObject(5, sv.getDiaChi());
            ps.setObject(6, sv.getSoDienThoai());
            ps.setObject(7, sv.getEmail());
            ps.setObject(8, sv.getIdLop());
            ps.setObject(9, id);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }

    public int deleteSinhVien(String id) throws SQLException {
        sql = "DELETE FROM SINHVIEN WHERE ID = ?";
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
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

    public boolean checkTrungIDSinhVien(String id) throws SQLException {
        sql = "SELECT * FROM SINHVIEN WHERE ID = ?";
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ps.setObject(1, id);
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
