import processing.core.*;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;



public class Roulette extends PApplet {
    PFont f;
    ArrayList<Textbox> textboxes = new ArrayList<Textbox>();
    RouletteWheel readWheelData = new RouletteWheel();
    int rectX = height/2+1200;
    int rectY = width/2+130;

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
//            image (loadImage("RoulettePictures/BettingRoulette.jpeg"), height/2+400, width/2-900);
            f = createFont("Times New Roman",16);




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
            rect(height / 2 + 310, width / 2 - 950, 200, 80);
            fill(255);
            text("Press 'Enter' to finalize bet(s)\n And start the spin  ", height / 2 + 315, width / 2 - 920);

//******
// Setting a textbox in the lower left corner
//******

        fill(0,0,0,127);
        rect(height/6+50,width/15+680,500,230,100);


//******
// Betting buttons
//******
        fill(150,150,150,191);
        rect(rectX,rectY,75,75);






//*******
// Exiting the game
//*******
            if (keyPressed){

                if(key == 'q' || key == 'Q'){
                    System.out.println("Quiting program" );
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
              payOut();
          }
          else{
              placeBet == null;
              System.out.println("Sorry you've lost your bet");
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
