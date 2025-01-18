package fpoly;

class NhanVienHanhChinh extends NhanVien {

    public NhanVienHanhChinh(String maNV, String hoTen, double luong) {
        super(maNV, hoTen, luong);
    }

    @Override
    public double getThuNhap() {
        return luong;
    }
}
