/**
 * @author Glenn Rivkees (grivkees)
 */
package core.playfield.scroller;

import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.SpriteGroup;


public class KeepLeftFirstPlayerGameScroller extends GameScroller {

	public void scroll() {
		myBackground.setLocation(myPlayers.getActiveSprite().getX()-100, 0);
	}

}
