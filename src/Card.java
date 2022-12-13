public class Card{

    private String name;
    private String suits;
    private int value;

    public Card(String suits, int value){
        this.suits = suits;
        this.value = value;
    }

    public Card(String name, String suits, int value){
        this.name = name;
        this.suits = suits;
        this.value = value;
    }

    public String getName(){
        return name;
    }
    public String getSuits() {
        return suits;
    }

    public int getValue() {
        return value;
    }
}
