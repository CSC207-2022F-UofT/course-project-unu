package UI;

import javax.swing.*;

/**
 * View Interface with methods that the Presenter calls to pass values for display
 */
public interface View {

    //generate a game board
    void generateGameBoard();

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




}
