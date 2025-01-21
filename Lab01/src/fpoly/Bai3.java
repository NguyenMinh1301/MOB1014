package fpoly;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Bai3 {
        public static void main(String[] args) {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        
        //Mời người dùng nhập cạnh
        System.out.print("Nhap chieu rong: ");
        float rong = scanner.nextFloat();
        System.out.print("Nhap chieu dai: ");
        float dai = scanner.nextFloat();
        System.out.print("Nhap chieu cao: ");
        float cao = scanner.nextFloat();
        
        //Tính thể thích và in kết quả
        float TheTich = rong * dai * cao;      
        System.out.print("The tich cua hinh la: " + TheTich);
    }
}