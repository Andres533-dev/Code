package Proyecto.Code.src.Controler;

import java.util.ArrayList;

public class DirectionController {
    protected int    streetNumber;
    protected int    careerNumber;
    protected int    houseNumber;
    public int correctDirection ;
    public boolean isNumber;
    public DirectionController(ArrayList<String> answers, String[] labelTexts) {
        this.correctDirection = 0;
        isNumber = true;
        this.setUpInformation(answers, labelTexts);
        this.getStreet();
        this.getCareer();
        this.getHouseNumber();

    }
    public void setUpInformation(ArrayList<String> answers, String[] labelTexts){
        try {
            if (labelTexts[0].equals("Career")) {
                this.careerNumber = Integer.parseInt(answers.get(0));
                this.streetNumber = Integer.parseInt(answers.get(1));
            }
            else {
                this.streetNumber = Integer.parseInt(answers.get(0));
                this.careerNumber = Integer.parseInt(answers.get(1));
            }
            this.houseNumber = Integer.parseInt(answers.get(2));
            isNumber=true;
            }
            catch (NumberFormatException e) {
            isNumber=false;
            }
    }
    public void getStreet() {
        if (isNumber && 1 <= streetNumber && streetNumber <= 246) {
            correctDirection++;
        }
    }
    public void getCareer(){
        if (isNumber && 1 <= careerNumber && careerNumber <= 161) {
            correctDirection++;
        }
    }
    public void getHouseNumber() {
        if (isNumber && 1 <= houseNumber && houseNumber <= 99) {
            correctDirection++;
        }
    }
    public String toString(String []labelText){

        if(labelText[0].equals("Street")) {
            return "Cl" + this.streetNumber + " #" + this.careerNumber + "-"+this.houseNumber ;
        }
        else {
            return "Cra" +" " +this.careerNumber + " #" + this.streetNumber + "-" +this.houseNumber ;
        }
    }
}
