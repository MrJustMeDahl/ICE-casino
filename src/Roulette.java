import processing.core.*;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;



public class Roulette extends PApplet {
    PFont f;
    RouletteWheel readWheelData = new RouletteWheel();
    int placeBet = 0;
    int rectX = height/2+1200;
    int rectY = width/2+130;
    int cols = 9;
    int rows = 4;

    int textOutX = width/6+60;
    int textOutY = height/15+730;
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
// Array of bettingbuttons
//******



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
// Setting a textbox in the lower left corner
//******

        fill(0,0,0,127);
        rect(height/6+50,width/15+680,500,230,100);


//******
// Betting buttons
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
