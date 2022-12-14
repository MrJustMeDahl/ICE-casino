import processing.core.PApplet;
import processing.core.PImage;

public class Crabs extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Crabs");
    }

public void settings(){
    size(1800,900);

}
    public void setup() {
        background(0);
            image (loadImage("Pictures/CrabsPictures/Craps_table_layout.jpeg"), 250, 1);
            rect(50,200,100,100);
            rect(50,50,100,100);



    }

    public void draw() {




    }
}
