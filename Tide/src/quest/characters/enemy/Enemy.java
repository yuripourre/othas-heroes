package quest.characters.enemy;

import java.util.List;

import quest.characters.Character;
import br.com.tide.platform.player.Player;
import br.com.tide.platform.player.PlayerState;

public abstract class Enemy extends Character{

	private List<Player> players;

	private Player target;
	
	private int damage = 30;
	
	public Enemy(int x, int y, String rightPath, String leftPath, List<Player> players) {
		super(x, y, rightPath, leftPath);

		this.players = players;

		target = players.get(0);

	}

	long startAttack = 0;

	@Override
	public void update(long now) {
		super.update(now);
		
		boolean goLeft = false;
		boolean goRight = false;
		boolean goUp = false;
		boolean goDown = false;

		if(target.getX()+target.getW()/2<this.getX()){
			goLeft = true;
		}
		if(target.getX()>this.getX()+this.getW()/2+walkSpeed){
			goRight = true;
		}

		if(target.getY()<this.getY()){
			goUp = true;
		}
		else if(target.getY()>this.getY()+walkSpeed){
			goDown = true;
		}

		//Verify Actions
		if(!goRight&&!goLeft&&!goUp&&!goDown){
			
			doAttack(now);
			
		}else if(state.contains(PlayerState.ATTACK)){
			
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
		}else if(state.contains(PlayerState.WALK_UP)){
			stopWalkUp();
		}
		
	}
	
	private void doWalkDown(boolean goDown, long now){
		
		if(goDown){
			walkDown();
		}else if(state.contains(PlayerState.WALK_DOWN)){
			stopWalkDown();
		}
		
	}
	
	private void doWalkLeft(boolean goLeft, long now){

		if(goLeft){
			walkLeft();
		}else if(state.contains(PlayerState.WALK_LEFT)){
			stopWalkLeft();
		}
		
	}
	
	private void doWalkRight(boolean goRight, long now){
		
		if(goRight){
			walkRight();
		}else if(state.contains(PlayerState.WALK_RIGHT)){
			stopWalkRight();
		}
		
	}
	
	private void doAttack(long now){

		if(!state.contains(PlayerState.ATTACK)){

			attack();

			startAttack = now;

		}else{

			if(now-startAttack>=attackDelay){
				target.beignHit(this, now);
				startAttack = now;
			}

		}

	}

}
