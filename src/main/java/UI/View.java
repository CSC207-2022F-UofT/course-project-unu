package UI;

import interfaceAdapters.Controller;

/**
 * View Interface with methods that the Presenter calls to pass values for display
 * Card strings (String parameters of any "update card" methods) are the string representations of the player's
 * last move and should have the following format:
 * if the player's last move is to draw a card,
 * - card = "D"
 * if the player's last move is to play a specific card, card = string representation of a card,
 * for example:
 * - number card "1-red"
 * - plus four card "+4"
 * - plus two card "+2-red"
 * - reverse card "R-red"
 * - skip card "S-red"
 * - wild card "W"
 */
public interface View {

    //generate a game board
    void generateGameBoard(Controller c);

    //update the last card played in the game
    void updateLastCardPlayed(String card);

    //update user's cards on hand after drawing card or playing card
    void updateAvailableCards(String[] card);

    void updateMyLastPlayedCard(String card);

    //update the last card that bot1 played
    void updateBot1Card(String card);

    //update the last card that bot2 played
    void updateBot2Card(String card);

    //update the last card that bot3 played
    void updateBot3Card(String card);

    void requestColorChange();

    void generatePlayWindow();

}
