package backend;

public class Player {
    private Hand hand;

    public Player(){
        this.hand = new Hand(5);
    }

    public void drawCard(Hand playerHand, boolean draw){
        if(draw)
            playerHand.addCard();
    }

    public Card placeCard(Hand playerHand, Card place){
        return playerHand.remove(place);
    }

    public boolean uno(Hand playerHand){
        return playerHand.size() == 1;
    }

    public boolean win(Hand playerHand){
        return playerHand.size() == 0;
    }

    public Hand getHand(){
        return this.hand;
    }

    public boolean hasCard(Card c){
        return this.hand.contains(c);
    }
}
