package fpoly;
//Khai báo thư viện dùng Scanner
import java.util.Scanner;

public class Bai4 {
    public static void ChucNang1() {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
    
        //In ra trương trình mời người dùng nhập 2 số
        System.out.print("Nhap so A: ");
        float numA = scanner.nextInt();
        System.out.print("Nhap so B: ");
        float numB = scanner.nextInt();
        
        //Kiểm tra 
        if (numA == 0) {    
            if (numB == 0) {
                System.out.println("Vo so nghiem!");
            } else {
                System.out.println("Vo nghiem!");
            }
        //Tính toán và in kết quả nếu vượt qua các điều kiện
        } else {
            float Nghiem = -numB / numA;
            System.out.println("Nghiem cua phuong trinh la: " + Nghiem);
        }
    }

    public static void ChucNang2() {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        
        //Mời người dùng nhập 3 số
        System.out.print("Nhap so A: ");
        double numA = scanner.nextInt();
        System.out.print("Nhap so B: ");
        double numB = scanner.nextInt();
        System.out.print("Nhap so C: ");
        double numC = scanner.nextInt();
        
        //Số đầu tiên phải khác 0
        if (numA == 0) {
            System.out.print("Vui long nhap mot so khac 0!");
        }
        
        //Tính toán và in ra kết quả
        if (numA != 0) {
            //Nếu người dùng nhập một số khác 0 thì trương trình tính và lưu vào biến Delta
            double Delta = Math.sqrt(numB) - (4 * numA * numC);
            //Nếu Delta < 0 in ra kết quả
            if (Delta < 0) {
                System.out.println("Phuong trinh vo nghiem!");
            //Nếu Delta == 0 in tính toán
            } else if (Delta == 0) {
                double Nghiem = (-numB / (2 * numA));
                System.out.println("Phuong trinh co nghiem kep la: " + Nghiem);
            //Nếu Dell ta > 0 tính toán (tất cả các trường hợp còn lại)
            } else {
                System.out.println("Phuong trinh co 2 nghiem phan biet la:");
                double X1 = ((-numB) + Math.sqrt(Delta)) / (2 * numA);
                double X2 = ((-numB) - Math.sqrt(Delta)) / (2 * numA);
                
                System.out.println("Nghiem thu nhat la: " + X1);
                System.out.println("Nghiem thu hai la: " + X2);
            }
        }
    }

    public static void ChucNang3() {     
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        double Total = 0;
        
        //Mời người dụng nhập số điện sử dụng
        System.out.print("Nhap so dien da su dung: ");
        float Kw = scanner.nextInt();
        
        //Nếu số điện <= 50 tính toán
        if (Kw <= 50) {
            Total = Kw * 1000;
        //Nếu số điện > 50 tính toán
        } else if (Kw > 50) {
            Total = 50 * 1000 + (Kw - 50) * 1200;
        //Tất cả trường hợp còn lại là nhập sai
        } else {
            System.out.println("Nhap sai!!");
        }
        
        //In kết quả
        System.out.println("Tong tien ban can thanh toan la: " + Total + "VND");
    }

    public static void main(String[] args) {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        int Choice;
        
        //Tạo vòng lặp do while khi trương người dùng nhập vào số đúng điều kiện và != 0 trương trình tiếp tục được chạy
        do {
            System.out.println("\t\t==================NguyenMinh.exe==================");
            System.out.println("\t\t||                                              ||");
            System.out.println("\t\t||   !! NHAP TRUONG TRINH BAN MUON SU DUNG !!   ||");
            System.out.println("\t\t||                                              ||");
            System.out.println("\t\t||  [1] Giai phuong trinh bac nhat.             ||");
            System.out.println("\t\t||  [2] Giai phuong trinh bac hai.              ||");
            System.out.println("\t\t||  [3] Tinh tien dien.                         ||");
            System.out.println("\t\t||                                              ||");
            System.out.println("\t\t||  [0] Thoat truong trinh.                     ||");
            System.out.println("\t\t||                                              ||");
            System.out.println("\t\t==================================================");
            System.out.print("\t\tVui long nhap trong khoang [0 - 3]: ");
            Choice = scanner.nextInt();
            switch (Choice) {
                case 0:
                    System.out.println("\t\tTam biet. Hen gap lai !");
                    System.exit(0);
                    break;
                case 1:
                    ChucNang1();
                    break;
                case 2:
                    ChucNang2();
                    break;
                case 3:
                    ChucNang3();
                    break;
                default:
                    System.out.println("!!Nhap sai vui long nhap lai!!");
                    break;
            }
        } while(Choice != 0);
    }
}
