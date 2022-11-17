package UI;

import javax.swing.*;

/**
 * View Interface with methods that the Presenter calls to pass values for display
 */
public interface View {

    //generate a game board
    void generateGame();

    //update the last card played in the game
    void updateLastCardPlayed();

    //update user's cards on hand after drawing card
    void updateCardDrawn();

    //update user's cards on hand after playing card
    void updateCardPlayed();

    //update the last card that bot1 played
    void updateBot1Card();

    //update the last card that bot2 played
    void updateBot2Card();

    //update the last card that bot3 played
    void updateBot3Card();


}
