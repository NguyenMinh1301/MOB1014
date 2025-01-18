package fpoly;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class SanPham {
    private String TenSP;
    private double DonGia;
    private double GiamGia;
    
    //Getter và Setter
    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public double getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(double GiamGia) {
        this.GiamGia = GiamGia;
    }
    
    //Tính thuế nhập khẩu mặc định 10%
    private double getThueNhapKhau () {
        return DonGia * 0.1;
    }
    
    //Constructor đầy đủ
    public SanPham(String TenSP, double DonGia, double GiamGia) {
        this.TenSP = TenSP;
        this.DonGia = DonGia;
        this.GiamGia = GiamGia;
    }
    
    //Constructor trống giảm giá
    public SanPham(String TenSP, double DonGia) {
        this.TenSP = TenSP;
        this.DonGia = DonGia;
        this.GiamGia = 0;
    }
    
    //Constructor mặc định null
    public SanPham() {
        this.TenSP = "Null";
        this.DonGia = 0;
        this.GiamGia = 0;
    }
    
    //Hàm xuất dữ liệu đã nhập vào 
    public void Xuat() {
        System.out.println("Ten san pham: " + TenSP);
        System.out.println("Don gia: " + DonGia);
        System.out.println("Giam gia: " + GiamGia);
        System.out.println("Thue nhap khau: " + getThueNhapKhau()) ;
    }
    
    //Hàm lưu giá trị đã nhập
    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap ten san pham: ");
        TenSP = scanner.nextLine();
        System.out.print("Nhap don Gia: ");
        DonGia = scanner.nextDouble();
        System.out.print("Nhap giam gia: ");
        GiamGia = scanner.nextDouble();
    }
}