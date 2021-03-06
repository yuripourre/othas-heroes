package br.com.othas;


import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.othas.model.Character;
import br.com.othas.model.Hero;
import br.com.othas.model.NPC;
import br.com.othas.player.Adventurer;
import br.com.othas.player.Ninja;
import br.com.othas.player.Satyr;
import br.com.othas.player.Skeleton;
import br.com.tide.input.controller.Controller;
import br.com.tide.input.controller.EasyController;
import br.com.tide.input.controller.FirstPlayerController;

public class OthasHeroesApplication extends Application {

	public OthasHeroesApplication(int w, int h) {
		super(w, h);
	}

	private Skeleton skeleton;

	private Ninja ninja;

	private Hero hero;

	private Satyr satyr;

	private List<Character> players = new ArrayList<Character>();

	private List<Character> enemies = new ArrayList<Character>();

	private List<NPC> skeletons = new ArrayList<NPC>();
	
	private Controller controller1;
	private Controller controller2;

	@Override
	public void load() {

		loading = 10;
		
		ninja = new Ninja(115, 220);
		controller1 = new FirstPlayerController(ninja);

		hero = new Adventurer(85, 250);
		//controller1 = new EasyController(hero);

		satyr = new Satyr(85, 200);
		controller2 = new EasyController(satyr);

		players.add(hero);

		skeleton = new Skeleton(200, 120);

		for(int j=0;j<3;j++){

			for(int i=0;i<10;i++){
				skeletons.add(new Skeleton(20+32*i, 40+60*j));
			}

		}

		enemies.add(skeleton);

		enemies.addAll(skeletons);

		loading = 100;

		updateAtFixedRate(50);

	}

	@Override
	public void timeUpdate(long now){
		ninja.update(now, enemies);
		satyr.update(now, enemies);

		//hero.updateAsNPC(now, enemies);

		//skeleton.update(now, players);
		//skeleton2.update(now, players);
	}

	@Override
	public void draw(Graphic g) {

		//Order to draw

		ninja.draw(g);
		hero.draw(g);
		satyr.draw(g);
		skeleton.draw(g);

		for(Character enemy: enemies){
			enemy.draw(g);	
		}
	}


	@Override
	public GUIEvent updateMouse(PointerEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GUIEvent updateKeyboard(KeyEvent event) {

		controller1.handleEvent(event);

		controller2.handleEvent(event);

		return null;
	}

}
