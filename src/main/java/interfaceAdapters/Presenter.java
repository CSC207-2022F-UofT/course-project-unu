package interfaceAdapters;

import TeamMode.TeamPlayer;
import UI.View;
import entities.players.Player;

import java.util.List;

public class Presenter implements Presenter_Interface {

    View viewMethods;
    /*
     Based on the MVC model, this Presenter class should depend on a View Interface.
     Where it gets it I have no idea (yet).
     */

    public Presenter(View view) {
        viewMethods = view;
    }
//    @Override
//    public void requestNewColour() {
//        viewMethods.requestColourChange();
//        /*
//        Calls a View Interface and a method in it.
//         */
//    }

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
     * @param player a string representation of player, can only be "player1", ..., "player4"
     */
    @Override
    public void updateDraw(String player) {
        if (player.equals("player1")) {
            viewMethods.updateMyLastPlayedCard("D");
        } else if (player.equals("player2")) {
            viewMethods.updateBot1Card("D");
        } else if (player.equals("player3")) {
            viewMethods.updateBot2Card("D");
        } else if (player.equals("player4")) {
            viewMethods.updateBot3Card("D");
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
        System.out.println(player.getName());
        System.out.println("Player hand"+player.getHand().size());
        if(teamMode==true){
            viewMethods.displayResultPage(player.getPlayerType().equalsIgnoreCase("real"),((TeamPlayer)player).getTeam().getName());
            //cast player to teamPlayer and get his team
        }
        else{
            viewMethods.displayResultPage(player.getPlayerType().equalsIgnoreCase("real"));
            //get the name of the player and show
        }
    }}