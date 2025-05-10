package oop;

public class HomePageObject {
    // Người viết code không tự định nghĩa ra 1 Constructor rõ ràng
    // Bất kỳ 1 class nào cũng có 1 Constructor ngầm định

    // Tự định nghĩa 1 Constructor thì khi khởi tạo class lên nó sẽ gọi qua constructor đó
    // Hàm khởi tạo:
    // Ưu tiên chạy đầu tiên khi class được gọi tới (new lên)
    // 1 - Cùng tên vs class
    // 2 - Có thể có 1 hoặc nhiều Constructor (tính đa hình)
    // 3 - Phải khác số lượng tham số/ khác kiểu dữ liệu

    public HomePageObject(){
        System.out.println("Khởi tạo HomePage object");
    }

    public HomePageObject (int number){
        System.out.println("Khởi tạo HomePage object");
    }

    public static void main(String[] args){
        HomePageObject homePage = new HomePageObject();
    }
}
