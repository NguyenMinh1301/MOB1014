package fpoly;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Bai5 {
        public static void main(String[] args) {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        
        //Mời người dùng nhập 3 số bất kì
        System.out.print("Nhap so A: ");
        int numA = scanner.nextInt();
        System.out.print("Nhap so B: ");
        int numB = scanner.nextInt();
        System.out.print("Nhap so B: ");
        int numC = scanner.nextInt();
        
        //Tính trung bình tổng của 3 số
        float Avg = (float)((numA + numB + numC) / 3);
        System.out.println("Trung binh cua 3 so la: " + Avg);
    }
}
