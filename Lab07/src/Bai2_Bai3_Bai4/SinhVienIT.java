package Bai2_Bai3_Bai4;
//Lớp SinhVienIT kế thừa từ lớp SinhVienPoly, đại diện cho sinh viên ngành IT
public class SinhVienIT extends SinhVienPoly {
    //Tạo các biến với đặt tả truy xuất protected
    protected double diemJava; //Điểm môn Java
    protected double diemCss; //Điểm môn Css
    protected double diemHtml; //Điểm môn Html

    //Constructor khởi tạo thông tin ngành IT
    public SinhVienIT(String hoTen, String nganh, double diemJava, double diemCss, double diemHtml) {
        super(hoTen, nganh); //Gọi constructor của lớp cha SinhVienPoly
        this.diemJava = diemJava;
        this.diemCss = diemCss;
        this.diemHtml = diemHtml;
    }
    
    //Phương thức ghi đè (Override) getDiem để tính điểm trung bình cho sinh viên ngành IT
    @Override
    double getDiem() {
        return (2 * diemJava + diemCss + diemHtml) / 4;
        //Return điểm trung bình
    }
}
