package interfaceAdapters;
import cards.Card;
import entities.Player;
import game.Game;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private boolean isTeamMode;
    /**
     * If the user clicks on team mode, then teamMode = true, otherwise = false
     * @param teamMode
     * May delete this method later if not useful
     */
    public void setTeamMode(boolean teamMode) {
        isTeamMode = teamMode;
    }


    /**
     * Setup Page methods (mode choosing)
     * for simplicity, default:
     * - four players
     * - two teams
     * - first two players are in one team, the last two players are another team
     * - the first player is the real player and the rest three players are AI (types)
     */
    //TODO: feel free to change the type of the three variables below to list if needed
    // I'm not sure if coming up with a list of players and cards count as dependency to the entity layer
    // If is, we still need to make subtle change on that to make it adhere to clean architecture
    private String[] teamNames = {}; //should have length 2 eventually after setup
    private String[] playerNames = {}; //should have length 4 eventually after setup
    private String[] botLevels = {}; //should have length 3 as there are 3 AI players
    public void addPlayerName(String playerName) {
        //TODO: append addPlayerName with playerName (recorded by textfield)
    }
    public void addTeamName (String teamName) {
        //TODO: append addTeamName with teamName (recorded by textfield)
    }
    public void addBotLevel (String botLevel) {
        //TODO: append botLevels with botLevel (will be one of "easy", "medium", "hard")
        // note that the first item in the list actually corresponds to player2 and so on
    }
    private List<Player> teamPlayerList() {
        //TODO: return the list of players that can be used to initialize the game
        // Can use teamNames and playerNames
        return new ArrayList<>() {};
    }
    private List<Player> regularPlayerList() {
        //TODO: return the list of players that can be used to initialize the game
        // Can use playerNames and botLevels
        return new ArrayList<>() {};
    }
    private List<Card> standardCardDeck() {
        //TODO: create a standard card deck that initializes the game
        // we can ask Paul if he wants to create a more general constructer that initializes a standard card deck in
        // the constructor, if so, we don't have to create a standard card deck as one of its parameters
        return new ArrayList<>() {};
    }
    private Game game;
    public void startGame() {
        //TODO: initialize a new game object using the playerlist and standardCardDeck we have in the previous method
        // this.game = new Game(...);
    }


    /**
     * GameBoard methods
     *
     * playCard()
     * I will give a string that represents the card, which will be in the form of "value-colour"
     * For example: g
     */
    public void playCard(String card) {
        //TODO: use method in game class to play the card
    }
    public void drawCard() {
        //TODO: let the game draw a card after the user clicks the draw button
    }
    /**
     * pass the new theme colour to the game use cases
     * @param colour the colour that the player chooses after a wild card or plus four card is played
     */
    public void changeColour(String colour) {
        //TODO: update the game mechanism about the new chosen colour by the user
    }
}
