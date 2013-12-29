package br.com.othas;


import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.core.application.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.video.Graphic;
import br.com.othas.model.Character;
import br.com.othas.model.Hero;
import br.com.othas.player.Adventurer;
import br.com.othas.player.Ninja;
import br.com.othas.player.Satyr;
import br.com.othas.player.Skeleton;
import br.com.tide.input.controller.EasyController;
import br.com.tide.input.controller.FirstPlayerController;

public class OthasHeroes extends Application{

	public OthasHeroes(int w, int h) {
		super(w, h);
	}
	
	private Skeleton skeleton;
	
	private Ninja ninja;
	
	private Hero hero;
	
	private Satyr satyr;
	
	private List<Character> players = new ArrayList<Character>();
	
	private List<Character> enemies = new ArrayList<Character>();
	
	@Override
	public void load() {
		
		loading = 10;

		ninja = new Ninja(115, 220);
		ninja.setController(new EasyController());
		
		hero = new Adventurer(85, 250);
		//hero.setController(new FirstPlayerController());
		
		satyr = new Satyr(85, 200);
		satyr.setController(new FirstPlayerController());
		
		players.add(hero);
		
		skeleton = new Skeleton(200, 120);
		
		enemies.add(skeleton);
				
		loading = 100;
		
		updateAtFixedRate(50);
		
	}
	
	@Override
	public void timeUpdate(long now){
		ninja.update(now, enemies);
		hero.update(now, enemies);
		satyr.update(now, enemies);
		
		skeleton.update(now, players);		
	}

	@Override
	public void draw(Graphic g) {
		
		//Order to draw
		
		ninja.draw(g);
		hero.draw(g);		
		satyr.draw(g);
		skeleton.draw(g);		
	}
	

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		
		ninja.handleEvent(event);
		//hero.handleEvent(event);
		
		satyr.handleEvent(event);
		
		return null;
	}

}