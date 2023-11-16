package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TinhLuong tinhLuong = new TinhLuong();

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Hien thi thong tin nhan vien");
            System.out.println("3. Tinh luong");
            System.out.println("4. Luu file luong");
            System.out.println("5. Nhap file luong");
            System.out.println("6. Chinh sua thong tin nhan vien");
            System.out.println("7. Xoa thong tin nhan vien");
            System.out.println("8. Tim kiem thong tin nhan vien");
            System.out.println("9. Thoat");

            System.out.print("Chon chuc nang (1-9): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    System.out.println("Nhap thong tin nhan vien: ");
                    System.out.print("Ten: ");
                    String ten = scanner.nextLine();

                    System.out.print("Loai nhan vien (Chinh thuc/Thoi vu): ");
                    String loaiNhanVien = scanner.nextLine();

                    if (loaiNhanVien.equalsIgnoreCase("Chinh thuc")) {
                        System.out.print("Chuc vu (Quan ly chon 1 hoac Cong nhan chon 2): ");
                        String chucVu = scanner.nextLine();

                        System.out.print("So ngay lam trong thang: ");
                        int soNgayLamTrongThang = scanner.nextInt();

                        tinhLuong.themNhanVien(new NhanVienChinhThuc(ten, chucVu, soNgayLamTrongThang, soNgayLamTrongThang - 22));
                    } else if (loaiNhanVien.equalsIgnoreCase("Thoi vu")) {
                        System.out.print("So ngay lam chinh thuc trong thang: ");
                        int soNgayLamTrongThang = scanner.nextInt();

                        tinhLuong.themNhanVien(new NhanVienThoiVu(ten, "Nhan vien thoi vu", soNgayLamTrongThang, (soNgayLamTrongThang - 22) * 8));
                    } else {
                        System.out.println("Loai nhan vien khong hop le. Vui long nhap lai.");
                    }
                    break;
                case 2:
                    System.out.println("\n===== Thong tin nhan vien =====");
                    tinhLuong.hienTTNV();
                    break;
                case 3:
                    System.out.println("\n===== Tinh luong nhan vien =====");
                    tinhLuong.tinhLuong();
                    break;
                case 4:
                    System.out.println("\n===== Luu file luong =====");
                    tinhLuong.luuFileLuong();
                    break;
                case 5:
                    System.out.println("\n===== Nhap file luong =====");
                    tinhLuong.nhapFileLuong();
                    break;
                case 6:
                    System.out.println("\n===== Chinh sua thong tin nhan vien =====");
                    System.out.print("Nhap ten nhan vien can chinh sua: ");
                    String tenCanChinhSua = scanner.nextLine();
                    tinhLuong.suaThongTinNhanVien(tenCanChinhSua);
                    break;
                case 7:
                    System.out.println("\n===== Xoa thong tin nhan vien =====");
                    System.out.print("Nhap ten nhan vien can xoa: ");
                    String tenCanXoa = scanner.nextLine();
                    tinhLuong.xoaNhanVien(tenCanXoa);
                    break;
                case 8:
                    System.out.println("\n===== Tim kiem thong tin nhan vien =====");
                    System.out.print("Nhap ten nhan vien can tim: ");
                    String tenCanTim = scanner.nextLine();
                    tinhLuong.timKiemNhanVien(tenCanTim);
                    break;
                case 9:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
            }
        }

        System.out.println("Chuong trinh da thoat.");
    }
}
