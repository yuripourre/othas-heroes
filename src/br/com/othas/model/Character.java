package br.com.othas.model;

import java.awt.Color;
import java.util.List;

import br.com.etyllica.core.Drawable;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.core.graphics.SVGColor;
import br.com.etyllica.layer.AnimatedLayer;
import br.com.etyllica.layer.StaticLayer;
import br.com.tide.ActivePlayer;
import br.com.tide.PlayerState;
import br.com.tide.arcade.player.ArcadePlayer;
import br.com.tide.arcade.player.ArcadePlayerListener;

public abstract class Character extends ArcadePlayer implements Drawable, ArcadePlayerListener {

	protected AnimatedLayer layer = null;

	private StaticLayer rightLayer = null;

	private StaticLayer leftLayer = null;

	protected Color lifeBarColor = SVGColor.GREEN; 

	public Character(int x, int y, String rightPath, String leftPath) {
		super();

		//Avoid new classes creation
		listener = this;
		
		rightLayer = new StaticLayer(rightPath);

		leftLayer = new StaticLayer(leftPath);

		layer = new AnimatedLayer(x,y,32,64);
		layer.setFrames(6);
		layer.setStopped(false);

		onWalkRight();

	}

	@Override
	public void draw(Graphic g) {

		layer.draw(g);

		drawLifeBar(g);

	}

	private void drawLifeBar(Graphic g) {

		g.setColor(Color.BLACK);
		g.fillRect(layer.getX(), layer.getY()+layer.getTileH()+4, layer.getTileW(), 4);

		int lifeW = (int)(((layer.getTileW()-2)*health)/100);

		g.setColor(lifeBarColor);
		g.fillRect(layer.getX()+1, layer.getY()+layer.getTileH()+5, lifeW, 2);
	}

	@Override
	public void onWalkLeft() {
		layer.cloneLayer(leftLayer);
	}

	@Override
	public void onWalkRight() {
		layer.cloneLayer(rightLayer);
	}

	@Override
	public void onStand() {

		layer.setFrames(6);

		layer.setYImage(layer.getTileH()*0);
		layer.setXImage(layer.getTileW()*0);
	}

	@Override
	public void onAttack() {

		layer.setFrames(4);

		layer.setXImage(layer.getTileW()*0);
		layer.setYImage(layer.getTileH()*2);
	}

	@Override
	public void onBeignHit(ActivePlayer attacker) {

		//Calculate damage
		if(health>0) {

			health += calculateDefenseDamage(attacker);

			layer.setFrames(3);

			layer.setXImage(layer.getTileW()*0);
			layer.setYImage(layer.getTileH()*1);

		}else{
			die();
		}

	}

	@Override
	public void onDie() {

		layer.setFrames(1);

		layer.setXImage(layer.getTileW()*4);
		layer.setYImage(layer.getTileH()*5);
		layer.setTileW(64);
		layer.setTileH(64);

	}

	@Override
	public void update(long now) {
		super.update(now);

		if(states.contains(PlayerState.WALK_RIGHT)) {
			this.layer.setOffsetX(walkSpeed);
		}else if(states.contains(PlayerState.WALK_LEFT)) {
			this.layer.setOffsetX(-walkSpeed);
		}

		if(states.contains(PlayerState.WALK_DOWN)) {
			this.layer.setOffsetY(walkSpeed);
		}else if(states.contains(PlayerState.WALK_UP)) {
			this.layer.setOffsetY(-walkSpeed);
		}

		if(isWalking()||isAttacking()||isBeignHit()) {
			layer.nextFrame();
		}

	}

	public int getX() {
		return this.layer.getX();
	}

	public int getY() {
		return this.layer.getY();
	}
	
	public int getW() {
		return this.layer.getTileW();
	}

	public int getH() {
		return this.layer.getTileH();
	}

	public void setX(int x) {
		this.layer.setX(x);
	}

	public void setY(int y) {
		this.layer.setY(y);
	}

	public abstract void update(long now, List<Character> targets);

	public float calculateDefenseDamage(ActivePlayer attacker) {

		return -55;
	}

	@Override
	public void onWalkUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onWalkDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopWalkLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopWalkRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopWalkUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopWalkDown() {
		// TODO Auto-generated method stub
		
	}

}
