import processing.core.*;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;



public class Roulette extends PApplet {
    public static boolean rouletteRunning = false;
    ArrayList<Bets> makeBet = new ArrayList<Bets>();
    private boolean mouseIsNotPressed = true;
    int betChange = 20;
    int totalBetSize = 20;
    boolean qPressed = false;
    boolean enterPressed = false;
    int time;
    int time2;
    boolean bDisplayMessage;
    int startTime;
    final int DISPLAY_DURATION = 3000;
    float x = width / 15 + 275;
    float y = height / 6 + 470;
    PFont f;
    RouletteWheel readWheelData = new RouletteWheel(this);
    int placeBet = 0;
    int rectX = width / 2 + 300;
    int rectY = height / 2 - 350;
    int cols = 9;
    int rows = 4;

    int textOutX = width / 6 + 60;
    int textOutY = height / 15 + 730;

    int ballX;
    int ballY;
    float ballRadius;

    int offsetX;
    int offsetY;
    int count = 0;
    int total = 76;
    int centerProx = 155;

    PImage img;

    //******
// Roulette constructor
//******
    public void runRoulette() {

    }

    //*******
//Creating the Processing window size
//*******
    public void settings() {
        //    fullScreen();
        size(1800, 1000);
    }

    //*******
//Setting up the table
//*******
    public void setup() {
        time = 0;
        background(0, 55, 0);
        imageMode(CENTER);
        img = loadImage("Pictures/RoulettePictures/Roulette.jpeg");
        f = createFont("Times New Roman", 16);
        offsetX = width / 4;
        offsetY = height / 3;


    }

//*******
//Running the program
//*******

    public void draw() {
        image(img, width / 4, height / 3);

//******
// Setting a displaybox in the top center
//******
        textFont(f, 16);
        fill(0, 0, 0, 127);
        rect(width / 2 - 20, height / 25, 200, 80);
        fill(255);
        text("Press 'Enter' to finalize bet(s)\n And start the spin\n press 'q' to quit  ", width / 2 - 18, height / 25 + 20);

//******
// Setting a textbox in the lower left corner
//******
        fill(10, 10, 10, 127);
        rect(width / 8, height / 3 + 400, 500, 230, 100);

//******
// Betting amount display
//******

        fill(0, 0, 0, 191);
        rect(width / 2, height / 2 - 70, 75, 50, 100);

//******
// Array of Betting buttons
//******
        fill(150, 150, 150, 191);

        int[][] bettingButtons = new int[cols][rows];
        int tempX = rectX;
        rectX = width / 2 + 300;
        rectY = height / 2 - 350;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {

                rect(tempX, rectY, 75, 75);
                tempX += 80;
            }
            tempX = rectX;
            rectY += 80;
        }

        //           readWheelData.getWheelData().get(0).drawfield(width/2,height/2);

//******
//Red bet button
//******
        fill(120, 0, 0, 191);
        rect(width / 2 + 630, height / 2 - 280, 75, 200, 100);
        fill(255);
        text("RED", width / 2 + 650, height / 2 - 180);
        if (mousePressed) {
            if (mouseX < width / 2 + 705 && mouseX > width / 2 + 630 && mouseY < height / 2 - 80 && mouseY > height / 2 - 280) {
                fill(0, 0, 0, 127);
                rect(width / 2 + 630, height / 2 - 280, 75, 200, 100);
                //TODO placeBet

            }
        }
//******
//Black bet button
//******
        fill(0, 0, 0, 191);
        rect(width / 2 + 630, height / 2, 75, 200, 100);
        fill(255);
        text("BLACK", width / 2 + 640, height / 2 + 100);
        if (mousePressed) {
            if (mouseX < width / 2 + 705 && mouseX > width / 2 + 630 && mouseY < height / 2 + 200 && mouseY > height / 2) {
                fill(100, 0, 0, 127);
                rect(width / 2 + 630, height / 2, 75, 200, 100);
                //TODO PlaceBet

            }
        }
//******
//Odd bet button
//*****
        fill(0, 100, 0, 191);
        rect(width / 2 + 200, height / 2 - 280, 75, 200, 100);
        fill(255);
        text("ODD", width / 2 + 215, height / 2 - 180);
        if (mousePressed) {
            if (mouseX < width / 2 + 275 && mouseX > width / 2 + 200 && mouseY < height / 2 - 80 && mouseY > height / 2 - 280) {
                fill(0, 0, 0, 127);
                rect(width / 2 + 200, height / 2 - 280, 75, 200, 100);
                //TODO PlaceBet

            }
        }

//******
//even bet button
//*****
        fill(0, 100, 0, 191);
        rect(width / 2 + 200, height / 2, 75, 200, 100);
        fill(255);
        text("EVEN", width / 2 + 215, height / 2 + 100);
        if (mousePressed) {
            if (mouseX < width / 2 + 275 && mouseX > width / 2 + 200 && mouseY < height / 2 + 200 && mouseY > height / 2) {
                fill(0, 0, 0, 127);
                rect(width / 2 + 200, height / 2, 75, 200, 100);
                //TODO PlaceBet

            }
        }
//******
//zero bet button
//*****
        fill(0, 100, 0, 191);
        rect(width / 2 + 335, height / 2 - 430, 237, 50, 100);
        fill(255);
        text("0", width / 2 + 450, height / 2 - 400);
        if (mousePressed) {
            if (mouseX < width / 2 + 572 && mouseX > width / 2 + 335 && mouseY < height / 2 - 380 && mouseY > height / 2 - 430) {
                fill(0, 0, 0, 127);
                rect(width / 2 + 335, height / 2 - 430, 237, 50, 100);
                //TODO PlaceBet

            }
        }

//******
// Increase bet button
//******

