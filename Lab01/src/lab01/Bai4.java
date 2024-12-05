package lab01;

import java.util.Scanner;

public class Bai4 {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so a: ");
        double numA = (double)scanner.nextInt();
        System.out.print("Nhap so b: ");
        double numB = (double)scanner.nextInt();
        System.out.print("Nhap so c: ");
        double numC = (double)scanner.nextInt();
        double Delta = Math.sqrt(numB) - (double)4.0F * numA * numC;
        System.out.println("Ket qua sau khi tinh delta la: " + Delta);
    }
}
