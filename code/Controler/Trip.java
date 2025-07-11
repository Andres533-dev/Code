package Proyecto.Code.src.Controler;

import java.util.ArrayList;
public class Trip {
    protected double travelDistance;
    protected double userDistance;

    public Trip(ArrayList<Integer>street,ArrayList<Integer>career,ArrayList<Integer>houseNumber,Car car) {
        this.getDistance(street,career,houseNumber);
        this.userCarDistance(street,career,houseNumber,car);
    }
    public void getDistance(ArrayList<Integer>street,ArrayList<Integer>career,ArrayList<Integer>houseNumber) {
        int streetDistance=(street.get(1) - street.get(0))*50;
        int careerDistance=(career.get(1) - career.get(0))*25;
        int houseDistance=(houseNumber.get(1) - houseNumber.get(0))*5;
        travelDistance=streetDistance+careerDistance+houseDistance;
    }
    public void userCarDistance(ArrayList<Integer>street,ArrayList<Integer>career,ArrayList<Integer>houseNumber,Car car) {
       int streetDistance=(street.getFirst() - car.ubication.getFirst())*50;
       int careerDistance=(career.getFirst() - car.ubication.get(1))*25;
       int houseDistance=(houseNumber.getFirst() -car.ubication.get(2))*5;
       userDistance=streetDistance+careerDistance+houseDistance;
    }
    public double timeToArrive(Car car){
        return ((travelDistance / 1000) /(50+car.getCarType().speedFactor))*60;
    }
    public double timeToUser(Car car){
        return (double) ((userDistance / 1000) /(50+car.getCarType().speedFactor))*60;

    }
    public double getBasePrice(double price){
        price=((double) travelDistance /1000)*100;
        return price;
    }
    public double getPrice(Car car,double price){
        price = this.getBasePrice(price) * car.getCarType().priceMultiplier;
        return price;
    }
}
