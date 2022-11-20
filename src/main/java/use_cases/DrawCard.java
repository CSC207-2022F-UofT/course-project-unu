package use_cases;

import game.Game;
import cards.Card;
import interfaceAdapters.Presenter_Interface;

import java.util.List;
import java.util.ArrayList;

public class DrawCard {

    final Presenter_Interface presenter;

    public DrawCard(Presenter_Interface presenter) {
        this.presenter = presenter;
    }

    public void draw(GameDataTransferObject game) {

        if (game.getDeck().isEmpty()) {
            game.reshuffle();
        }

        List<Card> toDraw = new ArrayList<>(game.getDeck().subList(0, 1));
        game.setDeck(game.getDeck().subList(1, game.getDeck().size()));

        game.getPlayers().get(game.getToMove()).drawCards(toDraw);

        presenter.updateAvailableCards(convertToString(game.getPlayers().get(game.getToMove()).getHand()));

        //Useless statement
        Game gameObject = new Game(game.getPlayers(), game.getDeck(), game.getLastPlayed(),
                game.getToMove(), game.getIsClockwise(), game.getDiscardPile());

        //Should the Controller update its game instance variable?
    }

    public String[] convertToString(List<Card> cards) {
        //converts list of cards to array of string representations of cards
    }
}
