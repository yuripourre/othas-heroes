package br.com.examples.tide;


import quest.Adventurer;
import quest.Hero;
import quest.Ninja;
import br.com.etyllica.core.application.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.video.Graphic;
import br.com.tide.input.controller.EasyController;
import br.com.tide.input.controller.FirstPlayerController;

public class BeatAdventure extends Application{

	public BeatAdventure(int w, int h) {
		super(w, h);
	}
	
	private Ninja ninja;
	
	private Hero hero;
	
	@Override
	public void load() {
		
		loading = 10;

		ninja = new Ninja(115, 220);
		ninja.setController(new EasyController());
		
		hero = new Adventurer(85, 250);
		hero.setController(new FirstPlayerController());
		
		loading = 100;
		
		updateAtFixedRate(50);
		
	}
	
	public void timeUpdate(){
		ninja.update();
		hero.update();
	}

	@Override
	public void draw(Graphic g) {
		ninja.draw(g);
		hero.draw(g);
	}
	

	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {
		
		ninja.handleEvent(event);
		hero.handleEvent(event);
		
		return null;
	}
	

}
