package quest;

import br.com.etyllica.core.video.Graphic;
import br.com.etyllica.layer.AnimatedLayer;
import br.com.tide.platform.player.Player;
import br.com.tide.platform.player.PlayerState;

public class Hero extends Player{

	private AnimatedLayer layer;
	
	public Hero(int x, int y, String path) {
		
		layer = new AnimatedLayer(x,y,32,64,path);
		layer.setFrames(6);
		layer.setStopped(false);
	}
	
	@Override
	public void draw(Graphic g) {
		layer.draw(g);
	}
	
	public void update() {

		if(state.contains(PlayerState.WALK_RIGHT)){
			layer.setOffsetX(walkSpeed);
		}else if(state.contains(PlayerState.WALK_LEFT)){
			layer.setOffsetX(-walkSpeed);
		}
		
		if(state.contains(PlayerState.WALK_DOWN)){
			layer.setOffsetY(walkSpeed);
		}else if(state.contains(PlayerState.WALK_UP)){
			layer.setOffsetY(-walkSpeed);
		}
		
		if(isWalking()){
			layer.nextFrame();
		}		
		
	}
	
}
