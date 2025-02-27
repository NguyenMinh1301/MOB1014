package fpoly.model;

import java.util.Scanner;

//Class nhân viên hành chính kế thừa class nhân viên
public class NhanVienHanhChinh extends NhanVien {
    //Constructor
    public NhanVienHanhChinh(String maNV, String hoTen, double luong) {
        super(maNV, hoTen, luong);
    }
    
    //Phương thức get thu nhập ghi đè phương thức get thu nhập trong class nhân viên
    @Override
    public double getThuNhap() {
        return luong;
    }

    //Phương thức cập nhật thông tin nhân viên
    @Override
    public void capNhatThongTin(Scanner scanner) {
        //Mời người dùng nhập lựa chọn thay đổi
        System.out.println("Cập nhật cho Nhân viên hành chính:");
        System.out.println("1. Họ tên");
        System.out.println("2. Lương");
        System.out.print("Chọn (1|2): ");
        //Try-catch để bắt lỗi nhập liệu
        try {
            //Lưu lựa chọn
            int choice = Integer.parseInt(scanner.nextLine());
            //Thực thi lựa chọn của người dùng
            switch (choice) {
                case 1:
                    System.out.print("Nhập họ tên mới: ");
                    this.setHoTen(scanner.nextLine());
                    System.out.println("!! Họ tên đã được cập nhật !!");
                    break;
                case 2:
                    System.out.print("Nhập lương mới: ");
                    this.setLuong(Double.parseDouble(scanner.nextLine()));
                    System.out.println("!! Lương đã được cập nhật !!");
                    break;
                default:
                    System.out.println("!! Lựa chọn không hợp lệ !!");
            }
        } catch (NumberFormatException ex) {
            System.out.println("!! Nhập sai định dạng số !!");
        }
    }
}
