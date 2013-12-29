package br.com.othas.player;

import br.com.othas.model.Hero;
import br.com.tide.platform.player.Player;



public class Adventurer extends Hero{
	
	public Adventurer(int x, int y) {
		super(x, y, "mv/adventurer.png", "mv/adventurer_inv.png");
	}
	
	@Override
	public float calculateDefenseDamage(Player attacker){
		
		return -1;
	}
	
}
