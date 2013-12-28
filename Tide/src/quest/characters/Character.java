package quest.characters;

import java.awt.Color;

import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.AnimatedLayer;
import br.com.etyllica.layer.StaticLayer;
import br.com.etyllica.util.SVGColor;
import br.com.tide.platform.player.Player;
import br.com.tide.platform.player.PlayerState;

public class Character extends Player{

	protected AnimatedLayer layer = null;
	
	private StaticLayer rightLayer = null;
	
	private StaticLayer leftLayer = null;
		
	public Character(int x, int y, String rightPath, String leftPath) {
		super(x,y,32,64);
		
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
		
		drawLife(g);
	}
	
	private void drawLife(Graphic g){
		
		g.setColor(Color.BLACK);
		g.fillRect(x, y+h+4, w, 4);
		
		int lifeW = (int)(((w-2)*health)/100);
		
		g.setColor(SVGColor.GREEN);
		g.fillRect(x+1, y+h+5, lifeW, 2);
	}

	@Override
	public void onWalkLeft(){
		layer.cloneLayer(leftLayer);
	}
	
	@Override
	public void onWalkRight(){
		layer.cloneLayer(rightLayer);
	}
	
	@Override
	public void onStand(){
		layer.setFrames(6);
		
		layer.setYImage(layer.getYTile()*0);
		layer.setXImage(layer.getXTile()*0);
	}
	
	@Override
	public void onAttack(){
		
		layer.setFrames(4);
		
		layer.setXImage(layer.getXTile()*0);
		layer.setYImage(layer.getYTile()*2);
	}
	
	@Override
	public void onBeignHit() {
		
		health -= 5;
			
		layer.setFrames(3);
		
		layer.setXImage(layer.getXTile()*0);
		layer.setYImage(layer.getYTile()*1);
	}
	
	@Override
	public void update(long now){
		super.update(now);
		
		if(state.contains(PlayerState.WALK_RIGHT)){
			this.setOffsetX(walkSpeed);
			layer.setOffsetX(walkSpeed);
		}else if(state.contains(PlayerState.WALK_LEFT)){
			this.setOffsetX(-walkSpeed);
			layer.setOffsetX(-walkSpeed);
		}
		
		if(state.contains(PlayerState.WALK_DOWN)){
			this.setOffsetY(walkSpeed);
			layer.setOffsetY(walkSpeed);
		}else if(state.contains(PlayerState.WALK_UP)){
			this.setOffsetY(-walkSpeed);
			layer.setOffsetY(-walkSpeed);
		}
				
		if(isWalking()||isAttacking()||isBeignHit()){
			layer.nextFrame();
		}
		
	}
	
}
