package Proyecto.Code.src.Controler;

import Proyecto.Code.src.Model.TripData;
import Proyecto.Code.src.Model.User;

import java.io.*;
import java.util.*;

public class TripController {
    private String pickup;
    private String arrive;
    private ArrayList<Integer> streets;
    private ArrayList<Integer>carreer;
    private ArrayList<Integer> housesNumbers;
    private User user;
    public TripController(User user) throws IOException {
        this.user = user;
        this.getDirections();
        this.convertDirections();
    }
    public void getDirections() throws IOException {
        TripData tripData = new TripData();
        pickup=tripData.getLastPickupAddress(user.getMail());
        arrive=tripData.getLastArrvieAddress(user.getMail());
    }
    public void convertDirections(){
        String[]directions=new String[]{pickup,arrive};
        for(int i=0;i<2;i++){
            String[] parts = directions[i].split("#",2);
            if(directions[i].contains("Cra")){
                // Extraer la parte que contiene el streetNumber y houseNumber (Y-Z)
                String cr=parts[0].split(" ",2)[1];
                String st = parts[1].split("-",2)[0];
                int careerNumber=Integer.parseInt(cr);
                int streetNumber = Integer.parseInt(st);
                streets.add(streetNumber);
                carreer.add(streetNumber);
            }
            else if(directions[i].contains("Cl")){
                // Extraer la parte que contiene el streetNumber y houseNumber (Y-Z)
                String cr=parts[1].split("-",2)[0];
                String st = parts[0].split(" ",2)[1];
                int careerNumber=Integer.parseInt(cr);
                int streetNumber = Integer.parseInt(st);
                streets.add(streetNumber);
                carreer.add(streetNumber);
            }
            String hn = parts[1].split("-",2)[1];
            int houseNumber = Integer.parseInt(hn);
            housesNumbers.add(houseNumber);
        }
    }
    public int getDistance() {
        Trip trip = new Trip(streets, carreer, housesNumbers);
        return trip.distance;
    }
    public int getPrice() {
        Trip trip = new Trip(streets, carreer, housesNumbers);
        return trip.price;
    }
}
