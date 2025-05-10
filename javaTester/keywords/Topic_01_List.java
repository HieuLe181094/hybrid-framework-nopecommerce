package keywords;

public class Topic_01_List {
    public static void main(String[] args){

        // Biểu thức điều kiện
        // if if-else if-else-if
        // switch-case

        if (3<5){
            System.out.println("Action...");
        }

        if (3>5){
            System.out.println("If...");
        } else {
            System.out.println("Else...");
        }

        String browserName = "Chrome";
        if (browserName.equals("Chrome")){
            //..
        } else if (browserName.equals("Firefox")){
            //..
        } else {
            //..
        }

        // Ko trùng lặp
        switch (browserName) {
            case "Chrome":
                System.out.println("Chrome browser");
                break;
            case "Firefox":
                System.out.println("Firefox browser");
                break;
            case "Edge":
                System.out.println("Edge browser");
                break;
            default:
                System.out.println("Safari browser");
                break;

        }



        // Biểu thức vòng lặp
        // for
        for (int i = 0; i < 5; i++){
            if (i==3){
                continue;
            }
        }

        // while
        int x = 0;
        while (x<5){
            System.out.println(x);
            x++;
        }

        // do-while
        do {
            System.out.println(x);
            x++;
        }while (x<5);

        // Nguyên Thủy - Primitive Type

        char c ='c';
        byte bNumber = 1;
        short sNumber = 10;
        int iNumber = 10;
        long lNumber = 100;
        float fNumber = 18.5f;
        double dNumber = 18.5d;

    }
}
