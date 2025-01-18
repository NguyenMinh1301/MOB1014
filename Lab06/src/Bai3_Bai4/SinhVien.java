package Bai3_Bai4;
//Khai báo thư viện dùng Scanner và RegexPattern
import java.util.Scanner;
import java.util.regex.Pattern;

public class SinhVien {
    //Tạo các biến với đặt tả truy xuất là private
    private String hoTen;
    private String email;
    private String sdt;
    private String cmnd;
    
    //Tạo Getter và Shetter
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }
    
    //Phương thức nhap()
    public void nhap() {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nVui lòng nhập TÊN | EMAIL | SĐT | CMND của sinh viên\n");
        
        //Mời người dùng nhập ten
        System.out.print("Nhập họ tên: ");
        //Dùng trim() để loại bỏ kí tự khoảng trắng ở đầu và cuối (nếu có)
        hoTen = scanner.nextLine().trim();
        
         
        try{
            //Mời người dùng nhập email
            do {
                try{
                    System.out.print("Nhập email: ");
                    //Dùng trim() để loại bỏ kí tự khoảng trắng ở đầu và cuối (nếu có)
                    email = scanner.nextLine().trim();
                    //Kiểm tra định dạng email
                    if(!validEmail(email)) {
                        System.out.println("Email không hợp lệ vui lòng nhập lại!");
                    }
                } catch(Exception ex) {
                    //Bắt lỗi nhập liệu
                    System.out.println("Đã xảy ra lỗi trong quá trình nhập email: " + ex.getMessage());
                }
            } while (!validEmail(email));
            
            //Mời người dùng nhập sdt
            do {
                try {
                    System.out.print("Nhập số điện thoại: ");
                    //Dùng trim() để loại bỏ kí tự khoảng trắng ở đầu và cuối (nếu có)
                    sdt = scanner.nextLine().trim();
                    //Kiểm tra định dạng sdt
                    if(!validSdt(sdt)) {
                        System.out.println("Số điện thoại không hợp lệ vui lòng nhập lại!");
                    }
                } catch (Exception ex) {
                    //Bắt lỗi nhập liệu
                    System.out.println("Đã xảy ra lỗi trong quá trình nhập số điện thoại: " + ex.getMessage());
                }
            } while (!validSdt(sdt));
            
            //Mời người dùng nhập cmnd
            do {
                try {
                    System.out.print("Nhập chứng minh nhân dân: ");
                    //Dùng trim() để loại bỏ kí tự khoảng trắng ở đầu và cuối (nếu có)
                    cmnd = scanner.nextLine().trim();
                    //Kiểm tra định dạng cmnd
                    if(!validCmnd(cmnd)) {
                        System.out.println("Chứng minh nhân dân không hợp lệ vui lòng nhập lại!");
                    }
                } catch(Exception ex) {
                    //Bắt lỗi nhập liệu
                    System.out.println("Đã xảy ra lỗi trong quá trình nhập chứng minh nhân dân: " + ex.getMessage());
                }
            } while (!validCmnd(cmnd));
        } catch (Exception ex) {
            System.out.println("Đã xảy ra lỗi trong quá trình nhập liệu: " + ex.getMessage());
        }
        
        System.out.println();
    }
    
    //Phương thức kiểm tra email
    private boolean validEmail(String email) {
        //Email mặc định là <username>@<domain>
        String emailRegex = "\\w+@\\w+\\.\\w+";
        return Pattern.matches(emailRegex, email);
    }
    
    //Phương thức kiểm tra sdt
    private boolean validSdt(String sdt) {
        //Số điện thoại Việt Nam bắt đầu bằng 03, 05, 07, 08, 09 và có 10 chữ số
        String sdtRegex = "^(03|05|07|08|09)\\d{8}$";
        return Pattern.matches(sdtRegex, sdt);
    }
    
    //Phương thức kiểm tra cmnd
    private boolean validCmnd(String cmnd) {
        //CMND cũ có 9 chữ số | loại mới có 12 chữ số
        String cmndRegex = "^\\d{9}$|^\\d{12}$";
        return Pattern.matches(cmndRegex, cmnd);
    }
    
    //Phương thức xuat()
    public void xuat() {
        //In ra thông tin sinh viên với định dạng cố định
        System.out.printf("%-25s %-30s %-15s %-15s\n", "TÊN", "EMAIL", "SĐT", "CMND");
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-25s %-30s %-15s %-15s\n", hoTen, email, sdt, cmnd);
    }
}
