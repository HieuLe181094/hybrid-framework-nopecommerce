package phuongHoaXuan;

public class CongMinh {
    public static void main(String[] args){
        XuanLan xuanLan = new XuanLan();
        // System.out.println(xuanLan.latte);
        // System.out.println(xuanLan.getLatte());
        // Dù cố tình gọi (có biết tên hàm) thì nó sẽ báo lỗi

        System.out.println("Drink: " + xuanLan.espresso);
        System.out.println("Drink: " + xuanLan.getEspresso());

        System.out.println("Drink: " + xuanLan.cappuccino);
        System.out.println("Drink: " +xuanLan.getMacchiato());

        System.out.println("Drink: " + xuanLan.macchiato);
        System.out.println("Drink: " +xuanLan.getMacchiato());
    }

    public void test(){
//        System.out.println("Drink: " + cappucino);
//        System.out.println("Drink: " + getCappucciano);

//        System.out.println("Drink: " + macchiato);
//        System.out.println("Drink: " + getMacchiato());
    }
}
