package interfaceAdapters;
import TeamMode.Team;
import TeamMode.TeamBotPlayer;
import TeamMode.TeamRealPlayer;
import UI.View;
import entities.BotPlayer;
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

    /**
     * return the list of team players that can be used to initialize the game
     * @return list of team players
     */
    private List<Player> teamPlayerList() {
        List<Player> teamPlayers = new ArrayList<>();
        Team team1 = new Team(teamNames.get(0));
        Player player1 = new TeamRealPlayer(playerNames.get(0),team1);
        Player player2 = new TeamBotPlayer(playerNames.get(1),botLevels.get(0),team1);
        teamPlayers.add(player1);
        teamPlayers.add(player2);
        Team team2 = new Team(teamNames.get(1));
        //k - bot levels name
        for(int i=2, k=1; i<playerNames.size();i++,k++){
            Player player = new TeamBotPlayer(playerNames.get(i),botLevels.get(k),team2);
            teamPlayers.add(player);
        }
        return teamPlayers;
    }

    /**
     * returns the list of players that can be used to initialize the game
     * @return the list of players
     */
    private List<Player> regularPlayerList() {
        List<Player> playerList = new ArrayList<>();
        Player player = new RealPlayer(playerNames.get(0));
        playerList.add(player);

        for(int k=1, i = 0;k<playerNames.size();k++, i++){
            player = new BotPlayer(playerNames.get(k), botLevels.get(i));
            playerList.add(player);
        }
        return playerList;
    }
    private GameFacade gameFacade;
    /**
     * initialization
     */
    public void startGame() {
        if(isTeamMode){
            gameFacade = new GameFacade(teamPlayerList(),new Presenter(ui),isTeamMode);
        }
        else{
            gameFacade = new GameFacade(regularPlayerList(),new Presenter(ui),isTeamMode);
        }
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
        //TODO: implement this method
    }
}
