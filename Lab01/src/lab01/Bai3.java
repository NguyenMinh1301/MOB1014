package lab01;

import java.util.Scanner;

public class Bai3 {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap canh: ");
        int Canh = scanner.nextInt();
        
        int TheTich = Canh * Canh * Canh;
        
        System.out.print("The tich cua hinh la: " + TheTich);
    }
}
