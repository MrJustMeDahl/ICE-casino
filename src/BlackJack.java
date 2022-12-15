import processing.core.*;

import java.util.ArrayList;

public class BlackJack extends CardGames {
    public static boolean blackjackRunning = false;
    private PImage img;
    private PFont menuFont;
    private int betAmount = 250;
    private boolean betMade = false;
    private boolean gameInProgress = false;
    private boolean gameOver = false;
    private boolean playersTurn = true;
    private boolean displayWinnerMessage = false;
    private boolean hitPressed = false;
    private String winnerText;
    private int hitTimer;
    private ArrayList<Card> playerHand = new ArrayList<>();
    private ArrayList<Card> dealerHand = new ArrayList<>();

    public BlackJack(String name, CardDeck currentDeck, PApplet sketch) {
        super(name, currentDeck, sketch);
        img = sketch.loadImage("Pictures/BlackjackPictures/Blackjack.jpg");
        menuFont = sketch.createFont("Georgia", 25);
    }

    @Override
    public void startGame() {
        if (blackjackRunning) {
            sketch.image(img, 0, 0, 1600, 900);
            displayUserInfo();
            if(displayWinnerMessage){
                sketch.fill(255, 150);
                sketch.rect(sketch.width / 2 + 100, 450, 1100, 250, 40);
                sketch.fill(0);
                sketch.text(winnerText, sketch.width / 2 + 100, 455);
            }
            if (!betMade) {
                if(displayWinnerMessage){
                    displayHands(playerHand, dealerHand);
                }
                chooseBet();
            } else {
                runGame();
            }
            stopGame();
        }
    }

    @Override
    public void stopGame() {
        sketch.fill(255, 150);
        sketch.rect(150, 840, 125, 50, 40);
        sketch.textSize(18);
        sketch.fill(0);
        sketch.text("Exit game", 150, 845);
        if (sketch.mousePressed && sketch.mouseX > 150 - (125 / 2) && sketch.mouseX < 150 + (125 / 2) && sketch.mouseY > 840 - 25 && sketch.mouseY < 840 + 25) {
            blackjackRunning = false;
            MainMenu.mainMenuRunning = true;
            newRound();
        }
    }

    @Override
    public void chooseBet() {
        sketch.fill(255, 150);
        sketch.rect(150, 350, 200, 80, 40);
        sketch.rect(100, 420, 100, 40, 40);
        sketch.rect(200, 420, 100, 40, 40);
        sketch.textSize(25);
        sketch.fill(0);
        sketch.text("" + betAmount, 150, 360);
        sketch.textSize(18);
        sketch.text("Decrease", 100, 425);
        sketch.text("Increase", 200, 425);
        if (sketch.mousePressed && sketch.mouseX > 50 && sketch.mouseX < 150 && sketch.mouseY > 400 && sketch.mouseY < 440) {
            if (betAmount <= 0) {
                betAmount = 0;
            } else {
                betAmount -= 250;
            }
        }
        if (sketch.mousePressed && sketch.mouseX > 150 && sketch.mouseX < 250 && sketch.mouseY > 400 && sketch.mouseY < 440) {
            if (betAmount + 250 >= ProgramControl.currentUser.getBalance()) {
                betAmount = (int) (ProgramControl.currentUser.getBalance());
            } else {
                betAmount += 250;
            }
        }
        sketch.fill(255, 150);
        sketch.rect(150, 475, 200, 50, 40);
        sketch.textSize(25);
        sketch.fill(0);
        sketch.text("Make bet", 150, 485);
        if (sketch.mousePressed && sketch.mouseX > 50 && sketch.mouseX < 250 && sketch.mouseY > 450 && sketch.mouseY < 500) {
            betMade = true;
            displayWinnerMessage = false;
            playersTurn = true;
            playerHand.removeAll(playerHand);
            dealerHand.removeAll(dealerHand);
            ProgramControl.currentUser.makeBet(betAmount);
        }
    }

    @Override
    public int calculatePrizeMoney() {
        int prizeMoney = betAmount * 2;
        ProgramControl.currentUser.receiveMoney(prizeMoney);
        return prizeMoney;
    }

    @Override
    public void newRound() {
        currentDeck.addUsedCards();
        betMade = false;
        gameOver = false;
        gameInProgress = false;
    }

    private void displayUserInfo() {
        sketch.fill(255, 255, 255, 150);
        sketch.rectMode(sketch.CENTER);
        sketch.rect(150, 100, 280, 180, 40);
        sketch.textAlign(sketch.CENTER);
        sketch.textFont(menuFont);
        sketch.fill(0);
        sketch.text("You are now playing\n" + name + "\nCash:\n" + ProgramControl.currentUser.getBalance() + "", 150, 50);
    }

