package Proyecto.Code.src.Controler;

public class CarTypeFactory {
    public static CarType createCarType(String type) {
        if (type.equals("Xl")) {
            return new CarXL();
        } else if (type.equals("Normal")) {
            return new NormalCar();
        } else {
            return new FastCar();
        }
    }
}
