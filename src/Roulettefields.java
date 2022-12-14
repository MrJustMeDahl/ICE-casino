import processing.core.*;
public class Roulettefields extends PApplet{
    private int ID;
    private int value;
    private int color;
    private boolean even;
    PApplet sketch;


    public Roulettefields(int ID, int value, String color, String even, PApplet sketch) {
        this.ID = ID;
        this.value = value;
        this.sketch = sketch;
        switch(color){

            case "red":
                this.color = 1;

            break;

            case "black":
                this.color = 2;

            break;

            case "green":
                this.color = 3;

            break;

            default:
                throw new RuntimeException("fail to load roulette data");


        }

        switch(even){
            case "true":
                this.even = true;

                break;

            case "false":
                this.even = false;

                break;

            default:
                throw new RuntimeException("fail to load roulette data");


        }

    }


    public void drawfield(int x, int y){



            switch (color) {

                case 1:
                    sketch.fill(100, 0, 0);

                    break;

                case 2:
                    sketch.fill(0, 0, 0);

                    break;

                case 3:
                    sketch.fill(0, 100, 0);

                    break;

                default:
                    throw new RuntimeException("fail to load roulette data");
            }

            rect(x, y, 75, 75);
            textAlign(CENTER);
            fill(255);
            text("" + value, x + 75 / 2, y + (75 / 2) + 5);


        }





}
