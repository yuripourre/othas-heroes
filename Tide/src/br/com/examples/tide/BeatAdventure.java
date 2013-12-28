package br.com.examples.tide;


import java.util.ArrayList;
import java.util.List;

import quest.characters.Adventurer;
import quest.characters.Hero;
import quest.characters.Ninja;
import quest.characters.Satyr;
import quest.characters.enemy.Skeleton;
import br.com.etyllica.core.application.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.video.Graphic;
import br.com.tide.input.controller.EasyController;
import br.com.tide.input.controller.FirstPlayerController;
import br.com.tide.platform.player.Player;

public class BeatAdventure extends Application{

	public BeatAdventure(int w, int h) {
		super(w, h);
	}
	
	private Skeleton skeleton;
	
	private Ninja ninja;
	
	private Hero hero;
	
	private Satyr satyr;
	
	@Override
	public void load() {
		
		loading = 10;

		ninja = new Ninja(115, 220);
		ninja.setController(new EasyController());
		
		hero = new Adventurer(85, 250);
		//hero.setController(new FirstPlayerController());
		
		satyr = new Satyr(85, 200);
		satyr.setController(new FirstPlayerController());
		
		List<Player> players = new ArrayList<Player>();
		players.add(ninja);
		players.add(satyr);
		
		skeleton = new Skeleton(200, 120, players);
				
		loading = 100;
		
		updateAtFixedRate(50);
		
	}
	
	@Override
	//public void update(long now){
	public void timeUpdate(){
		ninja.update(0);
		hero.update(0);
		satyr.update(0);
		
		skeleton.update(0);		
	}

	@Override
	public void draw(Graphic g) {
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
