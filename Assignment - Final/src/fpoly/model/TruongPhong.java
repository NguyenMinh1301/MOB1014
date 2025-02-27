package fpoly.model;

import java.util.Scanner;

//Class trưởng phòng thừa class nhân viên
public class TruongPhong extends NhanVien {
    //Tạo biến với đặt tả truy xuất là private
    private double luongTrachNhiem;
    
    //Constructor
    public TruongPhong(String maNV, String hoTen, double luong, double luongTrachNhiem) {
        super(maNV, hoTen, luong);
        this.luongTrachNhiem = luongTrachNhiem;
    }
    
    //Setter
    public void setLuongTrachNhiem(double luongTrachNhiem) {
        this.luongTrachNhiem = luongTrachNhiem;
    }

    //Getter ghi đè phương thức get thu nhập trong class nhân viên
    @Override
    public double getThuNhap() {
        return luong + luongTrachNhiem;
    }
    
    public void inLuongTrachNhiem() {
        System.out.println(this.luongTrachNhiem);
    }
    
    //Phương thức cập nhật thông tin nhân viên
    @Override
    public void capNhatThongTin(Scanner scanner) {
        //Mời người dùng nhập lựa chọn thay đổi
        System.out.println("Cập nhật cho Trưởng phòng:");
        System.out.println("1. Họ tên");
        System.out.println("2. Lương");
        System.out.println("3. Lương trách nhiệm");
        System.out.print("Chọn (1|2|3): ");
        //Try-catch để bắt lỗi nhập liệu
        try {
            //Thực thi lựa chọn của người dùng
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập họ tên mới: ");
                    this.setHoTen(scanner.nextLine());
                    System.out.println("Họ tên đã được cập nhật!");
                    break;
                case 2:
                    System.out.print("Nhập lương mới: ");
                    this.setLuong(Double.parseDouble(scanner.nextLine()));
                    System.out.println("Lương đã được cập nhật!");
                    break;
                case 3:
                    System.out.print("Nhập lương trách nhiệm mới: ");
                    this.setLuongTrachNhiem(Double.parseDouble(scanner.nextLine()));
                    System.out.println("Lương trách nhiệm đã được cập nhật!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Nhập sai định dạng số.");
        }
    }
}
