import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RouletteWheel {

private int value;
private String colour;
Random random;

private ArrayList<Roulettefields> wheelData = new ArrayList<>();

public void Wheel(){
 value = 0;
 colour = null;
 random = new Random();
 wheelData = readWheelData();
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

    public ArrayList<Roulettefields> readWheelData(){
        ArrayList<Roulettefields> values = new ArrayList<>();
        String header;
        try {
            Scanner scan = new Scanner(new File(""));
            header = scan.nextLine();
            while (scan.hasNextLine()){
                String s = scan.nextLine();
                String [] dataSet = s.split(", ");
                int ID = Integer.parseInt(dataSet[0]);
                int value = Integer.parseInt(dataSet[1]);
                String color = dataSet[3];
                String even = dataSet[4];
                Roulettefields r = new Roulettefields(ID, value,color, even);
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