    private void runGame() {
        drawPlayingLayout();
        for (Card c : currentDeck.getCards()) {
            if (c.getName() != null) {
                if (c.getName().equals("Knight") || c.getName().equals("Queen") || c.getName().equals("King")) {
                    c.setValue(10);
                }
                if (c.getName().equals("Ace")) {
                    c.setValue(11);
                }
            }
        }
        if (!gameInProgress) {
            currentDeck.shuffleCards();
            int startHand = 2;
            while (playerHand.size() < startHand && dealerHand.size() < startHand) {
                playerHand.add(currentDeck.drawTopCard());
                dealerHand.add(currentDeck.drawTopCard());
            }
            gameInProgress = true;
        }
        displayHands(playerHand, dealerHand);
        if (playersTurn) {
            if (sketch.mousePressed && sketch.mouseX > 50 && sketch.mouseX < 250 && sketch.mouseY > 290 && sketch.mouseY < 410) {
                hitTimer = sketch.millis();
                if(!hitPressed) {
                    playerHand.add(currentDeck.drawTopCard());
                    hitPressed = true;
                }
                if (getHandValue(playerHand) > 21) {
                    for (Card c : playerHand) {
                        if (c.getValue() == 11) {
                            c.setValue(1);
                            break;
                        }
                    }
                }
                if (getHandValue(playerHand) > 21) {
                    playersTurn = false;
                }
            }
            if (sketch.mousePressed && sketch.mouseX > 50 && sketch.mouseX < 250 && sketch.mouseY > 540 && sketch.mouseY < 660) {
                playersTurn = false;
            }
        }
        if (!playersTurn) {
            while (getHandValue(dealerHand) < getHandValue(playerHand) && getHandValue(playerHand) <= 21) {
                if (getHandValue(dealerHand) > 21) {
                    for (Card c : dealerHand) {
                        if (c.getValue() == 11) {
                            c.setValue(1);
                            break;
                        }
                    }
                }
                dealerHand.add(currentDeck.drawTopCard());
            }
            winnerText = whoWon();
            displayWinnerMessage = true;
            gameOver = true;
        }
        if (gameOver) {
            newRound();
        }
        System.out.println(sketch.millis() + " " + hitTimer);
        if(sketch.millis() <= hitTimer + 1000){
            hitPressed = false;
        }
    }

    private void drawPlayingLayout() {
        sketch.fill(0, 200, 0, 150);
        sketch.rect(150, 350, 200, 120, 40);
        sketch.fill(200, 0, 0, 150);
        sketch.rect(150, 600, 200, 120, 40);
        sketch.fill(255, 150);
        sketch.rect(sketch.width / 2 + 100, 610, 300, 28, 40);
        sketch.rect(sketch.width / 2 + 100, 750, 1100, 250, 40);
        sketch.rect(sketch.width / 2 + 100, 150, 1100, 250, 40);
        sketch.rect(sketch.width / 2 + 100, 290, 300, 28, 40);
        sketch.fill(0);
        sketch.textSize(30);
        sketch.text("Hit", 150, 365);
        sketch.text("Stand", 150, 615);
        sketch.text("Your cards:", sketch.width / 2 + 100, 620);
        sketch.text("Dealer's Cards:", sketch.width / 2 + 100, 300);
    }

    private void displayHands(ArrayList<Card> playerHand, ArrayList<Card> dealerHand) {
        int cardPlacement = 450;
        for (Card c : playerHand) {
            sketch.fill(255);
            sketch.rect(cardPlacement, 750, 150, 200, 40);
            sketch.fill(0);
            if (c.getName() == null) {
                sketch.text(c.getSuits() + "\n" + c.getValue(), cardPlacement, 750);
            } else if (c.getName() != null) {
                sketch.text(c.getName() + " of\n" + c.getSuits() + "\n" + c.getValue(), cardPlacement, 725);
            }
            cardPlacement += 155;
        }
        cardPlacement = 450;
        for (Card c : dealerHand) {
            sketch.fill(255);
            sketch.rect(cardPlacement, 150, 150, 200, 40);
            sketch.fill(0);
            if (c.getName() == null) {
                sketch.text(c.getSuits() + "\n" + c.getValue(), cardPlacement, 150);
            } else if (c.getName() != null) {
                sketch.text(c.getName() + " of\n" + c.getSuits() + "\n" + c.getValue(), cardPlacement, 125);
            }
            cardPlacement += 155;
        }
        cardPlacement = 450;
        if (playersTurn) {
            sketch.fill(255);
            sketch.rect(cardPlacement, 150, 150, 200, 40);
        }
    }

    private int getHandValue(ArrayList<Card> hand) {
        int totalHandValue = 0;
        for (Card c : hand) {
            totalHandValue += c.getValue();
        }
        return totalHandValue;
    }

    private String whoWon() {
        if (getHandValue(playerHand) <= 21 && getHandValue(dealerHand) < 22) {
            if (getHandValue(playerHand) > getHandValue(dealerHand)) {
                return "" + ProgramControl.currentUser.getUsername() + " won\nYour payout is: " + calculatePrizeMoney();
            }
        }
        if(getHandValue(playerHand) <= 21 && getHandValue(dealerHand) > 21){
            return "" + ProgramControl.currentUser.getUsername() + " won\nYour payout is: " + calculatePrizeMoney();
        }
        if (getHandValue(playerHand) == getHandValue(dealerHand)) {
            return "This round is a draw.";
        }
        return "Dealer won.\nBetter luck next time.";
    }
}