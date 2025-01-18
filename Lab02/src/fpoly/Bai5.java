package fpoly;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap so thu nhat: ");
        int numA = scanner.nextInt();
        System.out.print("Nhap so thu hai: ");
        int numB = scanner.nextInt();
        System.out.print("Nhap so thu ba: ");
        int numC = scanner.nextInt();
        
        int Max = numA;
        if (numB > numA) {
            Max = numB;
        } else if (numC > numA) {
            Max = numC;
        }

        System.out.println("So lon nhat trong ba so la: " + Max);
    }
}
