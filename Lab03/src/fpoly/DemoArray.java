package fpoly;

public class DemoArray {

public static void main(String[] args) {
        //Khai báo mảng 2 chiều có kích thước là ((3x3) 3 hàng và 3 cột)
        int[][] exarray2D = {
                       //  Hàng                    
            {2, 1, 9}, //- 1
            {4, 3, 7}, //- 2
            {5, 8, 6}  //- 3
    //       |  |  |
    //  Cột  1  2  3
                
        };
        
        int rows = exarray2D.length; //Số hàng của mảng 2 chiều (Hiện tại là 3 hàng)
        int cols = exarray2D[0].length; //Số cột của mảng 2 chiều (Hiện tại là 3 cột)
        int totalElements = rows * cols; //Tổng số phần tử (hàng x cột <=> 3 x 3 => 9)

        int[] exarray1D = new int[totalElements]; //Khai báo mảng 1 chiều có độ dài bằng tổng số phần tử của mảng (Hiện tại là 9)

        //Chỉ sử dụng 1 vòng lặp duy nhất để vừa ghi vào mảng 1 chiều và in phần tử
        for (int i = 0; i < totalElements; i++) {
            
            //Xác định hàng(row) của phần tử | row = i / cols
            //Xác định hàng(col) của phần tử | col = i % cols
            //Gán giá trị của mảng 2 chiều khi xác định được vị trí của phần tử vào mảng một chiều với vị trí là i 
            exarray1D[i] = exarray2D[i / cols][i % cols];
            
            //In phần tử ngay khi gán
            System.out.print(exarray1D[i] + " "); //In phần tử với khoảng trắng VD:{2 1 9 4 3 7 5 8 6 }
        }
    }
}
