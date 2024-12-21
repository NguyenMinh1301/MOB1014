/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly.lab03;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Bai2 {
    public static void Bai2() {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        int i, A = 0;
        
        System.out.print("Nhap vao bang cuu chuong ban muon hien: ");
        //Kiểm tra người dùng có nhập đúng giá trị hay không bằng try catch
        try {
            A = scanner.nextInt();
        } catch (Exception ex) {
            System.out.println("Da xay ra loi");
            return;
        } 
        
        //Sử dụng for để in ra bảng với giá phép nhân tăng dần
        for (i = 1; i <= 10; i++) {
            System.out.println(A + " X " + i + " = " + (A*i));
        }
    }
    
    
    public static void main(String[] args) {
        Bai2();
    }
}
