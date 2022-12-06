package interfaceAdapters;

import UI.View;
import entities.Player;
import useCases.Play;

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
        viewMethods.updateLastCardPlayed(card);

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



    @Override
    public void showWinner(Player player,boolean teamMode) {
        if(teamMode==true){
            //cast player to teamPlayer and get his team
        }
        else{
            //get the name of the player and show
        }
    }}