import processing.core.*;
//file/project Structure/ + / finde Processing hovedmappe/core
//importer filen core.jar



public class Main extends PApplet{

    public void draw() {
        background(255);
        stroke(0);
        ellipse(height/2,width/2,100,60);

    }


   public void settings(){
        size(500,500);
    }


    public static void main(String[] args) {
   String [] appletArgs = new String[]{"Main"};
   if (args != null) {
   PApplet.main(concat(appletArgs,args));
   } else {
   PApplet.main(appletArgs);
   }

        
    }
}