package Bai2;
//Khai báo thư viện dùng Scanner và ArrayList
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        ArrayList<SanPham> list = new ArrayList<>();
        
        //Mời người dùng nhập vào số lượng sản phẩm (theo đề bài là 5)
        System.out.print("Nhập vào số lượng sản phẩm mà bạn đang có: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        //Dùng vòng lặp để gọi phương thức nhap n lần 
        for(int i = 0; i < n; i++) {
            SanPham sp = new SanPham();
            sp.nhap();
            //add dữ liệu người dùng vừa nhập vào list
            list.add(sp);
        }
        
        
        String targetHang = "Nokia";
        //for-each để gọi phương thức xuat n lần 
        for(SanPham sp : list) {
            //Điều kiện là hang = "Nokia" (không phân biệt hoa thường bằng phương thức equalsIgnoreCase())
            if(sp.getHang().equalsIgnoreCase(targetHang)) {
                sp.xuat();
                System.out.println();
            } else {
                System.out.println("Không có sản phẩm nào có tên hãng là " + targetHang);
            }
        }
        
        //for-each để in toàn bộ sản phẩm đã nhập
        //for(SanPham sp : list) {
        //    sp.xuat();
        //    System.out.println();  
        //} 
    }
}
