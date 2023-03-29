package backend;

import java.util.ArrayList;

public class UnoGame {
    private ArrayList<Player> players;
    private CardPile pile = new CardPile();

    public UnoGame(int numPlayers){
        players.add(new HumanPlayer());
        for(int i = 0; i < numPlayers - 1; i++){
            players.add(new ComputerPlayer());
        }
    }

    public void playGame(int player){
        if(!finished()){
            players.get(player).drawCard(players.get(player).getHand(), true);
        }
    }

    public void playGame(int player, Card c){
        if(!finished() && pile.canPlace(c)){
            if(c.getNum() == Card.PLUS_FOUR){
                pile.plusFour();
            } else if(c.getNum() == Card.PLUS_TWO){
                pile.plusTwo();
            }
            pile.addCard(players.get(player).placeCard(players.get(player).getHand(), c));
        }
    }

    private boolean finished(){
        for(Player p : players){
            if(p.win(p.getHand()))
                return true;
        }
        return false;
    }
}
