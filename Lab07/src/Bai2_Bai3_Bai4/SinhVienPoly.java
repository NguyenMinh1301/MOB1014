package Bai2_Bai3_Bai4;

//Lớp trừ tượng SinhVienPoly đại diện cho một sinh viên
public abstract class SinhVienPoly {
    //Tạo các biến với đặt tả truy xuất là private
    private String hoTen; //Họ tên sinh viên
    private String nganh; //Ngành sinh viên
    
    //Constructor khởi tạo thông tin của sinh viên
    public SinhVienPoly(String hoTen, String nganh) {
        this.hoTen = hoTen;
        this.nganh = nganh;
    }
    
    //Getter lấy họ tên của sinh viên
    public String getHoTen() {
        return hoTen;
    }
    
    //Getter lấy ngành học của sinh viên
    public String getNganh() {
        return nganh;
    }
    
    //Phương thức trừu tượng để lấy điểm trung bình của sinh viên
    //Các lớp con (SinhVienIT | SinhVienBiz) sẽ thực hiện phương thức này sau đó return điểm trung bình
    abstract double getDiem();
    
    //Phương thức xác định học lực dựa trên điểm trung bình của sinh viên
    public String getHocLuc() {
        String hocLuc = null;
        double diem = getDiem();
        if (diem >= 9) {
            hocLuc = "Xuất sắc";
        } else if (diem >= 7.5) {
            hocLuc = "Giỏi";
        } else if (diem >= 6.5) {
            hocLuc = "Khá";
        } else if (diem >= 5) {
            hocLuc = "Trung bình";
        } else {
            hocLuc = "Yếu";
        }
        //Return học lực đã được xử lý
        return hocLuc;
    }
}
