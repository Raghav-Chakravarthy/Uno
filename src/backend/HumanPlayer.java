package backend;

public class HumanPlayer extends Player{
    public void drawCard(Hand playerHand, boolean draw){
        if(draw)
            playerHand.addCard();
    }

    public Card placeCard(Hand playerHand, Card place){
        return playerHand.remove(place);
    }

    public Card placeCard(Hand playerHand, int index){
        return playerHand.remove(index);
    }

    public boolean uno(Hand playerHand){
        return playerHand.size() == 1;
    }

    public boolean win(Hand playerHand){
        return playerHand.size() == 0;
    }
}
