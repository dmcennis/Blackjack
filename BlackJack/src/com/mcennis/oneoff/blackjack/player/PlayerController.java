package com.mcennis.oneoff.blackjack.player;

import java.util.HashMap;

public interface PlayerController {
	public void handTotal(int[] handTotal);
	
	public void exit();
	
	public void bet(int value);
	
	public void stay(int hand, int handCount);
	
	public void hit(int hand, int handCount);
	
	public void split(int hand, int handCount);
	
	public void join(HashMap<String, Object> properties);
	
	public int decide(int hand, int handCount, int handTotal);

}
