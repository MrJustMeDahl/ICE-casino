import processing.core.*;

public class Main extends PApplet {
    private ProgramControl pc;
    private MainMenu mainMenu;
    //MainMenu mainMenu;
    public static void main(String[] args) {
        String[] processingArgs = {"ICE CASINO"};
        Main ICE_CASINO = new Main();
        PApplet.runSketch(processingArgs, ICE_CASINO);
    }
    public void setup(){
        this.mainMenu = new MainMenu(this);
        this.pc = new ProgramControl(this, mainMenu);
    }
    public void settings(){
        size(1240,780);
    }

    public void draw(){
        this.pc.runCasino();
    }
}
