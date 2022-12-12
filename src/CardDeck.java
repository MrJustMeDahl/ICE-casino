public class CardDeck extends CardGames {

    private String name;
    private String suit;
    private int value;

    public CardDeck(boolean hasWon, String name, String suit, int value) {
        super(hasWon, name);
        this.suit = suit;
        this.value = value;
    }


    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
}
