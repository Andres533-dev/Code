/* 
This file is the creation of the mother class car

Author: Andres Murillo <afmurillot@udistrital.edu.co> - Abr/2025
*/
package Proyecto.Code.src.Controler;


public class Car {
    private int capacity;
    private String color;
    private CarType type;  // Reemplaza a model
    private String licensePlate;

    // Factory Method para crear carros según tipo
    public static Car createCar(String carType, String color, String licensePlate) {
        Car car = new Car();
        car.setColor(color, "admin");
        car.setLicensePlate(licensePlate, "admin");
        car.type = CarTypeFactory.createCarType(carType);
        car.capacity = car.type.getCapacity();  // Capacidad se determina por el tipo
        return car;
    }

    // Constructor ahora privado para forzar uso del factory
    private Car() {}

    // Métodos existentes (adaptados)
    public String getColor() {
        return color;
    }

    public String getTypeDescription() {
        return type.toString();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getCapacity(boolean carElection) {
        return capacity ;
    }

    
    public void setColor(String newColor, String charge) {
        if(charge.equals("Owner") || charge.equals("admin"))
            this.color = newColor;
    }

    public void setLicensePlate(String newLicensePlate, String charge) {
        if(charge.equals("Owner") || charge.equals("admin"))
            this.licensePlate = newLicensePlate;
    }

    // Nuevo getter para el tipo
    public CarType getCarType() {
        return type;
    }
}