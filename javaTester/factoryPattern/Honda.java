package factoryPattern;

public class Honda extends Car{
    @Override
    public void viewCar(String carName) {
        // quyết định cách view như thế nào
        System.out.println("View" + carName);

    }

    @Override
    public void driverCar() {
        System.out.println("Driver Honda Car");

    }
}