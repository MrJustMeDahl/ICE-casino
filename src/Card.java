public class Card extends CardGames{

    private String name;
    private String suits;
    private int value;

    public Card(boolean hasWon, String name, String suits, int value){
        super(hasWon, name);
        this.suits = suits;
        this.value = value;
    }


    public String getName() {
        return name;
    }

    public String getSuits() {
        return suits;
    }

    public int getValue() {
        return value;
    }
}
