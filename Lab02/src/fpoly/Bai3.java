package fpoly;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {      
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        double Total = 0;
        
        //Mời người dụng nhập số điện sử dụng
        System.out.print("Nhap so dien da su dung: ");
        float Kw = scanner.nextInt();
        
        //Nếu số điện <= 50 tính toán
        if (Kw <= 50) {
            Total = Kw * 1000;
        //Nếu số điện > 50 tính toán
        } else if (Kw > 50) {
            Total = 50 * 1000 + (Kw - 50) * 1200;
        //Tất cả trường hợp còn lại là nhập sai
        } else {
            System.out.println("Nhap sai!!");
        }
        
        //In kết quả
        System.out.println("Tong tien ban can thanh toan la: " + Total + "VND");
    }
}
