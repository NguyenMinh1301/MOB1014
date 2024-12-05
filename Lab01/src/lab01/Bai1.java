package lab01;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap ten sinh vien: ");
        String TenSV = scanner.nextLine();
        System.out.print("Nhap diem: ");
        
        double Diem = scanner.nextDouble();
        
        System.out.println("Ten cua sinh vien la: " + TenSV);
        System.out.println("Diem cua sinh vien la: " + Diem);
    }
}