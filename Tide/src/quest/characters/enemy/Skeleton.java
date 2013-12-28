package quest.characters.enemy;

import java.util.List;

import br.com.tide.platform.player.Player;

public class Skeleton extends Enemy{

	public Skeleton(int x, int y, List<Player> players) {
		super(x, y, "mv/skeleton.png", "mv/skeleton_inv.png", players);
		
		walkSpeed = 3;
	}

}
