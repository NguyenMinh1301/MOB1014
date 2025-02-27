package fpoly.model;

import java.util.Scanner;

public abstract class NhanVien {
    //Khởi tạo các biến với đặt tả truy xuất là protected
    protected String maNV;
    protected String hoTen;
    protected double luong;
    
    //Constructor
    public NhanVien(String maNV, String hoTen, double luong) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.luong = luong;
    }
    
    //Getter
    public String getMaNV() {
        return maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public double getLuong() {
        return luong;
    }
    
    //Settter
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
    
    //Phương thức trừu tượng get thu nhập để các lớp kế thừa ghi đè
    public abstract double getThuNhap();
    
    //Phương thức get thuế thu nhập
    public double getThueThuNhap() {
        double thuNhap = getThuNhap();
        
        //Nếu thu nhập bé hơn 9000000 thì không đánh thuế
        if (thuNhap < 9000000) {
            return 0;
        //Nếu thu nhập bé hơn hoặc bằng 15000000 đánh thuế thu nhập 10% và trừ khoảng thu nhập không bị đánh thuế (phương pháp luỹ tiến)
        } else if (thuNhap <= 15000000) {
            return (thuNhap - 9000000) * 0.1;
        //Nếu thu nhập lớn hơn 15000000 đánh thuế thu nhập 12% và trừ khoảng thu nhập không bị đánh thuế (phương pháp luỹ tiến)
        } else {
            return (thuNhap - 15000000) * 0.12 + 600000;
        }
    }
    
    //Phương thức get loại nhân viên
    public String getLoaiNhanVien() {
        //Sử dụng toán tử instanceof để kiểm tra đối tượng
        if(this instanceof NhanVienHanhChinh) {
            return "Hành chính";
        } else if (this instanceof NhanVienTiepThi) {
            return "Tiếp thị";
        } else if (this instanceof TruongPhong) {
            return "Trưởng Phòng";
        } else {
            return "Không xác định";
        }
    }
    
    //Phương thức xuất thông tin của nhân viên
    public void xuatThongTin() {
        double thuNhapSauThue = getThuNhap() - getThueThuNhap();
        System.out.printf("%-15s %-12s %-25s %25.2f %25.2f %25.2f %25.2f\n",   
                getLoaiNhanVien(), maNV, hoTen, luong, getThuNhap(), getThueThuNhap(), thuNhapSauThue);
    }
    
    //Phương thức trừu tượng cập nhật thông tin
    public abstract void capNhatThongTin(Scanner scanner);  
}
