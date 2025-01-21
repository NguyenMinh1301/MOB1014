package fpoly;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        
        //Mời người dùng nhập chiều dài và rộng
        System.out.print("Nhap chieu dai: ");
        int ChieuDai = scanner.nextInt();
        System.out.print("Nhap chieu rong: ");
        int ChieuRong = scanner.nextInt();
        
        //Tính Chu vi và diện tích hình chữ nhật theo công thức
        System.out.println("Chu vi cua hinh chu nhat la: " + (ChieuDai + ChieuRong) * 2);
        System.out.println("Dien tich cua hinh chu nhat la: " + ChieuDai * ChieuRong);
    }
}
