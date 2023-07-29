/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author long0
 */
public class MonHoc {
    private String id;
    private String tenMonHoc;
    private String maMonHoc;
    private int tinChi;
    private String loaiMonHoc;

    public MonHoc() {
    }

    public MonHoc(String id, String tenMonHoc, String maMonHoc, int chungChi, String loaiMonHoc) {
        this.id = id;
        this.tenMonHoc = tenMonHoc;
        this.maMonHoc = maMonHoc;
        this.tinChi = chungChi;
        this.loaiMonHoc = loaiMonHoc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public int getTinChi() {
        return tinChi;
    }

    public void setTinChi(int chungChi) {
        this.tinChi = chungChi;
    }

    public String getLoaiMonHoc() {
        return loaiMonHoc;
    }

    public void setLoaiMonHoc(String loaiMonHoc) {
        this.loaiMonHoc = loaiMonHoc;
    }
    
    public Object [] toDataMonHoc(){
        return new Object[]{this.id,this.tenMonHoc,this.maMonHoc,this.tinChi,this.loaiMonHoc};
    }
}
