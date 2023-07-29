/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dbconfig.DBContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.MonHoc;

/**
 *
 * @author H.Long
 */
public class MonHocService {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = "";
    ResultSet rs = null;
    DBContext db = new DBContext();

    public List<MonHoc> getAllMonHoc() throws SQLException {
        sql = "SELECT * FROM MONHOC";
        List<MonHoc> listMonHoc = new ArrayList<>();
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MonHoc mh = new MonHoc(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                listMonHoc.add(mh);
            }
            return listMonHoc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public int addMonHoc(MonHoc mh) throws SQLException {
        sql = "INSERT INTO MONHOC (ID, TENMON, MAMONHOC, TINCHI, LOAIMONHOC) VALUES (?, ?, ?, ?, ?)";
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, mh.getId());
            ps.setObject(2, mh.getTenMonHoc());
            ps.setObject(3, mh.getMaMonHoc());
            ps.setObject(4, mh.getTinChi());
            ps.setObject(5, mh.getLoaiMonHoc());
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

    public int updateMonHoc(MonHoc mh, String id) throws SQLException {
        sql = "UPDATE MONHOC SET TENMON = ?, MAMONHOC = ?, TINCHI = ?, LOAIMONHOC = ? WHERE ID = ?";
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, mh.getId());
            ps.setObject(2, mh.getTenMonHoc());
            ps.setObject(3, mh.getMaMonHoc());
            ps.setObject(4, mh.getTinChi());
            ps.setObject(5, mh.getLoaiMonHoc());
            ps.setObject(6, id);
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

    public int deleteMonHoc(String id) throws SQLException {
        sql = "DELETE FROM MONHOC WHERE ID = ?";
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

    public boolean checkMaTrungMonHoc(String id) {
        sql = "SELECT * FROM MONHOC WHERE ID = ?";
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
