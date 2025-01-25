package fpoly;

//Lớp kế thừa NhanVienHanhChinh() từ lớp cha NhanVien
class NhanVienHanhChinh extends NhanVien {

    //Constructor gọi đến lớp cha NhanVien() nhận 3 tham số maNV, hoTen, luong
    public NhanVienHanhChinh(String maNV, String hoTen, double luong) {
        super(maNV, hoTen, luong);
    }

    //Ghi đè phương thức getThuNhap() 
    @Override
    public double getThuNhap() {
        return luong;
    }
}
