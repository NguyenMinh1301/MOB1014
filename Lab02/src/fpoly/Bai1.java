package fpoly;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
    
        //In ra trương trình mời người dùng nhập 2 số
        System.out.print("Nhap so A: ");
        float numA = scanner.nextInt();
        System.out.print("Nhap so B: ");
        float numB = scanner.nextInt();
        
        //Kiểm tra 
        if (numA == 0) {    
            if (numB == 0) {
                System.out.println("Vo so nghiem!");
            } else {
                System.out.println("Vo nghiem!");
            }
        //Tính toán và in kết quả nếu vượt qua các điều kiện
        } else {
            float Nghiem = -numB / numA;
            System.out.println("Nghiem cua phuong trinh la: " + Nghiem);
        }
    }
}