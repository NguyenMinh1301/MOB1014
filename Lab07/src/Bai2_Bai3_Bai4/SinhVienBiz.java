package Bai2_Bai3_Bai4;
//Lớp SinhVienBiz kế thừa từ lớp SinhVienPoly, đại diện cho sinh viên ngành Marketing
public class SinhVienBiz extends SinhVienPoly {
    protected double diemMarketing; //Điểm môn Marketing
    protected double diemSales; //Điểm môn Sales

    //Constructor khởi tạo thông tin ngành Marketing
    public SinhVienBiz(String hoTen, String nganh, double diemMarketing, double diemSales) {
        super(hoTen, nganh); //Gọi constructor của lớp cha SinhVienPoly
        this.diemMarketing = diemMarketing;
        this.diemSales = diemSales;
    }
    
    //Phương thức ghi đè (Override) getDiem để tính điểm trung bình cho sinh viên ngành Marketings
    @Override
    double getDiem() {
        return (2 * diemMarketing + diemSales) / 3;
        //Return điểm trung bình
    }
}
