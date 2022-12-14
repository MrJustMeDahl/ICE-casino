import processing.core.*;

public class BlackJack extends CardGames{
    public static boolean blackjackRunning = false;
    private PImage img;
    private PFont menuFont;
    private int betAmount = 250;
    private boolean betMade = false;
    public BlackJack(String name, CardDeck currentDeck, PApplet sketch) {
        super(name, currentDeck, sketch);
        img = sketch.loadImage("Pictures/BlackjackPictures/Blackjack.jpg");
        menuFont = sketch.createFont("Georgia", 25);
    }

    @Override
    public void startGame() {
        if(blackjackRunning){
            sketch.image(img, 0, 0, 1600, 900);
            displayUserInfo();
            if(!betMade) {
                chooseBet();
            } else {
                runGame();
            }
            stopGame();
        }
    }

    @Override
    public void stopGame() {
        sketch.fill(255, 150);
        sketch.rect(150, 840, 125, 50, 40);
        sketch.textSize(18);
        sketch.fill(0);
        sketch.text("Exit game", 150, 845);
        if(sketch.mousePressed && sketch.mouseX > 150 - (125/2) && sketch.mouseX < 150 + (125/2) && sketch.mouseY > 840 - 25 && sketch.mouseY < 840 + 25) {
            blackjackRunning = false;
            MainMenu.mainMenuRunning = true;
        }
    }

    @Override
    public void chooseBet() {
        sketch.fill(255, 150);
        sketch.rect(150, 350, 200, 80, 40);
        sketch.rect(100, 420, 100, 40, 40);
        sketch.rect(200, 420, 100, 40, 40);
        sketch.textSize(25);
        sketch.fill(0);
        sketch.text("" + betAmount, 150, 360);
        sketch.textSize(18);
        sketch.text("Decrease", 100, 425);
        sketch.text("Increase", 200, 425);
        if(sketch.mousePressed && sketch.mouseX > 50 && sketch.mouseX < 150 && sketch.mouseY > 400 && sketch.mouseY < 440){
            if(betAmount <= 0) {
                betAmount = 0;
            } else {
                betAmount -= 250;
            }
        }
        if(sketch.mousePressed && sketch.mouseX > 150 && sketch.mouseX < 250 && sketch.mouseY > 400 && sketch.mouseY < 440){
            if(betAmount + 250 >= ProgramControl.currentUser.getBalance()){
                betAmount = ProgramControl.currentUser.getBalance();
            } else {
                betAmount += 250;
            }
        }
        sketch.fill(255, 150);
        sketch.rect(150, 475, 200, 50, 40);
        sketch.textSize(25);
        sketch.fill(0);
        sketch.text("Make bet", 150, 485);
        if(sketch.mousePressed && sketch.mouseX > 50 && sketch.mouseX < 250 && sketch.mouseY > 450 && sketch.mouseY < 500){
            betMade = true;
            ProgramControl.currentUser.makeBet(betAmount);
        }
    }

    @Override
    public void calculatePrizeMoney() {

    }

    @Override
    public void newRound() {

    }

    private void displayUserInfo() {
        sketch.fill(255, 255, 255, 150);
        sketch.rectMode(sketch.CENTER);
        sketch.rect(150, 100, 280, 180, 40);
        sketch.textAlign(sketch.CENTER);
        sketch.textFont(menuFont);
        sketch.fill(0);
        sketch.text("You are now playing\n" + name + "\nCash:\n" + ProgramControl.currentUser.getBalance() + "", 150, 50);
    }

    private void runGame(){
        drawPlayingLayout();
        currentDeck.shuffleCards();
        
    }

    private void drawPlayingLayout(){
        sketch.fill(0,200,0,150);
        sketch.rect(150, 350, 200, 120, 40);
        sketch.fill(200, 0, 0, 150);
        sketch.rect(150, 600, 200, 120, 40);
        sketch.fill(255, 150);
        sketch.rect(sketch.width/2 + 100, 610, 300, 28, 40);
        sketch.rect(sketch.width/2 + 100, 750, 1100, 250, 40);
        sketch.rect(sketch.width/2 + 100, 150, 1100, 250, 40);
        sketch.rect(sketch.width/2 + 100, 290, 300, 28, 40);
        sketch.fill(0);
        sketch.textSize(30);
        sketch.text("Hit", 150, 365);
        sketch.text("Stand", 150, 615);
        sketch.text("Your cards:", sketch.width/2 + 100, 620);
        sketch.text("Dealer's Cards:", sketch.width/2 + 100, 300);
    }
}
