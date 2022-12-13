import processing.core.*;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Thread.sleep;

public class ProgramControl {
    private PApplet sketch;
    private PImage img;
    private PFont welcomeFont;
    private PFont menuFont;
    private MainMenu mainMenu;
    public static User currentUser;
    private ArrayList<String> allGames;
    private boolean loginChosen = false;
    private boolean createNewUserChosen = false;
    private boolean loginSuccess = false;
    private UserInputBox userInputUsername;
    private UserInputBox userInputPassword;

    public ProgramControl(PApplet sketch, MainMenu mainMenu){
        this.sketch = sketch;
        this.allGames = new ArrayList<>(Arrays.asList("BlackJack", "Craps", "Roulette"));
        this.img = sketch.loadImage("Menu images/Loginbackground.jpg");
        this.welcomeFont = sketch.createFont("Georgia", 80);
        this.menuFont = sketch.createFont("Georgia", 50);
        this.mainMenu = mainMenu;
        this.userInputUsername = new UserInputBox(sketch.width / 2, sketch.height / 2 - 50, 500, 75, "Username");
        this.userInputPassword = new UserInputBox(sketch.width / 2, sketch.height / 2 + 50, 500, 75, "Password");
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
        if(loginChosen){
            login();
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
        }
        if(sketch.mousePressed && sketch.mouseX > sketch.width/2 - 250 && sketch.mouseX < sketch.width/2 + 250 && sketch.mouseY > sketch.height/2 + 25 && sketch.mouseY < sketch.height/2 + 75){
            createNewUserChosen = true;
        }
    }

    private void login(){
        userInputUsername.drawBox();
        userInputPassword.drawBox();
        if(submitLogin(userInputUsername.typedInBox(), userInputPassword.typedInBox()) != null){
            currentUser = submitLogin(userInputUsername.typedInBox(), userInputPassword.typedInBox());
        }

        if(currentUser != null){
            mainMenu.runMainMenu();
        }
    }

    private void createNewUser(){

    }

    private User submitLogin(String username, String password){
        User loggedInUser = null;
        sketch.textFont(menuFont);
        sketch.textAlign(sketch.CENTER);
        sketch.rectMode(sketch.CENTER);
        sketch.fill(255, 150);
        sketch.rect(sketch.width / 2, sketch.height / 2 + 135, 200, 40, 40);
        sketch.fill(0);
        sketch.textSize(25);
        sketch.text("Login", sketch.width/2, sketch.height/2 + 143);
        if(sketch.mousePressed && sketch.mouseX > (sketch.width/2 - 100) && sketch.mouseX < (sketch.width/2 + 100) && sketch.mouseY > ((sketch.height/2) - (135/2)) && sketch.mouseY < ((sketch.height/2) + (135/2))){
            loggedInUser = DatabaseIO.loadUserData(username, password);
        }
        if(loggedInUser != null) {
            return loggedInUser;
        }
        return loggedInUser;
    }

    private class UserInputBox{
        private String userInput = "";
        private int userInputLength = 0;
        private String message = "";
        private int x, y, w, h;
        private boolean pressed = false;
        private boolean keyIsNotPressed = true;
        private UserInputBox(int x, int y, int w, int  h, String message){
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.message += message;
        }

        private void drawBox(){
            sketch.textFont(menuFont);
            sketch.rectMode(sketch.CENTER);
            isPressed();
            if(pressed){
                sketch.fill(255,200);
                sketch.rect(x, y, w, h, 40);
                sketch.fill(0);
                sketch.textAlign(sketch.CENTER);
                sketch.text(userInput, x, y+(h/4));
            } else {
                sketch.fill(255, 150);
                sketch.rect(x, y, w, h, 40);
                sketch.fill(0);
                sketch.text(message, x, y + (h/4));
            }

            if(sketch.keyPressed && keyIsNotPressed){
                sketch.fill(0);
                keyPressed(sketch.key);
                keyIsNotPressed = false;
            }
            if(!sketch.keyPressed && !keyIsNotPressed){
                keyIsNotPressed = true;
            }
        }

        private String typedInBox(){
            return userInput;
        }

        private void isPressed(){
            if(sketch.mousePressed && sketch.mouseX > (x-(w/2)) && sketch.mouseX < (x+(w/2)) && sketch.mouseY > (y-(h/2)) && sketch.mouseY < (y+(h/2))){
                this.pressed = true;
            } else if(sketch.mousePressed){
                this.pressed = false;
            }
        }

        private void keyPressed(char key){
            if(pressed) {
                if ((key >= 'A' && key <= 'Z') || (key >= 'a' && key <= 'z') || (key >= '0' && key <= '9')) {
                    this.userInput += sketch.key;
                    userInputLength++;
                }
                if(sketch.key == sketch.BACKSPACE){
                    if(this.userInput.length() > 0) {
                        this.userInput = this.userInput.substring(0, userInputLength - 1);
                        userInputLength--;
                    }
                }
            }
        }
    }
}
