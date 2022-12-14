import processing.core.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ProgramControl {
    private PApplet sketch;
    private PImage img;
    private PFont welcomeFont;
    private PFont menuFont;
    public static User currentUser;
    private ArrayList<String> allGames;
    private boolean loginChosen = false;
    private boolean createNewUserChosen = false;
    public static boolean loginSuccess = false;
    private boolean showErrorMessasge = false;
    private UserInputBox userInputUsername;
    private UserInputBox userInputPassword;
    private UserInputBox usernameCreateUserBox;
    private UserInputBox passwordCreateUserBox;


    public ProgramControl(PApplet sketch){
        this.sketch = sketch;
        this.allGames = new ArrayList<>(Arrays.asList("BlackJack", "Craps", "Roulette"));
        this.img = sketch.loadImage("Pictures/Menu images/Loginbackground.jpg");
        this.welcomeFont = sketch.createFont("Georgia", 80);
        this.menuFont = sketch.createFont("Georgia", 50);
        this.userInputUsername = new UserInputBox(sketch.width / 2, sketch.height / 2 - 50, 500, 75, "Username");
        this.userInputPassword = new UserInputBox(sketch.width / 2, sketch.height / 2 + 50, 500, 75, "Password");
        this.usernameCreateUserBox = new UserInputBox(sketch.width / 2, sketch.height / 2 - 50, 500, 75, "Username");
        this.passwordCreateUserBox = new UserInputBox(sketch.width / 2, sketch.height / 2 + 50, 500, 75, "Password");
    }

    public void runCasino(){
        if(!loginSuccess) {
            runBackground();
        } else {
            MainMenu.mainMenuRunning = true;
        }
        if(!loginChosen && !createNewUserChosen && !loginSuccess) {
            displayOptions();
            chooseOption();
        }
        if(loginChosen) {
            login();
        }
        if(createNewUserChosen){
            createNewUser();
        }
    }

    private void runBackground(){
        sketch.image(this.img, 0,0, 1600, 900);
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
        boolean buttonPressed = false;
        userInputUsername.drawBox();
        userInputPassword.drawBox();
        sketch.textFont(menuFont);
        sketch.textAlign(sketch.CENTER);
        sketch.rectMode(sketch.CENTER);
        sketch.fill(255, 150);
        sketch.rect(sketch.width / 2, sketch.height / 2 + 135, 200, 40, 40);
        sketch.fill(0);
        sketch.textSize(25);
        sketch.text("Login", sketch.width/2, sketch.height/2 + 143);
        if(sketch.mousePressed && sketch.mouseX > (sketch.width/2 - 100) && sketch.mouseX < (sketch.width/2 + 100) && sketch.mouseY > ((sketch.height/2) + 150 - (135/2)) && sketch.mouseY < ((sketch.height/2) + 150 + (135/2))){
            currentUser = submitLogin(userInputUsername.typedInBox(), userInputPassword.typedInBox());
            buttonPressed = true;
            userInputUsername.resetInput();
            userInputPassword.resetInput();
        }
        if(currentUser != null && buttonPressed){
            loginSuccess = true;
            MainMenu.mainMenuRunning = true;
            loginChosen = false;
        } else if(currentUser == null && buttonPressed){
            sketch.fill(255);
            sketch.rect(sketch.width/2, sketch.height/2, 550, 200, 40);
            sketch.textAlign(sketch.CENTER);
            sketch.textFont(menuFont);
            sketch.textSize(25);
            sketch.fill(0);
            sketch.text("The username and password you've entered,\ndoes not match an existing account.\n Please try again.", sketch.width/2, sketch.height/2 - 20);
            //showErrorMessasge = true;
        }
        /*if(showErrorMessasge){
            int timer = sketch.millis();
            while(timer < timer + 3000){
                sketch.fill(255);
                sketch.rect(sketch.width/2, sketch.height/2, 500, 200);
                sketch.textAlign(sketch.CENTER);
                sketch.textFont(menuFont);
                sketch.textSize(25);
                sketch.fill(0);
                sketch.text("The username and password you've entered, \ndoes not match an existing account.\n Please try again.", sketch.width/2, sketch.height/2);
                showErrorMessasge = false;
            }
        }
      */
    }

    private void createNewUser(){
        boolean buttonPressed = false;
        //TODO: Make sure users make new accounts correctly
        usernameCreateUserBox.drawBox();
        passwordCreateUserBox.drawBox();
        sketch.textFont(menuFont);
        sketch.textAlign(sketch.CENTER);
        sketch.rectMode(sketch.CENTER);
        sketch.fill(255, 150);
        sketch.rect(sketch.width / 2, sketch.height / 2 + 135, 250, 40, 40);
        sketch.fill(0);
        sketch.textSize(25);
        sketch.text("Create new account", sketch.width/2, sketch.height/2 + 143);
        if(sketch.mousePressed && sketch.mouseX > (sketch.width/2 - 125) && sketch.mouseX < (sketch.width/2 + 125) && sketch.mouseY > ((sketch.height/2) + 150 - (135/2)) && sketch.mouseY < ((sketch.height/2) + 150 + (135/2))){
            DatabaseIO.databaseIO.writeToUserData(usernameCreateUserBox.typedInBox(), passwordCreateUserBox.typedInBox());
            currentUser = submitLogin(usernameCreateUserBox.typedInBox(), passwordCreateUserBox.typedInBox());
            buttonPressed = true;
            usernameCreateUserBox.resetInput();
            passwordCreateUserBox.resetInput();
        }
        if(currentUser != null && buttonPressed){
            loginSuccess = true;
            MainMenu.mainMenuRunning = true;
            createNewUserChosen = false;
        }
    }

    private User submitLogin(String username, String password){
        User loggedInUser = DatabaseIO.databaseIO.loadUserData(username, password);
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
            //TODO: Make writing in textboxes better
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

        private void resetInput(){
            userInput = "";
        }
    }
}
