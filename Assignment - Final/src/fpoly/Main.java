package fpoly;

import fpoly.view.QuanLyNhanSuView;

//Class Main gọi phương thức quanLyMenu trong view.QuanLyNhanSuView
public class Main {
    public static void main(String[] args) {
        QuanLyNhanSuView view = new QuanLyNhanSuView();
        view.quanLyMenu();
    }
}
