package useCases;

import cards.Card;
import entities.GameState;
import entities.Player;
import interfaceAdapters.Presenter_Interface;

import java.util.List;
public class Play {

    /**
     * From current player's hand, remove the card at index n
     * Update lastPlayed and discardPile
     * Update View with presenter
     * @param n index of Card to play
     */
    public void playCard(GameState gameState, int n, Presenter_Interface presenter, GameFacade game) {
        List<Player> players = gameState.getPlayers();
        int toMove = gameState.getToMove();

        Card played = players.get(toMove).playCard(n);

        gameState.setLastPlayed(played);

        List<Card> discardPile = gameState.getDiscardPile();
        discardPile.add(played);
        gameState.setDiscardPile(discardPile);

        presenter.updateLastPlayed(StringConverter.convertCardToString(played), toMove);

        // TODO - call player moves recursively

        if (players.get(toMove).getPlayerType().equalsIgnoreCase("real")) {
            String[] cards = StringConverter.convertHand(players.get(toMove).getHand());
            presenter.updateHand(cards);
        }
    }

}
