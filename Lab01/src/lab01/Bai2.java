package lab01;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap chieu dai: ");
        int ChieuDai = scanner.nextInt();
        System.out.print("Nhap chieu rong: ");
        int ChieuRong = scanner.nextInt();
        
        System.out.println("Chu vi cua hinh chu nhat la: " + (ChieuDai + ChieuRong) / 2);
        System.out.println("Dien tich cua hinh chu nhat la: " + ChieuDai * ChieuRong);
    }
}