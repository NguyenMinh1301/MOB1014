package Bai3;

import java.util.ArrayList;  //Thư viện ArrayList
import java.util.Comparator; //Thư viện Comparator
import java.util.Scanner; //Thư viện Scanner

public class DanhSachSanPham {
    //Biến toàn cục không thay đổi lưu trữ chuỗi của người dùng nhập vào
    private final ArrayList<SanPham> list = new ArrayList<>();
    
    public void nhap() {
        //Khai báo Scanner
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        //Mời người dùng nhập sản phẩm
        System.out.println("Vui long nhap danh sach san pham!!");
        System.out.println("Bam Enter de thoat nhap lieu");
        
        while(true) {
            System.out.print("Nhap ten san pham thu " + i + ": ");
            String ten = scanner.nextLine();
            //Kiểm tra nếu người dùng không nhập gì (ấn Enter) thì thoát vòng lặp
            if(ten == null || ten.equalsIgnoreCase("")) {
                System.out.println("Nhap ten san pham thanh cong");
                break;
            }
            
            //Khai báo gia
            double gia;
            while(true) {
                System.out.print("Nhap gia san pham: ");
                try {
                    //Yêu cầu người dùng nhập vào chuỗi và chuyển đổi chuỗi đó thành số thực
                    gia = Double.parseDouble(scanner.nextLine());
                    if(gia < 0) {
                        //Kiểm tra nếu giá bé hơn 0
                        System.out.println("Vui long nhap gia lon hon 0!! vui long nhap lai!!");
                        //Bắt đầu lại vòng lặp
                        continue;
                    }
                    //Nếu giá đọc được và lớn hơn hoặc bằng 0 thì thoát vòng lặp
                    break;
                } catch (NumberFormatException ex) {
                    //Nếu người dùng nhập sai VD: a20
                    System.out.println("Gia khong hop le vui long thu lai!!");
                }
            }
            //Ghi vào 2 giá trị người dùng nhập ten và gia vào list SanPham 
            list.add(new SanPham(ten, gia));
            //Tăng i lên 1 giá trị để tiếp tục nhập sản phẩm
            i++;
        }
    }
    
    public void xuat () {
        //Kiểm tra nếu danh sách trống
        if(list.isEmpty()) {
            System.out.println("Danh sach san pham trong!!");
            return;
        }
        //In danh sách
        System.out.println("Danh sach san pham");
        System.out.println("\tTen\t||\tGia\t");
        System.out.println("----------------------------------");
        for(SanPham sp: list) { //Dùng for-each để duyệt từng phần tử trong list
            System.out.println("\t" + sp.getTenSP() + "\t||\t" + sp.getGia());
        }
    }
    
    public void sapXep() {
        //Khai báo Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("!!Chon cach sap xep!!");
        //Mời người dùng lựa chọn cách sắp xếp
        System.out.println("[1] Sap xep theo TEN san pham!!");
        System.out.println("[2] Sap xep theo GIA san pham!!");
        
        //Kiểm tra lựa chọn
        int choice;
        while(true) {
            try {
                //Cho người dùng nhập vào chuỗi sau dó chuyển đổi chuỗi người dùng nhập vào thành số nguyên
                choice = Integer.parseInt(scanner.nextLine());
                //Chỉ chấp nhận hai giá trị duy nhất 1 hoặc 2 
                if(choice == 1 || choice == 2) break;
            } catch (NumberFormatException ex) {
                //Nếu chuỗi không đọc được hoặc giá trị không hợp lệ lặp lại vòng lặp
                System.out.println("Nhap sai!! Vui long nhap lai (1|2): ");
            }
        }
        
        //Nếu người dùng nhập 1 
        if(choice == 1) {
            
            //list.sort(...) phương thức sort của list được sử dụng để sắp xếp các phần tử theo danh sách được chỉ định
            //Comparator.comparing(...) Tạo một bộ so sánh Comparator dựa trên giá trị mà một hàm cụ thể trả về (Ở đây là SanPham::getTenSP)
            //SanPham::getTenSP trỏ đến phương thức getTenSP() của lớp SanPham | getTenSP trả lại tên sản phẩm (TenSP)
            //Comparator.comparing(SanPham::getTenSP) so sánh các phần tử dựa trên giá trị trả về của getTenSP() theo thứ tự từ điển
            list.sort(Comparator.comparing(SanPham::getTenSP)); //Đây là sắp xếp theo thứ tự tăng dần (theo từ điển) | Nếu muốn sắp xếp giảm dần, thêm .reversed() để đảo ngược chuỗi đã sắp xếp
            System.out.println("!!Da sap xep theo TEN san pham!!");
            
        //Nếu người dùng nhập 2  
        } else if(choice == 2) {
            //Cách hoạt động tương tự (điểm khác biệt là so sánh giữa các số)
            list.sort(Comparator.comparing(SanPham::getGia));
            System.out.println("!!Da sap xep theo GIA san pham!!");
        }
        //Gọi phương thức xuat()_sau khi sắp xếp theo yêu cầu
        xuat();
    }
    
