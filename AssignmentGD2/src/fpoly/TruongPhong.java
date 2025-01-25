package fpoly;

//Lớp kế thừa TruongPhong() từ lớp cha NhanVien
class TruongPhong extends NhanVien {

    //Tạo biến luongTrachNhiem với đặt tả truy xuất là private
    private double luongTrachNhiem;

    //Constructor gọi đến lớp cha NhanVien() nhận 3 tham số maNV, hoTen, luong
    public TruongPhong(String maNV, String hoTen, double luong, double luongTrachNhiem) {
        super(maNV, hoTen, luong);
        this.luongTrachNhiem = luongTrachNhiem;
    }

    //Setter
    public void setLuongTrachNhiem(double luongTrachNhiem) {
        this.luongTrachNhiem = luongTrachNhiem;
    }

    //Ghi đè phương thức getThuNhap() 
    @Override
    public double getThuNhap() {
        //Phương thức tính thu nhập của trưởng phòng
        return luong + luongTrachNhiem;
    }
}
