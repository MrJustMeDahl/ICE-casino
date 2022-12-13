import processing.core.*;

public class MainMenu {
    private PApplet sketch;
    private PImage img;
    private PFont userInfoFont;
    public static boolean mainMenuRunning = true;

    public MainMenu(PApplet sketch, ProgramControl pc){
        this.sketch = sketch;
        this.img = sketch.loadImage("Pictures/Menu images/MainMenu_background.jpg");
        this.userInfoFont = sketch.createFont("Georgia", 25);
    }

    public void runMainMenu(){
        if(mainMenuRunning) {
            sketch.image(img, 0, 0, 1240, 780);
            seeUserInfo();
            addBalance();
            //chooseGame();
            logout();
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
        sketch.rect(150, 740, 125, 50, 40);
        sketch.textSize(18);
        sketch.fill(0);
        sketch.text("Log out", 150, 745);
        if(sketch.mousePressed && sketch.mouseX > 150 - (125/2) && sketch.mouseX < 150 + (125/2) && sketch.mouseY > 740 - 25 && sketch.mouseY < 740 + 25){
            ProgramControl.loginSuccess = false;
            mainMenuRunning = false;
        }
    }
}
