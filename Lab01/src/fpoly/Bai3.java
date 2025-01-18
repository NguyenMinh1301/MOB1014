package fpoly;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Bai3 {
        public static void main(String[] args) {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        
        //Mời người dùng nhập cạnh
        System.out.print("Nhap canh: ");
        int Canh = scanner.nextInt();
        
        //Tính thể thích và in kết quả
        int TheTich = Canh * Canh * Canh;      
        System.out.print("The tich cua hinh la: " + TheTich);
    }
}