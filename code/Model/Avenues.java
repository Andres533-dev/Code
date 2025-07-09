package Proyecto.Code.src.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Avenues {
    public String[] avenueData;

    public Avenues() {
        loadAvenueData();
    }

    private void loadAvenueData() {
        List<String> tempList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Avenues.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tempList.add(line.trim()); // Guarda la línea exactamente como está
            }
        } catch (IOException e) {
            System.err.println("Error leyendo archivo: " + e.getMessage());
            tempList.add("Avenida Default");
        }

        this.avenueData = tempList.toArray(new String[0]);
    }
}
