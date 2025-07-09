package Proyecto.Code.src.View;

import Proyecto.Code.src.Controler.DirectionController;
import Proyecto.Code.src.Controler.DirectionTypeController;
import javax.swing.*;
import java.util.ArrayList;

public class Pickup extends Create {
    private DirectionsGUI directionsGUI;

    public Pickup() {
        DirectionTypeController dc = new DirectionTypeController();
        String []labelTexts = dc.typeDirectionLabels();
        String []avenuesData=dc.getAvenuesData();
        // Crear la vista DirectionsGUI con las avenidas y etiquetas
        this.directionsGUI = new DirectionsGUI(labelTexts, avenuesData);
        super("Pick Up");
        this.makeListeners();
    }

    @Override
    public JPanel createPanel() {
        return directionsGUI.setUpPanel();
    }

    public void makeListeners() {
        directionsGUI.backButton.addActionListener(e -> {
            try {
                Create.showPanel("Welcome");
            } catch (Exception ex) {
                System.out.println("Error al ingresar dirección: " + ex.getMessage());
            }
        });

        directionsGUI.submitButton.addActionListener(e -> {
            try {
                ArrayList<String> answers = directionsGUI.getFormData();
                DirectionController directionsController = new DirectionController(answers);
                int result = directionsController.success;

                if (result == 0) {
                    JOptionPane.showMessageDialog(null, "La dirección es inválida");
                } else if (result == 1) {
                    JOptionPane.showMessageDialog(null, "Dirección registrada correctamente");
                }
            } catch (Exception ex) {
                System.out.println("Error al ingresar dirección: " + ex.getMessage());
            }
        });
    }
}
