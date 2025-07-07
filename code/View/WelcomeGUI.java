package Proyecto.Code.src.View;

import javax.swing.*;
import java.util.ArrayList;

public class WelcomeGUI extends Create{
    private Choose choose;
    public ArrayList<JButton> buttons;
    private String[] labelTexts;
    public WelcomeGUI() {
        String[] labelsText = {"Welcome", "Sign Up", "Log In"};
        this.choose=new Choose(labelsText);
        super("Welcome");
        this.makeListener();
        // Texto para el label y botones

    }
    @Override
    public JPanel createPanel() {
        return choose.setUpPanel();
    }


    public void makeListener(){
        buttons=choose.getButtons();
        this.buttons.get(0).addActionListener(e->{
            try{
                Create.showPanel("Sign Up");
            }
            catch (Exception ex){
                System.out.println("Se ha presentado el error en Welcome: " + ex.getMessage());
            }
        });

        this.buttons.get(1).addActionListener(e->{
            try{
                Create.showPanel("Log In");
            }
            catch (Exception ex){
                System.out.println("Se ha presentado el error en Welcome: " + ex.getMessage());
            }
        });
    }


}