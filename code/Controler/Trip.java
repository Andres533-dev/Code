package Proyecto.Code.src.Controler;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Trip {
    protected int distance;
    protected double price;

    public Trip(ArrayList<Integer>street,ArrayList<Integer>career,ArrayList<Integer>houseNumber) {
        this.getDistance(street,career,houseNumber);

    }
    public int getDistance(ArrayList<Integer>street,ArrayList<Integer>career,ArrayList<Integer>houseNumber) {
        int streetDistance=(street.get(1) - street.get(0))*50;
        int careerDistance=(career.get(1) - career.get(0))*25;
        int houseDistance=(houseNumber.get(1) - houseNumber.get(0))*5;
        distance=streetDistance+careerDistance+houseDistance;
        return distance;
    }
    public double getBasePrice(){
        price=(distance/1000)*10;
        return price;
    }
    public int getPrice(double multiplier, int speedFactor){
        price = this.getBasePrice() * multiplier;
        double timeToUser = (distanceToUser / 1000.0) / (50 + speedFactor) * 60;
    }
}
