package Proyecto.Code.src.Controler;


public class CarXL extends CarType {
    public CarXL() {
        this.priceMultiplier = 1.5; // 50% más caro
        this.speedFactor = 0;
        this.capacity=6;// Misma velocidad
    }

    @Override
    public void applyTripSettings(Trip trip) {
        trip.getPrice(priceMultiplier, speedFactor);
    }

    @Override
    public String toString() {
        return "if you want to go with to many people, this is a good option";
    }
}
