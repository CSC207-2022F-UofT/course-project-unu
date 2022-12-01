package useCases;

import entities.GameState;
import entities.Player;
import cards.Card;
import interfaceAdapters.Presenter_Interface;

import java.util.List;
import java.util.ArrayList;

public class DisplayRealPlayerOptions {

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