package backend;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand = new ArrayList<Card>();

    public Hand(int start){
        for(int i = 0; i < start; i++)
			addCard();
    }

    public int size() {
		return hand.size();
	}

	public Card nthCard(int n) {
		return hand.get(n);
	}

	public Card remove(Card c){
		return hand.remove(hand.indexOf(c));
	}

	public void print() {
		for(Card p : hand)
			System.out.println(p);
	}

	public void addCard(Card card){
		hand.add(card);
	}

	public void addCard(){
		addCard(new Card());
	}

    public boolean contains(Card c1){
        for(Card c : hand){
            if(c.getNum() == c1.getNum() && c.getColor().equals(c1.getColor())){
                return true;
            }
        }
        return false;
    }
}
