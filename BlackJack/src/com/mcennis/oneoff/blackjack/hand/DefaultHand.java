package com.mcennis.oneoff.blackjack.hand;

import java.util.Vector;

import com.mcennis.oneoff.blackjack.cards.Card;

public class DefaultHand {
	private Vector<Card> hand = new Vector<Card>();
	
	public int getTotal(){
		int ace=0;
		int count=0;
		for(Card c : hand){
			switch(c.getCardType()){
			case TWO:
				count+=2;
				break;
			case THREE:
				count+=3;
				break;
			case FOUR:
				count+=4;
				break;
			case FIVE:
				count+=5;
				break;
			case SIX:
				count+=6;
				break;
			case SEVEN:
				count+=7;
				break;
			case EIGHT:
				count+=8;
				break;
			case NINE:
				count+=9;
				break;
			case TEN:
				count+=10;
				break;
			case JACK:
				count+=10;
				break;
			case QUEEN:
				count+=10;
				break;
			case KING:
				count+=10;
				break;
			case ACE:
				ace+=1;
				break;
			case JOKER:
				break;
			}
		}
		switch(ace){
		case 0:
			return count;
		case 1:
			if(count <= 10){
				return count+11;
			}else{
				return count+ace;
			}
		default:
			if(count < 10+(ace-1)){
				return count+ace+10;
			}else{
				return count+ace;
			}
		}
	}
	
	public void addCard(Card c){
		hand.add(c);
	}
	
	public Vector<Card> showHand(){
		return hand;
	}
	
}
