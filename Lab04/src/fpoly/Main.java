package fpoly;

public class Main {
    public static void main(String[] args) {
        
        //3 đối tượng tương ứng với 3 contructor trong SanPham
        SanPham SP1 = new SanPham("SP1", 5000, 1000); //Constructor đầy đủ
        SanPham SP2 = new SanPham("SP2", 8000); //Constructor trống giảm giá
        SanPham SP3 = new SanPham(); //Constructor mặc định null
        
        //Cho người dùng nhập vào giá trị mong muốn
        //SP1.Nhap();
        //SP2.Nhap();
        //SP3.Nhap();

        //In thông tin SanPham
        SP1.Xuat();
        SP2.Xuat();
        SP3.Xuat();
    }
}
