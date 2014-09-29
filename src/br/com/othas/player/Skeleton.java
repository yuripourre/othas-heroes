package br.com.othas.player;

import br.com.othas.model.NPC;


public class Skeleton extends NPC {

	public Skeleton(int x, int y) {
		super(x, y, "mv/skeleton.png", "mv/skeleton_inv.png");
		
		currentSpeed = 3;
	}

}
