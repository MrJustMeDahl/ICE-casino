import processing.core.*;

public class MainMenu {
    private PApplet sketch;
    private PImage img;
    private PFont userInfoFont;
    public static boolean mainMenuRunning = false;
    private Roulette roulette = new Roulette();

    public MainMenu(PApplet sketch){
        this.sketch = sketch;
        this.img = sketch.loadImage("Pictures/Menu images/MainMenu_background.jpg");
        this.userInfoFont = sketch.createFont("Georgia", 25);
    }

    public void runMainMenu(){
        if(mainMenuRunning) {
            sketch.image(img, 0, 0, 1600, 900);
            seeUserInfo();
            addBalance();
            logout();
            chooseGame();
        }
    }

    private void seeUserInfo(){
        sketch.fill(255, 255, 255, 150);
        sketch.rectMode(sketch.CENTER);
        sketch.rect(150, 100, 280, 180, 40);
        sketch.textAlign(sketch.CENTER);
        sketch.textFont(userInfoFont);
        sketch.fill(0);
        sketch.text("Welcome\n" + ProgramControl.currentUser.getUsername() + "\nCash:\n" + ProgramControl.currentUser.getBalance() + "", 150, 50);
    }

    private void addBalance(){
        boolean buttonPressed = false;
        sketch.fill(255, 150);
        sketch.rect(150, 225, 125, 50, 40);
        sketch.textSize(18);
        sketch.fill(0);
        sketch.text("Add funds", 150, 230);
        if(sketch.mousePressed && sketch.mouseX > 150 - (125/2) && sketch.mouseX < 150 + (125/2) && sketch.mouseY > 225 - 25 && sketch.mouseY < 225 + 25){
            buttonPressed = true;
        }
        if(buttonPressed){
            ProgramControl.currentUser.receiveMoney(5000);
            buttonPressed = false;
        }
    }

    private void logout(){
        sketch.fill(255, 150);
        sketch.rect(150, 840, 125, 50, 40);
        sketch.textSize(18);
        sketch.fill(0);
        sketch.text("Log out", 150, 845);
        if(sketch.mousePressed && sketch.mouseX > 150 - (125/2) && sketch.mouseX < 150 + (125/2) && sketch.mouseY > 840 - 25 && sketch.mouseY < 840 + 25){
            ProgramControl.loginSuccess = false;
            mainMenuRunning = false;
        }
    }

    private void chooseGame(){
        sketch.stroke(200, 200, 0);
        sketch.fill(255, 0);
        sketch.rect(sketch.width/2, sketch.height/2-190, 250, 65, 40);
        sketch.rect(sketch.width/2, sketch.height/2-110, 250, 65, 40);
        sketch.rect(sketch.width/2, sketch.height/2-30, 250,65, 40);
        if(sketch.mousePressed && sketch.mouseX > sketch.width/2 - 125 && sketch.mouseX < sketch.width/2 + 125 && sketch.mouseY > sketch.height/2 - 190 - (65/2) && sketch.mouseY < sketch.height/2 - 190 + (65/2)){
            if(!Roulette.rouletteRunning) {
                String[] processingArgs = {"Roulette"};
                sketch.runSketch(processingArgs, roulette);
                Roulette.rouletteRunning = true;
            }
        }
        if(sketch.mousePressed && sketch.mouseX > sketch.width/2 - 125 && sketch.mouseX < sketch.width/2 + 125 && sketch.mouseY > sketch.height/2 - 110 -(65/2) && sketch.mouseY < sketch.height/2 - 110 + (65/2)){
            BlackJack.blackjackRunning = true;
            mainMenuRunning = false;
        }
        if(sketch.mousePressed && sketch.mouseX > sketch.width/2 - 125 && sketch.mouseX < sketch.width/2 + 125 && sketch.mouseY > sketch.height/2 - 30 - (65/2) && sketch.mouseY < sketch.height/2 - 30 + (65/2)){
            /*Craps craps = new Craps();
            craps.startGame();

             */
        }
    }

}
