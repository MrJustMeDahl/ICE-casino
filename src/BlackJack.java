import processing.core.*;

public class BlackJack extends CardGames{
    public static boolean blackjackRunning = true;
    private PImage img;
    public BlackJack(String name, CardDeck currentDeck, PApplet sketch) {
        super(name, currentDeck, sketch);
        img = sketch.loadImage("Pictures/BlackjackPictures/Blackjack.jpg");
    }

    @Override
    public void startGame() {
        if(blackjackRunning){
            sketch.image(img, 0, 0, 1240, 780);
        }
    }

    @Override
    public void stopGame() {
        blackjackRunning = false;
        MainMenu.mainMenuRunning = true;
    }

    @Override
    public void chooseBet() {

    }

    @Override
    public void calculatePrizeMoney() {

    }

    @Override
    public void newRound() {

    }
}
