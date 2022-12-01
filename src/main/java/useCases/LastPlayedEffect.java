package useCases;

import cards.Card;
import useCases.GameFacade;

public class LastPlayedEffect {

    /**
     * Do Effect of Last Played Card
     * @param game
     */
    public void doEffect(GameFacade game){
        Card lastPlayed = game.getGameState().getLastPlayed();
        Card.playedEffect();
    }
}
