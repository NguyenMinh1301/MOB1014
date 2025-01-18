package Bai1;

public class Vuong extends ChuNhat{
    public Vuong(double canh) {
        super(canh, canh);
        double rong = canh;
    }
    
    public void xuat() {
        System.out.println("Chu vi hình vuông là: " + getChuVi());
        System.out.println("Diện tích hình vuông là: " + getDienTich());
    }
    
    
    
}
