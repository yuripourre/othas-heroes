package quest.characters.enemy;

import java.util.List;

import quest.characters.Character;
import br.com.tide.platform.player.Player;
import br.com.tide.platform.player.PlayerState;

public abstract class Enemy extends Character{

	private List<Player> players;

	private Player target;

	public Enemy(int x, int y, String rightPath, String leftPath, List<Player> players) {
		super(x, y, rightPath, leftPath);

		this.players = players;

		target = players.get(0);

	}

	@Override
	public void update(long now) {

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
			attack();
		}else if(state.contains(PlayerState.ATTACK)){
			stopAttack();
		}
		
		if(goUp){
			walkUp();
		}else if(state.contains(PlayerState.WALK_UP)){
			stopWalkUp();
		}
		
		if(goDown){
			walkDown();
		}else if(state.contains(PlayerState.WALK_DOWN)){
			stopWalkDown();
		}
		
		if(goLeft){
			walkLeft();
		}else if(state.contains(PlayerState.WALK_LEFT)){
			stopWalkLeft();
		}
			
		if(goRight){
			walkRight();
		}else if(state.contains(PlayerState.WALK_RIGHT)){
			stopWalkRight();
		}
		
		super.update(now);

	}

}
