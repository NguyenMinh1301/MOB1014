package Bai3_Bai4;
//Khai báo thư viện dùng Scanner và ArrayList
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        ArrayList<SinhVien> list = new ArrayList<>();
        
        //Mời người dùng nhập vào số lượng sinh viên
        System.out.print("Nhập vào số lượng sinh viên muốn nhập: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        //Dùng vòng lặp để gọi phương thức nhap n lần 
        for(int i = 0; i < n; i++) {
            SinhVien sv = new SinhVien();
            sv.nhap();
            //add dữ liệu người dùng vừa nhập vào list
            list.add(sv);
        }
        
        //for-each để in toàn bộ sinh viên đã nhập
        for(SinhVien sv : list) {
            sv.xuat();
            System.out.println();
        }
    }    
}
