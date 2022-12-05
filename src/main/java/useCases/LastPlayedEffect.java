package useCases;

import entities.cards.Card;

public class LastPlayedEffect {

    /**
     * Do Effect of Last Played Card.
     * @param gameF the appropriate GameFacade
     */
    public void doEffect(GameFacade gameF){
        Card lastPlayed = gameF.getGameState().getLastPlayed();
        //lastPlayed.playedEffect(gameF);
    }
}
