package lab01;

import java.util.Scanner;

public class Bai5 {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap so A: ");
        int numA = scanner.nextInt();
        System.out.print("Nhap so B: ");
        int numB = scanner.nextInt();
        System.out.print("Nhap so B: ");
        int numC = scanner.nextInt();
        
        float Avg = (float)((numA + numB + numC) / 3);
        
        System.out.println("Trung binh cua 3 so la: " + Avg);
    }
}
