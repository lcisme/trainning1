package org.example;

public class NhanVienThoiVu extends NhanVien {
    private String chucvu;
    private int soNgayLamTrongThang; // Thêm biến số ngày làm chính thức trong tháng
    private int soGioLamThem;

    public NhanVienThoiVu(String ten, String chucvu, int soNgayLamTrongThang,int soGioLamThem) {
        super(ten);
        this.chucvu = chucvu;
        this.soNgayLamTrongThang = soNgayLamTrongThang;
        this.soGioLamThem = (soNgayLamTrongThang - 22) * 8;
    }

    public int getSoGioLamThem() {
        return soGioLamThem;
    }

    public void setSoGioLamThem(int soGioLamThem) {
        this.soGioLamThem = soGioLamThem;
    }

    public String getChucVu() {
        return chucvu;
    }

    public void setChucVu(String chucvu) {
        this.chucvu = chucvu;
    }

    public int getSoNgayLamTrongThang() {
        return soNgayLamTrongThang;
    }

    public void setSoNgayLamTrongThang(int soNgayLamTrongThang) {
        this.soNgayLamTrongThang = soNgayLamTrongThang;
    }

    public double tinhLuong() {
        double luongCung = 240000 * soNgayLamTrongThang;
        double luongThem = soGioLamThem * 50000;
        return luongCung + luongThem;
    }
}
