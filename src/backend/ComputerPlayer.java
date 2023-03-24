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
}
