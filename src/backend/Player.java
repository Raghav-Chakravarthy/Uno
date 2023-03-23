package backend;

public class Player {
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
}
