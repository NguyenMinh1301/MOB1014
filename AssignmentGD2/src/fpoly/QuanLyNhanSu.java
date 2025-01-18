package fpoly;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class QuanLyNhanSu {

    private final ArrayList<NhanVien> danhSach = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void nhap() {
        System.out.print("Nhập số lượng nhân viên: ");
        int soLuong = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < soLuong; i++) {
            System.out.println("1. Nhân viên hành chính");
            System.out.println("2. Nhân viên tiếp thị");
            System.out.println("3. Trưởng phòng");
            System.out.print("Chọn loại nhân viên: ");
            int loai = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập mã nhân viên: ");
            String ma = scanner.nextLine();
            System.out.print("Nhập họ tên: ");
            String ten = scanner.nextLine();
            System.out.print("Nhập lương cơ bản: ");
            double luong = Double.parseDouble(scanner.nextLine());

            switch (loai) {
                case 1 ->
                    danhSach.add(new NhanVienHanhChinh(ma, ten, luong));
                case 2 -> {
                    System.out.print("Nhập doanh số: ");
                    double doanhSo = Double.parseDouble(scanner.nextLine());
                    System.out.print("Nhập tỉ lệ hoa hồng: ");
                    double hoaHong = Double.parseDouble(scanner.nextLine());
                    danhSach.add(new NhanVienTiepThi(ma, ten, luong, doanhSo, hoaHong));
                }
                case 3 -> {
                    System.out.print("Nhập lương trách nhiệm: ");
                    double trachNhiem = Double.parseDouble(scanner.nextLine());
                    danhSach.add(new TruongPhong(ma, ten, luong, trachNhiem));
                }
                default ->
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void xuat() {
        for (NhanVien nv : danhSach) {
            nv.xuatThongTin();
        }
    }

    public void timNhanVienMa() {
        System.out.print("Nhập mã nhân viên cần tìm: ");
        String ma = scanner.nextLine();
        for (NhanVien nv : danhSach) {
            if (nv.getMaNV().equalsIgnoreCase(ma)) {
                nv.xuatThongTin();
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên.");
    }

    public void xoaNhanVien() {
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String ma = scanner.nextLine();
        danhSach.removeIf(nv -> nv.getMaNV().equalsIgnoreCase(ma));
    }

    private void capNhatThongTinNhanVien() {
        System.out.print("Nhập mã nhân viên cần cập nhật: ");
        String maNV = scanner.nextLine();
        boolean found = false;

        for (NhanVien nv : danhSach) {
            if (nv.getMaNV().equalsIgnoreCase(maNV)) {
                found = true;

                System.out.println("\t\tĐã tìm thấy nhân viên: ");
                nv.xuatThongTin();

                // Hiển thị menu cập nhật
                System.out.println("\t\tChọn thông tin cần cập nhật:");
                System.out.println("\t\t1. Họ tên");
                System.out.println("\t\t2. Lương");
                if (nv instanceof NhanVienTiepThi) {
                    System.out.println("\t\t3. Doanh số");
                    System.out.println("\t\t4. Hoa hồng");
                } else if (nv instanceof TruongPhong) {
                    System.out.println("\t\t3. Lương trách nhiệm");
                }
                System.out.print("\t\tChọn (1/2/3/...): ");

                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> {
                        System.out.print("Nhập họ tên mới: ");
                        nv.setHoTen(scanner.nextLine());
                        System.out.println("\t\tHọ tên đã được cập nhật!");
                    }
                    case 2 -> {
                        System.out.print("Nhập lương mới: ");
                        nv.setLuong(Double.parseDouble(scanner.nextLine()));
                        System.out.println("\t\tLương đã được cập nhật!");
                    }
                    case 3 -> {
                        if (nv instanceof NhanVienTiepThi tiepThi) {
                            System.out.print("Nhập doanh số mới: ");
                            double doanhSo = Double.parseDouble(scanner.nextLine());
                            tiepThi.setDoanhSo(doanhSo);
                            System.out.println("\t\tDoanh số đã được cập nhật!");
                        } else if (nv instanceof TruongPhong truongPhong) {
                            System.out.print("Nhập lương trách nhiệm mới: ");
                            double luongTrachNhiem = Double.parseDouble(scanner.nextLine());
                            truongPhong.setLuongTrachNhiem(luongTrachNhiem);
                            System.out.println("\t\tLương trách nhiệm đã được cập nhật!");
                        } else {
                            System.out.println("\t\tChức năng không khả dụng cho loại nhân viên này.");
                        }
                    }
                    case 4 -> {
                        if (nv instanceof NhanVienTiepThi tiepThi) {
                            System.out.print("Nhập hoa hồng mới (tỉ lệ phần trăm): ");
                            double hoaHong = Double.parseDouble(scanner.nextLine());
                            tiepThi.setHoaHong(hoaHong);
                            System.out.println("\t\tHoa hồng đã được cập nhật!");
                        } else {
                            System.out.println("\t\tLựa chọn không hợp lệ!");
                        }
                    }
                    default ->
                        System.out.println("\t\tLựa chọn không hợp lệ!");
                }
                return; // Thoát khỏi phương thức sau khi cập nhật
            }
        }

        if (!found) {
            System.out.println("\t\tKhông tìm thấy nhân viên với mã này!");
        }
    }

    private void timNhanVienLuong() {
        try {
            System.out.print("Nhập khoảng lương tối thiểu: ");
            double min = Double.parseDouble(scanner.nextLine());

            System.out.print("Nhập khoảng lương tối đa: ");
            double max = Double.parseDouble(scanner.nextLine());

            System.out.println("\t\tDanh sách nhân viên có thu nhập trong khoảng [" + min + ", " + max + "]:");
            boolean found = false;

            for (NhanVien nv : danhSach) {
                double thuNhap = nv.getThuNhap();
                if (thuNhap >= min && thuNhap <= max) {
                    nv.xuatThongTin();
                    found = true;
                }
            }

            if (!found) {
                System.out.println("\t\tKhông có nhân viên nào trong khoảng lương này.");
            }
        } catch (NumberFormatException e) {
            System.out.println("\t\t!! Lỗi: Vui lòng nhập số hợp lệ cho khoảng lương !!");
        }
    }

    public void sapXepHoTen() {
        danhSach.sort(Comparator.comparing(nv -> nv.hoTen));
    }

    public void sapXepLuong() {
        danhSach.sort(Comparator.comparingDouble(NhanVien::getThuNhap).reversed());
    }

    public void thuNhapCaoNhat() {
        sapXepLuong();
        for (int i = 0; i < Math.min(5, danhSach.size()); i++) {
            danhSach.get(i).xuatThongTin();
        }
    }

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
        System.out.println("\t\t||    [9] Xuất 5 nhân viên có thu nhập cao nhất.              ||");
        System.out.println("\t\t||                                                            ||");
        System.out.println("\t\t||    [0] Thoát chương trình.                                 ||");
        System.out.println("\t\t||                                                            ||");
        System.out.println("\t\t================================================================");
    }

    // Xử lý lựa chọn từ người dùng
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

    // Thực thi chức năng dựa trên lựa chọn
    private void choice(int choice) {
        switch (choice) {
            case 0 -> {
                System.out.println("\t\tTạm biệt. Hẹn gặp lại!");
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
                thuNhapCaoNhat();
            default ->
                System.out.println("\t\t!! Nhập sai, vui lòng nhập lại trong khoảng từ 0 đến 9 !!");
        }
    }

}
