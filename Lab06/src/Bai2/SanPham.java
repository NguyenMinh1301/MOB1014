package Bai2;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class SanPham {
    //Tạo các biến với đặt tả truy xuất là private
    private String ten;
    private double gia;
    private String hang;
    
    //Tạo Getter và Shetter
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }
    
    //Phương thức nhap()
    public void nhap() {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        
        //Mời người dùng nhập ten
        System.out.println("\nVui lòng nhập TÊN | GIÁ | HÃNG của sản phẩm\n");
        System.out.print("Nhập tên sản phẩm: ");
        //Dùng trim() để loại bỏ kí tự khoảng trắng ở đầu và cuối (nếu có)
        ten = scanner.nextLine().trim();
        
        //Mời người dùng nhập gia
        do {
            try {
                System.out.print("Nhập giá sản phẩm: ");
                //Dùng trim() để loại bỏ kí tự khoảng trắng ở đầu và cuối (nếu có)
                gia = Double.parseDouble(scanner.nextLine().trim());
                //Kiểm tra gia phải lớn hơn 0
                if (gia <= 0) {
                    System.out.println("Giá sản phẩm không hợp lệ, vui lòng nhập lại!");
                }
            } catch (NumberFormatException ex) {
                //Bắt lỗi nhập liệu
                System.out.println("Đã xảy ra lỗi trong quá trình nhập giá: " + ex.getMessage());
            }
        } while (gia <= 0);

        //Mời người dùng nhập hang
        System.out.print("Nhập hãng sản phẩm: ");
        //Dùng trim() để loại bỏ kí tự khoảng trắng ở đầu và cuối (nếu có)
        hang = scanner.nextLine().trim();

        System.out.println();
    }

    //Phương thức xuat()
    public void xuat() {
        //Xuất ra màn hính với khoảng cách cố định
        System.out.printf("%-20s %-15s %-15s\n", "TÊN", "GIÁ", "HÃNG");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-20s %-15.2f %-15s\n", ten, gia, hang);
    }
}
