package useCases;

import cards.Card;
import entities.GameState;
import entities.Player;
import interfaceAdapters.Presenter_Interface;

import java.util.List;
public class Play {

    public void playCard(GameState gameState, int n, Presenter_Interface presenter) {
        List<Player> players = gameState.getPlayers();
        int toMove = gameState.getToMove();

        Card played = players.get(toMove).playCard(n);

        gameState.setLastPlayed(played);

        List<Card> discardPile = gameState.getDiscardPile();
        discardPile.add(played);
        gameState.setDiscardPile(discardPile);

        presenter.updateLastPlayed(StringConvert.convert(played), players.indexOf(toMove));

        if (players.get(toMove).getPlayerType().equalsIgnoreCase("real")) {
            String[] cards = StringConvert.convertHand(players.get(toMove).getHand());
            presenter.updateHand(cards);
        }

        played.playedEffect(this);
    }

}
