package phuongHoaXuan;

public class XuanLan {
    // Private (Chỉ có nhà bà Xuân Lan mới được uống)
    private String latte = "Latte";

    // Default: Trong class dùng được
    // Ngoài class nhưng chỉ trong cùng package
    // Con nhưng khác package ko dùng được
    String espresso = "Espresso";
    protected String cappuccino = "Cappuccino";
    public String macchiato = "Macchiato";

    // Private (chỉ có nhà bà Xuân Lan mới được uống)
    private String getLatte(){
        return latte;
    }

    String getEspresso(){
        return espresso;
    }

    protected String getCappuccino(){
        return cappuccino;
    }

    public String getMacchiato(){
        return macchiato;
    }

    public static void main(String[] args){
        XuanLan xuanLan = new XuanLan();
        System.out.println("Drink: " + xuanLan.latte);
        System.out.println("Drink: " + xuanLan.getLatte());

        System.out.println("Drink: " + xuanLan.espresso);
        System.out.println("Drink: " + xuanLan.getEspresso());

        System.out.println("Drink: " + xuanLan.cappuccino);
        System.out.println("Drink: " +xuanLan.getCappuccino());
    }

}
