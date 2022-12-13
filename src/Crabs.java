import processing.core.PApplet;
import processing.core.PImage;

public class Crabs extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Crabs");
    }
    PImage img;


    public void setup(){
        size(400,400);
        img = loadImage("Craps_table_layout.svg.png");

        image(loadImage("C:\\Users\\techn\\OneDrive\\Skrivebord\\Ice\\Pictures\\Craps_table_layout.svg.png"), height/2, width/2);


    }

    public void draw() {
background(0);

        image(img, 0, 0);


    }
}
