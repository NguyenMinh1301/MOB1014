package fpoly;

//Lớp kế thừa NhanVienTiepThi() từ lớp cha NhanVien
class NhanVienTiepThi extends NhanVien {

    //Tạo các biến với đặt tả truy xuất là private
    private double doanhSo;
    private double hoaHong;

    //Constructor gọi đến lớp cha NhanVien() nhận 3 tham số maNV, hoTen, luong
    public NhanVienTiepThi(String maNV, String hoTen, double luong, double doanhSo, double hoaHong) {
        super(maNV, hoTen, luong);
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
    }

    //Setter
    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public void setHoaHong(double hoaHong) {
        this.hoaHong = hoaHong;
    }

    //Ghi đè phương thức getThuNhap() 
    @Override
    public double getThuNhap() {
        //Phương thức tính thu nhập của nhân viên tiếp thị
        return luong + doanhSo * hoaHong;
    }
}
