import processing.core.*;
import java.util.ArrayList;

import static java.lang.Thread.sleep;



public class Roulette extends PApplet {
PFont f;
ArrayList<Textbox> textboxes = new ArrayList<Textbox>();
//    ArrayList<User> allUsers;

 /*   public Roulette(ArrayList<User> allUsers) {
        this.allUsers = allUsers;
    }
*/

 //   public void runRoulette(){


//        PImage image1;
//        PImage image2;

// Setting the visual bounderies
        public void settings(){
            fullScreen();
        }

        public void setup(){
            background(0,55,0);

            image (loadImage("Data/Roulette.jpeg"), height/6,width/15);
            image (loadImage("Data/BettingRoulette.jpeg"), height/2+400, width/2-900);
            f = createFont("Times New Roman",16);
            initLayout();



        }

// Visual table of Roulette

        public void draw(){
            textFont(f,16);
            fill(0);
            rect(height/2+310,width/2-950,200,80);
            fill(255);
            text ("Press 'Enter' to finalize bet(s)\n And start the spin  ", height/2+315,width/2-920);

            for (Textbox t: textboxes){
                t.DRAW();
            }

// Place bet on table - run placeBet()
/*
          if (User.balance >= 20){
              placeBet();
            }
          else{
                System.out.println("You don't have enough credits to place a bet");
            }
*/
// make the visual roulette magic



// run rouletteRules()



// check if the user is wins or not
// payout prizemoney or deduct loss from user balance
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

        }

        void initLayout(){
            Textbox message = new Textbox();
            message.W = 400;
            message.H = 200;
            message.X = width/15+650;
            message.Y = height/5-50;

            Textbox input = new Textbox();
            input.W = 400;
            input.H = 200;
            input.X = width/15+1050;
            input.Y = height/5+150;



        }







//    }
/*
   private int placeBet( User.makeBet()){



        return makeBet;
    }
*/
    private void rouletteRules(){



    }





//    private int payOut(User.recievePrizeMoney()){



//    }



    public static void main (String[] Args){
        PApplet.main("Roulette");

    }


}
