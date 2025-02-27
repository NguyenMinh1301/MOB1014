package fpoly.service;

//import các thư viện và địa chỉ package chứa các file cần thiết
import fpoly.model.NhanVien;
import fpoly.model.NhanVienHanhChinh;
import fpoly.model.NhanVienTiepThi;
import fpoly.model.TruongPhong;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//Class nhân sự (Service) xử lý các yêu cầu của người dùng
public class NhanSuService {
    //Tạo list danh sách nhân viên với đặt tả truy xuất là private và không thể khởi tạo lại sau khi được khởi tạo
    private final List<NhanVien> danhSach;
    private final Scanner scanner;
    
    //Constructor khởi tạo các đối tượng của chương trình
    public NhanSuService() {
        danhSach = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    //Phương thức nhập nhân viên (có xử lý nhập dữ liệu từ bàn phím)
    public void nhapNhanVien() {
        //Mời người dụng nhập số lượng nhân viên
        System.out.print("Nhập số lượng nhân viên: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        //for để cho người dùng nhập theo thứ tự từng nhân viên
        for (int i = 0; i < soLuong; i++) {
            //Mời người dùng chọn loại nhân viên
            System.out.println("\n------------ Nhân viên thứ " + (i + 1) + " ------------");
            System.out.println("Chọn loại nhân viên:");
            System.out.println("1. Nhân viên hành chính");
            System.out.println("2. Nhân viên tiếp thị");
            System.out.println("3. Trưởng phòng");
            System.out.print("Chọn (1|2|3): ");
            int loai = Integer.parseInt(scanner.nextLine());
            
            String ma;
            //do-while để kiểm tra điều kiện để cho người dùng nhập lại nếu sai điều kiện
            do {
                System.out.print("Nhập mã nhân viên: ");
                ma = scanner.nextLine();
                //Gọi đến phương thức kiểm tra xem mã nhân viên đã tồn tại hay chưa
                if (kiemTraTonTaiCuaMaNhanVien(ma)) {
                    System.out.println("!! Mã nhân viên đã tồn tại !!");
                }
            } while (kiemTraTonTaiCuaMaNhanVien(ma));
            
            //Mời người dùng nhập tên
            System.out.print("Nhập họ tên: ");
            String ten = scanner.nextLine();
            double luong;
            
            //while để người dùng nhập lương
            while (true) {
                //try-catch để bắt lỗi trong quá trình nhập liệu
                try {
                    System.out.print("Nhập lương cơ bản: ");
                    luong = Double.parseDouble(scanner.nextLine());
                    //Không cho phép lương bé hơn hoặc bằng 0
                    if (luong > 0) break;
                    else System.out.println("!! Vui lòng nhập số lớn hơn 0 !!");
                } catch (Exception ex) {
                    System.out.println("!! Lỗi nhập liệu !!");
                }
            }
            
            switch (loai) {
                //Chạy case 1 nếu loại nhân viên là hành chính
                case 1:
                    //add vào danh sách các thông tin của nhân viên hành chính
                    danhSach.add(new NhanVienHanhChinh(ma, ten, luong));
                    break;
                //Chạy case 2 nếu loại nhân viên là tiếp thị
                case 2:
                    double doanhSo;
                    while (true) {
                        try {
                            System.out.print("Nhập doanh số: ");
                            doanhSo = Double.parseDouble(scanner.nextLine());
                            //Không cho phép lương bé hơn hoặc bằng 0
                            if (doanhSo > 0) break;
                            else System.out.println("!! Vui lòng nhập số lớn hơn 0 !!");
                        } catch (Exception ex) {
                            System.out.println("!! Lỗi nhập liệu !!");
                        }
                    }
                    double hoaHong;
                    while (true) {
                        try {
                            System.out.print("Nhập tỉ lệ hoa hồng: ");
                            hoaHong = Double.parseDouble(scanner.nextLine());
                            //Không cho phép lương bé hơn hoặc bằng 0
                            if (hoaHong > 0) break;
                            else System.out.println("!! Vui lòng nhập số lớn hơn 0 !!");
                        } catch (Exception ex) {
                            System.out.println("!! Lỗi nhập liệu !!");
                        }
                    }
                    //add vào danh sách các thông tin, đặc tính của nhân viên tiếp thị
                    danhSach.add(new NhanVienTiepThi(ma, ten, luong, doanhSo, hoaHong));
                    break;
                //Chạy case 3 nếu loại nhân viên là trưởng phòng
                case 3:
                    double luongTrachNhiem;
                    while (true) {
                        try {
                            System.out.print("Nhập lương trách nhiệm: ");
                            luongTrachNhiem = Double.parseDouble(scanner.nextLine());
                            //Không cho phép lương bé hơn hoặc bằng 0
                            if (luongTrachNhiem > 0) break;
                            else System.out.println("!! Vui lòng nhập số lớn hơn 0 !!");
                        } catch (Exception ex) {
                            System.out.println("!! Lỗi nhập liệu !!");
                        }
                    }
                    //add vào danh sách các thông tin, đặc tính của nhân viên
                    danhSach.add(new TruongPhong(ma, ten, luong, luongTrachNhiem));
                    break;
                //Default nếu người dùng nhập sai
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    //Phương thức xuất danh sách nhân viên
    public void xuatDanhSach() {
        //Kiểm tra xem danh sách có trống hay không
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách nhân viên trống!");
            return;
        }
        //Xuất thông tin nhân viên theo cột cố định
        System.out.printf("%-15s %-12s %-25s %25s %25s %25s %25s\n",
                "Loại NV", "Mã NV", "Họ Tên", "Lương", "Thu Nhập", "Thuế", "Thu Nhập Sau Thuế");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        //For-each để lặp qua danh sách sinh viên
        for (NhanVien nv : danhSach) {
            //Gọi phương thức xuất thông tin
            nv.xuatThongTin();
        }
    }

    //Phương thức tìm nhân viên theo mã
    public void timNhanVienTheoMa() {
        //Mời người dùng nhập mã nhân viên
        System.out.print("Nhập mã nhân viên cần tìm: ");
        String ma = scanner.nextLine();
        boolean found = false;

        //Xuất thông tin nhân viên theo cột cố định
        System.out.printf("%-15s %-12s %-25s %25s %25s %25s %25s\n",
                "Loại NV", "Mã NV", "Họ Tên", "Lương", "Thu Nhập", "Thuế", "Thu Nhập Sau Thuế");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");

        //For-each để lặp qua danh sách sinh viên
        for (NhanVien nv : danhSach) {
            //Kiểm tra nếu mã nhân viên của nv trùng khớp với mã nhập vào (không phân biệt chữ hoa chữ thường)
            if (nv.getMaNV().equalsIgnoreCase(ma)) {
                //Gọi phương thức xuất thông tin
                nv.xuatThongTin();
                found = true;
                break;
            }
        }

        // Nếu không tìm thấy, thông báo cho người dùng
        if (!found) {
            System.out.println("!! Không tìm thấy nhân viên !!");
        }
    }

    //Phương thức xóa nhân viên theo mã
    public void xoaNhanVienTheoMa() {
        //Mời người dùng nhập mã nhân viên cần xoá
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String ma = scanner.nextLine();
        /*Boolean kiểm tra xem mã nhân viên có được xoá hay chưa. removeIf(xoá nếu điều kiện đúng) "->" là một biểu thức lamda
        * nó so sánh giá trị của thuộc tính maNV được lấy qua nv.getMaNV với ma được người dùng nhập vào không phân biệt chữ hoa thường
        */ 
        boolean removed = danhSach.removeIf(nv -> nv.getMaNV().equalsIgnoreCase(ma));
        if (removed) {
            System.out.println("!! Nhân viên có mã " + ma + " đã được xóa !!");
        } else {
            System.out.println("!! Không tìm thấy nhân viên có mã " + ma + " !!");
        }
    }

    //Phương thức capNhatThongTinNhanVien()
    public void capNhatThongTinNhanVien() {
        //Mời người dùng nhập vào mã sinh viên muốn thay đổi thông tin
        System.out.print("Nhập mã nhân viên cần cập nhật: ");
        String maNV = scanner.nextLine();
        
        //For-each để lặp qua toàn bộ danh sách sinh viên
        for (NhanVien nv : danhSach) {
            //Kiểm tra xem có sinh viên có tồn tại trong danh sách hay không
            if (nv.getMaNV().equalsIgnoreCase(maNV)) {
                //In thông báo nếu tìm thấy
                System.out.println("Đã tìm thấy nhân viên:");
                System.out.printf("%-15s %-12s %-25s %25s %25s %25s %25s\n",
                        "Loại nhân viên", "Mã NV", "Họ Tên", "Lương", "Thu Nhập", "Thuế", "Thu Nhập Sau Thuế");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
                //Gọi phương thức xuất
                nv.xuatThongTin();

                //Gọi phương thức cập nhật riêng của từng loại nhân viên
                nv.capNhatThongTin(scanner);
                return;
            }
        }
        //In thông báo nếu không tìm thấy sinh viên
        System.out.println("!! Không tìm thấy nhân viên với mã này !!");
    }

    //Phương thức tìm nhân viên theo khoảng lương (dựa trên thu nhập)
    public void timNhanVienTheoLuong() {
        double min, max;
        
        //Try-catch để bắt lỗi
        try {
            do {
                //Mời người dùng nhập khoảng lương tối thiểu
                System.out.print("Nhập khoảng lương tối thiểu: ");
                min = Double.parseDouble(scanner.nextLine());
                if(min < 0) {
                    System.out.println("!! Lương tối thiểu không được bé hơn 0 !!");
                } else {
                    //Mời người dùng nhập khoảng lương tối đa
                    System.out.print("Nhập khoảng lương tối đa: ");
                    max = Double.parseDouble(scanner.nextLine());
                    if(max < min) {
                        System.out.println("!! Lương tối đa không được bé hơn hoặc bằng lương tối thiểu !!");
                    } else {
                        break;
                    }
                } 
            } while(true);
            
            //Khởi tạo một List danh sách để lưu thông tin của nhân viên có lương nằm trong khoảng yêu cầu
            List<NhanVien> result = new ArrayList<>();
            
            //For-each lặp qua toàn bộ danh sách sinh viên
            for (NhanVien nv : danhSach) {
                //Khởi tạo biến thu nhập và gán cho nó giá trị của phương thức get thu nhập của nhân viên có vị trí đang được lặp trong for
                double thuNhap = nv.getThuNhap();
                //Nếu biến thu nhập nằm trong khoảng yêu cầu
                if (thuNhap >= min && thuNhap <= max) {
                    //add nhân viên đó vào danh sách
                    result.add(nv);
                }
            }
            
            //Nếu không tìm thấy nhân viên nào không nằm trong khoảng lương yêu cầu
            if (result.isEmpty()) {
                //In thông báo
                System.out.println("Không có nhân viên nào trong khoảng lương này.");
            //Nếu tìm thấy nhân viên nằm trong khoảng lương yêu cầu    
            } else {
                //In thông tin nhân viên theo định dạng cố định
                System.out.printf("%-15s %-12s %-25s %25s %25s %25s %25s\n",
                        "Loại NV", "Mã NV", "Họ Tên", "Lương", "Thu Nhập", "Thuế", "Thu Nhập Sau Thuế");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
                //For-each để lặp qua toàn bộ danh sách nhân viên có lương nằm trong khoảng yêu cầu
                for (NhanVien nv : result) {
                    nv.xuatThongTin();
                }
            }
        //In thông báo nếu có lỗi
        } catch (NumberFormatException ex) {
            System.out.println("!! Lỗi: Vui lòng nhập số hợp lệ cho khoảng lương !!");
        }
    }

    //Phương thức sắp xếp theo họ tên
    public void sapXepTheoHoTen() {
        //Gọi phương thức sort của Comparator 
        danhSach.sort(Comparator.comparing(nv -> nv.getHoTen()));
        //In thông báo nếu sắp xếp thành công
        System.out.println("!! Sắp xếp theo họ tên thành công !!");
        //Gọi phương thức xuất danh sách
        xuatDanhSach();
    }

    //Phương thức sắp xếp theo thu nhập (người dùng chọn tăng dần hoặc giảm dần)
    public void sapXepTheoThuNhap() {
        //Hỏi người dugn2 muốn sắp xếp theo thứ tự nào
        System.out.println("Chọn cách sắp xếp theo thu nhập:");
        System.out.println("1. Từ lớn đến bé");
        System.out.println("2. Từ bé đến lớn");
        System.out.print("Chọn (1|2): ");
        try {
            //comp1 sắp xếp từ lớn đến bé
            Comparator<NhanVien> comp1 = new Comparator<NhanVien>() {
                @Override
                public int compare(NhanVien nv1, NhanVien nv2) {
                    return Double.compare(nv2.getThuNhap(), nv1.getThuNhap());
                }
            };
            
            //comp2 sắp xếp từ bé đến lớn
            Comparator<NhanVien> comp2 = new Comparator<NhanVien>() {
                @Override
                public int compare(NhanVien nv1, NhanVien nv2) {
                    return Double.compare(nv1.getThuNhap(), nv2.getThuNhap());
                }
            };
            
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    //Gọi comp1
                    danhSach.sort(comp1);
                    System.out.println("!! Sắp xếp từ lớn đến bé thành công !!");
                    break;
                case 2:
                    //Gọi comp2
                    danhSach.sort(comp2);
                    System.out.println("!! Sắp xếp từ bé đến lớn thành công !!");
                    break;
                default:
                    System.out.println("!! Vui lòng nhập số hợp lệ (1 hoặc 2) !!");
                    return;
            }
            //Gọi phương thức xuất danh sách nhân viên
            xuatDanhSach();
        } catch (Exception ex) {
            System.out.println("!! Lỗi nhập liệu !!");
        }
    }

    //Phương thức xuất những nhân viên có thu nhập cao nhất
    public void xuatTopNhanVien() {
        //Nhập số lương nhân viên muốn xuất
        System.out.print("Nhập số lượng nhân viên muốn xuất: ");
        int n = Integer.parseInt(scanner.nextLine());
        
        //Dùng comparator để sắp xếp
        Comparator<NhanVien> comp1 = new Comparator<NhanVien>() {
                @Override
                public int compare(NhanVien nv1, NhanVien nv2) {
                    return Double.compare(nv2.getThuNhap(), nv1.getThuNhap());
                }
            };
        
        //Gọi danh sách và phương thức sort
        danhSach.sort(comp1);
        //In thông tin theo cột cố định
        System.out.printf("%-15s %-12s %-25s %25s %25s %25s %25s\n",
                "Loại NV", "Mã NV", "Họ Tên", "Lương", "Thu Nhập", "Thuế", "Thu Nhập Sau Thuế");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        //For-each để lặp qua danh sách nhân viên
        for (int i = 0; i < Math.min(n, danhSach.size()); i++) {
            danhSach.get(i).xuatThongTin();
        }
    }

    //Phương thức kiểm tra tồn tài của mã nhân viên
    private boolean kiemTraTonTaiCuaMaNhanVien(String maNV) {
        for (NhanVien nv : danhSach) {
            //Nếu tìm thấy mã nhân viên đã tồn tại trong danh sách
            if (nv.getMaNV().equalsIgnoreCase(maNV)) {
                return true; 
            }
        }
        return false;
    }
}
