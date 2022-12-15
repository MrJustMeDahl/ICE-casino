import processing.core.PApplet;
import processing.core.PImage;

public class Crabs extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Crabs");
    }
    private float betAmount = 250;
    private boolean betMade = false;

public void settings(){
    size(1600,900);

}
    public void setup() {
        background(0);
            image (loadImage("Pictures/CrabsPictures/Craps_table_layout.jpeg"), 250, 1);


    }
    public void chooseBet() {
    rectMode(CENTER);
    textAlign(CENTER);
    
        fill(255, 150);
        rect(150, 350, 200, 80, 40);
        rect(100, 420, 100, 40, 40);
        rect(200, 420, 100, 40, 40);
        textSize(25);
        fill(0);
        text("" + betAmount, 150, 360);
        textSize(18);
        text("Decrease", 100, 425);
        text("Increase", 200, 425);
        if(mousePressed && mouseX > 50 && mouseX < 150 && mouseY > 400 && mouseY < 440){
            if(betAmount <= 0) {
                betAmount = 0;
            } else {
                betAmount -= 250;
            }
        }
        if(mousePressed && mouseX > 150 && mouseX < 250 && mouseY > 400 && mouseY < 440){
            if(betAmount + 250 >= ProgramControl.currentUser.getBalance()){
                betAmount = ProgramControl.currentUser.getBalance();
            } else {
                betAmount += 250;
            }
        }
        fill(255, 150);
        rect(150, 475, 200, 50, 40);
        textSize(25);
        fill(0);
        text("Make bet", 150, 485);
        if(mousePressed && mouseX > 50 && mouseX < 250 && mouseY > 450 && mouseY < 500){
            betMade = true;
        }
    }
    public void draw() {

    chooseBet();




    }
}
