/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author long0
 */
public class Diem {
    private String id;
    private String idSinhVien;
    private String idMon;
    private float diem;

    public Diem() {
    }

    public Diem(String id, String idSinhVien, String idMon, float diem) {
        this.id = id;
        this.idSinhVien = idSinhVien;
        this.idMon = idMon;
        this.diem = diem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(String idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public String getIdMon() {
        return idMon;
    }

    public void setIdMon(String idMon) {
        this.idMon = idMon;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
    

   
    public Object [] toDataDiem(){
        return new Object[]{this.id,this.idSinhVien,this.idMon,this.diem};
    }
}
