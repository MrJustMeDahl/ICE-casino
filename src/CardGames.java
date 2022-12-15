import processing.core.PApplet;

public abstract class CardGames implements AllGames{

    private boolean hasWon = false;
    protected String name;
    protected CardDeck currentDeck;
    protected PApplet sketch;

    public CardGames(String name, CardDeck currentDeck, PApplet sketch){
        this.name = name;
        this.currentDeck = currentDeck;
        this.sketch = sketch;
    }

    public abstract void startGame();

    public abstract void stopGame();

    public abstract void chooseBet();

    public abstract int calculatePrizeMoney();

    public abstract void newRound();
}
