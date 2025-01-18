package Bai2_Bai3_Bai4;
//Khai báo thư viện dùng ArrayList, Collections, Comparator và Scanner

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DanhSachSinhVien {

    //Danh sách lưu trữ các đối tượng SinhVienPoly
    ArrayList<SinhVienPoly> list = new ArrayList<>();

    //Vòng lặp cho người dùng nhập vào danh sách sinh viên
    public void nhap() {
        while (true) {
            try {
                //Tạo đối tượng Scanner và các biến
                Scanner scanner = new Scanner(System.in);
                
                System.out.print("Nhập họ tên sinh viên: ");
                //Dùng trim() để loại bỏ khoảng trắn đầu và cuối dòng
                String hoTen = scanner.nextLine().trim();
                
                //Nếu người dùng để khoảng trắng (Enter) thì dừng nhập 
                if (hoTen.isEmpty()) {
                    break;
                }

                //Người dùng nhập ngành
                System.out.print("Nhập tên ngành (IT/Biz): ");
                String nganh = scanner.nextLine().trim();

                //Dựa trên ngành người dùng nhập (IT | Biz)
                //Đối tượng SinhVienIT hoặc SinhVienBiz được tạo và thêm vào danh sách
                if (nganh.equalsIgnoreCase("IT")) {
                    //Xử lý ngành nhập IT
                    double diemJava = nhapDiem(scanner, "Nhập điểm Java: ");
                    double diemCss = nhapDiem(scanner, "Nhập điểm CSS: ");
                    double diemHtml = nhapDiem(scanner, "Nhập điểm HTML: ");
                    //Add sinh viên vừa nhập vào danh sách SinhVienIT
                    SinhVienPoly svIT = new SinhVienIT(hoTen, nganh, diemJava, diemCss, diemHtml);
                    list.add(svIT);
                } else if (nganh.equalsIgnoreCase("Biz")) {
                    //Xử lý ngành nhập Biz
                    double diemMarketing = nhapDiem(scanner, "Nhập điểm Marketing: ");
                    double diemSales = nhapDiem(scanner, "Nhập điểm Sales: ");
                    //Add sinh viên vừa nhập vào danh sách SinhVienBiz
                    SinhVienPoly svBiz = new SinhVienBiz(hoTen, nganh, diemMarketing, diemSales);
                    list.add(svBiz);
                } else {
                    //Ngành không hợp lệ
                    System.out.println("Ngành không hợp lệ vui lòng nhập lại!!");
                }
            } catch (Exception ex) {
                //In nếu có lỗi
                System.out.println("Đã xảy ra lỗi trong quá trình nhập liệu: " + ex.getMessage());
            }
        }
    }

    //Phương thức hỗ trợ kiểm tra phần nhap(). Đảm bảo rằng điểm nhập vào phải là số thực
    private double nhapDiem(Scanner scanner, String message) {
        double diem = 0.0;
        while (true) {
            try {
                //In thông báo yêu cầu nhập điểm
                System.out.print(message);
                diem = Double.parseDouble(scanner.nextLine().trim());
                //Điểm phải nằm trong khoảng từ [0-10]
                if (diem < 0 || diem > 10) {
                    //Thả lỗi được xác định
                    throw new IllegalArgumentException("Điểm phải nằm trong khoảng từ 0 đến 10.");
                }
                break;
            } catch (NumberFormatException ex) {
                //In lỗi được thả
                System.out.println("Dữ liệu nhập không hợp lệ. Vui lòng nhập số.");
            } catch (IllegalArgumentException ex) {
                //Các lỗi còn lại
                System.out.println("Đã xảy ra lỗi trong quá trình nhập liệu: " + ex.getMessage());
            }
        }
        //Trả lại điểm đã được kiểm tra (điểm hợp lệ)
        return diem;
    }

    public void xuat() {
        System.out.printf("%-25s %-10s %-10s %-15s\n", "TÊN", "NGÀNH", "ĐIỂM", "HỌC LỰC");
        System.out.println("-----------------------------------------------------------");
        for (SinhVienPoly sv : list) {
            //In ra thông tin sinh viên với định dạng cố định
            System.out.printf("%-25s %-10s %-10.1f %-15s\n", sv.getHoTen(), sv.getNganh(), sv.getDiem(), sv.getHocLuc());
        }
    }

    public void xuatTheoHocLuc() {
        //Tạo đối tượng Scanner và các biến
        Scanner scanner = new Scanner(System.in);

        //Hỏi người dùng muốn in học lực loại nào
        System.out.print("Nhập học lực bạn muốn xem (YẾU | TRUNG BÌNH | KHÁ | GIỎI | XUẤT SẮC): ");
        //Lưu học lực người dùng mong muốn, dùng trim() để loại bỏ kí tự khoảng trắng ở đầu và cuối (nếu có)
        String hocLuc = scanner.nextLine().trim();
        boolean coSinhVien = false;

        //In ra thông tin sinh viên nếu trùng học lực
        System.out.printf("%-25s %-10s %-10s %-15s\n", "TÊN", "NGÀNH", "ĐIỂM", "HỌC LỰC");
        System.out.println("-----------------------------------------------------------");
        //Dùng for-each để lặp qua danh sách
        for (SinhVienPoly sv : list) {
            //Nếu có sinh viên trùng với học lực của người dùng nhập
            if (hocLuc.equalsIgnoreCase(sv.getHocLuc())) {
                //In ra thông tin sinh viên với định dạng cố định
                System.out.printf("%-25s %-10s %-10.1f %-15s\n", sv.getHoTen(), sv.getNganh(), sv.getDiem(), sv.getHocLuc());
                coSinhVien = true;
            }
        }
        //Nếu không có sinh viên trùng với học lực người dùng nhập
        if (!coSinhVien) {
            //In ra thông báo + học lực người dùng nhập
            System.out.println("Không có sinh viên nào có học lực " + hocLuc + ".");
        }
    }

    //Comparator để sắp xếp sinh viên theo điểm tăng dần
    Comparator<SinhVienPoly> comp1 = new Comparator<SinhVienPoly>() {
        @Override
        public int compare(SinhVienPoly o1, SinhVienPoly o2) {
            return Double.compare(o1.getDiem(), o2.getDiem());
        }
    };

    //Comparator để sắp xếp sinh viên theo điểm giảm dần
    Comparator<SinhVienPoly> comp2 = new Comparator<SinhVienPoly>() {
        @Override
        public int compare(SinhVienPoly o1, SinhVienPoly o2) {
            return Double.compare(o1.getDiem(), o2.getDiem());
        }
    };

    //Phương thức sắp xếp sinh viên theo điểm [tăng | giảm]
    public void sapXepTheoDiem() {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                //Mời người dùng nhập 
                System.out.print("Sắp xếp theo điểm (1: Tăng dần, 2: Giảm dần): ");
                //Lưu thông tin và chỉ cho phép 2 giá trì là 1 hoặc 2
                int choice = scanner.nextInt();

                //Kiểm tra giá trị nhập vào
                if (choice < 1 || choice > 2) {
                    //Thả lỗi đã được xác định
                    throw new Error("Lựa chọn phải số nguyên là 1 hoặc 2");
                } else {

                    if (choice == 1) {
                        //Nếu người dùng nhập 1
                        //Dùng phương thức sort của Collections
                        Collections.sort(list, comp1);
                        System.out.println("Sắp xếp tăng dần theo điểm: ");
                        //In danh sách sau khi được sắp xếp
                        xuat();
                        break;
                    } else if (choice == 2) {
                        //Nếu người dùng nhập 2
                        //Dùng phương thức sort của Collections
                        Collections.sort(list, comp2);
                        System.out.println("Sắp xếp giảm dần theo điểm: ");
                        //In danh sách sau khi được sắp xếp
                        xuat();
                        break;
                    } else {
                        //Nếu người dùng nhập sai
                        System.out.println("!!Nhập sai, vui lòng nhập lại!!");
                    }
                }
            } catch (Exception ex) {
                System.out.println("!!Nhập sai, vui lòng nhập lại!!");
            } catch (Error ex) {
                //In lỗi đã được xác định
                System.out.println(ex.getMessage());
            }
        } while (true);
    }

    public void menu() {
        //Tạo đối tượng scanner và các biến
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\t\t==================NguyenMinh.exe==================");
            System.out.println("\t\t||                                              ||");
            System.out.println("\t\t||   !! NHẬP TRƯƠNG TRÌNH BẠN MUỐN SỬ DỤNG !!   ||");
            System.out.println("\t\t||                                              ||");
            System.out.println("\t\t||  [1] Nhập danh sách sinh viên.               ||");
            System.out.println("\t\t||  [2] Xuất thông tin danh sách sinh viên.     ||");
            System.out.println("\t\t||  [3] Xuất danh sách sinh viên theo học lực.  ||");
            System.out.println("\t\t||  [4] Sắp xếp danh sách sinh viên theo điểm.  ||");
            System.out.println("\t\t||                                              ||");
            System.out.println("\t\t||  [0] Thoat truong trinh.                     ||");
            System.out.println("\t\t||                                              ||");
            System.out.println("\t\t==================================================");
            System.out.print("\t\tVui lòng nhập trong khoảng [0 - 4]: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 0:
                        System.out.println("\t\tTạm biệt. Hẹn gặp lại !");
                        System.exit(0);
                        break;
                    case 1:
                        nhap();
                        break;
                    case 2:
                        xuat();
                        break;
                    case 3:
                        xuatTheoHocLuc();
                        break;
                    case 4:
                        sapXepTheoDiem();
                        break;
                    default:
                        System.out.println("!!Nhập sai, vui lòng nhập lại!!");
                        break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("!!Nhập sai, vui lòng nhập lại!!");
            }
        } while (true);
    }
}
