package interfaceAdapters;

import UI.View;

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
    @Override
    public void requestNewColour() {
        viewMethods.requestColourChange();
        /*
        Calls a View Interface and a method in it.
         */
    }

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
            case 1:
                viewMethods.updateBot1Card(card);
            case 2:
                viewMethods.updateBot2Card(card);
            case 3:
                viewMethods.updateBot3Card(card);
        }
    }

    @Override
    public void displayOptions(List<String> cards) {
        viewMethods.generatePlayWindow(cards);
    }

}
