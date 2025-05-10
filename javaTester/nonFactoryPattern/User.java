package nonFactoryPattern;

public class User {
    public static void main(String[] args) {
        // Đi đến hãng Honda
        Honda hond = new Honda();

        // Xem xe Honda
        hond.viewingCar("Civic 2024");
        hond.drivingCar();

        hond.viewingCar("CRV 2024");
        hond.drivingCar();

        hond.viewingCar("Brio 2024");
        hond.drivingCar();

        // Đi đến hãng Huyndai
        Huyndai huyn = new Huyndai();

        // Xem xe Huyndai
        huyn.viewingCar("Tucson 2023");
        huyn.driverCar();

        huyn.viewingCar("Santafa 2024");
        huyn.driverCar();
    }
}
