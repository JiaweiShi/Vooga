package mario;

import java.util.List;
import voogaobject.GameElement;
import com.golden.gamedev.Game;
import charactersprites.NPC;
import charactersprites.ai.DeadState;
import charactersprites.ai.State;

/**
 * @author Eric Mercer (JacenLakiir)
 */
public class Goomba extends NPC
{

    public Goomba (Game game)
    {
        super(game);
    }
    
    public Goomba (Game game, List<State> possibleStates)
    {
        super(game, possibleStates);
    }
    
    @Override
    public void afterHitFromTopBy (GameElement e)
    {
        if (e instanceof Mario)
            setCurrentState(new DeadState(this));
    }
    
    @Override
    public void afterHitFromRightBy (GameElement e)
    {
        setDirection(-1);
    }
    
    @Override
    public void afterHitFromLeftBy (GameElement e)
    {
        setDirection(1);
    }
    
}
