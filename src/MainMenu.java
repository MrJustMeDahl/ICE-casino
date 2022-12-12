import processing.core.*;

public class MainMenu {
    private PApplet sketch;
    private PImage img;
    private PFont font;

    public MainMenu(PApplet sketch){
        this.sketch = sketch;
        this.img = sketch.loadImage("Menu images/MainMenu_background.jpg");
    }

    public void runMainMenu(){
        sketch.image(img, 0, 0, 1240, 780);
    }
}
