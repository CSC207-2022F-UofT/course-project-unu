package useCases;


import entities.Player;

import java.util.List;

/**
 * An interface of methods that lower level objects can freely interface with.
 */
public interface Presenter_Interface {
    //void requestNewColour();

    void updateHand(String[] cards);
    void updateLastPlayed(String card, int toMove);
    void displayOptions(List<String> cards);
    /**
     * Tell the UI that this player has drawn a card.
     */
    void updateDraw(String player);
    /**
     * Show the last played card of the last player.
     */
    void updateGameLastCard(String card);
    /**
     * Show the winner.
     */
    void showWinner(Player player, boolean teamMode);

    void showRanking(String rankType);
}
