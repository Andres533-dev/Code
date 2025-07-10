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
                String[] parts = line.split(":", 2);
                String avenue = parts[0].trim();
                tempList.add(avenue);
            }
        } catch (IOException e) {
            System.err.println("Error adding the Avenues: " + e.getMessage());
        }

        this.avenueData = tempList.toArray(new String[0]);
    }
    private int loadAvenueNumber(String inputAvenue) {
        List<String> tempList = new ArrayList<>();
        int avenueNumber =0;
        try (BufferedReader reader = new BufferedReader(new FileReader("Avenues.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.contains(inputAvenue)) {
                    String[] parts = line.split(":", 2);
                    avenueNumber = Integer.parseInt(parts[1].trim());
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error founding the Avenue´s number: " + e.getMessage());
        }
        return avenueNumber;
    }
}
