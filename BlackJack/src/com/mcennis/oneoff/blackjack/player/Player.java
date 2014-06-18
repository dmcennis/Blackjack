package com.mcennis.oneoff.blackjack.player;

import java.util.HashMap;

public interface Player {
	public int[] handTotal();
	
	public void exit();
	
	public void join(HashMap<String,Object> properties);
	
	public void bet(int value);
	
	public void stay(int hand);
	
	public void hit(int hand);
	
	public void split(int hand);
	
	public void registerController(PlayerController controller);
	
	public void changeCoin(int coin);
	
	public void decide(int hand);
}
