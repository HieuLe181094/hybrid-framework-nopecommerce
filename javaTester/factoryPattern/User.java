package factoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class User {

    public static void main(String[] args) {
        Car carFactory;

        carFactory = getCar("Honda");
        carFactory.viewCar("Civic 2024");
        carFactory.driverCar();

        carFactory = getCar("Huyndai");
        carFactory.viewCar("Satafe 2024");
        carFactory.driverCar();

        carFactory = getCar("Toyota");
        carFactory.viewCar("CRV");
        carFactory.driverCar();

    }

    // Apply Factory Pattern
    // Quản lý việc khởi tạo các loại Car
    public static Car getCar(String carType) {
        Car car = null;

        switch (carType){
            case "Honda":
                car = new Honda();
                break;
            case "Huyndai":
                car = new Huyndai();
                break;
            case "Toyota":
                car = new Toyota();
                break;
            default:
                new IllegalArgumentException("Car Type is not valid.");
                break;
        }

        return car;
    }
}
