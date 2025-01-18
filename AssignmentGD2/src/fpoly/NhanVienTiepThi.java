package fpoly;

class NhanVienTiepThi extends NhanVien {

    private double doanhSo;
    private double hoaHong;

    public NhanVienTiepThi(String maNV, String hoTen, double luong, double doanhSo, double hoaHong) {
        super(maNV, hoTen, luong);
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public void setHoaHong(double hoaHong) {
        this.hoaHong = hoaHong;
    }

    @Override
    public double getThuNhap() {
        return luong + doanhSo * hoaHong;
    }
}
