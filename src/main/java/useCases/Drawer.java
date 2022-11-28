package useCases;

import entities.GameState;
import entities.Player;
import cards.Card;
import interfaceAdapters.Presenter_Interface;

import java.util.ArrayList;
import java.util.List;

public class Drawer {

    public void draw(GameState gameState, int drawAmount, int player, Presenter_Interface presenter) {
        List<Card> cards;
        List<Card> deck = gameState.getDeck();

        if (drawAmount <= deck.size()) {
            cards = new ArrayList<>(deck.subList(0, drawAmount));
            deck.subList(0, drawAmount).clear();
            gameState.setDeck(deck);

        } else {
            int leftover = drawAmount - deck.size();
            cards = new ArrayList<>(deck);

            gameState.reshuffle();

            cards.addAll(deck.subList(0, leftover));
            deck.subList(0, leftover).clear();
            gameState.setDeck(deck);
        }

        List<Player> players = gameState.getPlayers();

        if (players.get(player).getPlayerType().equalsIgnoreCase("real")) {
            String[] hand = StringConvert.convertHand(players.get(player).getHand());
            presenter.updateHand(hand);
        }

        players.get(player).drawCards(cards);
    }
}
