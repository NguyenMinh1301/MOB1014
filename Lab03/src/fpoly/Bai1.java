package fpoly;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Bai1 {
    public static void Bai1() {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner (System.in);
        int A, i, count = 0;
        
        try {
            //Mời người dùng nhập một số nguyên
            System.out.print("Nhap mot so nguyen: ");
            A = scanner.nextInt();
        } catch (Exception ex) {
            System.out.println("Da xay ra loi");
            return;
        }
        
        //Tính xem số người dùng có phải một số nguyên tố hay không
        for(i = 2; i <= Math.sqrt(A); i++) {
            if (A % i == 0) {
                //Nếu không phải là 1 số nguyên tố biến count++
                count++;
                break;
            }                 
        }
        
        //Nếu biến count == 0 và số người dùng nhập vào lớn hơn 1, in ra kết quả
        if (count == 0 && A > 1) {
            System.out.println(A + " la mot so nguyen to");
        //Tất cả các trường hợp còn lại
        } else {
            System.out.println(A + " khong phai la mot so nguyen to");
        }   
    }
    
    public static void main(String[] args) {
        Bai1();
    }
}