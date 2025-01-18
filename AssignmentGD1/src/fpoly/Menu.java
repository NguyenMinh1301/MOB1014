package fpoly;

import java.util.Scanner;

public class Menu {
    //Scanner chung cho chương trình
    private final Scanner scanner = new Scanner(System.in);

    //Hiển thị menu
    private void showMenu() {
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
        System.out.println("\t\t||    [9] Xuất 5 nhân viên có thu nhập cao nhất.              ||");
        System.out.println("\t\t||                                                            ||");
        System.out.println("\t\t||    [0] Thoát chương trình.                                 ||");
        System.out.println("\t\t||                                                            ||");
        System.out.println("\t\t================================================================");
    }
    
    // Xử lý lựa chọn từ người dùng
    public void handleMenu() {
        int choice;
        do {
            //Hiển thị menu cho người dùng
            showMenu();
            System.out.print("\t\tVui lòng nhập trong khoảng [0 - 9]: ");
            try {
                //Lưu lựa chọn và kiểm tra
                choice = Integer.parseInt(scanner.nextLine());
                choice(choice);
            } catch (NumberFormatException ex) {
                //In nếu người dùng nhập sai cú pháp
                System.out.println("\t\t!! Nhập sai, vui lòng nhập số từ 0 đến 9 !!");
            }
        } while (true);
    }
    
    // Thực thi chức năng dựa trên lựa chọn
    private void choice(int choice) {
        switch (choice) {
            case 0 -> {
                System.out.println("\t\tTạm biệt. Hẹn gặp lại!");
                System.exit(0);
            }
            case 1 -> nhap();
            case 2 -> xuat();
            case 3 -> timNhanVienMa();
            case 4 -> xoaNhanVien();
            case 5 -> capNhatThongTinNhanVien();
            case 6 -> timNhanVienLuong();
            case 7 -> sapXepHoTen();
            case 8 -> sapXepLuong();
            case 9 -> thuNhapCaoNhat();
            default -> System.out.println("\t\t!! Nhập sai, vui lòng nhập lại trong khoảng từ 0 đến 9 !!");
        }
    }
    
    public void nhap() {
        System.out.println("\t\tBạn đã chọn chức năng: Nhập danh sách nhân viên.");
    }
    
    public void xuat() {
        System.out.println("\t\tBạn đã chọn chức năng: Xuất danh sách nhân viên.");
    }
    
    public void timNhanVienMa() {
        System.out.println("\t\tBạn đã chọn chức năng: Tìm và hiển thị nhân viên theo mã.");
    }
    
    public void xoaNhanVien() {
        System.out.println("\t\tBạn đã chọn chức năng: Xoá nhân viên theo mã.");
    }
    
    public void capNhatThongTinNhanVien() {
        System.out.println("\t\tBạn đã chọn chức năng: Cập nhật thông tin nhân viên theo mã.");
    }
    
    public void timNhanVienLuong() {
        System.out.println("\t\tBạn đã chọn chức năng: Tìm các nhân viên theo khoảng lương.");
    }
    
    public void sapXepHoTen() {
        System.out.println("\t\tBạn đã chọn chức năng: Sắp xếp nhân viên theo họ và tên.");
    }
    
    public void sapXepLuong() {
        System.out.println("\t\tBạn đã chọn chức năng: Sắp xếp nhân viên theo thu nhập.");
    }
    
    public void thuNhapCaoNhat() {
        System.out.println("\t\tBạn đã chọn chức năng: Xuất 5 nhân viên có thu nhập cao nhất.");
    }
    
}
