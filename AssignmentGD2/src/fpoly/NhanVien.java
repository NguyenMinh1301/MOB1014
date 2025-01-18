package fpoly;

abstract class NhanVien {

    protected String maNV;
    protected String hoTen;
    protected double luong;

    public NhanVien(String maNV, String hoTen, double luong) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.luong = luong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public abstract double getThuNhap();

    public double getThueThuNhap() {
        double thuNhap = getThuNhap();
        if (thuNhap < 9000000) {
            return 0;
        } else if (thuNhap <= 15000000) {
            return (thuNhap - 9000000) * 0.1;
        } else {
            return (thuNhap - 15000000) * 0.12 + 600000;
        }
    }

    public void xuatThongTin() {
        System.out.printf("Mã: %s, Họ tên: %s, Lương: %.2f, Thu nhập: %.2f, Thuế: %.2f\n",
                maNV, hoTen, luong, getThuNhap(), getThueThuNhap());
    }
}
