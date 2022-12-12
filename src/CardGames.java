public abstract class CardGames implements AllGames{

    private boolean hasWon;
    private String name;
    CardDeck currenDeck;

    public CardGames(boolean hasWon, String name){
        this.hasWon = hasWon;
        this.name = name;

    }

    @Override
    public void startGame() {

    }

    @Override
    public void stopGame() {

    }

    @Override
    public void chooseBet() {

    }

    @Override
    public void calculatePrizeMoney() {

    }

    @Override
    public void newRound() {

    }
}
