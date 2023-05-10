package backend;

public class ComputerPlayer extends Player{
    public void drawCard(Hand playerHand, boolean draw){
        try {
            Thread.sleep((long)(Math.random() * 4000) + 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(draw)
            playerHand.addCard();
    }

    public Card placeCard(Hand playerHand, Card place){
        try {
            Thread.sleep((long)(Math.random() * 4000) + 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return playerHand.remove(place);
    }

    public Card placeCard(Hand playerHand, int index){
        try {
            Thread.sleep((long)(Math.random() * 4000) + 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return playerHand.remove(index);
    }

    public int placeCard(Card topCard, int plusTwoCount, int plusFourCount){
        for(int i = 0; i < super.getHand().size(); i++){
            if(canPlace(topCard, super.getHand().getHand().get(i), plusTwoCount, plusFourCount)){
                return i;
            }
        }
        return -1;
    }

    private boolean canPlace(Card topCard, Card c, int plusTwoCount, int plusFourCount){
        if(plusTwoCount >= 0 &&  plusFourCount == 0 && c.getNum() == Card.PLUS_TWO) return true;
        else if(plusFourCount >= 0 && plusTwoCount == 0 && c.getNum() == Card.PLUS_FOUR) return true;
        else if(topCard.getColor() == c.getColor() && plusFourCount == 0 && plusTwoCount == 0) return true;
        else if(c.getNum() == topCard.getNum() && plusFourCount == 0 && plusTwoCount == 0) return true;
        else if(c.getNum() == Card.WILD && plusFourCount == 0 && plusTwoCount == 0) return true;
        else if(c.getNum() == Card.PLUS_FOUR && plusTwoCount == 0) return true;
        return false;
    }
    
}
