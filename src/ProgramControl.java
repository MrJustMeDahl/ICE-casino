import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Thread.sleep;

public class ProgramControl {

    public static User currentUser;
    private ArrayList<String> allGames;

    public ProgramControl(){
        this.allGames = new ArrayList<>(Arrays.asList("BlackJack", "Craps", "Roulette"));
    }

    public void runCasino(){
        MainMenu mainMenu = new MainMenu();
        //TODO: Run visual window
        //Log in or make new user
        //Draw
        if(mousePressed ) {
            currentUser = login();
            mainMenu.runMainMenu();
        }
        if(mousePressed ) {
            currentUser = DatabaseIO.createNewUser();
            mainMenu.runMainMenu();
        }
    }

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
    }
}
