package UI;

import interfaceAdapters.Controller;

import java.util.List;

/**
 * View Interface with methods that the Presenter calls to pass values for
 * display
 * Card strings (String parameters of any "update card" methods) are the string
 * representations of the player's
 * last move and should have the following format:
 * if the player's last move is to draw a card,
 * - card = "D"
 * if the player's last move is to play a specific card, card = string
 * representation of a card,
 * for example:
 * - number card "1-red"
 * - plus four card "+4"
 * - plus two card "+2-red"
 * - reverse card "R-red"
 * - skip card "S-red"
 * - wild card "W"
 */
public interface View {

    /**
     * generate a main game board
     * 
     * @param c the controller that the game board interacts with
     */
    void generateGameBoard(Controller c);

    /**
     * update UI the last played card of the game
     * 
     * @param card the string representation of the last played card
     */
    void updateLastCardPlayed(String card);

    /**
     * update user's cards on hand after drawing card or playing card
     * 
     * @param card a list of cards strings on the real player's hand
     */
    void updateAvailableCards(String[] card);

    /**
     * update UI the user's last played card
     * 
     * @param card the string representation of the user's last played card
     */
    void updateMyLastPlayedCard(String card);

    /**
     * update UI the last card that bot1 played
     * 
     * @param card the string representation of bot1's last played card
     */
    void updateBot1Card(String card);

    /**
     * update UI the last card that bot2 played
     * 
     * @param card the string representation of bot2's last played card
     */
    void updateBot2Card(String card);

    /**
     * update UI the last card that bot2 played
     * 
     * @param card the string representation of bot3's last played card
     */
    void updateBot3Card(String card);

    /**
     * display a colour choosing window after a wild card is played
     */
    void requestColourChange();

    /**
     * display all the possible moves that the real player can make
     * 
     * @param cards a list of strings of all the possible moves the user can make
     */
    void generatePlayWindow(List<String> cards);

    /**
     * display the result page after a regular game ends
     * should be called by the presenter after the game ends
     * 
     * @param isWin game result, true if the user won the game, false if the use
     *              lost the game
     */
    void displayResultPage(boolean isWin, int losses, int totalGames);

    /**
     * Overload method, display the result page after a team game ends
     * should be called by the presenter after the game ends
     * 
     * @param isWin   game result, true if the user won the game, false if the user
     *                lost the game
     * @param winTeam winner team name
     */
    void displayResultPage(boolean isWin, String winTeam, int losses, int totalGames);

    /**
     * display the player ranking UI
     * @param rankType the criteria of how the players are ranked
     * @param players a sorted ArrayList of players
     */
    void displayPlayerRanking(String rankType, List<String> players);
}
