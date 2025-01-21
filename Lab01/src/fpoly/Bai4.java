package fpoly;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Bai4 {
        public static void main(String[] args) {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        
        //Mời người dùng nhập 3 số bất kì
        System.out.print("Nhap so a: ");
        double numA = scanner.nextDouble();
        System.out.print("Nhap so b: ");
        double numB = scanner.nextDouble();
        System.out.print("Nhap so c: ");
        double numC = scanner.nextDouble();
        
        //Tính delta
        double Delta = Math.pow(numB, 2) - (double)4.0F * numA * numC;
        System.out.println("Ket qua sau khi tinh delta la: " + Delta);
    }
}
