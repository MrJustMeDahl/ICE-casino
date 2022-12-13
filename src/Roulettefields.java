public class Roulettefields{
    private int ID;
    private int value;
    private int color;
    private boolean even;


    public Roulettefields(int ID, int value, String color, String even) {
        this.ID = ID;
        this.value = value;
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



}
