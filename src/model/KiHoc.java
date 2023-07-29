/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author long0
 */
public class KiHoc {
    private String id;
    private String tenKyHoc;
    private int namHoc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenKyHoc() {
        return tenKyHoc;
    }

    public void setTenKyHoc(String tenKyHoc) {
        this.tenKyHoc = tenKyHoc;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }

    public KiHoc() {
    }

    public KiHoc(String id, String tenKyHoc, int namHoc) {
        this.id = id;
        this.tenKyHoc = tenKyHoc;
        this.namHoc = namHoc;
    }

    public Object[] toDataKiHoc() {
        return new Object[]{this.id, this.tenKyHoc, this.namHoc};
    }

}
