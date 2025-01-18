/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        
        //Mời người dùng nhập 3 số
        System.out.print("Nhap so A: ");
        double numA = scanner.nextInt();
        System.out.print("Nhap so B: ");
        double numB = scanner.nextInt();
        System.out.print("Nhap so C: ");
        double numC = scanner.nextInt();
        
        //Số đầu tiên phải khác 0
        if (numA == 0) {
            System.out.print("Vui long nhap mot so khac 0!");
        }
        
        //Tính toán và in ra kết quả
        if (numA != 0) {
            //Nếu người dùng nhập một số khác 0 thì trương trình tính và lưu vào biến Delta
            double Delta = Math.sqrt(numB) - (4 * numA * numC);
            //Nếu Delta < 0 in ra kết quả
            if (Delta < 0) {
                System.out.println("Phuong trinh vo nghiem!");
            //Nếu Delta == 0 in tính toán
            } else if (Delta == 0) {
                double Nghiem = (-numB / (2 * numA));
                System.out.println("Phuong trinh co nghiem kep la: " + Nghiem);
            //Nếu Dell ta > 0 tính toán (tất cả các trường hợp còn lại)
            } else {
                System.out.println("Phuong trinh co 2 nghiem phan biet la:");
                double X1 = ((-numB) + Math.sqrt(Delta)) / (2 * numA);
                double X2 = ((-numB) - Math.sqrt(Delta)) / (2 * numA);
                
                System.out.println("Nghiem thu nhat la: " + X1);
                System.out.println("Nghiem thu hai la: " + X2);
            }
        }
    }
}
