/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpoly.lab01;
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
