package useCases;

import entities.GameState;
import entities.players.Player;
import entities.cards.Card;

import java.util.List;

public class GameSetup {

    public void setupGame(GameState gameState, Presenter_Interface presenter) {
        Draw drawer = new Draw();
        List<Player> players = gameState.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            drawer.draw(gameState,7, i, presenter);
        }

        List<Card> deck = gameState.getDeck();

        while (deck.get(0).getCardType().equalsIgnoreCase("plusFour") ||
                deck.get(0).getCardType().equalsIgnoreCase("wild")) {
            gameState.shuffleDeck(deck);
        }

        Card removed = deck.remove(0);

        gameState.setDeck(deck);
        gameState.setLastPlayed(removed);
        List<Card> discardPile = gameState.getDiscardPile();
        discardPile.add(removed);
        gameState.setDiscardPile(discardPile);

        presenter.updateGameLastCard(StringConverter.convertCardToString(removed));
    }
}
