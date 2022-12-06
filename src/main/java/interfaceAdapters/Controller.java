package interfaceAdapters;
import TeamMode.Team;
import TeamMode.TeamPlayer;
import UI.View;
import cards.Card;
import entities.BotPlayer;
import entities.GameState;
import entities.Player;
import entities.RealPlayer;
import useCases.GameFacade;

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
    /**
     * the list of player names
     */
    private List<String> teamNames = new ArrayList<>(); //should have length 2 eventually after setup
    /**
     * the list of team names
     */
    private List<String> playerNames = new ArrayList<>(); //should have length 4 eventually after setup
    /**
     * the list of bot player levels
     */
    private List<String> botLevels = new ArrayList<>(); //should have length 3 as there are 3 AI players


    /**
     * appends playerName with playerNames List
     * @param playerName
     */
    public void addPlayerName(String playerName) {
        playerNames.add(playerName);
    }

    /**
     * appends teamName with teamNames List
     * @param teamName
     */
    public void addTeamName (String teamName) {
        teamNames.add(teamName);
    }

    /**
     * appends botLevels with botLevel (will be one of "easy", "medium", "hard")
     * @param botLevel
     */
    public void addBotLevel (String botLevel) {
        botLevels.add(botLevel);
    }
    private List<Player> teamPlayerList() {
        //TODO: return the list of players that can be used to initialize the game
        // Can use teamNames and playerNames
        List<Player> teamPlayers = new ArrayList<>();
        for(int i=0; i<teamNames.size();i++){
            Team team = new Team(teamNames.get(i));
            for(int k=0;k<playerNames.size();k++){
                TeamPlayer player = new TeamPlayer(playerNames.get(k),team);
                team.addTeamPlayer(player);
                teamPlayers.add(player);
            }
        }
        return teamPlayers;
    }

    /**
     * returns the list of players that can be used to initialize the game
     * @return
     */
    private List<Player> regularPlayerList() {
        List<Player> playerList = new ArrayList<>();
        Player player = new RealPlayer(playerNames.get(0));
        playerList.add(player);
        for(int k=1;k<playerNames.size();k++){
            player = new BotPlayer(playerNames.get(k)) {//HERE BOT PLAYER
            };
            playerList.add(player);
        }
        return playerList;
    }
    private GameFacade gameFacade;
    /**
     * initialization
     */
    public void startGame() {
        gameFacade = new GameFacade(regularPlayerList(),new Presenter(ui));
        ui.generateGameBoard(this);
        gameFacade.setup();
        /*while(!gameFacade.checkWin()){

        }
        this.game = new Game(regularPlayerList(),true,new Presenter(ui));
        ui.generateGameBoard(this);

        //TODO: initialize a new game object using the playerlist and standardCardDeck we have in the previous method
        // this.game = new Game(...);
        game.setup();*/

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
    }
    public void drawCard() {
        gameFacade.draw(1, gameFacade.getGameState().getToMove());
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
        //TODO: implement this method
    }
}
