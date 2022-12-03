package useCases;

import cards.Card;

public class LastPlayedEffect {

    /**
     * Do Effect of Last Played Card
     * @param gameF
     */
    public void doEffect(GameFacade gameF){
        Card lastPlayed = gameF.getGameState().getLastPlayed();
        //lastPlayed.playedEffect(gameF);
    }
}
