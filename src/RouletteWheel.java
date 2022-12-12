import java.util.Random;

public class RouletteWheel {

private int value;
private String colour;
Random random;

public void Wheel(){
 value = 0;
 colour = null;
 random = new Random();
}

public int getValue(){
    return value;
}

public void setValue (int value){
    this.value = value;
}

public String getColour(){
    return colour;
}

public void spin(){
    value = random.nextInt(39)+1;
    colour = (random.nextInt(1)==0)?"red":"black";
}






}
