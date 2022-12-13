import processing.core.*;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Thread.sleep;

public class ProgramControl {
    private PApplet sketch;
    private PImage img;
    private PFont welcomeFont;
    private PFont menuFont;
    MainMenu mainMenu;
    public static User currentUser;
    private ArrayList<String> allGames;
    boolean loginChosen = false;
    boolean createNewUserChosen = false;
    boolean loginSuccess = true;
    public ProgramControl(PApplet sketch, MainMenu mainMenu){
        this.sketch = sketch;
        this.allGames = new ArrayList<>(Arrays.asList("BlackJack", "Craps", "Roulette"));
        this.img = sketch.loadImage("Menu images/Loginbackground.jpg");
        this.welcomeFont = sketch.createFont("Georgia", 80);
        this.menuFont = sketch.createFont("Georgia", 50);
        this.mainMenu = mainMenu;
    }

    public void runCasino(){
        //TODO: Run visual window
        if(!loginSuccess) {
            runBackground();
        } else {
            mainMenu.runMainMenu();
        }
        if(!loginChosen && !createNewUserChosen) {
            displayOptions();
            chooseOption();
        }
        /*Log in or make new user
        if(mousePressed ) {
            currentUser = login();
            mainMenu.runMainMenu();
        }
        if(mousePressed ) {
            currentUser = DatabaseIO.createNewUser();
            mainMenu.runMainMenu();
        }
        */

    }
/*
    private User login(){
        //TODO: Run visual login screen
        User user = DatabaseIO.loadUserData(username, password);
        if(user == null){
            //TODO: Display message on screen - login failed, please try again.
            try {
                sleep(1500);
            } catch (InterruptedException e){
                throw new RuntimeException("Sleep failed");
            }
            login();
        }
        return user;
    }
 */
    private void runBackground(){
        sketch.image(this.img, 0,0, 1240, 780);
        sketch.textFont(this.welcomeFont);
        sketch.textAlign(sketch.CENTER);
        sketch.fill(255);
        sketch.text("WELCOME TO", sketch.width/2, sketch.height/6);
        sketch.text("ICE CASINO", sketch.width/2, sketch.height/6 + 80);
    }

    private void displayOptions(){
        sketch.rectMode(sketch.CENTER);
        if(sketch.mouseX > sketch.width/2 - 250 && sketch.mouseX < sketch.width/2 + 250 && sketch.mouseY > sketch.height/2 - 75 && sketch.mouseY < sketch.height/2 - 25) {
            sketch.fill(0, 0, 220, 150);
        } else {
            sketch.fill(255, 150);
            sketch.noStroke();
        }
        sketch.rect(sketch.width / 2, sketch.height / 2 - 50, 500, 75, 40);
        if(sketch.mouseX > sketch.width/2 - 250 && sketch.mouseX < sketch.width/2 + 250 && sketch.mouseY > sketch.height/2 + 25 && sketch.mouseY < sketch.height/2 + 75) {
            sketch.fill(0, 0, 220, 150);
        } else {
            sketch.fill(255, 150);
            sketch.noStroke();
        }
        sketch.rect(sketch.width / 2, sketch.height / 2 + 50, 500, 75, 40);
        sketch.stroke(0);
        sketch.textFont(menuFont);
        if(sketch.mouseX > sketch.width/2 - 250 && sketch.mouseX < sketch.width/2 + 250 && sketch.mouseY > sketch.height/2 - 75 && sketch.mouseY < sketch.height/2 - 25) {
            sketch.fill(255);
        } else {
            sketch.fill(0);
        }
        sketch.text("Login", sketch.width/2, sketch.height/2 - 35);
        if(sketch.mouseX > sketch.width/2 - 250 && sketch.mouseX < sketch.width/2 + 250 && sketch.mouseY > sketch.height/2 + 25 && sketch.mouseY < sketch.height/2 + 75) {
            sketch.fill(255);
        } else {
            sketch.fill(0);
        }
        sketch.text("Create new account", sketch.width/2, sketch.height/2 + 62);
    }

    private void chooseOption(){
        if(sketch.mousePressed && sketch.mouseX > sketch.width/2 - 250 && sketch.mouseX < sketch.width/2 + 250 && sketch.mouseY > sketch.height/2 - 75 && sketch.mouseY < sketch.height/2 - 25){
            loginChosen = true;
            login();
        }
        if(sketch.mousePressed && sketch.mouseX > sketch.width/2 - 250 && sketch.mouseX < sketch.width/2 + 250 && sketch.mouseY > sketch.height/2 + 25 && sketch.mouseY < sketch.height/2 + 75){
            createNewUserChosen = true;
            createNewUser();
        }
    }

    private void login(){
        
    }

    private void createNewUser(){

    }
}
