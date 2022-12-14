public abstract class CardGames implements AllGames{

    private boolean hasWon = false;
    private String name;
    private CardDeck currentDeck;

    public CardGames(String name){
        this.name = name;

    }

    public abstract void startGame();

    public abstract void stopGame();

    public abstract void chooseBet();

    public abstract void calculatePrizeMoney();

    public abstract void newRound();
}
