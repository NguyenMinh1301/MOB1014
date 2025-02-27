package fpoly.view;

import fpoly.service.NhanSuService;
import java.util.Scanner;

//Class quản lý nhân sự (View)
public class QuanLyNhanSuView {
    private final NhanSuService service;
    
    //Constructor
    public QuanLyNhanSuView() {
        service = new NhanSuService();
    }
    
    //Phương thức menu
    public void menu() {
        //In menu ra màn hình console
        System.out.println("\t\t=========================NguyenMinh.exe=========================");
        System.out.println("\t\t||                                                            ||");
        System.out.println("\t\t||          !! NHẬP TRƯƠNG TRÌNH BẠN MUỐN SỬ DỤNG !!          ||");
        System.out.println("\t\t||                                                            ||");
        System.out.println("\t\t||    [1] Nhập danh sách nhân viên.                           ||");
        System.out.println("\t\t||    [2] Xuất danh sách nhân viên.                           ||");
        System.out.println("\t\t||    [3] Tìm và hiển thị nhân viên theo mã.                  ||");
        System.out.println("\t\t||    [4] Xoá nhân viên theo mã.                              ||");
        System.out.println("\t\t||    [5] Cập nhật thông tin nhân viên theo mã.               ||");
        System.out.println("\t\t||    [6] Tìm các nhân viên theo khoảng lương.                ||");
        System.out.println("\t\t||    [7] Sắp xếp nhân viên theo họ và tên.                   ||");
        System.out.println("\t\t||    [8] Sắp xếp nhân viên theo thu nhập.                    ||");
        System.out.println("\t\t||    [9] Xuất nhân viên có thu nhập cao nhất.                ||");
        System.out.println("\t\t||    [0] Thoát chương trình.                                 ||");
        System.out.println("\t\t================================================================");
    }
    
    //Phương thức quản lý menu
    public void quanLyMenu() {
        //Khai báo scanner
        Scanner scanner = new Scanner(System.in);
        int choice;
        //Do-while để người dùng nhập lại nếu nhập sai
        do {
            menu();
            System.out.print("\t\tVui lòng nhập trong khoảng [0 - 9]: ");
            try {
                //Lưu thông tin người dùng nhập và gọi phương thức xử lý lựa chọn
                choice = Integer.parseInt(scanner.nextLine());
                xuLyLuaChon(choice);
            //Bắt lỗi nếu nhập lỗi
            } catch (Exception ex) {
                System.out.println("\t\t!! Nhập sai, vui lòng nhập số từ 0 đến 9 !!");
                //set lại cho choise bằng -1 để tránh thoát vòng lặp lỗi
                choice = -1;
            }
        } while (choice != 0);
        //Đóng scanner tránh tràn bộ nhớ
        scanner.close();
    }
    
    //Phương thức xử lý lựa chọn
    private void xuLyLuaChon(int choice) {
        //Thực hiện gọi đến phương thức người dùng muốn sử dụng
        switch (choice) {
            case 0:
                System.out.println("\t\tTạm biệt. Hẹn gặp lại!");
                break;
            case 1:
                service.nhapNhanVien();
                break;
            case 2:
                service.xuatDanhSach();
                break;
            case 3:
                service.timNhanVienTheoMa();
                break;
            case 4:
                service.xoaNhanVienTheoMa();
                break;
            case 5:
                service.capNhatThongTinNhanVien();
                break;
            case 6:
                service.timNhanVienTheoLuong();
                break;
            case 7:
                service.sapXepTheoHoTen();
                break;
            case 8:
                service.sapXepTheoThuNhap();
                break;
            case 9:
                service.xuatTopNhanVien();
                break;
            default:
                System.out.println("\t\t!! Nhập sai, vui lòng nhập lại trong khoảng từ 0 đến 9 !!");
        }
    }
}
