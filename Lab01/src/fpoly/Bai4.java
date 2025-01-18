package fpoly;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Bai4 {
        public static void main(String[] args) {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        
        //Mời người dùng nhập 3 số bất kì
        System.out.print("Nhap so a: ");
        double numA = (double)scanner.nextInt();
        System.out.print("Nhap so b: ");
        double numB = (double)scanner.nextInt();
        System.out.print("Nhap so c: ");
        double numC = (double)scanner.nextInt();
        
        //Tính delta
        double Delta = Math.sqrt(numB) - (double)4.0F * numA * numC;
        System.out.println("Ket qua sau khi tinh delta la: " + Delta);
    }
}
