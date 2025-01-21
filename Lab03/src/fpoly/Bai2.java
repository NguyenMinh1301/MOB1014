package fpoly;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Bai2 {
    public static void Bai2() {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        
        //Mời người dùng nhập vào lựa chọn
        System.out.println("Chon mot trong hai lua chon:");
        System.out.println("1. In bang cuu chuong tu 1 den 10");
        System.out.println("2. In bang cuu chuong tu chon");
        System.out.print("Nhap lua chon cua ban (1 hoac 2): ");
        
        int choice;
        //Bắt lỗi ở phần lựa chọn
        try {
            choice = scanner.nextInt();
        } catch (Exception ex) {
            System.out.println("Da xay ra loi. Vui long nhap so 1 hoac 2.");
            return;
        }
        //Chọn chương trình
        switch (choice) {
            case 1:
                //In tất cả bảng cửu chương [1-10]
                All();
                break;
            case 2:
                //In bảng cửu chương mong muốn
                Only();
                break;
            default:
                System.out.println("Lua chon khong hop le. Vui long thu lai.");
        }
    }
    
    public static void All() {
        System.out.println("Bang cuu chuong tu 1 den 10:");
        //Dùng 2 vòng for lồng để in ra bảng cửu chương từ [1-10]
        for (int i = 2; i <= 9; i++) {
            //Chạy từ [1-10]
            System.out.println("\nBang cuu chuong " + i + ":");
            for (int j = 1; j <= 9; j++) {
                //Chạy từ [1-10] và tính các phép tính của từng bảng cửu chương
                System.out.println(i + " x " + j + " = " + (i * j));
            }
        }
    }

    public static void Only() {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        int table;
        
        //In thông báo
        System.out.print("Nhap vao bang cuu chuong ban muon hien (1 den 10): ");
        try {
            table = scanner.nextInt();
            //Chỉ cho nhập từ [1-10]
            if (table < 2 || table > 9) {
                System.out.println("Vui long nhap so tu 1 den 10.");
                return;
            }
        } catch (Exception ex) {
            //Bắt lỗi ở phần nhập liệu
            System.out.println("Da xay ra loi. Vui long nhap so nguyen hop le.");
            return;
        }

        System.out.println("\nBang cuu chuong " + table + ":");
        for (int i = 2; i <= 9; i++) {
            //Chạy từ [1-10] và tính các phép tính của từng bảng cửu chương
            System.out.println(table + " x " + i + " = " + (table * i));
        }
    }
    
    public static void main(String[] args) {
        //Gọi trương trình
        Bai2();
    }
}
