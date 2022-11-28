package interfaceAdapters;
import TeamMode.Team;
import TeamMode.TeamPlayer;
import UI.View;
import cards.Card;
import entities.Player;
import entities.RealPlayer;
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
    /**
     * the list of player names
     */
    private List<String> teamNames; //should have length 2 eventually after setup
    /**
     * the list of team names
     */
    private List<String> playerNames; //should have length 4 eventually after setup
    /**
     * the list of bot player levels
     */
    private List<String> botLevels; //should have length 3 as there are 3 AI players

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
            player = new RealPlayer(playerNames.get(k)) {//HERE BOT PLAYER
            };
            playerList.add(player);
        }
        return playerList;
    }
    private Game game;
    public void startGame(View ui) {
        this.game = new Game(regularPlayerList(),true,new Presenter(ui));

        this.game.draw(7,for each player);
        //TODO: initialize a new game object using the playerlist and standardCardDeck we have in the previous method
        // this.game = new Game(...);

        //TODO: (this can also be done in the Game class) deal 7 cards to each player.
        // Flip the first of the deck. If it is a draw card, return the card to the deck and repeat.
        // If it is a wild card, let the player who goes first choose its color. Alternatively, if
        // it's easier to implement, we could also just return the wild card to the deck and repeat.
    }


    /**
     * GameBoard methods
     *
     * playCard()
     * I will give a string that represents the card, which will be in the form of "value-colour"
     * For example: number card "1-red"
     * plus four card "+4"
     * plus two card "+2-red"
     * reverse card "R-red"
     * skip card "S-red"
     * wild card "W"
     */

    //Convert string representation into the index of the card.

    public void playCard(String card) {
        game.play(card);
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
