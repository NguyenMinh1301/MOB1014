package fpoly;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        
        //Mời người dùng nhập thông tin
        System.out.print("Nhap ten sinh vien: ");
        String TenSV = scanner.nextLine();
        System.out.print("Nhap diem: ");
        double Diem = scanner.nextDouble();
        
        //In ra thông tin
        System.out.println("Ten cua sinh vien la: " + TenSV);
        System.out.println("Diem cua sinh vien la: " + Diem);
    }
}