    public void timXoa() {
        //Khai báo Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten san pham can tim: ");
        String ten = scanner.nextLine();
        
        //Khởi tạo biến spTimThay dùng để lưu trữ đối tượng SanPham
        SanPham spTimThay = null;
        
        for(SanPham sp1:list) { //Sử dụng for-each để lặp và tìm phần tử
            //Nếu có phần tử trùng với ten (không phân biệt hoa thường bằng equalsIgnoreCase)
            if(sp1.getTenSP().equalsIgnoreCase(ten)) {
                spTimThay = sp1; //Gán giá trị của sp1 cho spTimThay
                break; //Thoát vòng lặp sau khi tìm
            } 
        }
        
        //Kiểm tra nếu sản phẩm tìm thấy không trống (!= null)
        if(spTimThay != null) {
            //In thông tin của sản phẩm
            System.out.println("Thong tin san pham: " + spTimThay);
            System.out.println("\tTen\t||\tGia\t");
            System.out.println("----------------------------------");
            System.out.println("\t" + spTimThay.getTenSP() + "\t||\t" + spTimThay.getGia());
            
            //Hỏi người dùng có muốn xoá sản phẩm hay không (Y|N)
            System.out.println("Ban co muon xoa san phan nay khong? (Y|N): ");
            while(true) {
                String choice = scanner.nextLine().toUpperCase().trim(); //Nhận chuỗi từ người dùng (chuyển chuỗi người dùng nhập thành chữ in hoa bằng toUpperCase()) (xoá kí tự khoảng trống ở đầu và cuối bằng trim())
                
                //Nếu người dùng nhập Y
                if(choice.equals("Y")) {
                    //Xoá sản phẩm tìm thấy khỏi list
                    list.remove(spTimThay);
                    //In thông báo
                    System.out.println("Da xoa san pham thanh cong!!");
                    break; //Thoát vòng lặp
                } else if (choice.equals("N")) { //Nếu người dùng nhập N
                    //In thông báo
                    System.out.println("Da thoat thao tac xoa san pham!!");
                    break; //Thoát vòng lặp
                } else { //Người dùng không nhập Y hoặc N
                    //In thông báo và cho người dùng nhập lại
                    System.out.println("Nhap sai!! Vui long nhap lai (Y|N): ");
                }
            }
        } else { //Nếu sản phẩm không tìm thấy trong list
            //In thông báo
            System.out.println("Khong tim thay san pham!!");
        }
    }
    
    public void tinhGiaTrungBinh() {
        //Khai báo avg và sum
        double avg = 0, sum = 0;
        
        //Kiểm tra nếu danh sách trống
        if(list.isEmpty()) {
            System.out.println("Khong co san pham nao de tinh hoac khong co san pham nao co gia de tinh trung binh!!");
        } else { //Nếu danh sách không trống
        for(SanPham sp: list) { //Sử dụng for-each để lặp từng giá trị trong list
            //Cộng dồn giá sản phẩm vào sum
            sum += sp.getGia();
        }
        
        //Tính trung bình (trung bình = tổng / số lượng phần tử trong list) list.size() trả về số lượng phần tử trong list
        avg = sum / list.size();
        //In kết quả
        System.out.printf("Gia trung binh cua tat ca san pham hien co la: " + avg);
        }
    }
    
    
    public void Menu() {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        int Choice;
        
        do {
            System.out.println("\t\t==================NguyenMinh.exe==================");
            System.out.println("\t\t||                                              ||");
            System.out.println("\t\t||   !! NHAP TRUONG TRINH BAN MUON SU DUNG !!   ||");
            System.out.println("\t\t||                                              ||");
            System.out.println("\t\t||  [1] Nhap danh sach san pham.                ||");
            System.out.println("\t\t||  [2] Hien thi danh sach san pham.            ||");
            System.out.println("\t\t||  [3] Sap xep san pham theo gia.              ||");
            System.out.println("\t\t||  [4] Tim va xoa san pham.                    ||");
            System.out.println("\t\t||  [5] Tinh gia trung binh.                    ||");
            System.out.println("\t\t||                                              ||");
            System.out.println("\t\t||  [0] Thoat truong trinh.                     ||");
            System.out.println("\t\t||                                              ||");
            System.out.println("\t\t==================================================");
            System.out.print("\t\tVui long nhap trong khoang [0 - 5]: ");
            try {
                Choice = Integer.parseInt(scanner.nextLine());
                switch (Choice) {
                    case 0:
                        System.out.println("\t\tTam biet. Hen gap lai !");
                        System.exit(0);
                        break;
                    case 1: nhap(); break;
                    case 2: xuat(); break;
                    case 3: sapXep(); break;
                    case 4: timXoa(); break;
                    case 5: tinhGiaTrungBinh(); break;
                    default: System.out.println("!!Nhap sai vui long nhap lai!!"); break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("!!Nhap sai vui long nhap lai!!");
            }
        } while(true);
    }
}
