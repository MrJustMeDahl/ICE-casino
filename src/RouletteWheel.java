import processing.core.PApplet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RouletteWheel {

private int value;
private String color;
Random random;
PApplet sketch;

private ArrayList<Roulettefields> wheelData = readWheelData();

public  RouletteWheel(PApplet sketch) {
    value = 0;
    color = null;
    random = new Random();
    this.sketch = sketch;
}


public int getValue(){
    return value;
}

public void setValue (int value){
    this.value = value;
}

public String getColor(){
    return color;
}

    public ArrayList<Roulettefields> readWheelData(){
        ArrayList<Roulettefields> values = new ArrayList<>();
        String header;
        try {
            Scanner scan = new Scanner(new File("Data/RouletteData/Roulette.txt"));
            header = scan.nextLine();
            while (scan.hasNextLine()){
                String s = scan.nextLine();
                String [] dataSet = s.split(", ");
                int ID = Integer.parseInt(dataSet[0]);
                int value = Integer.parseInt(dataSet[1]);
                String color = dataSet[2];
                String even = dataSet[3];
                Roulettefields r = new Roulettefields(ID, value,color, even,sketch);
                values.add(r);
            }
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
        return values;
    }

    public ArrayList<Roulettefields> getWheelData() {
        return wheelData;
    }

}
