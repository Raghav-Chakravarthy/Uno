package backend;

import java.util.ArrayList;

public class CardPile {
    private ArrayList<Card> pile;
    private int plusTwoCount = 0, plusFourCount = 0;
    private boolean SKIP = false;
    private boolean plusTwo = false;
    private boolean plusFour = false;

    public CardPile(){
        pile = new ArrayList<Card>();
        Card c = new Card();
        while(c.getNum() == Card.PLUS_FOUR || c.getNum() == Card.PLUS_TWO || c.getNum() == Card.SKIP || c.getNum() == Card.WILD){
            c = new Card();
        }
        pile.add(c);
    }

    public int getTopColor(){
        return this.pile.get(this.pile.size()-1).getColor();
    }

    public int getTopNum(){
        return this.pile.get(this.pile.size()-1).getNum();
    }

    public Card getTopCard(){
        return this.pile.get(this.pile.size()-1);
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

    public void resetPlusTwo(){
        this.plusTwoCount = 0;
    }

    public void resetPlusFour(){
        this.plusFourCount = 0;
    }
    public void plusTwo(){
        this.plusTwoCount += 2;
    }

    public void plusFour(){
        this.plusFourCount += 4;
    }

    public boolean getSkip(){
        return this.SKIP;
    }

    public void skip(){
        this.SKIP = true;
    }

    public void resetSkip(){
        this.SKIP = false;
    }

    /*public void plusTwo(){
        this.plusTwo = true;
    }

    public void resetPlusTwo(){
        this.plusTwo = false;
    }*/

    public boolean canPlace(Card c){
        if(plusTwoCount >= 0 &&  plusFourCount == 0 && c.getNum() == Card.PLUS_TWO) return true;
        else if(plusFourCount >= 0 && plusTwoCount == 0 && c.getNum() == Card.PLUS_FOUR) return true;
        else if(pile.get(pile.size()-1).getColor() == c.getColor() && plusFourCount == 0 && plusTwoCount == 0) return true;
        else if(c.getNum() == pile.get(pile.size() - 1).getNum() && plusFourCount == 0 && plusTwoCount == 0) return true;
        else if(c.getNum() == Card.WILD && plusFourCount == 0 && plusTwoCount == 0) return true;
        else if(c.getNum() == Card.PLUS_FOUR && plusTwoCount == 0) return true;
        return false;
    }
}
