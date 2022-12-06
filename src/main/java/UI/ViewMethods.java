package UI;

import interfaceAdapters.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * the UI handler that implements the methods in the view interface
 */
public class ViewMethods implements View {

    GameBoard gameBoard;
    Controller c;

    /**
     * create a new ViewMethod object
     */
    public ViewMethods() {
        this.c = new Controller(this);
        displayResultPage(true);
        new StartPage(c);
        // this.displayResultPage(true, 2, 10);
    }

    /**
     * create a game board page
     * 
     * @param c the controller that the game board interacts with
     */
    @Override
    public void generateGameBoard(Controller c) {
        gameBoard = new GameBoard(c);
    }

    /**
     * update UI the last card played in the game
     * 
     * @param card the string representation of the last played card
     */
    @Override
    public void updateLastCardPlayed(String card) {
        gameBoard.updateLastPlayed(card);
    }

    /**
     * update UI the last card the user played
     * 
     * @param card the string representation of the last card the user played
     */
    @Override
    public void updateMyLastPlayedCard(String card) {
        gameBoard.updatePlayer1Card(card);
    }

    /**
     * update UI the last card bot1 played
     * 
     * @param card the string representation of bot1's last played card
     */
    @Override
    public void updateBot1Card(String card) {
        gameBoard.updatePlayer2Card(card);
    }

    /**
     * update UI the last card bot2 played
     * 
     * @param card the string representation of bot2's last played card
     */
    @Override
    public void updateBot2Card(String card) {
        gameBoard.updatePlayer3Card(card);
    }

    /**
     * update UI the last card bot3 played
     * 
     * @param card the string representation of bot3's last played card
     */
    @Override
    public void updateBot3Card(String card) {
        gameBoard.updatePlayer4Card(card);
    }

    /**
     * update UI the user's cards on hand after the user drew or played a card
     * 
     * @param cardList a list of cards strings on the real player's hand
     */
    @Override
    public void updateAvailableCards(String[] cardList) {
        gameBoard.displayAvailableCards(cardList);
    }

    /**
     * create a choosing colour page after the user played a wild or +4 card
     */
    @Override
    public void requestColourChange() {
        new ChooseColourPage(c);
    }

    /**
     * generate the play card window that the user can play a card by clicking on a
     * card button
     * 
     * @param cards a list of strings of all the possible moves the user can make
     */
    @Override
    public void generatePlayWindow(List<String> cards) {
        new PlayCardWindow(c, cards);
    }

    /**
     * generate the result page after the game ends
     * 
     * @param isWin game result, true if the user won the game, false if the user
     *              lost the game
     */
    @Override
    public void displayResultPage(boolean isWin, int losses, int totalGames) {
        new ResultPage(c, isWin, losses, totalGames);
        gameBoard.discardWindow();
    }

    /**
     * Overload method, display the result page after a team game ends
     * should be called by the presenter after the game ends
     * 
     * @param isWin   game result, true if the user won the game, false if the user
     *                lost the game
     * @param winTeam winner team name
     */
    @Override
    public void displayResultPage(boolean isWin, String winTeam, int losses, int totalGames) {
        new ResultPage(c, isWin, winTeam, losses, totalGames);
        gameBoard.discardWindow();
    }

    /**
     * display the player ranking UI
     * @param rankType the criteria of how the players are ranked
     * @param players a sorted ArrayList of players
     */
    @Override
    public void displayPlayerRanking(String rankType, List<String> players) {
        new ScoreBoard(rankType, players);
    }

}
