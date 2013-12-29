package br.com.othas.player;

import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.util.SVGColor;
import br.com.othas.model.Character;
import br.com.othas.model.Hero;


public class Satyr extends Hero{

	private List<Hero> summons = new ArrayList<Hero>();
	
	public Satyr(int x, int y) {
		super(x, y, "mv/satyr.png", "mv/satyr_inv.png");
	}
	
	@Override
	public void onSpecialAttack() {
		
		Satyr summon = new Satyr((int)x-20, (int)y-20);
		summon.lifeBarColor = SVGColor.ALICE_BLUE;
		
		summons.add(summon);
	}
	
	public void draw(Graphic g) {
		super.draw(g);
		
		for(Hero summon: summons){
			summon.draw(g);				
		}
		
	}
	
	public void update(long now, List<Character> targets) {
		super.update(now, targets);
				
		for(Hero summon: summons){
			summon.updateAsNPC(now, targets);				
		}
		
	}
	
}
