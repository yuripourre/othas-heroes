package br.com.othas.model;

import java.util.List;

import br.com.tide.ActivePlayer;
import br.com.tide.PlayerState;

public abstract class NPC extends Character {

	private Character target = null;

	private int playerTarget = -1;
	
	private boolean killedAll = false;
	
	long startAttack = 0;
	
	public NPC(int x, int y, String rightPath, String leftPath) {
		super(x, y, rightPath, leftPath);
	}

	public void update(long now, List<Character> targets) {
		super.update(now);
				
		if(isDead()){
			return;
		}
		
		if(target==null){
			changeTarget(targets);
		}
		
		boolean goLeft = false;
		boolean goRight = false;
		boolean goUp = false;
		boolean goDown = false;

		if(target.getX()+target.getW()/2<this.getX()){
			goLeft = true;
		}
		if(target.getX()>this.getX()+this.getW()/2+currentSpeed){
			goRight = true;
		}

		if(target.getY()<this.getY()){
			goUp = true;
		}
		else if(target.getY()>this.getY()+currentSpeed){
			goDown = true;
		}

		//Verify Actions
		if(!goRight&&!goLeft&&!goUp&&!goDown){
			
			doAttack(now, targets);
			
		}else if(states.contains(PlayerState.ATTACK)){
			
			stopAttack();
			
		}

		doWalkUp(goUp, now);

		doWalkDown(goDown, now);

		doWalkLeft(goLeft, now);
		
		doWalkRight(goRight, now);		

	}
	
	private void doWalkUp(boolean goUp, long now){
		
		if(goUp){
			walkUp();
		}else if(states.contains(PlayerState.WALK_UP)){
			stopWalkUp();
		}
		
	}
	
	private void doWalkDown(boolean goDown, long now){
		
		if(goDown){
			walkDown();
		}else if(states.contains(PlayerState.WALK_DOWN)){
			stopWalkDown();
		}
		
	}
	
	private void doWalkLeft(boolean goLeft, long now){

		if(goLeft){
			walkLeft();
		}else if(states.contains(PlayerState.WALK_LEFT)){
			stopWalkLeft();
		}
		
	}
	
	private void doWalkRight(boolean goRight, long now){
		
		if(goRight){
			walkRight();
		}else if(states.contains(PlayerState.WALK_RIGHT)){
			stopWalkRight();
		}
		
	}
		
	private void doAttack(long now, List<Character> targets){

		if(!states.contains(PlayerState.ATTACK)&&!killedAll){

			attack();

			startAttack = now;

		}else if(!target.isDead()){

			if(now-startAttack>=attackDelay){
				target.beignHit(this, now);
				startAttack = now;
			}

		}else{
	
			//Check of someone is alive
			for(ActivePlayer player: targets) {
				if(!player.isDead()){
					changeTarget(targets);
					return;
				}
			}
			
			killedAll = true;
			stand();
			
		}

	}
	
	private void changeTarget(List<Character> targets){
		
		this.target = aimTarget(targets);
		
		while(this.target.isDead()&&this.target!=null){
			this.target = aimTarget(targets);
		}
		
	}
	
	protected Character aimTarget(List<Character> targets){
		
		for(Character target: targets){
			if(!target.isDead()){
				return target;
			}
		}		
		
		return null;
	}
	

}