        fill(100, 100, 100, 191);
        rect(width / 2, height / 2 - 280, 75, 200, 100);
        fill(255);
        text("Increase\n Bet", width / 2 + 10, height / 2 - 180);
        if (mousePressed) {
            if (mouseX < width / 2 + 75 && mouseX > width / 2 && mouseY < height / 2 - 80 && mouseY > height / 2 - 280) {
                fill(0, 0, 0, 127);
                rect(width / 2, height / 2 - 280, 75, 200, 100);

                if (mousePressed && mouseIsNotPressed) {
                    increaseBet();
                    mouseIsNotPressed = false;
                }
            }
        }
        if (!mousePressed && !mouseIsNotPressed){
            mouseIsNotPressed = true;
        }

//******
// Decrease bet button
//******
        fill(100, 100, 100, 191);
        rect(width / 2, height / 2, 75, 200, 100);
        fill(255);
        text("Decrease\n Bet", width / 2 + 10, height / 2 + 100);
        if (mousePressed) {
            if (mouseX < width / 2 + 75 && mouseX > width / 2 && mouseY < height / 2 + 200 && mouseY > height / 2) {
                time = millis();

                fill(0, 0, 0, 127);
                rect(width / 2, height / 2, 75, 200, 100);

                if(totalBetSize > 20){
                    if (mousePressed && mouseIsNotPressed) {
                        decreaseBet();
                        mouseIsNotPressed = false;
                    }
                }
                }
            }

        if (!mousePressed && !mouseIsNotPressed){
            mouseIsNotPressed = true;
        }

//******
// Show betting size
//******

        fill(255);
        text(totalBetSize,width/2+35,height/2-40);


//******
// End betting round
//******
        if (keyPressed) {
            if (key == ENTER && enterPressed == false) {
                time2 = millis();
                enterPressed = true;
            }
        }

        if (enterPressed) {
            fill(10, 10, 10);
            rect(width / 8, height / 3 + 400, 500, 230, 100);
            textFont(f, 16);
            fill(255);
            text("ALL BETS ARE SET", width / 8 + 180, height / 3 + 515);
//******
//Move the ball
//******

            if (frameCount % 2 == 0) {
                count = frameCount;
                placeShapeAtAngle(count);
            }
//******
// Place the bet/bets
//******
            if (millis() > time2 + 5000) {
                placeBet();

                //TODO decrease the betsize from userbalance
                exit();
            }

        }

//******
// takes a random Roulettefield
//******
        //TODO take a random Roulettefield
        spinTheWheel();


//******
// sees if the user is the winner
//******

        //TODO is the player a winner "Display"
        //TODO increase the balance or
        //TODO go further


//*******
// Start a new game
//*******

        //TODO runRoulette();


//*******
// Exiting the game
//*******
        if (keyPressed) {

            if (key == 'q' || key == 'Q') {

                time = millis();
                qPressed = true;
            }
        }
        if (qPressed) {
            fill(10, 10, 10);
            rect(width / 8, height / 3 + 400, 500, 230, 100);
            textFont(f, 16);
            fill(255);
            text("EXITING PROGRAM", width / 8 + 180, height / 3 + 515);

            if (millis() > time + 3000) {
                //rouletteRunning = false;
                exit();
            }
        }
    }


//******
// Place bet on table - run placeBet()
//******

    public void placeBet() {

        ArrayList<Bets> makeBet = new ArrayList<Bets>();






    }


//******
// Increase betting size
//******
    public int increaseBet() {

        totalBetSize=totalBetSize+20;

        return totalBetSize;
    }


//******
// Decrease betting size
//******

    public int decreaseBet() {

        totalBetSize=totalBetSize-20;

        return totalBetSize;
    }


//******
// make the visual roulette magic
//******
            public Roulettefields spinTheWheel(){
                Random random = new Random();
                int index = random.nextInt(readWheelData.getWheelData().size());
                Roulettefields field = readWheelData.getWheelData().get(index);
                return field;
            }



//******
//place the ball
//******

            void placeShapeAtAngle(float i){
                float angle = TWO_PI/(float) total;
                float x1 = offsetX + centerProx*sin(angle*i);
                float y1 = offsetY - centerProx * cos(angle*i);
                ellipse(x1,y1,10,10);
            }


//*******
// check if the user is wins or not
// payout prizemoney or deduct loss from user balance
//*******
/*
          if ( placeBet == result){
        text("Congratulation. You have won" + payOut + " will be inserted to your account", textOutX, textOutY);
        try{
            sleep(3000);
        } catch (InterruptedException e){

        }
              payOut();
          }
          else{
              placeBet == 0;
              text("Sorry you've lost your bet", textOutX, textOutY);
              try{
                  sleep(3000);
              } catch (InterruptedException e){

              }
          }
*/






//    private int payOut(User.recievePrizeMoney()){



//    }


//*******
//Temp startup
//*******
    public static void main (String[] Args){
        PApplet.main("Roulette");

    }


}
