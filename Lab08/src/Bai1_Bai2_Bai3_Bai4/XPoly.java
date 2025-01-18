package Bai1_Bai2_Bai3_Bai4;

public class XPoly {
    //Tính tổng các số chuyền vào
    public static double sum(double... nums) {
        double tong = 0;
        //Dùng for-each để lặp và cộng dồn
        for(double item : nums) {
            tong += item;
        }
        //Trả lại kết quả tong
        return tong;
    }
    
    //Tìm số nhỏ nhất trong danh sách các số
    public static double min(double... nums) {
        //Kiểm tra độ dài của danh sách
        if(nums.length == 0) {
            //Nếu danh sách trống thả lỗi
            throw new IllegalArgumentException("!!Không được để trống đầu vào!!");
        }
        double min = nums[0];
        //Dùng for-each để lặp và ghi đè bằng số nhỏ nhất
        for(double item : nums) {
            min = Math.min(min, item);
        }
        //Trả lại kết quả min
        return min;
    }
    
    //Tìm số lớn nhất trong danh sách các số
    public static double max(double... nums) {
        //Kiểm tra độ dài của danh sách
        if(nums.length == 0) {
            //Nếu danh sách trống thả lỗi
            throw new IllegalArgumentException("!!Không được để trống đầu vào!!");
        }
        double max = nums[0];
        //Dùng for-each để lặp và ghi đè bằng số lớn nhất
        for(double item : nums) {
            max = Math.max(max, item);
        }
        //Trả lại kết quả max
        return max;
    }
    
    //Chuyển kí tự đầu tiên của chuỗi thành ký tự viết hoa
    public static String toUpperFirstChar(String name) {  
        //Kiểm tra chuỗi
        if(name == null || name.isEmpty()) {
            return name; // Trả về chuỗi ban đầu nếu chuỗi null hoặc rỗng.
        }
        //Chia chuỗi đầu vào name thành các mảng dựa theo khoảng trắng VD: nguyễN  qUang miNh -> nguyễN| | |qUang| |miNh
        String[] ars = name.split(" ");                                           //Kí tự khoảng trắng  ^ ^       ^            
        //Tạo StringBuilder sb để lưu chuỗi kết quả
        StringBuilder sb = new StringBuilder();
        
        //Lặp qua từng phần tử của mảng 
        for(int i = 0; i < ars.length; i++) {
            //Lấy từng phần tử trong mảng ars và gán vào biến item để xử lý
            String item = ars[i];
            
            //Bỏ qua các kí tự khoảng trắng (ví nếu các chuỗi rỗng có thể xuất hiện nếu đầu vào có nhiều khoảng trắng liên tiếp) VD: nguyễN| | |qUang| |miNh
            if(!item.equals("")) {                                                                                                 //  ^    ^ ^   ^   ^   ^
                //Lấy kí tự đầu tiên từ item.substring(0, 1) sau đó chuyển thành chữ viết hoa bằng toUpperCase()
                //VD: item = "nguyễN" -> ch = "N" kết quả sẽ là N|guyễN
                String ch = item.substring(0, 1).toUpperCase();
                
                //Ghép ch + item lại và các từ trong item chuyển thành chữ thường bằng toLowerCase() VD: item = guyễn
                item = ch + item.substring(1).toLowerCase();
                //Kết quả có được sau khi sử lý phần từ đầu tiên -> Nguyễn
                sb.append(item).append(" ");
                //Thêm từ vừa được chỉnh sửa vào StringBuilder(sb) sau đó thêm một khoảng trắng " " để phân tách các từ
            }
        }
        //Sau khi chạy hết vòng lặp kết quả ta có được là -> "Nguyễn Quang Minh " 
        
        //Trả lại kết quả và xoá 2 khoảng trắng ở đầu và cuối bằng trim() (nếu có) -> "Nguyễn Quang Minh" 
        return sb.toString().trim();
    }
    
    public static void main(String[] args) {
        //Test các phương thức tính toán
        double ketqua;
        ketqua = sum(8, 2.6, 7, 1.1);
        System.out.printf("Kết quả (sum): %.2f\n", ketqua);
        
        ketqua = min(8, 2.6, 7, 1.1);
        System.out.println("Kết quả (min): " + ketqua);
        
        ketqua = max(8, 2.6, 7, 1.1);
        System.out.println("Kết quả (max): " + ketqua);
        
        String ten = toUpperFirstChar("nguyễN  qUang miNh");
        System.out.println("Kết quả (toUpperFirstChar): " + ten);
    }    
}
