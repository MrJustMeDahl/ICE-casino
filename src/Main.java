import processing.core.*;

public class Main extends PApplet {
    private ProgramControl pc;
    private MainMenu mainMenu;
    private BlackJack blackJack;

    public static void main(String[] args) {
        String[] processingArgs = {"ICE CASINO"};
        Main ICE_CASINO = new Main();
        PApplet.runSketch(processingArgs, ICE_CASINO);
    }
    public void setup(){
        this.mainMenu = new MainMenu(this);
        this.pc = new ProgramControl(this);
        this.blackJack = new BlackJack("Blackjack", new CardDeck(10, 4, true, true),this);
    }
    public void settings(){
        size(1600,900);
    }

    public void draw(){
        this.pc.runCasino();
        this.mainMenu.runMainMenu();
        this.blackJack.startGame();
    }
}
