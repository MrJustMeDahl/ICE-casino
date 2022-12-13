import processing.core.PApplet;
import processing.core.PImage;

public class Crabs extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Crabs");
    }
    PImage img;

public void settings(){
    size(900,900);
}
    public void setup() {

            image(loadImage("Pictures/CrabsPictures/Craps_table_layout.jpeg"), height / 2, width / 2);
            
    }

    public void draw() {




    }
}
