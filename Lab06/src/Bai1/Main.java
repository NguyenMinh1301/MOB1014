package Bai1;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        
        //Mời người dùng nhập họ tên và dùng trim() để loại bỏ 2 khoảng trắng ở đầu và cuối (nếu có)
        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine().trim();
        
        //Lấy khoảng trắng đầu tiên trở lại (từ đầu tiên từ khoảng trắng đổ về trước) VD: NGUYỄN Quang Minh
        String ho = hoTen.substring(0, hoTen.indexOf(" "));
        
        //Lấy khoảng trắn đầu tiên và khoảng trắng cuối cùng (ở giữa khoảng trắng đầu tiên và khoảng trắng cuối cùng) VD: Nguyễn QUANG Minh
        String tenDem = hoTen.substring(hoTen.indexOf(" "), hoTen.lastIndexOf(" "));
        
        //Lấy khoảng trắng cuối cùng (từ cuối cùng từ khoảng trắng đổ về sau) VD: Nguyễn Quang MINH
        String ten = hoTen.substring(hoTen.lastIndexOf(" "));
        
        //Chuyển họ và tên thành chữ viết hoa bằng phương thức toUpperCase()
        System.out.println(ho.toUpperCase() + tenDem + ten.toUpperCase());
    }
    
}
