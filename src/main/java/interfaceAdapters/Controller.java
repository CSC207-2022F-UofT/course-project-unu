package interfaceAdapters;
import useCases.GameFacade;
import useCases.UserProfilePage.PlayerRanking;
import useCases.Helper;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    /**
     * Constructor
     */
    View ui;
    public Controller(View ui) {
        this.ui = ui;
    }
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
     * the list of player names
     */
    private final List<String> teamNames = new ArrayList<>(); //should have length 2 eventually after setup
    /**
     * the list of team names
     */
    private final List<String> playerNames = new ArrayList<>(); //should have length 4 eventually after setup
    /**
     * the list of bot player levels
     */
    private final List<String> botLevels = new ArrayList<>(); //should have length 3 as there are 3 AI players

    private PlayerRanking playerRanking = new PlayerRanking();

    /**
     * appends playerName with playerNames List
     * @param playerName the player name
     */
    public void addPlayerName(String playerName) {
        playerNames.add(playerName);
    }

    /**
     * appends teamName with teamNames List
     * @param teamName the team name
     */
    public void addTeamName (String teamName) {
        teamNames.add(teamName);
    }

    /**
     * appends botLevels with botLevel (will be one of "easy", "medium", "hard")
     * @param botLevel the bot level
     */
    public void addBotLevel (String botLevel) {
        botLevels.add(botLevel);
    }





    private GameFacade gameFacade;
    /**
     * initialization
     */
    public void startGame() {
        gameFacade = new GameFacade(new Helper(playerNames,teamNames,botLevels,isTeamMode),new Presenter(ui),isTeamMode);
        ui.generateGameBoard(this);
        gameFacade.setup();

        gameFacade.doLastPlayedEffect();
        gameFacade.setNextTurn();

        //this has to be called in case the flipped card is a skip or reverse
        gameFacade.botCycle();
}



    /**
     * GameBoard methods
     * playCard()
     * I will give a string that represents the card, which will be in the form of "value-colour"
     * For example: g
     */

    //Convert string representation into the index of the card.

    public void playCard(String card) {
        gameFacade.play(card);
        gameFacade.doLastPlayedEffect();
        gameFacade.botCycle();
    }
    public void drawCard() {
        gameFacade.draw(1, gameFacade.getGameState().getToMove());
        gameFacade.botCycle();
    }
    /**
     * pass the new theme colour to the game use cases
     * @param colour the colour that the player chooses after a wild card or plus four card is played
     */
    public void changeColour(String colour) {
        gameFacade.setColour(colour);
    }
    public void requestPossibleMoves() {
        gameFacade.displayRealPlayerOptions();
    }

    /**
     * pass the type of player ranking the user wants to see to the user profile system
     * @param rankType string, can only be one of "Games", "Wins", "Win Rate"
     */
    public void getPlayerRank(String rankType) {
        playerRanking = new PlayerRanking();
        if (rankType.equals("Games")){
            playerRanking.getRankByGames();
        }
        if (rankType.equals("Wins")) {
            playerRanking.getRankByWins();
        }
        if (rankType.equals("Win Rate")) {
            playerRanking.getRankByWinrate();
        }
    }
}
