package br.com.othas.player;

import br.com.othas.model.Hero;
import br.com.tide.ActivePlayer;
import br.com.tide.platform.player.PlatformPlayer;



public class Adventurer extends Hero {
	
	public Adventurer(int x, int y) {
		super(x, y, "mv/adventurer.png", "mv/adventurer_inv.png");
	}
	
	@Override
	public float calculateDefenseDamage(ActivePlayer attacker) {
		
		return -1;
	}
	
}
