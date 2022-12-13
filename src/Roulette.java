import processing.core.*;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;



public class Roulette extends PApplet {
    float x = height/6+470;
    float y = width/15+275;
    PFont f;
    RouletteWheel readWheelData = new RouletteWheel();
    int placeBet = 0;
    int rectX = height/2+1200;
    int rectY = width/2+130;
    int cols = 9;
    int rows = 4;

    int textOutX = width/6+60;
    int textOutY = height/15+730;

    int ballX;
    int ballY;
    float ballRadius;
//******
// Roulette constructor
//******
       public void runRoulette(){

       }
//*******
//Creating the Processing window size
//*******
        public void settings(){
            fullScreen();
        }

//*******
//Setting up the table
//*******
        public void setup(){
            background(0,55,0);
            image (loadImage("Pictures/RoulettePictures/Roulette.jpeg"), height/6,width/15);
            f = createFont("Times New Roman",16);
//******
//RouletteBall
//******
           // int radius = min(height/6,width/15);

        }

//*******
//Running the program
//*******

        public void draw() {
//******
// Setting a displaybox in the top center
//******
            textFont(f, 16);
            fill(0,0,0,127);
            rect(height / 2 + 310, width / 2 - 945, 200, 80);
            fill(255);
            text("Press 'Enter' to finalize bet(s)\n And start the spin\n press 'q' to quit  ", height / 2 + 315, width / 2 - 920);

//******
//Draw the ball
//******

          ellipseMode(CENTER);
/*
            float steps = 38;
            float x = height/6+470;
            float y = width/15+275;
            for (int i = 0; i <= steps; i++){
              float t = i /(steps);
              x = curvePoint(x,x+25,x+50,x+72,t);
              y = curvePoint(y,y+5,y+10,y+17,t);
              ellipse(x,y,10,10);
          }
*/

           circle(x,y,10);
//******
// Setting a textbox in the lower left corner
//******

        fill(0,0,0,127);
        rect(height/6+50,width/15+680,500,230,100);


//******
// Array of Betting buttons
//******

            fill(150,150,150,191);

            int [][] bettingButtons = new int[cols][rows];
            int tempX = rectX;
            for (int i = 0; i<9; i++) {
                for (int j = 0; j < 4; j++) {

                    rect(tempX, rectY, 75, 75);
                    tempX += 80;


                }

                tempX = rectX;
                rectY += 80;
            }
        rectX = height/2+1200;
        rectY = width/2+130;

//******
//Red bet button
//******

        fill(120,0,0,191);
        rect(height/2+1050, width/2-700,75,200,100);
        fill(255);
        text("RED",height/2+1070,width/2-600);
//******
//Black bet button
//******
        fill(0,0,0,191);
        rect(height/2+1050,width/2-400,75,200,100);
        fill(255);
        text("BLACK",height/2+1060,width/2-300);

//******
//Odd bet button
//*****

        fill (0,100,0,191);
        rect (height/2+617,width/2-700,75,200,100);
        fill(255);
        text("ODD",height/2+637,width/2-600);

//******
//even bet button
//*****

            fill (0,100,0,191);
            rect (height/2+617,width/2-400,75,200,100);
            fill(255);
            text("EVEN",height/2+632,width/2-300);

//******
//zero bet button
//*****

            fill (0,100,0,191);
            rect (height/2+750,width/2-850,237,50,100);
            fill(255);
            text("0",height/2+863,width/2-820);


//*******
// Exiting the game
//*******
            if (keyPressed){

                if(key == 'q' || key == 'Q'){
                    textFont(f, 16);
                    fill(255);
                    text("Exiting program", width/2, height/2);
                    try{
                        sleep(3000);
                    } catch (InterruptedException e){

                    }
                    exit();
                }
            }
        }


//******
// Place bet on table - run placeBet()
//******
   /*
          if (User.balance >= 20){
              placeBet();
            }
          else{
                System.out.println("You don't have enough credits to place a bet");
            }
    */
//******
// make the visual roulette magic
//******
            public Roulettefields spinTheWheel(){
                Random random = new Random();
                int index = random.nextInt(readWheelData.getWheelData().size());
                Roulettefields field = readWheelData.getWheelData().get(index);
                return field;
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

//*******
//Runs the Roulette Algorithm
//*******
    private void rouletteRules(){



    }





//    private int payOut(User.recievePrizeMoney()){



//    }


//*******
//Temp startup
//*******
    public static void main (String[] Args){
        PApplet.main("Roulette");

    }


}
