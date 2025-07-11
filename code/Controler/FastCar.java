package Proyecto.Code.src.Controler;

public class FastCar extends CarType {
    public FastCar() {
        this.priceMultiplier = 1.2; // 20% más caro
        this.speedFactor = 20;
        this.capacity=4;// 20 km/h más rápido
    }

    @Override
    public void applyTripSettings(Trip trip) {
    }

    @Override
    public String toString() {
        return "A good option if you go late ";
    }
}