package Bai2;

import java.util.Scanner; //Thư viện Scanner
import java.util.ArrayList; //Thư viện ArrayList
import java.util.Collections; //Thư viện Collections

public class DanhSachHoTen {
    //Biến toàn cục lưu trữ chuỗi của người dùng nhập vào (Ở đây là Họ Tên)
    private ArrayList<String> ds = new ArrayList<>();
    
    public void Nhap() {
        //Xoá danh sách cũ (nếu có)
        ds.clear();
        //Khai báo Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap danh sach ho ten:");
        while (true) {
            System.out.print("Nhap ho ten: ");
            String Ten = scanner.nextLine();
            
            if (Ten.isEmpty()) {
                if (ds.isEmpty()) {
                    //Yêu cầu phải có ít nhất một chuỗi tồn tại trong list (Ở đây là Họ Tên)
                    System.out.println("Vui long nhap it nhat mot ho ten!");
                } else {
                    //Nếu đã có ít nhất một chuỗi trong list tự động thoát nhập
                    System.out.println("Nhap du lieu thanh cong!");
                    break;
                }
            } else {
                //Thêm chuỗi vào list
                ds.add(Ten);
            }
        }
    }
    public void Xuat() {
        if (ds.isEmpty()) {
            //Kiểm tra nếu danh sách trống
            System.out.println("Danh sach trong! Khong co gi de hien thi.");
        } else {
            System.out.println("=====================================================================================");
            for (String item : ds) {
                //Sử dụng for-each để in ra màn hình từng chuỗi trong list
                System.out.println(item);
            }
        }
    }
    
    public void SapXepNgauNhien() {
        if (ds.isEmpty()) {
            //Kiểm tra nếu danh sách trống
            System.out.println("Danh sach trong! Khong the sap xep ngau nhien.");
        } else {
            //Sử dụng thư viện Collections và dùng chức năng shuffle (xáo trộn) list
            Collections.shuffle(ds);
            System.out.println("Danh sach da duoc sap xep ngau nhien:");
            //Gọi phương thức Xuat() để in ra màn hình
            Xuat();
        }
    }
    
    public void SapXep() {
        if (ds.isEmpty()) {
            //Kiểm tra nếu danh sách trống
            System.out.println("Danh sach trong! Khong the sap xep.");
        } 
        //Sử dụng thư viện Collections và dùng chức năng sort (sắp xếp) list tăng dần
        Collections.sort(ds);
        //Sử dụng thư viện Collections và dùng chức năng reverse (đảo ngược) list
        Collections.reverse(ds);
        System.out.println("Danh sach da duoc sap xep theo thu tu giam dan:");
        //Gọi phương thức Xuat() để in ra màn hình
        Xuat();
    }
    
    public void Xoa() {
        //Khai báo Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao ten muon xoa: ");
        String HoTen = scanner.nextLine();
        
        boolean found = false;
        
        //Dùng for-each để tìm chuỗi trong list (Ở đây là Họ Tên)
        for(String item : ds) {
            //Nếu tìm được tên trong list (không phân biệt hoa thường bằng cách sử dụng equalsIgnoreCase())
            if(item.equalsIgnoreCase(HoTen)) {
                //Xoá phần tử tìm thấy
                ds.remove(item);
                //Hiện thông báo và thoát vòng lặp
                System.out.println("Da xoa thanh cong: " + HoTen);
                found = true;
                break;
            } 
        }
        if(!found) {
            //Nếu không tìm thấy chuỗi tương ứng
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