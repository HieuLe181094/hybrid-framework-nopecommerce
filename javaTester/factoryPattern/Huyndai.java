package factoryPattern;

public class Huyndai extends Car{
    @Override
    public void viewCar(String carName) {
        System.out.println("View" + carName);
    }

    @Override
    public void driverCar() {
        System.out.println("Driver Huyndai car");

    }
}
