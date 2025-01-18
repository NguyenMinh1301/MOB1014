package Bai1;

public class ChuNhat {
    protected double rong;
    protected double dai;

    public ChuNhat(double rong, double dai) {
        this.rong = rong;
        this.dai = dai;
    }
    
    public double getChuVi() {
        return (dai + rong) * 2;
    }
    
    public double getDienTich() {
        return dai* rong;
    }
    
    public void xuat() {
        System.out.println("Chu vi hình chữ nhật là: " + getChuVi());
        System.out.println("Diện tích hình chữ nhật là: " + getDienTich());
    }
    
    
    
    
}
