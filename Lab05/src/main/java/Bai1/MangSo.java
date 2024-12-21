
package Bai1;

import java.util.Scanner;
import java.util.ArrayList;

public class MangSo {
    private ArrayList<Double> list = new ArrayList<>();
    
    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap danh sach so thuc");
        
        while(true) {
            System.out.print("Nhap so: ");
            Double x = scanner.nextDouble();
            list.add(x);
            scanner.nextLine();
            
            System.out.print("Ban co muon tiep tuc nhap Y/N: ");
            if(scanner.nextLine().equals("N")) {
                break;
            } 
        }
    }
    
    public void HienThi() {
        System.out.println("==================================");
        for(Double item : list) {
            System.out.print("   " + item);
        } 
    }
    
    public void TinhTong() {
        double tong = 0;
        for (Double item : list) {
            tong += item;
        }
        System.out.println();
        System.out.println("Tong: " + tong);
    }
}
