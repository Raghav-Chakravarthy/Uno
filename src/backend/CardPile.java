package backend;

import java.util.ArrayList;

public class CardPile {
    private ArrayList<Card> pile;
    private int plusTwoCount = 0, plusFourCount = 0;
    
    public CardPile(){
        pile = new ArrayList<Card>();
        pile.add(new Card());
    }

    public int getTopColor(){
        return this.pile.get(this.pile.size()-1).getColor();
    }

    public int getTopNum(){
        return this.pile.get(this.pile.size()-1).getNum();
    }

    public void setTopColor(int color){
        this.pile.get(this.pile.size()-1).setColor(color);
    }

    public void addCard(Card c){
        if(this.canPlace(c)){
            pile.add(c);
        }
    }

    public int getPlusTwo(){
        return this.plusTwoCount;
    }

    public int getPlusFour(){
        return this.plusFourCount;
    }

    public void plusTwo(){
        this.plusTwoCount += 2;
    }

    public void plusFour(){
        this.plusFourCount += 4;
    }

    public boolean canPlace(Card c){
        if(plusTwoCount >= 0 && c.getNum() == Card.PLUS_TWO) return true;
        else if(plusFourCount >= 0 && c.getNum() == Card.PLUS_FOUR) return true;
        else if(pile.get(pile.size()-1).getColor() == c.getColor()) return true;
        else if(c.getNum() == pile.get(pile.size() - 1).getNum()) return true;
        else if(c.getNum() == Card.WILD) return true;
        else if(c.getNum() == Card.PLUS_FOUR) return true;
        return false;
    }
}
