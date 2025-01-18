package Bai3;

public class SanPham {
    private String tenSP;
    private double gia;
    
    //Constructor mặc định null
    public SanPham() {
        this.tenSP = null;
        this.gia = 0;
    }
    
    //Constructor đầy đủ
    public SanPham(String tenSP, double gia) {
        this.tenSP = tenSP;
        this.gia = gia;
    }
    
    //Getter và Setter
    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
