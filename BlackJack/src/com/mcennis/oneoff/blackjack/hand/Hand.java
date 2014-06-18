package com.mcennis.oneoff.blackjack.hand;

import java.util.Vector;

import com.mcennis.oneoff.blackjack.cards.Card;

public interface Hand {
	public int getTotal();
	
	public void addCard(Card c);
	
	public Vector<Card> showHand();
}
