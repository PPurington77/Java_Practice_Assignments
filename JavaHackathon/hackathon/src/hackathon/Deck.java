package hackathon;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	
    public Deck() {
        this.cards = new ArrayList<Card>();

        // Populate the cards list -- loop to 52
        for (String name : new String[] {"Hearts", "Clubs", "Diamonds", "Spades"}) {
            for (Integer rank = 1; rank <= 13; rank++) {
                this.cards.add(new Card(name, rank));
            }
        }
    }

	public ArrayList<Card> getCards() {
		//assign two cards to player randomly;
		ArrayList<Card> hand = new ArrayList<Card>();
		Random randomCard = new Random();
		int deckSize = this.cards.size();
		int temp = randomCard.nextInt(temp);
		for(int i = 0; i <= temp; i++) {
			if(i == temp) {
				Card card = this.cards;
				this.hand.add(this.cards(name, rank));
			}
		}
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
//	public void removeCard(ArrayList<Card> cards)
    
}