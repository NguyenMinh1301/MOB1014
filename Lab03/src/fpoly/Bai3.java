package fpoly;
//Khai báo thư viện dùng Scanner và Arrays (dùng cho Arrays.sort và Arrays.toString)
import java.util.Scanner;
import java.util.Arrays;

public class Bai3 {
    public static void Bai3 () {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        int sum = 0, n = 0, count = 0, min, i;
        double avg;
        
        //Mời người dùng nhập 
        System.out.print("Nhap so luong phan tu cua mang: ");
        //Kiểm tra người dùng có nhập đúng giá trị hay không bằng try catch
        try {
            //Nếu người dùng nhập dúng trả lại giá trị true cho Valid
            n = scanner.nextInt();
        } catch (Exception ex) {
            //Nếu nhập lỗi trương trình thoát
            System.out.println("Da xay ra loi");
            return;
        }

        //Khởi tạo một mảng có giá trị bằng với giá trị người dùng nhập vào (n)
        int mang[] = new int[n];

        //Dùng for để người dùng nhập vào giá trị cho từng phần tử của mảng
        for(i = 0; i < n; i++) {
            try {
                System.out.print("Nhap phan tu cua mang " + (i + 1) + " : ");
                mang[i] = scanner.nextInt();
            } catch (Exception ex) {
                //Nếu nhập lỗi trương trình thoát
                System.out.println("Da xay ra loi");
                return;
            }
        }

        //Sắp xếp mảng và in ra bằng Arrays.sort()
        Arrays.sort(mang);
        //Chuyển mảng thành chuỗi String và in ra
        System.out.println("Mang sau khi sap xep: " + Arrays.toString(mang));

        //Sau khi được sắp xếp (theo quy tắc là từ bé -> lớn của Arrays.sort()) phần tử 0 của mảng mặc định là giá trị nhỏ nhất 
        min = mang[0];
        System.out.println("Phan tu nho nhat cua mang: " + min);

        //Đếm các phần tử chia hết cho 3 và cộng dồn giá trị vào sum
        for(int num : mang) {
            //Nếu phần tử chia hết cho 3 thì cộng giá trị vào sum và biến count tăng lên 1 giá trị
            if (num % 3 == 0) {
                sum += num;
                count++;
            }
        }

        //Nếu count tăng lên và lớn hơn 0 (giá trị mặc định của count là 0) tính trung bình tổng
        if(count > 0) {
            avg = sum / count;
            System.out.println("Trung binh tong cac so chia het cho 3 trong mang nhap vao: " + avg);
        } else {
            //Nếu count không tăng lên nghĩa là không có phần tử nào chia hết cho 3 trong mảng
            System.out.println("Khong co phan tu nao chia het cho 3 trong mang nhap vao");
        }     
    }
    
    
    public static void main(String[] args) {
        Bai3();
    }   
}
