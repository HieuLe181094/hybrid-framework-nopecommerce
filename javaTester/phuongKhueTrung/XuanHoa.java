package phuongKhueTrung;

import phuongHoaXuan.XuanLan;

public class XuanHoa extends XuanLan {
    public static void main(String[] agrs){
        XuanLan xuanLan = new XuanLan();
//        System.out.println(xuanLan.latte);
//        System.out.println(xuanLan.getLatte);

//        System.out.println("Drink: " + xuanLan.espresso);
//        System.out.println("Drink: " + xuanLan.getEspresso());

        // Kế thừa (protected) ko cho phép gọi qua đối tượng (Object)
//        System.out.println("Drink: " + xuanLan.cappuccino);
//        System.out.println("Drink: " + xuanLan.getCappuccino());
    }

    public void test(){
        System.out.println("Drink: " + cappuccino);
        System.out.println("Drink: " + getCappuccino());
    }

}
