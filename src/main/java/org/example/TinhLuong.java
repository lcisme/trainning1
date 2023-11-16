package org.example;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TinhLuong {
    private List<NhanVien> listNV;
    private String thang;
    private String outputPath;

    public TinhLuong() {
        listNV = new ArrayList<>();
        outputPath = Paths.get("").toAbsolutePath().toString();
    }

    public void themNhanVien(NhanVien nhanVien) {
        listNV.add(nhanVien);
    }

    public void xoaNhanVien(String ten) {
        listNV.removeIf(nhanVien -> nhanVien.getTen().equals(ten));
    }

    public void suaThongTinNhanVien(String ten) {
        Scanner scanner = new Scanner(System.in);
        for (NhanVien nhanVien : listNV) {
            if (nhanVien.getTen().equals(ten)) {
                System.out.println("Nhap lai thong tin cho nhan vien " + ten);
                System.out.print("Ten: ");
                String tenMoi = scanner.nextLine();
                nhanVien.setTen(tenMoi);

                if (nhanVien instanceof NhanVienChinhThuc) {
                    NhanVienChinhThuc nvc = (NhanVienChinhThuc) nhanVien;
                    System.out.print("So ngay lam trong thang: ");
                    int soNgayLamTrongThangMoi = scanner.nextInt();
                    scanner.nextLine();
                    nvc.setSoNgayLamTrongThang(soNgayLamTrongThangMoi);
                    int soNgayLamThemMoi = soNgayLamTrongThangMoi - 22;
                    nvc.setSoNgayLamThem(soNgayLamThemMoi);
                    System.out.print("Chuc vu (Quan ly chon 1 hoac Cong nhan chon 2): ");
                    String chucVuMoi = scanner.nextLine();
                    nvc.setChucVu(chucVuMoi);
                } else if (nhanVien instanceof NhanVienThoiVu) {
                    NhanVienThoiVu nvtv = (NhanVienThoiVu) nhanVien;
                    nvtv.setChucVu("Nhan vien thoi vu");
                    System.out.print("So ngay lam chinh thuc trong thang: ");
                    int soNgayLamChinhThucTrongThangMoi = scanner.nextInt();
                    scanner.nextLine();
                    nvtv.setSoNgayLamTrongThang(soNgayLamChinhThucTrongThangMoi);
                    int soGioLamThemMoi = (soNgayLamChinhThucTrongThangMoi - 22) * 8;
                    nvtv.setSoGioLamThem(soGioLamThemMoi);
                }

                System.out.println("Da sua thong tin cho nhan vien " + ten);
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien co ten " + ten);
    }

    public NhanVien timKiemNhanVien(String ten) {
        for (NhanVien nhanVien : listNV) {
            if (nhanVien.getTen().equalsIgnoreCase(ten)) {
                System.out.println("Thông tin quản lý và hiển thị:\n");
                System.out.format("%-20s%-30s%-25s%-15s\n", "Tên", "Chức vụ", "Thời lượng làm thêm", "Tiền công");

                if (nhanVien instanceof NhanVienChinhThuc) {
                    NhanVienChinhThuc nvt = (NhanVienChinhThuc) nhanVien;
                    String thoiLuong = nvt.getSoNgayLamThem() + " Ngày";
                    String tienCong = nvt.tinhLuong() + " Tr";
                    System.out.format("%-20s%-30s%-25s%-15s\n", nvt.getTen(), nvt.getTenChucVu(), thoiLuong, tienCong);
                } else if (nhanVien instanceof NhanVienThoiVu) {
                    NhanVienThoiVu nvtv = (NhanVienThoiVu) nhanVien;
                    String thoiLuong = nvtv.getSoGioLamThem() + " Giờ";
                    String tienCong = nvtv.tinhLuong() + " Tr";
                    System.out.format("%-20s%-30s%-25s%-15s\n", nvtv.getTen(), nvtv.getChucVu(), thoiLuong, tienCong);
                }
                return nhanVien;
            }
        }
        System.out.println("Không tìm thấy nhân viên có tên: " + ten);
        return null;
    }

    public void tinhLuong() {
        System.out.println("\n===== TINH LUONG NHAN VIEN =====");
        for (NhanVien nv : listNV) {
            if (nv instanceof NhanVienChinhThuc) {
                double luong = ((NhanVienChinhThuc) nv).tinhLuong();
                System.out.println("Ten: " + nv.getTen() + "\tLuong: " + luong + " VND");
            } else if (nv instanceof NhanVienThoiVu) {
                double luong = ((NhanVienThoiVu) nv).tinhLuong();
                System.out.println("Ten: " + nv.getTen() + "\tLuong: " + luong + " VND");
            }
        }
    }

    public void hienTTNV() {
        System.out.println("\n===== THONG TIN LUONG NHAN VIEN =====");
        System.out.format("%-20s%-30s%-25s%-15s\n", "Tên", "Chức vụ", "Thời lượng làm thêm", "Tiền công");

        for (NhanVien nv : listNV) {
            if (nv instanceof NhanVienChinhThuc) {
                NhanVienChinhThuc nvt = (NhanVienChinhThuc) nv;
                String thoiLuong = nvt.getSoNgayLamThem() + " Ngày";
                String tienCong = nvt.tinhLuong() + " Tr";
                System.out.format("%-20s%-30s%-25s%-15s\n", nvt.getTen(), nvt.getTenChucVu(), thoiLuong, tienCong);

            } else if (nv instanceof NhanVienThoiVu) {
                NhanVienThoiVu nvtv = (NhanVienThoiVu) nv;
                String thoiLuong = nvtv.getSoGioLamThem() + " Giờ";
                String tienCong = nvtv.tinhLuong() + " Tr";
                System.out.format("%-20s%-30s%-25s%-15s\n", nvtv.getTen(), nvtv.getChucVu(), thoiLuong, tienCong);
            }
        }
    }

    public void luuFileLuong() {
        String fileName = outputPath + File.separator + "salary_" + thang + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (NhanVien nv : listNV) {
                if (nv instanceof NhanVienChinhThuc) {
                    writer.write("Ten: " + nv.getTen() + "\tChuc vu: " + ((NhanVienChinhThuc) nv).getChucVu() +
                            "\tThoi luong lam: " + ((NhanVienChinhThuc) nv).getSoNgayLamTrongThang() + " ngay\n");
                } else if (nv instanceof NhanVienThoiVu) {
                    writer.write("Ten: " + nv.getTen() + "\tChuc vu: " + ((NhanVienThoiVu) nv).getChucVu() +
                            "\tThoi luong lam: " + ((NhanVienThoiVu) nv).getSoNgayLamTrongThang() + " ngay\n");
                }
            }
            System.out.println("Da luu file luong: " + fileName);
        } catch (IOException e) {
            System.out.println("Luu file that bai: " + e.getMessage());
        }
    }

    public void nhapFileLuong() {
        String fileName = outputPath + File.separator + "salary_" + thang + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Doc file that bai: " + e.getMessage());
        }
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
}
