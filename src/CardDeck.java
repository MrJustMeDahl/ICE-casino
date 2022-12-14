import java.util.ArrayList;
import java.util.Random;

public class CardDeck{
    private int cardAmount;
    private int highestCardValue;
    private int suits;
    private boolean aces;
    private boolean pictureCards;
    private ArrayList<Card> cards;
    private ArrayList<Card> usedCards = new ArrayList<>();
    public CardDeck(int highestCardValue, int suits, boolean aces, boolean pictureCards) {
        this.highestCardValue = highestCardValue;
        this.suits = suits;
        this.aces = aces;
        this.pictureCards = pictureCards;
        this.cardAmount = highestCardValue * suits;
        if(aces){
            this.cardAmount += suits;
        }
        if(pictureCards){
            this.cardAmount += suits*3;
        }
        this.cards = fillCardDeck();
    }

    public ArrayList<Card> shuffleCards(){
        ArrayList<Card> shuffledDeck = new ArrayList<>();
        Random r = new Random();
        for(int i = 0; i < cardAmount; i++) {
            int randomCard = r.nextInt(0, cards.size());
            shuffledDeck.add(cards.get(randomCard));
            cards.remove(randomCard);
        }
        cards = shuffledDeck;
        return shuffledDeck;
    }

    public Card drawTopCard(){
        Card topCard = cards.get(0);
        cards.remove(topCard);
        usedCards.add(topCard);
        return topCard;
    }

    public void addUsedCards(){
        for(Card c : usedCards){
            cards.add(c);
            usedCards.remove(c);
        }
    }

    private ArrayList<Card> fillCardDeck(){
        ArrayList<Card> generatedCards = new ArrayList<>();
        switch(suits) {
            case 1:
                for (Card c : generateHearts()) {
                    generatedCards.add(c);
                }
            break;
            case 2:
                for (Card c : generateHearts()) {
                    generatedCards.add(c);
                }
                for (Card c : generateClubs()) {
                    generatedCards.add(c);
                }
            break;
            case 3:
                for (Card c : generateHearts()) {
                    generatedCards.add(c);
                }
                for (Card c : generateClubs()) {
                    generatedCards.add(c);
                }
                for (Card c : generateDiamonds()){
                    generatedCards.add(c);
                }
            break;
            case 4:
                for (Card c : generateHearts()) {
                    generatedCards.add(c);
                }
                for (Card c : generateClubs()) {
                    generatedCards.add(c);
                }
                for (Card c : generateDiamonds()){
                    generatedCards.add(c);
                }
                for (Card c : generateSpades()){
                    generatedCards.add(c);
                }
            break;
        }
        if(aces){
            for (Card c : generateAces()){
                generatedCards.add(c);
            }
        }
        if(pictureCards){
            for (Card c : generatePictureCards()){
                generatedCards.add(c);
            }
        }
        return generatedCards;
    }

    private ArrayList<Card> generateHearts(){
        ArrayList<Card> generatedCards = new ArrayList<>();
        for(int i = 0; i < highestCardValue; i++){
            Card card = new Card("Hearts", i+1);
            generatedCards.add(card);
        }
        return generatedCards;
    }

    private ArrayList<Card> generateClubs(){
        ArrayList<Card> generatedCards = new ArrayList<>();
        for(int i = 0; i < highestCardValue; i++){
            Card card = new Card("Clubs", i+1);
            generatedCards.add(card);
        }
        return generatedCards;
    }

    private ArrayList<Card> generateDiamonds(){
        ArrayList<Card> generatedCards = new ArrayList<>();
        for(int i = 0; i < highestCardValue; i++){
            Card card = new Card("Diamonds", i+1);
            generatedCards.add(card);
        }
        return generatedCards;
    }

    private ArrayList<Card> generateSpades(){
        ArrayList<Card> generatedCards = new ArrayList<>();
        for(int i = 0; i < highestCardValue; i++){
            Card card = new Card("Spades", i+1);
            generatedCards.add(card);
        }
        return generatedCards;
    }

    private ArrayList<Card> generateAces(){
        ArrayList<Card> generatedCards = new ArrayList<>();
        switch(suits){
            case 1:
                generatedCards.add(new Card("Ace", "Hearts", 14));
                break;
            case 2:
                generatedCards.add(new Card("Ace", "Hearts", 14));
                generatedCards.add(new Card("Ace", "Clubs", 14));
                break;
            case 3:
                generatedCards.add(new Card("Ace", "Hearts", 14));
                generatedCards.add(new Card("Ace", "Clubs", 14));
                generatedCards.add(new Card("Ace", "Diamonds", 14));
                break;
            case 4:
                generatedCards.add(new Card("Ace", "Hearts", 14));
                generatedCards.add(new Card("Ace", "Clubs", 14));
                generatedCards.add(new Card("Ace", "Diamonds", 14));
                generatedCards.add(new Card("Ace", "Spades", 14));
                break;
        }
        return generatedCards;
    }

    private ArrayList<Card> generatePictureCards(){
        ArrayList<Card> generatedCards = new ArrayList<>();
        switch(suits){
            case 1:
                for(Card c: generatePictureCards("Hearts")){
                    generatedCards.add(c);
                }
                break;
            case 2:
                for(Card c: generatePictureCards("Hearts")){
                    generatedCards.add(c);
                }
                for(Card c: generatePictureCards("Clubs")){
                    generatedCards.add(c);
                }
                break;
            case 3:
                for(Card c: generatePictureCards("Hearts")){
                    generatedCards.add(c);
                }
                for(Card c: generatePictureCards("Clubs")){
                generatedCards.add(c);
                }
                for(Card c: generatePictureCards("Diamonds")){
                generatedCards.add(c);
                }
                break;
            case 4:
                for(Card c: generatePictureCards("Hearts")){
                    generatedCards.add(c);
                }
                for(Card c: generatePictureCards("Clubs")){
                    generatedCards.add(c);
                }
                for(Card c: generatePictureCards("Diamonds")){
                    generatedCards.add(c);
                }
                for(Card c: generatePictureCards("Spades")){
                    generatedCards.add(c);
                }
                break;
        }
        return generatedCards;
    }

    private ArrayList<Card> generatePictureCards(String suits){
        ArrayList<Card> generatedCards = new ArrayList<>();
        generatedCards.add(new Card("Knight", suits, 11));
        generatedCards.add(new Card("Queen", suits, 12));
        generatedCards.add(new Card("King", suits, 13));
        return generatedCards;
    }
}
