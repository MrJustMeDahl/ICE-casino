import processing.core.*;

public class MainMenu {
    private PApplet sketch;
    private ProgramControl pc;
    private PImage img;
    private PFont userInfoFont;

    public MainMenu(PApplet sketch, ProgramControl pc){
        this.sketch = sketch;
        this.pc = pc;
        this.img = sketch.loadImage("Pictures/Menu images/MainMenu_background.jpg");
        this.userInfoFont = sketch.createFont("Georgia", 25);
    }

    public void runMainMenu(){
        sketch.image(img, 0, 0, 1240, 780);
        seeUserInfo();
        //Logout();
        addBalance();
        //chooseGame();
    }

    private void seeUserInfo(){
        sketch.fill(255, 150);
        sketch.rectMode(sketch.CENTER);
        sketch.rect(150, 100, 280, 180, 40);
        sketch.textAlign(sketch.CENTER);
        sketch.textFont(userInfoFont);
        sketch.fill(0);
        sketch.text("Welcome\n" + ProgramControl.currentUser.getUsername() + "\nCash:\n" + ProgramControl.currentUser.getBalance() + "", 150, 50);
    }

    private void addBalance(){
        sketch.fill(255, 150);
        sketch.rect(150, 225, 125, 50, 40);
        sketch.textSize(18);
        sketch.fill(0);
        sketch.text("Add funds", 150, 230);
        if(sketch.mousePressed && sketch.mouseX > 150 - (125/2) && sketch.mouseX < 150 + (125/2) && sketch.mouseY > 225 - 25 && sketch.mouseY < 225 + 25){
            ProgramControl.currentUser.receiveMoney(5000);
        }
    }
}
