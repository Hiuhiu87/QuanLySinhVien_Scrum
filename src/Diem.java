public class Diem {
    private String Id;
    private String IdSinhVien;
    private String IdMon;
    private float Diem;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getIdSinhVien() {
        return IdSinhVien;
    }

    public void setIdSinhVien(String idSinhVien) {
        IdSinhVien = idSinhVien;
    }

    public String getIdMon() {
        return IdMon;
    }

    public void setIdMon(String idMon) {
        IdMon = idMon;
    }

    public float getDiem() {
        return Diem;
    }

    public void setDiem(float diem) {
        Diem = diem;
    }

    public Diem() {
    }

    public Diem(String id, String idSinhVien, String idMon, float diem) {
        Id = id;
        IdSinhVien = idSinhVien;
        IdMon = idMon;
        Diem = diem;
    }
}
