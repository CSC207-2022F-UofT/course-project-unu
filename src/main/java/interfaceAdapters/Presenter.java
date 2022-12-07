package interfaceAdapters;

import TeamMode.TeamPlayer;
import UI.View;
import entities.Player;
import gateway.*;

import java.util.List;

public class Presenter implements Presenter_Interface {

    View viewMethods;
    /*
     * Based on the MVC model, this Presenter class should depend on a View
     * Interface.
     * Where it gets it I have no idea (yet).
     */
    DBGateway gateway;

    public Presenter(View view) {
        viewMethods = view;
        gateway = new CSVGateway("db/stats.csv");
    }

    @Override
    public void updateHand(String[] cards) {
        viewMethods.updateAvailableCards(cards);
    }

    @Override
    public void updateLastPlayed(String card, int toMove) {
        if (!card.equals("D")) { // if the player's last move is not draw
            viewMethods.updateLastCardPlayed(card);
        }

        switch (toMove) {
            case 0:
                viewMethods.updateMyLastPlayedCard(card);
                break;
            case 1:
                viewMethods.updateBot1Card(card);
                break;
            case 2:
                viewMethods.updateBot2Card(card);
                break;
            case 3:
                viewMethods.updateBot3Card(card);
        }
    }

    @Override
    public void displayOptions(List<String> cards) {
        viewMethods.generatePlayWindow(cards);
    }

    /**
     *
     * @param player a string representation of player, can only be "player1", ...,
     *               "player4"
     */
    @Override
    public void updateDraw(String player) {
        switch (player) {
            case "player1":
                viewMethods.updateMyLastPlayedCard("D");
                break;
            case "player2":
                viewMethods.updateBot1Card("D");
                break;
            case "player3":
                viewMethods.updateBot2Card("D");
                break;
            case "player4":
                viewMethods.updateBot3Card("D");
                break;
        }
    }

    @Override
    public void updateGameLastCard(String card) {
        viewMethods.updateLastCardPlayed(card);
    }


    /**
     * the method shows the winner depending on whether it is the team mode or not
     * @param player - player who won
     * @param teamMode - is it a teamMode or not
     */

    @Override
    public void showWinner(Player player,boolean teamMode) {
        if(teamMode){
            viewMethods.displayResultPage(player.getPlayerType().equalsIgnoreCase("real"),((TeamPlayer)player).getTeam().getName());
            //cast player to teamPlayer and get his team
        }
        else{
            viewMethods.displayResultPage(player.getPlayerType().equalsIgnoreCase("real"));
            //get the name of the player and show
        }
    }
}
