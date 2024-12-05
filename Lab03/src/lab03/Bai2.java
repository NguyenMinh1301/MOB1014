package lab03;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        int i, A = 0;
        boolean Valid = false;
        
        //In trương trình
        System.out.print("Nhap vao bang cuu chuong ban muon hien: ");
        //Kiểm tra người dùng có nhập đúng giá trị hay không bằng try catch
        try {
            //Nếu nhập đúng trả lại giá trị Valid = true
            A = scanner.nextInt();
            Valid = true;
        //Thông báo người dùng nhập lỗi
        } catch (Exception ex) {
            System.out.println("Da xay ra loi");
            System.exit(0);
        } 
        
        //Nếu Valid == true trương trình in ra kết quả
        if (Valid == true) {
            for (i = 1; i <= 10; i++) {
                System.out.println(A + " X " + i + " = " + (A*i));
            }
        //Nếu Valid != true trương trình in sai
        } else {
            System.out.println("Nhap lieu sai");
        }
    }
}
