package fpoly;

//Khai báo các thư viện sử dụng ArrayList, Scanner, Comparator
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

public class QuanLyNhanSu {

    //Khởi tạo các biến với đặt tả truy xuất là private
    private final ArrayList<NhanVien> danhSach = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    // Phương thức kiểm tra mã trùng lặp
    private boolean trungMaNV(String maNV) {
        for (NhanVien nv : danhSach) {
            if (nv.getMaNV().equalsIgnoreCase(maNV)) {
                return true; // Mã bị trùng
            }
        }
        return false; // Mã không trùng
    }

    //Phương thức nhap()
    public void nhap() {
        //Mời người dùng nhập số lượng nhân viên
        int soLuong;
        while (true) {
            try {
                System.out.print("Nhập số lượng nhân viên: ");
                soLuong = Integer.parseInt(scanner.nextLine());
                if (soLuong > 0) {
                    break;
                } else {
                    System.out.println("!! Vui lòng nhập một số lớn hơn 0 !!");
                }
            } catch (Exception ex) {
                System.out.println("!! Đã có lỗi xảy ra trong quá trình nhập liệu !!");
            }
        }
        //Tạo vòng lặp với số lượng nhân viên mà người dùng nhập
        for (int i = 0; i < soLuong; i++) {
            //Mời người dùng chọn loại nhân viên
            System.out.println("------------ " + (i + 1) + " ------------");
            System.out.println("1. Nhân viên hành chính");
            System.out.println("2. Nhân viên tiếp thị");
            System.out.println("3. Trưởng phòng");
            System.out.print("Chọn loại nhân viên: ");
            int loai = Integer.parseInt(scanner.nextLine());

            //Nhập 3 thông tin cơ bản
            String ma;
            do {
                System.out.print("Nhập mã nhân viên: ");
                ma = scanner.nextLine();
                if (trungMaNV(ma)) {
                    System.out.println("!! Mã nhân viên đã tồn tại !!");
                }
            } while (trungMaNV(ma));

            System.out.print("Nhập họ tên: ");
            String ten = scanner.nextLine();

            double luong;
            while (true) {
                try {
                    System.out.print("Nhập lương cơ bản: ");
                    luong = Double.parseDouble(scanner.nextLine());
                    if (luong > 0) {
                        break;
                    } else {
                        System.out.println("!! Vui lòng nhập một số lớn hơn 0 !!");
                    }
                } catch (Exception ex) {
                    System.out.println("!! Đã có lỗi xảy ra trong quá trình nhập liệu !!");
                }
            }

            //Nhập thông tin đặc biệt của các loại nhân viên
            switch (loai) {
                //Nhân viên hành chính
                case 1 ->
                    //Vì nhân viên hành chính không có thông tin đặc biệt nên truyền toàn bộ 3 thông tin cơ bản vào trong danh sách nhân viên
                    danhSach.add(new NhanVienHanhChinh(ma, ten, luong));
                //Nhân viên tiếp thị
                case 2 -> {
                    double doanhSo;
                    //Nhân viên tiếp thị có 2 thông tin đặc biệt là: Doanh số và Tỉ lệ hoa hồng
                    while (true) {
                        try {
                            System.out.print("Nhập doanh số: ");
                            doanhSo = Double.parseDouble(scanner.nextLine());
                            if (doanhSo > 0) {
                                break;
                            } else {
                                System.out.println("!! Vui lòng nhập một số lớn hơn 0 !!");
                            }
                        } catch (Exception ex) {
                            System.out.println("!! Đã có lỗi xảy ra trong quá trình nhập liệu !!");
                        }
                    }

                    double hoaHong;
                    while (true) {
                        try {
                            System.out.print("Nhập tỉ lệ hoa hồng: ");
                            hoaHong = Double.parseDouble(scanner.nextLine());
                            if (hoaHong > 0) {
                                break;
                            } else {
                                System.out.println("!! Vui lòng nhập một số lớn hơn 0 !!");
                            }
                        } catch (Exception ex) {
                            System.out.println("!! Đã có lỗi xảy ra trong quá trình nhập liệu !!");
                        }
                    }
                    //Truyền 3 thông tin cơ bản và 2 thông tin đặc biệt vào danh sách nhân viên
                    danhSach.add(new NhanVienTiepThi(ma, ten, luong, doanhSo, hoaHong));
                }
                //Trưởng phòng
                case 3 -> {
                    double trachNhiem;
                    //Trưởng phòng có 1 thông tin đặc biệt là: Lương trách nhiệm
                    while (true) {
                        try {
                            System.out.print("Nhập lương trách nhiệm: ");
                            trachNhiem = Double.parseDouble(scanner.nextLine());
                            if (trachNhiem > 0) {
                                break;
                            } else {
                                System.out.println("!! Vui lòng nhập một số lớn hơn 0 !!");
                            }
                        } catch (Exception ex) {
                            System.out.println("!! Đã có lỗi xảy ra trong quá trình nhập liệu !!");
                        }
                    }
                    //Truyền 3 thông tin cơ bản và 1 thông tin đặc biệt vào danh sách nhân viên
                    danhSach.add(new TruongPhong(ma, ten, luong, trachNhiem));
                }
                //Nhập không hợp lệ
                default ->
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    //Phương thức xuat()
    public void xuat() {
        //%-15s %-10s %-25s %25.2f %25.2f %25.2f %25.2f
        //Xuất thông tin của nhân viên với định dạng cột cố định
        System.out.printf("%-15s %-12s %-25s %25s %25s %25s %25s\n",
                "Loại nhân viên", "Mã NV", "Họ Tên", "Lương", "Thu Nhập", "Thuế", "Thu Nhập Sau Thuế");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        //Dùng for-each để lặp qua toàn bộ nhân viên có trong danh sách và in ra màn hình
        for (NhanVien nv : danhSach) {
            //Gọi phương thức xuất
            nv.xuatThongTin();
        }
    }

    //Phương thức tìm timNhanVienMa() (tìm nhân viên theo mã)
    public void timNhanVienMa() {
        //Mời người dùng nhập mã nhân viên cần tìm
        System.out.print("Nhập mã nhân viên cần tìm: ");
        String ma = scanner.nextLine();
        //Dùng for-each để lặp qua danh sách nhân viên
        for (NhanVien nv : danhSach) {
            //Nếu tìm thấy mã
            if (nv.getMaNV().equalsIgnoreCase(ma)) {
                //Xuất thông tin nhân viên vừa tìm
                nv.xuatThongTin();
                return;
            }
        }
        //Nếu for-each chạy hết danh sách và không tìm thấy mã nhân viên yêu cầu, in thông báo
        System.out.println("!! Không tìm thấy nhân viên !!");
    }

    //Phương thức xoaNhanVien() (xoá nhân viên theo mã)
    public void xoaNhanVien() {
        //Mời người dùng nhập mã nhân viên cần xoá
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String ma = scanner.nextLine();

        //Tạo boolean để kiểm tra có xoá thành công hay không
        boolean found = danhSach.removeIf(nv -> nv.getMaNV().equalsIgnoreCase(ma));

        //Nếu xoá thành công in thông báo
        if (found) {
            System.out.println("!! Nhân viên có mã " + ma + " đã được xoá !!");
        } else {
            //Xoá thất bại in thông báo
            System.out.println("!! Không tìm thấy nhân vien có mã " + ma + " !!");
        }
    }

    //Phương thức capNhatThongTinNhanVien()
    private void capNhatThongTinNhanVien() {
        //Mời người dùng nhập mã nhân viên
        System.out.print("Nhập mã nhân viên cần cập nhật: ");
        String maNV = scanner.nextLine();

        //Tạo boolean để kiểm tra xem có thực hiện tìm nhân viên thành công hay không
        boolean found = false;

        //Dùng for-each để lặp qua danh sách nhân viên
        for (NhanVien nv : danhSach) {
            //Nếu tìm được nhân viên yêu cầu cập nhật
            if (nv.getMaNV().equalsIgnoreCase(maNV)) {
                //boolean trả về thành công
                found = true;

                //In thông báo và thông tin của nhân viên vừa tìm được
                System.out.println("Đã tìm thấy nhân viên: ");
                System.out.printf("%-15s %-12s %-25s %25s %25s %25s %25s\n",
                        "Loại nhân viên", "Mã NV", "Họ Tên", "Lương", "Thu Nhập", "Thuế", "Thu Nhập Sau Thuế");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
                nv.xuatThongTin();

                //Hiển thị menu cập nhật theo từng loại nhân viên
                //Dùng toán tử instanceof để kiểm tra đối tượng có thuộc kiểu cụ thể (class) hoặc kiểu kế thừa (subclass) nào đó hay không (Trả về 2 giá trị true | false)
                if (nv instanceof NhanVienHanhChinh) {
                    //Nếu là nhân viên hành chính
                    System.out.println("Chọn thông tin cần cập nhật:");
                    System.out.println("1. Họ tên");
                    System.out.println("2. Lương");
                    System.out.print("Chọn (1|2): ");
                } else if (nv instanceof NhanVienTiepThi) {
                    //Nếu là nhân viên tiếp thị
                    System.out.println("1. Họ tên");
                    System.out.println("2. Lương");
                    System.out.println("3. Doanh số");
                    System.out.println("4. Hoa hồng");
                    System.out.print("Chọn (1|2|3|4): ");
                } else if (nv instanceof TruongPhong) {
                    //Nếu là trưởng phòng
                    System.out.println("1. Họ tên");
                    System.out.println("2. Lương");
                    System.out.println("3. Lương trách nhiệm");
                    System.out.print("Chọn (1|2|3): ");
                } else {
                    //Xảy ra lỗi
                    System.out.println("!! Đã có lỗi xảy ra !!");
                }

                try {
                    //Lưu lựa chọn người dùng vừa nhập
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        //Đổi họ tên
                        case 1 -> {
                            try {
                                System.out.print("Nhập họ tên mới: ");
                                nv.setHoTen(scanner.nextLine());
                            } catch (Exception ex) {
                                System.out.println("!! Đã có lỗi xảy ra trong quá trình nhập liệu !!");
                            }
                            System.out.println("!! Họ tên đã được cập nhật !!");
                        }
                        //Đổi lương
                        case 2 -> {
                            try {
                                System.out.print("Nhập lương mới: ");
                                nv.setLuong(Double.parseDouble(scanner.nextLine()));
                            } catch (Exception ex) {
                                System.out.println("!! Đã có lỗi xảy ra trong quá trình nhập liệu !!");
                            }
                            System.out.println("!! Lương đã được cập nhật !!");
                        }
                        //Đổi doanh số (nhân viên tiếp thị) hoặc lương trách nhiệm (trưởng phòng)
                        case 3 -> {
                            //Nếu là nhân viên tiếp thị
                            if (nv instanceof NhanVienTiepThi tiepThi) {
                                //Dùng try catch để bắt lỗi trong quá trình nhập liệu
                                try {
                                    System.out.print("Nhập doanh số mới: ");
                                    double doanhSo = Double.parseDouble(scanner.nextLine());
                                    tiepThi.setDoanhSo(doanhSo);
                                } catch (Exception ex) {
                                    System.out.println("!! Đã có lỗi xảy ra trong quá trình nhập liệu !!");
                                }
                                System.out.println("!! Doanh số đã được cập nhật !!");
                                //Nếu là trưởng phòng    
                            } else if (nv instanceof TruongPhong truongPhong) {
                                //Dùng try catch để bắt lỗi trong quá trình nhập liệu
                                try {
                                    System.out.print("Nhập lương trách nhiệm mới: ");
                                    double luongTrachNhiem = Double.parseDouble(scanner.nextLine());
                                    truongPhong.setLuongTrachNhiem(luongTrachNhiem);
                                } catch (Exception ex) {
                                    System.out.println("!! Đã có lỗi xảy ra trong quá trình nhập liệu !!");
                                }
                                System.out.println("!! Lương trách nhiệm đã được cập nhật!!");
                            } else {
                                System.out.println("!! Chức năng không khả dụng cho loại nhân viên này !!");
                            }
                        }
                        //Đổi hoa hồng
                        case 4 -> {
                            if (nv instanceof NhanVienTiepThi tiepThi) {
                                //Dùng try catch để bắt lỗi trong quá trình nhập liệu
                                try {
                                    System.out.print("Nhập hoa hồng mới (tỉ lệ phần trăm): ");
                                    double hoaHong = Double.parseDouble(scanner.nextLine());
                                    tiepThi.setHoaHong(hoaHong);
                                } catch (Exception ex) {
                                    System.out.println("!! Đã có lỗi xảy ra trong quá trình nhập liệu !!");
                                }
                                System.out.println("!! Hoa hồng đã được cập nhật !!");
                            } else {
                                System.out.println("!! Chức năng không khả dụng cho loại nhân viên này !!");
                            }
                        }
                        default ->
                            System.out.println("!! Lựa chọn không hợp lệ !!");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("!! Vui lòng nhập số hợp lệ !!");
                }
                return; //Thoát khỏi phương thức sau khi cập nhật
            }
        }

        //Nếu tìm thất bại in thông báo
        if (!found) {
            System.out.println("!! Không tìm thấy nhân viên với mã này !!");
        }
    }

    //Phương thức timNhanVienLuong() (tìm nhân viên theo khoảng lương)
    private void timNhanVienLuong() {
        try {
            //Mời người dùng nhập khoảng lương
            System.out.print("Nhập khoảng lương tối thiểu: ");
            double min = Double.parseDouble(scanner.nextLine());

            System.out.print("Nhập khoảng lương tối đa: ");
            double max = Double.parseDouble(scanner.nextLine());

            //In danh sách nhân viên trong khoảng lương
            System.out.println("Danh sách nhân viên có thu nhập trong khoảng [" + min + ", " + max + "]:");

            //Tạo boolean để kiểm tra xem có thực hiện tìm nhân viên thành công hay không
            boolean found = false;

            //Dùng for-each để lặp qua danh sách nhân viên
            for (NhanVien nv : danhSach) {
                //Tạo biến thuNhap và gán giá trị thu nhập của nhân viên
                double thuNhap = nv.getThuNhap();

                //Xét điều kiện (xem thu nhập có nằm trong khoảng yêu cầu hay không)
                if (thuNhap >= min && thuNhap <= max) {
                    System.out.printf("%-15s %-12s %-25s %25s %25s %25s %25s\n",
                            "Loại nhân viên", "Mã NV", "Họ Tên", "Lương", "Thu Nhập", "Thuế", "Thu Nhập Sau Thuế");
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
                    //Xuất thông tin nếu hợp lệ
                    nv.xuatThongTin();
                    //Trả boolean về true
                    found = true;
                }
            }

            //Nếu không tìm được in thông báo
            if (!found) {
                System.out.println("Không có nhân viên nào trong khoảng lương này.");
            }
        } catch (NumberFormatException e) {
            System.out.println("!! Lỗi: Vui lòng nhập số hợp lệ cho khoảng lương !!");
        }
    }

    //Phương thức sapXepHoTen()
    public void sapXepHoTen() {
        //Sử dụng phương thức sort của danhSach sắp xếp các phần tử bằng cách sử dụng bộ so sánh Comparator (Ở đây Comparator.comparing tạo một bộ so sánh dựa trên giá trị của thuộc tính hoTen)
        danhSach.sort(Comparator.comparing(nv -> nv.hoTen));
        System.out.println("!! Sắp xếp thành công !!");
        xuat();
    }

    //Phương thức sapXepLuong()
    public void sapXepLuong() {
        //Cho người dùng lựa chọn 2 chức năng
        System.out.println("!! VUI LÒNG CHỌN CHỨC NĂNG !!");
        System.out.println("1. Sắp xếp lương từ lớn đến bé");
        System.out.println("2. Sắp xếp lương từ bé đến lớn");
        System.out.print("Vui lòng nhập [1|2]: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            //Chỉ cho người dùng nhập 2 giá trị là 1 hoặc 2
            if (choice == 1 || choice == 2) {
                //Nếu nhập 1
                if (choice == 1) {
                    //Sắp xếp lương từ lớn đến bé
                    danhSach.sort(Comparator.comparingDouble(NhanVien::getThuNhap).reversed());
                    System.out.println("!! Sắp xếp thành công !!");
                    xuat();
                    //Nếu nhập 2
                } else if (choice == 2) {
                    //Sắp xếp lương từ bé đến lớn
                    danhSach.sort(Comparator.comparingDouble(NhanVien::getThuNhap));
                    System.out.println("!! Sắp xếp thành công !!");
                    xuat();
                }
            } else {
                //Nếu nhập sai in thông báo
                System.out.println("!! Vui lòng nhập số hợp lệ !!");
            }
            //Bắt lỗi nếu có
        } catch (Exception ex) {
            System.out.println("!! Đã có lỗi xảy ra trong quá trình nhập liệu !!");
        }
    }

    //Phương thức timThuNhap()
    public void timThuNhap() {
        //Cho người dùng lựa chọn 2 chức năng
        System.out.println("!! VUI LÒNG CHỌN CHỨC NĂNG !!");
        System.out.println("1. Xuất những nhân viên có lương nhiều nhất");
        System.out.println("2. Xuất những nhân viên có lương ít nhất");
        System.out.print("Vui lòng nhập [1|2]: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            //Chỉ cho người dùng nhập 2 giá trị là 1 hoặc 2
            if (choice == 1 || choice == 2) {
                //Cho người dùng nhập vào số lượng nhân viên muốn xuất (theo yêu cầu là 5)
                System.out.print("Nhập số lương nhân viên mà bạn muốn xuất: ");
                int n = scanner.nextInt();
                //Nếu nhập 1
                if (choice == 1) {
                    //Sắp xếp nhân viên theo thứ tự lớn đến bé
                    danhSach.sort(Comparator.comparingDouble(NhanVien::getThuNhap).reversed());
                    //i < Math.min(n, danhSach.size()) để đảm bảo rằng chỉ có n nhân viên được xuất ra màn hình (n là số lương nhân viên muốn xuất người dùng đã nhập)
                    for (int i = 0; i < Math.min(n, danhSach.size()); i++) {
                        danhSach.get(i).xuatThongTin();
                    }
                    //Nếu nhập 2
                } else if (choice == 2) {
                    //Sắp xếp nhân viên theo thứ tự bé đến lớn
                    danhSach.sort(Comparator.comparingDouble(NhanVien::getThuNhap));
                    //i < Math.min(n, danhSach.size()) để đảm bảo rằng chỉ có n nhân viên được xuất ra màn hình (n là số lương nhân viên muốn xuất người dùng đã nhập)
                    for (int i = 0; i < Math.min(n, danhSach.size()); i++) {
                        danhSach.get(i).xuatThongTin();
                    }
                }
            } else {
                System.out.println("!! Vui lòng nhập số hợp lệ !!");
            }
        } catch (Exception ex) {
            System.out.println("!! Đã có lỗi xảy ra trong quá trình nhập liệu !!");
        }
    }

    //Phương thức showMenu()
    private void showMenu() {
        System.out.println("\t\t=========================NguyenMinh.exe=========================");
        System.out.println("\t\t||                                                            ||");
        System.out.println("\t\t||          !! NHẬP TRƯƠNG TRÌNH BẠN MUỐN SỬ DỤNG !!          ||");
        System.out.println("\t\t||                                                            ||");
        System.out.println("\t\t||    [1] Nhập danh sách nhân viên.                           ||");
        System.out.println("\t\t||    [2] Xuất danh sách nhân viên.                           ||");
        System.out.println("\t\t||    [3] Tìm và hiển thị nhân viên theo mã.                  ||");
        System.out.println("\t\t||    [4] Xoá nhân viên theo mã.                              ||");
        System.out.println("\t\t||    [5] Cập nhật thông tin nhân viên theo mã.               ||");
        System.out.println("\t\t||    [6] Tìm các nhân viên theo khoảng lương.                ||");
        System.out.println("\t\t||    [7] Sắp xếp nhân viên theo họ và tên.                   ||");
        System.out.println("\t\t||    [8] Sắp xếp nhân viên theo thu nhập.                    ||");
        System.out.println("\t\t||    [9] Xuất nhân viên có thu nhập cao nhất hoặc ít nhất.   ||");
        System.out.println("\t\t||                                                            ||");
        System.out.println("\t\t||    [0] Thoát chương trình.                                 ||");
        System.out.println("\t\t||                                                            ||");
        System.out.println("\t\t================================================================");
    }

    //Xử lý lựa chọn từ người dùng
    public void handleMenu() {
        int choice;
        do {
            //Hiển thị menu cho người dùng
            showMenu();
            System.out.print("\t\tVui lòng nhập trong khoảng [0 - 9]: ");
            try {
                //Lưu lựa chọn và kiểm tra
                choice = Integer.parseInt(scanner.nextLine());
                choice(choice);
            } catch (NumberFormatException ex) {
                //In nếu người dùng nhập sai cú pháp
                System.out.println("\t\t!! Nhập sai, vui lòng nhập số từ 0 đến 9 !!");
            }
        } while (true);
    }

    //Thực thi chức năng dựa trên lựa chọn
    private void choice(int choice) {
        switch (choice) {
            case 0 -> {
                System.out.println("\t\tTạm biệt. Hẹn gặp lại!");
                scanner.close();
                System.exit(0);
            }
            case 1 ->
                nhap();
            case 2 ->
                xuat();
            case 3 ->
                timNhanVienMa();
            case 4 ->
                xoaNhanVien();
            case 5 ->
                capNhatThongTinNhanVien();
            case 6 ->
                timNhanVienLuong();
            case 7 ->
                sapXepHoTen();
            case 8 ->
                sapXepLuong();
            case 9 ->
                timThuNhap();
            default ->
                System.out.println("\t\t!! Nhập sai, vui lòng nhập lại trong khoảng từ 0 đến 9 !!");
        }
    }
}
