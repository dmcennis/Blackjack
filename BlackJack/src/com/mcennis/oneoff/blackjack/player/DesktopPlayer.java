package com.mcennis.oneoff.blackjack.player;

import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import com.mcennis.oneoff.blackjack.hand.Hand;

public class DesktopPlayer implements Player {
	private Vector<Hand> hands = new Vector<Hand>();
	private int coins = 100;
	private int bet = 0;
	private PlayerController controller;

	public DesktopPlayer() {
		System.out.println("What is your name?");
		byte[] data = new byte[2048];
		try {
			System.in.read(data, 0, 2048);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		String name = new String(data, 0, 2048);
		controller = new ConsolePlayerController(name);
	}

	@Override
	public int[] handTotal() {
		int[] ret = new int[hands.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = hands.get(i).getTotal();
		}
		controller.handTotal(ret);
		return ret;
	}

	@Override
	public void exit() {
		controller.exit();
		hands.clear();
		bet = 0;
	}

	@Override
	public void join(HashMap<String, Object> properties) {
		controller.join(properties);

	}

	@Override
	public void bet(int value) {
		bet = value;
		controller.bet(value);

	}

	@Override
	public void stay(int hand) {
		controller.stay(hand, hands.size());

	}

	@Override
	public void hit(int hand) {
		controller.hit(hand, hands.size());
	}

	@Override
	public void split(int hand) {
		controller.split(hand, hands.size());
	}

	@Override
	public void registerController(PlayerController controller) {
		this.controller = controller;

	}

	@Override
	public void changeCoin(int coin) {
		this.coins += coin;

	}

	public void decide(int hand) {
		boolean done = false;
		while (!done) {
			switch (controller.decide(hand, hands.size(), hands.get(hand)
					.getTotal())) {
			case 0:
				stay(hand);
				done = true;
				break;
			case 1:
				bet(hand);
				done = true;
				break;
			case 2:
				if (canSplit(hand)) {
					split(hand);
					done = true;
				}
			}
		}
	}

	protected boolean canSplit(int hand) {
		if ((hands.get(hand).showHand().size() == 2)
				&& (hands.get(hand).showHand().get(0).getCardType() == hands
						.get(hand).showHand().get(1).getCardType())) {
			return true;
		} else {
			return false;
		}
	}
}
