package useCases;

import entities.GameState;
import entities.players.Player;
import entities.cards.Card;
import interfaceAdapters.Presenter_Interface;

import java.util.List;
import java.util.ArrayList;

public class DisplayRealPlayerOptions {

    /**
     * Display the Cards the RealPlayer can play from their hand.
     * @param gameState the GameState the program is managing
     * @param presenter the Presenter_Interface we are displaying the options to
     */
    public void displayRealPlayerOptions(GameState gameState, Presenter_Interface presenter) {
        Player realPlayer = gameState.getPlayers().get(0);
        List<String> cards = new ArrayList<>();
        List<Card> possibleMoves = realPlayer.getPossibleMoves(gameState.getLastPlayed());

        for (Card card: possibleMoves) {
            cards.add(StringConverter.convertCardToString(card));
        }

        presenter.displayOptions(cards);
    }
}
