package com.mcennis.oneoff.blackjack.cards;

public interface Card {
	enum CARD_TYPE {TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING,ACE,JOKER};
	
	enum SUIT {HEARTS,SPADES,CLUBS,DIAMONDS};
	
	public CARD_TYPE getCardType();
	
	public SUIT getSuit();
	
	public String getDeckID();
	
}
