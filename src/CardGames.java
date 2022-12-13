import processing.core.PApplet;

public abstract class CardGames implements AllGames{

    private boolean hasWon = false;
    private String name;
    private CardDeck currentDeck;
    protected PApplet sketch;

    public CardGames(String name, CardDeck currentDeck, PApplet sketch){
        this.name = name;
        this.currentDeck = currentDeck;
        this.sketch = sketch;
    }

    public abstract void startGame();

    public abstract void stopGame();

    public abstract void chooseBet();

    public abstract void calculatePrizeMoney();

    public abstract void newRound();
}
