public class Bets {

private int bet;
private int value;
private int color;
private boolean even;

    public Bets(int bet, int value, int color, boolean even) {
        this.bet = bet;
        this.value = value;
        this.color = color;
        this.even=even;
    }

    public Bets(int bet, int value, int color) {
        this.bet = bet;
        this.value = value;
        this.color = color;
    }

    public int getBet() {
        return bet;
    }

    public int getvalue() {
        return value;
    }

    public int getColor() {
        return color;
    }

    public boolean isEven() {
        return even;
    }
}
