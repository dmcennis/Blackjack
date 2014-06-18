package com.mcennis.oneoff.blackjack.player;

import java.io.IOException;
import java.util.HashMap;

public class ConsolePlayerController implements PlayerController {
	String name;
	public ConsolePlayerController(String name){
		this.name = name;
	}
	@Override
	public void handTotal(int[] data) {
		// TODO Auto-generated method stub
		if(data.length==1){
			System.out.println(name+"'s hand total is "+data[0]);
		}else{
			for(int hand : data){
				System.out.println(name+"'s hand "+(data[hand]+1)+" total is "+data[hand]);
			}
		}
	}

	@Override
	public void exit() {
		

	}

	@Override
	public void bet(int value) {
		System.out.println(name+" bet "+value);

	}

	@Override
	public void stay(int hand,int handCount) {
		if(handCount == 0){
			System.out.println(name+" stays");
		}else{
			System.out.println(name+" stays in hand "+(hand+1));
		}

	}

	@Override
	public void hit(int hand, int handCount) {
		if(handCount == 0){
			System.out.println(name+" hits");
		}else{
			System.out.println(name+" hits in hand "+(hand+1));
		}
	}

	@Override
	public void split(int hand, int handCount) {
		if(handCount==0){
			System.out.println(name+" splits the hand");
		}else{
			System.out.println(name+" splits the "+(hand+1)+" hand");
		}
	}

	@Override
	public void join(HashMap<String, Object> properties) {
		System.out.println(name+" is playing the next hand");
	}

	public int decide(int hand, int handCount, int handTotal){
		if(handCount==1){
			System.out.println("Your hand total is "+handTotal);
		}else{
			System.out.println("Your hand total is "+handTotal+" in hand "+hand);
		}
		return displayDecide();
	}
	
	protected int displayDecide(){
		while(true){
			System.out.println("B for bet, S for stay, P for split, E for exit");
			byte[] data = new byte[6];
			try {
				System.in.read(data, 0, 6);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(-1);
			}
			String entry = new String(data,0,6);
			if(entry.matches("^[bB].*")){
				return 0;
			}else if(entry.matches("^[sS]")){
				return 1;
			}else if(entry.matches("^[pP]")){
				return 2;
			}else if(entry.matches("^[eE]")){
				return 3;
			}
		}
	}
}
