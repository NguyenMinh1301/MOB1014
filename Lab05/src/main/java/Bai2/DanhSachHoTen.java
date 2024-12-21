
package Bai2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class DanhSachHoTen {
    private ArrayList<String> ds = new ArrayList<>();
    
    public void Nhap() {
        ds.clear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap danh sach ho ten:");
        while (true) {
            System.out.print("Nhap ho ten: ");
            String Ten = scanner.nextLine();
            if (Ten.isEmpty()) {
                if (ds.isEmpty()) {
                    System.out.println("Vui long nhap it nhat mot ho ten!");
                } else {
                    System.out.println("Nhap du lieu thanh cong!");
                    break;
                }
            } else {
                ds.add(Ten);
            }
        }
    }
    public void Xuat() {
        if (ds.isEmpty()) {
            System.out.println("Danh sach trong! Khong co gi de hien thi.");
        } else {
            System.out.println("=====================================================================================");
            for (String item : ds) {
                System.out.println(item);
            }
        }
    }
    
    public void SapXepNgauNhien() {
        if (ds.isEmpty()) {
            System.out.println("Danh sach trong! Khong the sap xep ngau nhien.");
        } else {
            Collections.shuffle(ds);
            System.out.println("Danh sach da duoc sap xep ngau nhien:");
            Xuat();
        }
    }
    
    public void SapXep() {
        if (ds.isEmpty()) {
            System.out.println("Danh sach trong! Khong the sap xep.");
        } 
        Collections.sort(ds);
        Collections.reverse(ds);
        System.out.println("Danh sach da duoc sap xep theo thu tu giam dan:");
        Xuat();
    }
    
    public void Xoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao ten muon xoa: ");
        String HoTen = scanner.nextLine();
        boolean found = false;
        
        for(String item : ds) {
            if(item.equalsIgnoreCase(HoTen)) {
                ds.remove(item);
                System.out.println("Da xoa thanh cong: " + HoTen);
                found = true;
                break;
            } 
        }
        if(!found) {
            System.out.println("Khong tim thay ten: " + HoTen);
        }
    }
     
    
    public void Menu() {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        int Choice;
        
        //Tạo vòng lặp do while khi trương người dùng nhập vào số đúng điều kiện và != 0 trương trình tiếp tục được chạy
        do {
            System.out.println("\t\t==================NguyenMinh.exe==================");
            System.out.println("\t\t||                                              ||");
            System.out.println("\t\t||   !! NHAP TRUONG TRINH BAN MUON SU DUNG !!   ||");
            System.out.println("\t\t||                                              ||");
            System.out.println("\t\t||  [1] Nhap danh sach ho ten.                  ||");
            System.out.println("\t\t||  [2] Hien thi danh sach ho ten.              ||");
            System.out.println("\t\t||  [3] Sap xep ngau nhien.                     ||");
            System.out.println("\t\t||  [4] Sap xep.                                ||");
            System.out.println("\t\t||  [5] Xoa.                                    ||");
            System.out.println("\t\t||                                              ||");
            System.out.println("\t\t||  [0] Thoat truong trinh.                     ||");
            System.out.println("\t\t||                                              ||");
            System.out.println("\t\t==================================================");
            System.out.print("\t\tVui long nhap trong khoang [0 - 5]: ");
            Choice = scanner.nextInt();
            switch (Choice) {
                case 0:
                    System.out.println("\t\tTam biet. Hen gap lai !");
                    System.exit(0);
                    break;
                case 1:
                    Nhap();
                    break;
                case 2:
                    Xuat();
                    break;
                case 3:
                    SapXepNgauNhien();
                    break;
                case 4:   
                    SapXep();
                    break;
                case 5:   
                    Xoa();
                    break;
                default:
                    System.out.println("!!Nhap sai vui long nhap lai!!");
                    break;
            }
        } while(Choice != 0);
    }
}
