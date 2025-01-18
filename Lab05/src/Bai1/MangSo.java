package Bai1;

import java.util.Scanner; //Thư viện Scanner
import java.util.ArrayList; //Thư viện ArrayList

public class MangSo {
    //Biến toàn cục lưu trữ số thực của người dùng nhập vào
    private ArrayList<Double> list = new ArrayList<>();
    
    public void Nhap() {
        //Khai báo Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap danh sach so thuc");
        
        while(true) {
            //Người dùng nhập số vào danh sách
            System.out.print("Nhap so: ");
            Double x = scanner.nextDouble();  
            list.add(x); //Thêm số vừa nhập vào danh sách
            scanner.nextLine();
            
            System.out.print("Ban co muon tiep tuc nhap Y/N: ");
            if(scanner.nextLine().equals("N")) { //Nếu người dùng nhập "N" thoát vòng lặp. Ngược lại tiếp tục vòng lặp
                break;
            } 
        }
    }
    
    public void HienThi() {
        System.out.println("==================================");
        for(Double item : list) { //Sử dụng for-each duyệt tất cả phần tử trong list và in ra màn hình
            System.out.print("   " + item);
        } 
    }
    
    public void TinhTong() {
        double tong = 0;
        for (Double item : list) { //Sử dụng for-each duyệt tất cả phần tử trong list
            tong += item; //Cộng dồn phần tử trong list vào tong
        }
        System.out.println();
        System.out.println("Tong: " + tong); //In tổng
    }
}