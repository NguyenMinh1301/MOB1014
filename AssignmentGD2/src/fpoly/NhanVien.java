package fpoly;

//Lớp trừu tượng NhanVien 
abstract class NhanVien {

    //Tạo các biến với đặt tả truy xuất protected
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

    //Setter
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    //Phương thức trừu tượng getThuNhap()
    public abstract double getThuNhap();

    //Phương thức getThueThuNhap()
    public double getThueThuNhap() {
        //Tạo biến thu nhập và gán giá trị của getThuNhap()
        double thuNhap = getThuNhap();

        //Kiểm tra và đánh thuế thu nhập theo yêu cầu (sử dụng phương pháp tính luỹ tiến)
        if (thuNhap < 9000000) {
            return 0;
        } else if (thuNhap <= 15000000) {
            return (thuNhap - 9000000) * 0.1;
        } else {
            return (thuNhap - 15000000) * 0.12 + 600000;
        }
    }

    //Phương thức getLoaiNhanVien()
    public String getLoaiNhanVien() {
        if (this instanceof NhanVienHanhChinh) {
            return "Hành chính";
        } else if (this instanceof NhanVienTiepThi) {
            return "Tiếp thị";
        } else if (this instanceof TruongPhong) {
            return "Trưởng phòng";
        } else {
            return "Không xác định";
        }
    }

    //Phương thức xuatThongTin()
    public void xuatThongTin() {
        //Tính thu nhập sau thuế
        double thuNhapSauThue = getThuNhap() - getThueThuNhap();
        //Xuất thông tin của nhân viên với định dạng cột cố định
        System.out.printf("%-15s %-12s %-25s %25.2f %25.2f %25.2f %25.2f\n",
                getLoaiNhanVien(), maNV, hoTen, luong, getThuNhap(), getThueThuNhap(), thuNhapSauThue);
    }
}
