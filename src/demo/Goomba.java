package demo;

import java.util.List;


import com.golden.gamedev.Game;

import core.characters.GameElement;
import core.characters.NPC;
import core.characters.Player;
import core.characters.ai.DeadState;
import core.characters.ai.State;


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
        if (e instanceof Player)
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
