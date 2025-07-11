package Proyecto.Code.src.View;

import javax.swing.*;

public class ManagerView {
    public static void main(String[] args) {
        new WelcomeGUI();
        new LogInGUI();
        new SignUpGUI();
        // DirectionsElections se creará después del login exitoso

        // Configurar el JFrame
        JFrame frame = new JFrame("Mobility App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2000, 2000);
        frame.add(Create.getPanel());

        // Mostrar el panel inicial
        Create.showPanel("Welcome");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}

