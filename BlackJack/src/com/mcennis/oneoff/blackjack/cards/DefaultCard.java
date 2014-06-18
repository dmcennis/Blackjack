package com.mcennis.oneoff.blackjack.cards;

import com.mcennis.oneoff.blackjack.deck.Deck;
import com.mcennis.oneoff.blackjack.cards.Card;
import com.mcennis.oneoff.blackjack.cards.Card.CARD_TYPE;
import com.mcennis.oneoff.blackjack.cards.Card.SUIT;

public class DefaultCard implements Card {

	CARD_TYPE type;
	
	SUIT suit;
	
	String id;
	
	
	public DefaultCard(CARD_TYPE t, SUIT s, Deck d){
		new DefaultCard(t,s,d,"default");
	}
	
	public DefaultCard(CARD_TYPE t, SUIT s, Deck d, String id){
		
	}
	
	@Override
	public CARD_TYPE getCardType() {
		return type;
	}

	@Override
	public SUIT getSuit() {
		return suit;
	}

	@Override
	public String getDeckID() {
		return id;
	}

}
