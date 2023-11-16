package org.example;
public class NhanVienChinhThuc extends NhanVien {
    private String chucvu;

    private int soNgayLamTrongThang;

    private int soNgayLamThem;

    public NhanVienChinhThuc(String ten, String chucvu,int soNgayLamTrongThang,int soNgayLamThem) {
        super(ten);
        this.chucvu = chucvu;
        this.soNgayLamTrongThang = soNgayLamTrongThang;
        this.soNgayLamThem = soNgayLamTrongThang - 22;
    }

    public int getSoNgayLamThem() {
        return soNgayLamThem;
    }

    public void setSoNgayLamThem(int soNgayLamThem) {
        this.soNgayLamThem = soNgayLamThem;
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
        double luongCung = 0;

        if (chucvu.equals("1")) {
            luongCung = 10000000;
        } else if (chucvu.equals("2")) {
            luongCung = 6000000;
        }

        double luongThem = soNgayLamThem * 500000;
        return luongCung + luongThem;
    }

    public String getTenChucVu() {
        if ("1".equals(chucvu)) {
            return "Quan ly";
        } else if ("2".equals(chucvu)) {
            return "Cong Nhan";
        } else {
            return "Chua xac dinh";
        }
    }
}
