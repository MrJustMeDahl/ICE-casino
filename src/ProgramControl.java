import processing.core.*;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Thread.sleep;

public class ProgramControl {
    private PApplet sketch;
    private PImage img;
    private PFont welcomeFont;
    MainMenu mainMenu;
    public static User currentUser;
    private ArrayList<String> allGames;
    boolean loginSuccess = false;
    public ProgramControl(PApplet sketch, MainMenu mainMenu){
        this.sketch = sketch;
        this.allGames = new ArrayList<>(Arrays.asList("BlackJack", "Craps", "Roulette"));
        this.img = sketch.loadImage("Menu images/Loginbackground.jpg");
        this.welcomeFont = sketch.createFont("Georgia", 80);
        this.mainMenu = mainMenu;
    }

    public void runCasino(){
        //TODO: Run visual window
        if(!loginSuccess) {
            runBackground();
        } else {
            mainMenu.runMainMenu();
        }
        displayOptions();
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
        sketch.text("WELCOME TO", sketch.width/2, sketch.height/6);
        sketch.text("ICE CASINO", sketch.width/2, sketch.height/6 + 80);
    }

    private void displayOptions(){
        
    }
}
