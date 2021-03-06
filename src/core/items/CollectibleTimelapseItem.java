package core.items;


import com.golden.gamedev.GameObject;
import com.golden.gamedev.object.Timer;

import core.characters.Player;

/**
 * @author Kathleen Oshima
 */
public class CollectibleTimelapseItem extends CollectibleItem {

	Timer timerStart;
	Timer timerEnd;
	Player player;
	long timePassed;
	
	public void update(long elapsedTime) {
		timePassed = elapsedTime;
	}
	
	public CollectibleTimelapseItem(GameObject game) {
	    super(game);
    }

	@Override
	public void decorate(Player player) {
		if (timerStart.action(timePassed))
		{
			updatePlayerPoints(player);
			updatePlayerAttackPower(player);
			updatePlayerDefensePower(player);
			updatePlayerHitPoints(player);
			updatePlayerLevel(player);
		}
		if (timerEnd.action(timePassed)) {
			timerStart.setActive(false);
			timerEnd.setActive(false);
			this.setIsInUse(false);
		}
	}
	
	public void setTimerStart(int time) {
		this.timerStart = new Timer(time);
	}
	
	public void setTimerEnd(int time) {
		this.timerEnd = new Timer(time);
	}

}
