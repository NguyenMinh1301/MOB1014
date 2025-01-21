package fpoly;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Bai4 {
    //Hàm sắp xếp điểm và sinh viên theo thứ tự tăng dần bằng thuật toán Bubble Sort
    public static void SapXep(String sv[], float Diem[]) {
        for (int i = 0; i < sv.length - 1; i++) {
            for (int j = 0; j < sv.length - 1; j++) {
                //Thay đổi "<" để sắp xếp từ giảm dần
                if (Diem[j] > Diem[j + 1]) {
                    //Sắp xếp điểm
                    float tempA = Diem[j];
                    Diem[j] = Diem[j + 1];
                    Diem[j + 1] = tempA;
                    //Sắp xếp tên
                    String tempB = sv[j];
                    sv[j] = sv[j + 1];
                    sv[j + 1] = tempB;
                }
            }
        }
    }

    public static void Bai4() {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        int n;
        
        //Mời người dùng nhập và kiểm tra
        try {
            System.out.print("Nhap so luong sinh vien: ");
            n = scanner.nextInt();
        } catch (Exception ex) {
            System.out.println("Da xay ra loi");
            return;
        }
        
        //Khai báo 2 mảng tên và điểm sinh viên
        String[] sv = new String[n];
        float[] Diem = new float[n];
        
        //Mời người dùng nhập vào thông tin sinh viên n
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap ten sinh vien thu [" + (i + 1) + "]: ");
            sv[i] = scanner.nextLine();
            System.out.print("Nhap diem sinh vien thu [" + (i + 1) + "]: ");
            Diem[i] = scanner.nextFloat();
            scanner.nextLine();
        }
        
        //Gọi hàm sau khi sắp xếp
        SapXep(sv, Diem);
        
        //Kiểm tra học lực của sinh viên n
        System.out.println("\nDanh sach sinh vien sau khi sap xep:");
        for (int i = 0; i < n; i++) {
            System.out.println("Ho ten: " + sv[i]);
            System.out.println("Diem: " + Diem[i]);
            if (Diem[i] >= 9) {
                System.out.println("Hoc luc: Xuat sac!!");
            } else if (Diem[i] >= 7.5) {
                System.out.println("Hoc luc: Gioi!!");
            } else if (Diem[i] >= 6.5) {
                System.out.println("Hoc luc: Kha!!");
            } else if (Diem[i] >= 5) {
                System.out.println("Hoc luc: Trung binh!!");
            } else {
                System.out.println("Hoc luc: Yeu!!");
            }
            //Tạo một dòng trống ngăn cách giữa mỗi thông tin của sinh viên
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Bai4();
    }
}
