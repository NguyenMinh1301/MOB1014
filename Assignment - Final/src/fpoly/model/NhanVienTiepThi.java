package fpoly.model;

import java.util.Scanner;

//Class nhân viên tiếp thị kế thừa class nhân viên
public class NhanVienTiepThi extends NhanVien {
    //Tạo biến với đặt tả truy xuất là private
    private double doanhSo;
    private double hoaHong;

    //Constructor
    public NhanVienTiepThi(String maNV, String hoTen, double luong, double doanhSo, double hoaHong) {
        super(maNV, hoTen, luong);
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
    }
    
    public void inHoaHong() {
        System.out.println(this.doanhSo);
        System.out.println(this.hoaHong);
    }
    
    //Setter
    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public void setHoaHong(double hoaHong) {
        this.hoaHong = hoaHong;
    }
    
    //Getter ghi đè phương thức get thu nhập trong class nhân viên
    @Override
    public double getThuNhap() {
        return luong + doanhSo * hoaHong;
    }
    
    //Phương thức cập nhật thông tin nhân viên
    @Override
    public void capNhatThongTin(Scanner scanner) {
        //Mời người dùng nhập lựa chọn thay đổi
        System.out.println("Cập nhật cho Nhân viên tiếp thị:");
        System.out.println("1. Họ tên");
        System.out.println("2. Lương");
        System.out.println("3. Doanh số");
        System.out.println("4. Hoa hồng");
        System.out.print("Chọn (1|2|3|4): ");
        //Try-catch để bắt lỗi nhập liệu
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                //Thực thi lựa chọn của người dùng
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
                    System.out.print("Nhập doanh số mới: ");
                    this.setDoanhSo(Double.parseDouble(scanner.nextLine()));
                    System.out.println("Doanh số đã được cập nhật!");
                    break;
                case 4:
                    System.out.print("Nhập hoa hồng mới (tỉ lệ phần trăm): ");
                    this.setHoaHong(Double.parseDouble(scanner.nextLine()));
                    System.out.println("Hoa hồng đã được cập nhật!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Nhập sai định dạng số.");
        }
    }
}
